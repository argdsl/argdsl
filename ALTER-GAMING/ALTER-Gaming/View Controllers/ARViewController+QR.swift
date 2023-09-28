//
//  ARViewController+QR.swift
//  ARModelling
//
//  Created by MISO on 03/11/2020.
//
import Foundation
import ARKit

extension ARViewController {
    ///Show the table of all avaiable classes
    func showTypesTable() {
        self.dataSource = []
        for aMetamodelClass in self.metamodel {
            dataSource.append(aMetamodelClass["name"] as! String)
        }
        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)
        self.tableView.frame = CGRect(x: self.view.bounds.minX + 20, y: 200, width: self.view.bounds.width - 40, height: 300)
        self.tableView.delegate = self.QRDelegate
        self.tableView.dataSource = self.QRDelegate
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.QRDelegate?.setData(dataSource: self.dataSource)
        self.tableView.reloadData()
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(tableView)
        }
        self.tableView.isHidden = false;
        self.addButton = UIButton(frame: CGRect(x: self.view.bounds.minX + 20, y: 150, width: 150, height: 50))
        self.addButton.setTitle("Add", for: .normal)
        self.addButton.backgroundColor = .black
        self.addButton.addTarget(self, action: #selector(self.newQRObject), for: .touchUpInside)
        if(!self.addButton.isDescendant(of: auxView)){
            self.auxView.addSubview(self.addButton)
        }
        self.addButton.isHidden = false;
        self.closeButton = UIButton(frame: CGRect(x: self.view.bounds.maxX - 170, y: 150, width: 150, height: 50))
        self.closeButton.setTitle("Close", for: .normal)
        self.closeButton.backgroundColor = .black
        self.closeButton.addTarget(self, action: #selector(self.closeEdit), for: .touchUpInside)
        if(!self.closeButton.isDescendant(of: auxView)){
            self.auxView.addSubview(self.closeButton)
        }
        self.closeButton.isHidden = false
    }
    @objc func newQRObject() {
        let cells = self.tableView.visibleCells
        var selectedRows = [String]()
        var name = ""
        for cell in cells {
            if cell.backgroundColor == UIColor.green {
                name = (cell.textLabel?.text)!
                selectedRows.append(cell.textLabel!.text!)
                cell.backgroundColor = UIColor.systemBackground
            }
        }
        let editcontrol = UIAlertController(title: "Edit", message: "Write the new name", preferredStyle: .alert)
        //action of the modal. User writes the word, table and data update
        let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
            guard let textfield = editcontrol.textFields?.first else { return }
            let text = textfield.text
            //use the content of textfield to update dataSource and tableView
            if (text != nil) {
                if(text!.count == 0){
                    self.addQRElement(name: "", selectedItem: name, info: "")
                } else {
                    self.addQRElement(name: text!, selectedItem: name, info: "")
                }
            } else {
                self.addQRElement(name: "", selectedItem: name, info: "")
            }
        }
        //open editable textfield
        editcontrol.addTextField()
        editcontrol.addAction(editalertaction)
        self.present(editcontrol, animated: true)
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    func addQRElement(name: String, selectedItem: String, info: String) {
        var graphicalSyntaxOfSelectedItem = NSMutableDictionary()
        // retrieves the information relative to the selected item in graphical syntax
        for aGraphicalSyntaxClass in self.graphicalSyntax {
            let nameOfCurrentClass = aGraphicalSyntaxClass["name"] as! String
            if nameOfCurrentClass == selectedItem {
                graphicalSyntaxOfSelectedItem = aGraphicalSyntaxClass
            }
        }
        var classOfSelectedItem = NSMutableDictionary()
        for aMetamodelClass in self.metamodel {
            let nameOfCurrentClass = aMetamodelClass["name"] as! String
            if nameOfCurrentClass == selectedItem {
                classOfSelectedItem = aMetamodelClass
            }
        }
        var accessOfSelectedItem = NSMutableDictionary()
        for anAccessClass in self.accesses {
            let classAccess = anAccessClass["class"] as! String
            let method = anAccessClass["method"] as! String
            if classAccess == selectedItem && method == "GET" {
                accessOfSelectedItem = anAccessClass
            }
        }
        let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
        let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
        var APIOfSelectedItem = ""
        var authOfSelectedItem = ""
        if accessOfSelectedItem["name"] != nil {
            APIOfSelectedItem = accessOfSelectedItem["name"] as! String
        }
        if accessOfSelectedItem["auth"] != nil {
            authOfSelectedItem = accessOfSelectedItem["auth"] as! String
        }
        // Get the first version's sources and load the graphical representation if it exists
        if let versionsOfSelectedItem = graphicalSyntaxOfSelectedItem["versions"] as? NSMutableDictionary {
            let currentVersion = 1
            let nameOfVersions = graphicalSyntaxOfSelectedItem["vname"] as! NSMutableDictionary
            //let numberOfVersions = nameOfVersions.count
            //newItem["max_version"] = numberOfVersions
            // "v\(currentVersion)" stands for v1
            let listOfVersions = NSMutableDictionary()
            var numberOfVersions = 0
            for name in nameOfVersions {
                listOfVersions[name.value] = versionsOfSelectedItem[name.key]
                numberOfVersions+=1
            }
            let nameOfCurrentVersion = nameOfVersions["v\(currentVersion)"] as! String
            let urlOfCurrentVersion = versionsOfSelectedItem["v\(currentVersion)"] as! String
            let url = URL(string: urlOfCurrentVersion)
            let urlString = url?.absoluteString
            let attributesToShow = graphicalSyntaxOfSelectedItem["showAttributes"] as! NSMutableArray
            var attributesMaterials : NSMutableArray = []
            if graphicalSyntaxOfSelectedItem["materialAttributes"] != nil {
                attributesMaterials = graphicalSyntaxOfSelectedItem["materialAttributes"] as! NSMutableArray
            }
            // Add anchor
            if let constraintsOfSelectedItem = graphicalSyntaxOfSelectedItem["constraints"] as? NSMutableDictionary {
                var transform: simd_float4x4
                var rotation = 0
                if self.rayCastQR == nil {
                    if self.hitTestQR == nil {
                        self.displayLabel(text: "Error: The code hasn't been placed in the virtual plane. Please, try again in a few seconds")
                        self.processing = true
                        self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                        return
                    }
                    transform = self.hitTestQR!.worldTransform
                    let plane = self.hitTestQR?.anchor as? ARPlaneAnchor
                    if plane != nil {
                        if plane?.alignment == .vertical {
                            rotation = 90
                        }
                    }
                } else {
                    transform = self.rayCastQR!.worldTransform
                    let plane = self.rayCastQR?.anchor as? ARPlaneAnchor
                    if plane != nil {
                        if plane?.alignment == .vertical {
                            rotation = 90
                        }
                    }
                }
                var scale = SCNVector3Make(1.0, 1.0, 1.0)
                if constraintsOfSelectedItem["sizeInit"] != nil {
                    let sizeString = constraintsOfSelectedItem["sizeInit"] as! String
                    let size = Float(sizeString) ?? 1.0
                    scale = SCNVector3Make(size, size, size)
                }
                let anchor = ItemAnchor(identifier: UUID(), name: name, type: selectedItem, currentVersion: nameOfCurrentVersion, currentVersionInt: 1, urlOfCurrentVersion: urlString!, numberOfVersions: numberOfVersions.description, versions:     listOfVersions, attributes: attributesOfSelectedItem, references: referencesOfSelectedItem, constraints: constraintsOfSelectedItem, attributesToShow: attributesToShow, attributesMaterials: attributesMaterials, scale: scale, rotation: rotation, QR: self.QRCurrentName, API: APIOfSelectedItem, auth: authOfSelectedItem, param: ["QR" : self.QRCurrentName], previousInfo: info, beacon: "", forces: [], initForce: "", transform: transform)
                //to avoid jump to case loading model
                self.needToLoad = false
                
                self.sceneView.session.add(anchor: anchor)
                self.itemAnchors.append(anchor)
                self.QRCurrentName = ""
            }
        }
    }
}
