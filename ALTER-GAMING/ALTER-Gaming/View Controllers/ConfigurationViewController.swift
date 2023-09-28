//
//  ConfigurationViewController.swift
//  ARModelling
//
//  Created by MISO on 20/9/21.
//

import UIKit

class ConfigurationViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var nodesTable: UITableView!
    @IBOutlet weak var idsTable: UITableView!
    @IBOutlet weak var attributesButton: UIButton!
    @IBOutlet weak var createButton: UIButton!
    @IBOutlet weak var classTable: UITableView!
    @IBOutlet weak var QRButton: UIButton!
    
    var selectedInfo : NSMutableDictionary = [:]
    
    @IBAction func myUnwindActionConfig(unwindSegue: UIStoryboardSegue){
        print("to config")
    }
    //Collections for database info
    var graphicalSyntax: [NSMutableDictionary] = []
    var itemsArray: [String] = []
    var noSCNItems: [String] = []
    var bluetoothClasses: [String] = []
    var itemsCodesOnly: [String] = []
    var metamodel: [NSMutableDictionary] = []
    var accesses: [NSMutableDictionary] = []
    var codesInfo: [NSMutableDictionary] = []
    var beacons: [NSMutableDictionary] = []
    
    var nameMetamodel : String = ""
    var codesOnly : Bool = false
    var external : Bool = false
    var bluetooth : Bool = false
    
    var codesName : [String] = []
    var beaconsName : [String] = []
    var className : [String] = []
    var currentParam: String = ""
    var canSegue: Bool = false
    var classChange: Bool = false
    var previousClass: String = ""
    
    let auxView = UIView()
    let tableView = UITableView()
    var dataSource : [String] = []
    var addButton = UIButton()
    var closeButton = UIButton()
    var selectedClassRow = IndexPath()
    override func viewDidLoad() {
        super.viewDidLoad()
        self.idsTable.delegate = self
        self.idsTable.dataSource = self
        
        self.nodesTable.delegate = self
        self.nodesTable.dataSource = self
        
        if !self.bluetooth {
            self.createButton.isEnabled = false
        }
        
        for info in self.codesInfo {
            self.codesName.append(info["name"] as! String)
        }
        
        for beacon in beacons {
            self.beaconsName.append(beacon["uuid"] as! String)
        }
        self.idsTable.reloadData()
        
        self.classTable.delegate = self
        self.classTable.dataSource = self
        for aMetamodelClass in self.metamodel {
            self.className.append(aMetamodelClass["name"] as! String)
        }
    }
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        if identifier == "fromConfigToAttr" && self.classChange {
            let alertController = UIAlertController(title: "Save",
                                                    message: "Class changed. Do you want to save",
                                                    preferredStyle: UIAlertController.Style.alert)
            let saveAction = UIAlertAction(title: "Yes", style: .default, handler: { (_) in
                self.canSegue = true
                let json = ["name" : self.nameMetamodel, "code" : self.selectedInfo["name"] as! String, "class" : self.selectedInfo["class"] as! String, "nodename" : self.selectedInfo["nodename"] as! String]
                let jsonData = try? JSONSerialization.data(withJSONObject: json)
                let string = "https://alter-server.onrender.com/pushCodesInfos?json=true"
                let url = URL(string: string)!
                var request = URLRequest(url: url)
                request.httpMethod = "POST"
                request.httpBody = jsonData
                request.setValue("application/json", forHTTPHeaderField: "Content-Type")
                request.setValue("application/json", forHTTPHeaderField: "Accept")
                let task = URLSession.shared.dataTask(with: request) { data, response, error in
                    guard let data = data, error == nil else {
                        print(error?.localizedDescription ?? "No data")
                        return
                    }
                    let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
                    if let responseJSON = responseJSON as? [String: Any] {
                        print(responseJSON)
                    }
                }
                task.resume()
                var accessOfSelectedItem = NSMutableDictionary()
                var trigger = false
                for anAccessClass in self.accesses {
                    let classAccess = anAccessClass["class"] as! String
                    if classAccess == self.previousClass {
                        let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                        trigger = classTrigger["onDelete"] as! Bool
                        if trigger {
                            accessOfSelectedItem = anAccessClass
                        }
                    }
                }
                
                let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                let authOfSelectedItem = accessOfSelectedItem["auth"] as! String
                
                var string2 = "https://alter-databroker.onrender.com/deleteUrl?aname=" + APIOfSelectedItem
                string2 += "&aclass=" + self.previousClass
                string2 += "&ain="
                string2 += self.selectedInfo["name"] as! String
                string2 = string2.replacingOccurrences(of: " ", with: "+")
                if authOfSelectedItem != "" {
                    string2 += "&eauth=" + authOfSelectedItem
                }
                string2 += "&json=true"
                let url2 = URL(string: string2)
                if (url2 != nil) {
                    print("[NewExtNode] URL object exists: ", url2!)
                }
                let session = URLSession.shared
                let task2 = session.dataTask(with: url2!) { (data, response, error) -> Void in
                    if error != nil {
                        print("[NewExtNode] ", error!)
                    } else {
                        guard let data = data, error == nil else {
                            print(error?.localizedDescription ?? "No data")
                            return
                        }
                        let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
                        if let responseJSON = responseJSON as? [String: Any] {
                            print(responseJSON)
                        }
                    }
                }
                task2.resume()
                self.previousClass = ""
                self.performSegue(withIdentifier: identifier, sender: sender)
            })
            let dontSaveAction = UIAlertAction(title: "No", style: .destructive, handler: { (_) in
                self.canSegue = false
            })
            alertController.addAction(saveAction)
            alertController.addAction(dontSaveAction)
            self.present(alertController, animated: true, completion: nil)
        } else {
            return true
        }
        return self.canSegue
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier != nil {
            let id = segue.identifier
            if id == "fromConfigToAttr" {
                let attrConfController =  segue.destination as! AttributesConfigurationViewController
                var classOfSelectedItem = NSMutableDictionary()
                let className = self.selectedInfo["class"] as! String
                for aMetamodelClass in self.metamodel {
                    let nameOfCurrentClass = aMetamodelClass["name"] as! String
                    if nameOfCurrentClass == className {
                        classOfSelectedItem = aMetamodelClass
                    }
                }
                var accessOfSelectedItem = NSMutableDictionary()
                for anAccessClass in self.accesses {
                    let classAccess = anAccessClass["class"] as! String
                    let method = anAccessClass["method"] as! String
                    if classAccess == className && method == "GET" {
                        accessOfSelectedItem = anAccessClass
                    }
                }
                let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
                attrConfController.attributesOfSelectedItem = attributesOfSelectedItem
                let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
                let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                let authOfSelectedItem = accessOfSelectedItem["auth"] as! String
                
                var previousInfo = "{"
                var arrayParam : NSMutableDictionary = [:]
                if self.selectedInfo["name"] != nil {
                    self.currentParam = self.selectedInfo["name"] as! String
                } else if self.selectedInfo["param"] != nil {
                    arrayParam = self.selectedInfo["param"] as! NSMutableDictionary
                }
                 
                for attr in attributesOfSelectedItem {
                    let attrInfo = attr as! NSMutableDictionary
                    let type = attrInfo["type"] as! String
                    let isParam = attrInfo["isParam"] as! Bool
                    var isLoaded = false
                    var loadAttributeValue = attrInfo["default"] as! String
                    if isParam {
                        previousInfo += "\""
                        previousInfo += attrInfo["name"] as! String
                        previousInfo += "\":\""
                        if arrayParam != [:] {
                            let name = attrInfo["name"] as! String
                            let value = arrayParam[name] as! String
                            previousInfo += value
                        } else {
                            
                        }
                        previousInfo += self.currentParam
                        previousInfo += "\""
                        if(attributesOfSelectedItem.index(of: attr) != attributesOfSelectedItem.count - 1) {
                            previousInfo += ","
                        }
                    } else {
                        var string = "https://alter-databroker.onrender.com/accessUrl?aname=" + APIOfSelectedItem
                        let classattr = classOfSelectedItem["name"] as! String
                        string += "&aclass=" + classattr
                        let attString = attrInfo["name"] as! String
                        string += "&ain="
                        if arrayParam != [:] {
                            var count = 0
                            for key in arrayParam.allKeys {
                                let val = arrayParam[key] as! String
                                if count != 0 {
                                    string += "&ain" + String(count) + "="
                                }
                                string += val
                                count += 1
                            }
                        } else {
                            string += self.currentParam.replacingOccurrences(of: " ", with: "+")
                        }
                        string += "&aout=" + attString
                        if authOfSelectedItem != "" {
                            string += "&eauth=" + authOfSelectedItem
                        }
                        string += "&json=true"
                        let url = URL(string: string)
                        if (url != nil) {
                            print("[LoadCode] URL object exists: ", url!)
                        }
                        let session = URLSession.shared
                        let task2 = session.dataTask(with: url!) { (data, response, error) -> Void in
                            if error != nil {
                                print("[LoadCode] ", error!)
                                isLoaded = true
                            } else {
                                if let data = data {
                                    do {
                                        let jsonResult = try JSONSerialization.jsonObject(
                                            with: data,
                                            options: JSONSerialization.ReadingOptions.mutableContainers
                                        ) as! NSMutableDictionary
                                        if(jsonResult["code"] as! String != "200") {
                                            
                                        } else {
                                            let array = jsonResult["array"] as! NSMutableDictionary
                                            if(type == "String" || type == "Image") {
                                                let body = array["body"] as! NSString
                                                loadAttributeValue = body as String
                                            } else {
                                                let body = String(describing: array["body"])
                                                if body.contains("Optional") {
                                                    let split = body.split(separator: "(")
                                                    let split2 = split[split.count - 1].split(separator: ")")
                                                    let res = split2[0]
                                                    if type == "Int" {
                                                        loadAttributeValue = String(res)
                                                    } else if type == "Bool" {
                                                        if res == "1" {
                                                            loadAttributeValue = "true"
                                                        } else {
                                                            loadAttributeValue = "false"
                                                        }
                                                    }
                                                } else {
                                                    loadAttributeValue = body
                                                }
                                            }
                                        }
                                        
                                        
                                        isLoaded = true
                                    } catch let e{
                                        print("[LoadCode] ", e)
                                    }
                                }
                            }
                        }
                        task2.resume()
                        while(!isLoaded){
                        }
                        previousInfo += "\""
                        previousInfo += attrInfo["name"] as! String
                        previousInfo += "\":\""
                        previousInfo += loadAttributeValue
                        previousInfo += "\""
                        if(attributesOfSelectedItem.index(of: attr) != attributesOfSelectedItem.count - 1) {
                            previousInfo += ","
                        }
                    }
                }
                previousInfo += "}"
                attrConfController.previousInfo = previousInfo
                attrConfController.metamodel = self.metamodel
                attrConfController.currentClass = className
                attrConfController.accesses = self.accesses
                attrConfController.nameMetamodel = self.nameMetamodel
                attrConfController.currentParam = self.currentParam
                attrConfController.arrayParam = arrayParam
                attrConfController.APIOfSelectedItem = APIOfSelectedItem
                /*
                for ref in referencesOfSelectedItem {
                    var isLoaded = false
                    let refInfo = ref as! NSMutableDictionary
                    var string = "https://alter-databroker.onrender.com/accessUrl?aname=" + APIOfSelectedItem
                    let classref = classOfSelectedItem["name"] as! String
                    string += "&aclass=" + classref
                    let refString = refInfo["name"] as! String
                    string += "&ain="
                    if arrayParam != [:] {
                        var count = 0
                        for key in arrayParam.allKeys {
                            let val = arrayParam[key] as! String
                            if count != 0 {
                                string += "&ain" + String(count) + "="
                            }
                            string += val
                            count += 1
                        }
                    } else {
                        string += self.currentParam.replacingOccurrences(of: " ", with: "+")
                    }
                    string += "&aout=" + refString
                    if authOfSelectedItem != "" {
                        string += "&eauth=" + authOfSelectedItem
                    }
                    string += "&json=true"
                    let url = URL(string: string)
                    if (url != nil) {
                        print("[LoadCode] URL object exists: ", url!)
                    }
                    let session = URLSession.shared
                    let task3 = session.dataTask(with: url!) { (data, response, error) -> Void in
                        if error != nil {
                            print("[LoadCode] ", error!)
                            isLoaded = true
                        } else {
                            if let data = data {
                                do {
                                    let jsonResult = try JSONSerialization.jsonObject(
                                        with: data,
                                        options: JSONSerialization.ReadingOptions.mutableContainers
                                    ) as! NSMutableDictionary
                                    if(jsonResult["code"] as! String != "200") {
                                        
                                    } else {
                                        let array = jsonResult["array"] as! NSMutableDictionary
                                        let body = array["body"]
                                        if body != nil {
                                            let dict = NSMutableDictionary()
                                            dict.setValue(classref, forKey: "class")
                                            if body is String {
                                                if body as! String != "" {
                                                    dict.setValue(body as! String, forKey: "refAttr")
                                                }
                                            } else if body is Int {
                                                let intBody = body as! Int
                                                dict.setValue(body as! Int, forKey: "refAttr")
                                            }
                                            dict.setValue(refString, forKey: "refName")
                                            dict.setValue(refInfo["target"] as! String, forKey: "target")
                                            
                                        }
                                        isLoaded = true
                                    }
                                } catch let e{
                                    print("[LoadCode] ", e)
                                }
                            }
                        }
                    }
                    task3.resume()
                    while(!isLoaded){
                    }
                }*/
            } else if segue.identifier == "fromConfigToBeacon" {
                let beaconController =  segue.destination as! BeaconViewController
                beaconController.classes = self.className
                beaconController.nameMetamodel = self.nameMetamodel
            } else if segue.identifier == "fromConfigToQR" {
                let codesController = segue.destination as! CodesViewController
                codesController.nameMetamodel = self.nameMetamodel
                codesController.codesName = self.codesName
                codesController.metamodel = self.metamodel
            }
        }
    }
    
    //MARK: UITableView
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if self.idsTable == tableView {
            if section == 0 {
                return self.codesName.count
            } else if section == 1 {
                return self.beacons.count
            }
        } else if self.classTable == tableView {
            if section == 0 {
                return self.codesInfo.count
            } else if section == 1 {
                return self.beacons.count
            }
        } else if self.nodesTable == tableView {
            if section == 0 {
                return self.codesInfo.count
            } else if section == 1 {
                return self.beacons.count
            }
        } else if self.tableView == tableView {
            return self.className.count
        }
        return 1
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        var cell = UITableViewCell()
        if self.idsTable == tableView {
            cell = tableView.dequeueReusableCell(withIdentifier: "modelCell", for: indexPath)
            if indexPath.section == 0 {
                cell.textLabel?.text = self.codesName[indexPath.row]
            } else if indexPath.section == 1 {
                cell.textLabel?.text = self.beaconsName[indexPath.row]
            }
            
        } else if self.classTable == tableView {
            cell = tableView.dequeueReusableCell(withIdentifier: "classCell", for: indexPath)
            if indexPath.section == 0 {
                let code = self.codesInfo[indexPath.row]
                cell.textLabel?.text = code["class"] as? String
            } else if indexPath.section == 1 {
                if self.beacons.isEmpty || self.beacons.count <= indexPath.row {
                    cell.textLabel?.text = ""
                } else {
                    let code = self.beacons[indexPath.row]
                    cell.textLabel?.text = code["class"] as? String
                }
            }
            
        } else if self.nodesTable == tableView {
            cell = tableView.dequeueReusableCell(withIdentifier: "modelCell", for: indexPath)
            if indexPath.section == 0 {
                let code = self.codesInfo[indexPath.row]
                cell.textLabel?.text = code["nodename"] as? String
            } else if indexPath.section == 1 {
                if self.beacons.isEmpty || self.beacons.count <= indexPath.row {
                    cell.textLabel?.text = ""
                } else {
                    let code = self.beacons[indexPath.row]
                    cell.textLabel?.text = code["nodename"] as? String
                }
            }
        } else if self.tableView == tableView {
            cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
            cell.textLabel?.text = self.dataSource[indexPath.row]
        }
        
        return cell
    }
    func numberOfSections(in tableView: UITableView) -> Int {
        if self.tableView == tableView {
            return 1
        }
        return 2
    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print(indexPath.section)
        if self.idsTable == tableView {
            if indexPath.section == 0 {
                let name = self.codesName[indexPath.row]
                for info in self.codesInfo {
                    if info["name"] as? String == name {
                        self.selectedInfo = info
                        let classInfo = info["class"] as! String
                        var index = 0
                        for cell in self.classTable.visibleCells {
                            if cell.textLabel?.text == classInfo && index == indexPath.row {
                                cell.isSelected = true
                                let nodename = info["nodename"] as? String
                                for cell2 in self.nodesTable.visibleCells {
                                    if cell2.textLabel?.text == nodename {
                                        cell2.isSelected = true
                                    } else {
                                        cell2.isSelected = false
                                    }
                                }
                            } else {
                                cell.isSelected = false
                            }
                            index+=1
                        }
                        break
                    }
                }
            } else if indexPath.section == 1 {
                let uuid = self.beaconsName[indexPath.row]
                var i = 0
                for info in self.beacons {
                    if info["uuid"] as? String == uuid && indexPath.row == i {
                        self.selectedInfo = info
                        let classInfo = info["class"] as! String
                        var j = 0
                        for cell in self.classTable.visibleCells {
                            if cell.textLabel?.text == classInfo && j == i {
                                cell.isSelected = true
                                let nodename = info["nodename"] as? String
                                var k = 0
                                for cell2 in self.nodesTable.visibleCells {
                                    if cell2.textLabel?.text == nodename && k == i {
                                        cell2.isSelected = true
                                    } else {
                                        cell2.isSelected = false
                                    }
                                    k+=1
                                }
                            } else {
                                cell.isSelected = false
                            }
                            j+=1
                        }
                        break
                    }
                    i+=1
                }
            }
        } else if tableView == self.classTable {
            self.selectedClassRow = indexPath
            self.chooseClass()
        } else if tableView == self.tableView {
            let cell = tableView.cellForRow(at: indexPath)
            cell!.selectionStyle = .none
            if cell?.backgroundColor == UIColor.green {
                cell?.backgroundColor = UIColor.systemBackground
            } else {
                cell?.backgroundColor = UIColor.green
                for c in tableView.visibleCells {
                    if c != cell {
                        c.backgroundColor = UIColor.systemBackground
                    }
                }
            }
        }
    }
    func tableView(_ tableView: UITableView, trailingSwipeActionsConfigurationForRowAt indexPath: IndexPath) -> UISwipeActionsConfiguration? {
        if tableView == self.nodesTable {
            let actionedit = UIContextualAction(style: .normal, title: "Edit") { (_, _, _) in
                //build modal
                let editcontrol = UIAlertController(title: "Edit", message: "Write the new name", preferredStyle: .alert)
                //action of the modal. User writes the word, table and data update
                let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
                    guard let textfield = editcontrol.textFields?.first else { return }
                    let text = textfield.text
                    //use the content of textfield to update dataSource and tableView
                    if (text != nil) {
                        if(text?.count == 0){
                            return
                        } else {
                            if indexPath.section == 0 {
                                self.codesInfo[indexPath.row]["nodename"] = text ?? "null"
                                tableView.reloadRows(at: [indexPath], with: .automatic)
                                let json = ["name" : self.nameMetamodel, "code" : self.codesInfo[indexPath.row]["name"] as! String, "class" : self.codesInfo[indexPath.row]["class"] as! String, "nodename" : text ?? "null"]
                                let jsonData = try? JSONSerialization.data(withJSONObject: json)
                                let string = "https://alter-server.onrender.com/pushCodesInfos?json=true"
                                let url = URL(string: string)!
                                var request = URLRequest(url: url)
                                request.httpMethod = "POST"
                                request.httpBody = jsonData
                                request.setValue("application/json", forHTTPHeaderField: "Content-Type")
                                request.setValue("application/json", forHTTPHeaderField: "Accept")
                                let task = URLSession.shared.dataTask(with: request) { data, response, error in
                                    guard let data = data, error == nil else {
                                        print(error?.localizedDescription ?? "No data")
                                        return
                                    }
                                    let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
                                    if let responseJSON = responseJSON as? [String: Any] {
                                        print(responseJSON)
                                    }
                                }
                                task.resume()
                            }
                        }
                    } else {
                        return
                    }
                }
                //open editable textfield
                editcontrol.addTextField()
                editcontrol.addAction(editalertaction)
                self.present(editcontrol, animated: true)
            }
            return UISwipeActionsConfiguration(actions: [actionedit])
        }
        return UISwipeActionsConfiguration(actions: [])
    }
    func chooseClass() {
        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)
        self.tableView.frame = CGRect(x: self.view.bounds.minX + 20, y: 200, width: self.view.bounds.width - 40, height: 300)
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.dataSource = []
        for item in self.className {
            self.dataSource.append(item)
        }
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.reloadData()
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(self.tableView)
        }
        self.tableView.isHidden = false;
        self.addButton = UIButton(frame: CGRect(x: self.view.bounds.minX + 20, y: 150, width: 150, height: 50))
        self.addButton.setTitle("Select", for: .normal)
        self.addButton.backgroundColor = .black
        self.addButton.addTarget(self, action: #selector(self.closeSelection), for: .touchUpInside)
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
    @objc func closeEdit() {
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    
    @objc func closeSelection() {
        
        let cells = self.tableView.visibleCells
        var selectedRow: String = ""
        for cell in cells {
            if cell.backgroundColor == UIColor.green {
                selectedRow = cell.textLabel!.text!
                break
            }
        }
        if selectedRow == "" {
            return
        } else {
            if previousClass == "" {
                self.previousClass = self.codesInfo[self.selectedClassRow.row]["class"] as! String
            }
            self.codesInfo[self.selectedClassRow.row]["class"] = selectedRow
            self.classTable.reloadData()
        }
        
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
        self.classChange = true
        
    }
}
