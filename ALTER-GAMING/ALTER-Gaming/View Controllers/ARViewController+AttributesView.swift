//
//  ARViewController+AttributesView.swift
//  ARModelling
//
//  Created by Miso on 07/10/2020.
//

import UIKit
import ARKit
import FirebaseStorage

extension ARViewController {
    
    func wrongAttrAlert(message: String){
        let alertcontrol = UIAlertController(title: "Error", message: message, preferredStyle: .alert)
        let alertaction = UIAlertAction(title: "OK", style: .default)
        alertcontrol.addAction(alertaction)
        self.present(alertcontrol, animated: true)
    }
    //MARK: - Edit objects table
    @objc func addEditTable(){
        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)
        self.tableView.frame = CGRect(x: self.view.bounds.minX + 20, y: 200, width: self.view.bounds.width - 40, height: 300)
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.dataSource = []
        for item in self.objectsList.allKeys {
            let key = item as! String
            self.dataSource.append(key)
        }
        self.tableView.delegate = self.editDelegate
        self.tableView.dataSource = self.editDelegate
        self.editDelegate?.setData(dataSource: self.dataSource)
        self.tableView.reloadData()
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(self.tableView)
        }
        self.tableView.isHidden = false;
        self.addButton = UIButton(frame: CGRect(x: self.view.bounds.minX + 20, y: 150, width: 150, height: 50))
        self.addButton.setTitle("Edit", for: .normal)
        self.addButton.backgroundColor = .black
        self.addButton.addTarget(self, action: #selector(self.toEdit), for: .touchUpInside)
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
        if self.processing {
            self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
        }
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    @objc func toEdit() {
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
        }
        let keys = self.objectsIdName.allKeys(for: selectedRow)
        let nodeName = keys.first as! String
        for node in self.sceneView.scene.rootNode.childNodes {
            let anchor = self.sceneView.anchor(for: node)
            if anchor != nil {
                if (anchor!.isKind(of: ItemAnchor.self)) {
                    if let anItemAnchor = anchor as? ItemAnchor {
                        if anItemAnchor.itemIdentifier == nodeName {
                            if self.sceneView.scene.rootNode.childNodes.contains(node) {

                                //check if text is hidden (text always first child)
                                //var child = node.childNodes.first
                                /*
                                //we need to check is an orphan node.
                                if child == nil {
                                    for anAnchor in worldMap!.anchors {
                                        if (anAnchor.isKind(of: AttributesAnchor.self)) {
                                            if let anAttrAnchor = anAnchor as? AttributesAnchor {
                                                if anAttrAnchor.nameOfItemAnchor == anItemAnchor.givenName {
                                                    node?.addChildNode(self.sceneView.node(for: anAttrAnchor)!)
                                                    child = node?.childNodes.first
                                                }
                                            }
                                        }
                                    }
                                }*//*
                                if child!.isHidden {
                                    self.hiddenButton.setTitle("Show", for: .normal)
                                } else {
                                    self.hiddenButton.setTitle("Hide", for: .normal)
                                }
                                */
                                // LEA: "save" the node for potential deletion
                                self.nodeToDelete = node

                                // Search for the result's object in the model, as an object or as an attributes
                                var itemDic: NSMutableDictionary = [:]
                                var itemFound = false
                                for eachItemDic in self.model {

                                    
                                    if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                                        print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(String(describing: node.name))")
                                        if eachNameOfItemInModel == node.name {
                                            itemDic = eachItemDic
                                            itemFound = true
                                        }
                                    }
                                }
                                if (itemFound) {
                                    print("[ARVC+Gestures] Object node found.")

                                    // Get the attributes from the model
                                    let itemAttributes = itemDic["attributes"] as! NSMutableDictionary
                                    let itemTypeAttributes = itemDic["typeAttributes"] as! NSMutableDictionary
                                    let itemMaxAttributes = itemDic["maxAttributes"] as! NSMutableDictionary
                                    let itemReferences = itemDic["references"] as! NSMutableDictionary
                                    let itemTargetReferences = itemDic["targetReferences"] as! NSMutableDictionary
                                    let itemMaxReferences = itemDic["maxReferences"] as! NSMutableDictionary
                                    let itemReadOnlyAttributes = itemDic["readOnlyAttributes"] as! NSMutableDictionary

                                    // Show the edit interface; this was meant to be in the next else if statement
                                    // Show the view to edit the attributes
                                    self.modelObjectEdited = itemDic
                                    self.itemsCollectionView.isHidden = true
                                    self.attributesMainStackView.isHidden = false
                                    self.buttonStackView.isHidden = false
                                    self.trashButton.isHidden = false
                                    self.submitButton.isHidden = false
                                    self.cancelButton.isHidden = false
                                    self.attributesScrollView.isHidden = false
                                    self.attributesContentView.isHidden = false
                                    self.attributesStackView.isHidden = false
                                    self.show(attributes: itemAttributes, typeAttributes: itemTypeAttributes, maxAttributes: itemMaxAttributes, readOnlyAttributes: itemReadOnlyAttributes, references: itemReferences, targetReferences: itemTargetReferences, maxReferences: itemMaxReferences)

                                } else {
                                    print("[ARVC+Gestures] Scene raycast result not found in model", node.name ?? "nil")
                                }

                                print("[ARVC+Gestures] Model", self.model)

                            } else {
                                // If nil, the raycast did not get a model's object
                                print("[ARVC+Gestures] Scene raycast result is node named (null)")
                            }
                        }
                    }
                } else if (anchor!.isKind(of: ItemNoSCNAnchor.self)) {
                    if let anNoItemSCNAnchor = anchor as? ItemNoSCNAnchor {
                        if anNoItemSCNAnchor.itemIdentifier == nodeName {
                            if self.sceneView.scene.rootNode.childNodes.contains(node) {
                                self.nodeToDelete = node

                                // Search for the result's object in the model, as an object or as an attributes
                                var itemDic: NSMutableDictionary = [:]
                                var itemFound = false
                                for eachItemDic in self.model {

                                    
                                    if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                                        print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(String(describing: node.name))")
                                        if eachNameOfItemInModel == node.name {
                                            itemDic = eachItemDic
                                            itemFound = true
                                        }
                                    }
                                }
                                if (itemFound) {
                                    print("[ARVC+Gestures] Object node found.")

                                    // Get the attributes from the model
                                    let itemAttributes = itemDic["attributes"] as! NSMutableDictionary
                                    let itemTypeAttributes = itemDic["typeAttributes"] as! NSMutableDictionary
                                    let itemMaxAttributes = itemDic["maxAttributes"] as! NSMutableDictionary
                                    let itemReferences = itemDic["references"] as! NSMutableDictionary
                                    let itemTargetReferences = itemDic["targetReferences"] as! NSMutableDictionary
                                    let itemMaxReferences = itemDic["maxReferences"] as! NSMutableDictionary
                                    let itemReadOnlyAttributes = itemDic["readOnlyAttributes"] as! NSMutableDictionary

                                    // Show the edit interface; this was meant to be in the next else if statement
                                    // Show the view to edit the attributes
                                    self.modelObjectEdited = itemDic
                                    self.itemsCollectionView.isHidden = true
                                    self.attributesMainStackView.isHidden = false
                                    self.buttonStackView.isHidden = false
                                    self.trashButton.isHidden = false
                                    self.submitButton.isHidden = false
                                    self.cancelButton.isHidden = false
                                    self.attributesScrollView.isHidden = false
                                    self.attributesContentView.isHidden = false
                                    self.attributesStackView.isHidden = false
                                    self.show(attributes: itemAttributes, typeAttributes: itemTypeAttributes, maxAttributes: itemMaxAttributes, readOnlyAttributes: itemReadOnlyAttributes, references: itemReferences, targetReferences: itemTargetReferences, maxReferences: itemMaxReferences)

                                } else {
                                    print("[ARVC+Gestures] Scene raycast result not found in model", node.name ?? "nil")
                                }

                                print("[ARVC+Gestures] Model", self.model)
                            } else {
                                // If nil, the raycast did not get a model's object
                                print("[ARVC+Gestures] Scene raycast result is node named (null)")
                            }
                        }
                    }
                }
            }
        }
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    //MARK: - One-to-many Attributes
    //It opens the tableview to manages attributes one-to-many
    @objc func addTable(_ textField: UITextField){
        let itemString = textField.text
        let itemList = itemString?.split(separator: " ")


        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)/*
        let tap = UITapGestureRecognizer(target: self, action: #selector(returnTable))
        self.auxView.addGestureRecognizer(tap);*/

        self.tableView.frame = CGRect(x: textField.frame.origin.x, y: 200, width: textField.frame.width, height: 200)
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.dataSource = []
        for item in itemList! {
            self.dataSource.append(String(item))
        }
        self.tableView.reloadData()
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(self.tableView)
        }
        self.currentTextField = textField
        self.tableView.isHidden = false;
        self.addButton = UIButton(frame: CGRect(x: textField.frame.origin.x, y: 150, width: 150, height: 50))
        self.addButton.setTitle("Add", for: .normal)
        self.addButton.backgroundColor = .black
        self.addButton.addTarget(self, action: #selector(self.addRow), for: .touchUpInside)
        if(!self.addButton.isDescendant(of: auxView)){
            self.auxView.addSubview(self.addButton)
        }
        self.addButton.isHidden = false;
        self.closeButton = UIButton(frame: CGRect(x: textField.frame.origin.x + textField.frame.width - 150, y: 150, width: 150, height: 50))
        self.closeButton.setTitle("Close", for: .normal)
        self.closeButton.backgroundColor = .black
        self.closeButton.addTarget(self, action: #selector(self.returnTable), for: .touchUpInside)
        if(!self.closeButton.isDescendant(of: auxView)){
            self.auxView.addSubview(self.closeButton)
        }
        self.closeButton.isHidden = false
    }

    //exit tableview ans updates textview
    @objc func returnTable(){
        self.finalText = ""
        var i = 0
        for item in self.dataSource {
            i+=1
            self.finalText! += item
            if(i<self.dataSource.count){
                self.finalText! += " "
            }
        }
        self.currentTextField.text = self.finalText
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }

    //adds row when pressing add button. new by default
    @objc func addRow(){
        self.dataSource.append("new")
        self.tableView.reloadData()
    }

    //number of rows in the iterable section. It must be equal to datasource. If not, exception
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.dataSource.count
    }

    //fills the table with datasource
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        cell.textLabel?.text = self.dataSource[indexPath.row]
        return cell
    }

    //when swipe to left, appears 2 buttons, delete and edit
    func tableView(_ tableView: UITableView, trailingSwipeActionsConfigurationForRowAt indexPath: IndexPath) -> UISwipeActionsConfiguration? {

        //remove data associate with the row of the table and remove the table
        let actiondelete = UIContextualAction(style: .destructive, title: "Delete") { (_, _, _) in
            //IMPORTANT remove data from datasource. Error if not
            self.dataSource.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .automatic)
        }

        //update data and table row with an alertAction
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
                        self.dataSource[indexPath.row] = text ?? "null"
                        tableView.reloadRows(at: [indexPath], with: .automatic)
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
        return UISwipeActionsConfiguration(actions: [actiondelete, actionedit])
    }

    //MARK: - Adjust textfield to types
    //target of Bool textField, true -> false or false -> true. Default false if another
    @objc func changeText(_ textField: UITextField){
        if(textField.text == "false"){
            textField.text = "true"
        }
        else{
            textField.text = "false"
        }
    }
    
    //target of Image textField
    @objc func selectPhotoAlbum(_ textField: UITextField){
        self.currentTextField = textField
        let alert = UIAlertController(title: "Media", message: "Do you want to pick an image or video in the gallery, put a custom URL or open the URLz", preferredStyle: .alert)
        let cancel = UIAlertAction(title: "Cancel", style: .cancel)
        let custom = UIAlertAction(title: "URL", style: .default) {
            (action) in
            let urlController = UIAlertController(title: "URL", message: "Write the custom URL", preferredStyle: .alert)
            let cancel = UIAlertAction(title: "Cancel", style: .cancel)
            let ok = UIAlertAction(title: "OK", style: .default) {
                (action) in
                guard let textfield = urlController.textFields?.first else { return }
                let text = textfield.text
                //use the content of textfield to create the new object
                if (text != nil) {
                    self.currentTextField.text = text
                }
            }
            urlController.addAction(cancel)
            urlController.addAction(ok)
            urlController.addTextField(configurationHandler: { (textField) -> Void in
                textField.text = self.currentTextField.text
            })
            self.present(urlController, animated: true)
        }
        let gallery = UIAlertAction(title: "Gallery", style: .default) {
            (action) in
            self.present(self.imagePickerController, animated: true, completion: nil)
        }
        let open = UIAlertAction(title: "open", style: .default) {
            (action) in
            let url = URL(string: self.currentTextField.text ?? "")
            UIApplication.shared.open(url!)
        }
        alert.addAction(cancel)
        alert.addAction(open)
        alert.addAction(custom)
        alert.addAction(gallery)
        self.present(alert, animated: true)
        
    }
    
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        self.dismiss(animated: true, completion: nil)
    }
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        let infoType = info[UIImagePickerController.InfoKey.mediaType] as? String
        if infoType == "public.movie" {
            let videoURL = info[UIImagePickerController.InfoKey.mediaURL] as! NSURL
            do {
                let videoData = try NSData(contentsOf: videoURL as URL, options: .mappedIfSafe)
                let str64 = videoData.base64EncodedString(options: .lineLength64Characters)
                if firebase {
                    // Get a reference to the storage service using the default Firebase App
                    let storage = Storage.storage()

                    // Create a storage reference from our storage service
                    let storageRef = storage.reference()
                    
                    // Create a reference to the file you want to upload
                    let riversRef = storageRef.child(self.modelObjectEdited["nick"] as! String + ".mp4")

                    riversRef.putData(videoData as Data, metadata: nil) { (metadata, error) in
                        guard let metadata = metadata else {
                          print(error)
                          return
                        }
                        // You can also access to download URL after upload.
                        riversRef.downloadURL { (url, error) in
                          guard let downloadURL = url else {
                              print(error)
                            return
                          }
                          print(downloadURL)
                            self.currentTextField.text = downloadURL.absoluteString
                          self.dismiss(animated: true, completion: nil)
                        }
                      }
                } else {
                    self.currentTextField.text = videoURL.absoluteString
                }
            } catch {
                self.dismiss(animated: true, completion: nil)
            }
        } else {
            if firebase {
                let image = info[UIImagePickerController.InfoKey.originalImage] as? UIImage
                let imageData : NSData = image!.pngData()! as NSData
                let str64 = imageData.base64EncodedString(options: .lineLength64Characters)
                self.currentTextField.text = str64
                self.dismiss(animated: true, completion: nil)
            } else {
                var documentsUrl: URL {
                    return FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first!
                }
                let image = info[UIImagePickerController.InfoKey.originalImage] as? UIImage
                
                let fileName = self.modelObjectEdited["nick"] as! String
                let fileURL = documentsUrl.appendingPathComponent(fileName)
                if let imageData = image?.jpegData(compressionQuality: 1.0) {
                   try? imageData.write(to: fileURL, options: .atomic)
                    self.currentTextField.text = fileName
                    self.dismiss(animated: true, completion: nil)
                } else {
                    print("Error saving image")
                    self.dismiss(animated: true, completion: nil)
                }
            }
            
        }
    }
    
    //when press return, hid the keyboard
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        self.view.endEditing(true)
        return false
    }
    //disable keyboard when bool type
    func textFieldShouldBeginEditing(_ textField: UITextField) -> Bool {
        if(textField.keyboardType == UIKeyboardType.emailAddress){
            self.view.endEditing(true)
            return false
        }
        return true
    }
    //disable results that not fit with especific type
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool{

        //if nothing changes
        if (string.count == 0){
            return true
        }
        let currentText = textField.text ?? ""
        let text = (currentText as NSString).replacingCharacters(in: range, with: string)

        //check if is only integer or boolean, specified in keyboard type
        //numberPad -> Int
        //emailaddress -> Bool (due to func textFieldShouldBeginEditing, this won't be triggered, but there is a conditional just in case of bug)
        if (textField.keyboardType == UIKeyboardType.numberPad){
            //set of rest of characters that doesn't belong to number
            let setNoNumbers = NSCharacterSet(charactersIn: "0123456789").inverted
            //if any of the text is not a number, return false. If its full numbers, return true
            return text.rangeOfCharacter(from: setNoNumbers) == nil
        } else if (textField.keyboardType == UIKeyboardType.emailAddress){
            return text == "true" || text == "false"
        }
        return true
    }

    //MARK: - References
    @objc func addReferencesTable(_ textField: UITextField){
        let itemString = textField.text
        let itemList = itemString?.split(separator: " ")
        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)
        let tap = UITapGestureRecognizer(target: self, action: #selector(self.returnReferences))
        self.auxView.addGestureRecognizer(tap);
        self.tableView.frame = CGRect(x: textField.frame.origin.x, y: 200, width: textField.frame.width, height: 200)
        self.tableView.delegate = self.referencesDelegate
        self.tableView.dataSource = self.referencesDelegate
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.dataSource = []
        let allName = self.objectsList.allKeys
        var type = ""
        let subviews = self.attributesStackView.subviews
        for sub in subviews{
            if sub == textField {
                break
            } else {
                if sub is UILabel {
                    let aux = sub as! UILabel
                    let text = aux.text
                    let labelTextList = text?.split(separator: "(")
                    if(labelTextList!.count <= 1) {
                        type = aux.text!
                    } else {
                        let auxList = labelTextList![1].split(separator: ")")
                        type = String(auxList[0])
                    }
                }
            }
        }

        for eachName in allName {
            if(self.objectsList.value(forKey: eachName as! String) as! String == type){
                self.dataSource.append(eachName as! String)
            }
        }
        self.referencesDelegate?.setData(dataSource: self.dataSource)
        self.tableView.reloadData()
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(tableView)
        }
        let cells = self.tableView.visibleCells
        for cell in cells {
            for str in itemList! {
                if(cell.textLabel?.text == String(str)) {
                    cell.backgroundColor = UIColor.green
                    break
                }
            }
        }
        self.currentTextField = textField
        self.tableView.isHidden = false;
    }
    //exit tableview and updates reference
    @objc func returnReferences(){
        let cells = self.tableView.visibleCells
        var selectedRows = [String]()
        for cell in cells {
            if cell.backgroundColor == UIColor.green {
                selectedRows.append(cell.textLabel!.text!)
                cell.backgroundColor = UIColor.systemBackground
            }
        }
        self.finalText = ""
        var i = 0
        for item in selectedRows {
            i+=1
            self.finalText! += item
            if(i<selectedRows.count){
                self.finalText! += ","
            }
            let keys = self.objectsIdName.allKeys(for: self.modelObjectEdited.value(forKey: "nick")!)
            let finalnodekeys = self.objectsIdName.allKeys(for: item)
            //search label above subview. Contains the name of the references
            let subviews = self.attributesStackView.subviews
            var refname = ""
            var target = ""
            for subview in subviews {
                if(subview is UILabel) {
                    let aux = subview as! UILabel
                    let text = aux.text
                    let labelTextList = text?.split(separator: "(")
                    refname = String(labelTextList![0])
                    if(labelTextList!.count <= 1) {
                        target = aux.text!
                    } else {
                        let auxList = labelTextList![1].split(separator: ")")
                        target = String(auxList[0])
                    }
                } else if (self.currentTextField == subview) {
                    break;
                }
            }
            if !self.noSCNList.contains(item) {
                drawLine(nodeInit: keys[0] as! String, nodeFinish: finalnodekeys[0] as! String, initName: self.modelObjectEdited.value(forKey: "nick")! as! String, finalName: item, objectClass: self.modelObjectEdited.value(forKey: "class") as! String, refname: refname, target: target)
            }
        }
        self.currentTextField.text = self.finalText
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    /**
     Calculate distance of line and get configuration to create line
     
     - parameter nodeInit: the id of the first node
     - parameter nodeFinish: the id of the second node
     - parameter initName: the name of the first node
     - parameter finalName: the name of the second node
     - parameter objectClass: the class of the object
     - parameter refname: the name of the reference
     */
    func drawLine(nodeInit: String, nodeFinish: String, initName: String, finalName: String, objectClass: String, refname: String, target: String){
        let objectCords = self.objectsCurrentPos.value(forKey: nodeInit) as! NSMutableDictionary
        let objectFinalCords = self.objectsCurrentPos.value(forKey: nodeFinish) as! NSMutableDictionary
        let initpos = SCNVector3(objectCords.value(forKey: "x") as! Float, objectCords.value(forKey: "y") as! Float, objectCords.value(forKey: "z") as! Float)
        let finalpos = SCNVector3(objectFinalCords.value(forKey: "x") as! Float, objectFinalCords.value(forKey: "y") as! Float, objectFinalCords.value(forKey: "z") as! Float)
        let line = finalpos - initpos
        let length = line.distance()
        //Get the graph syntax to get conections
        var graphicalSyntaxClass = NSMutableDictionary()
        for aGraphicalSyntaxClass in self.graphicalSyntax {
            let className = aGraphicalSyntaxClass["name"] as! String
            if className == objectClass {
                graphicalSyntaxClass = aGraphicalSyntaxClass
            }
        }
        let classConnections = graphicalSyntaxClass["connections"] as! NSMutableDictionary
        if(classConnections.count == 0){
            return
        }
        
        let arrayConnectors = classConnections[refname] as! NSMutableArray
        if(arrayConnectors.count == 0){
            return
        }
        let initconf = arrayConnectors[0] as! NSMutableDictionary
        self.createLine(initpos: initpos, finalpos: finalpos, length: length, initName: initName, finalName: finalName, width: initconf["width"] as! String, color: initconf["color"] as! String, version: initconf["name"] as! String, name: refname, target: target)
    }
    /**
     Create line on scene and save line information
     
     - parameter initpos: position of the first node
     - parameter finalpos: position of the second node
     - parameter length: length of the line
     - parameter initName: name of the first node
     - parameter finalName: name of the second node
     - parameter width: width of the line
     - parameter color: color of the line
     - parameter version: version of the line
     - parameter name: name of the reference attribute
     - parameter target: name of the class target
     */
    func createLine(initpos: SCNVector3, finalpos: SCNVector3, length: Float, initName: String, finalName: String, width: String, color: String, version: String, name: String, target: String) {
        var capRadius = CGFloat(0.001)
        let format = NumberFormatter()
        format.decimalSeparator = "."
        capRadius = CGFloat(truncating: format.number(from: width )!)
        let vector = SCNVector3Make(finalpos.x - initpos.x, finalpos.y - initpos.y, finalpos.z - initpos.z)
        if(vector.x == 0 && vector.y == 0 && vector.z == 0) {
            let line = Line(geometry: SCNTorus(ringRadius: capRadius, pipeRadius: capRadius), a: initpos, b: finalpos, nickA: initName, nickB: finalName, objsClass: target, refName: name, dirVector: vector)
            line.position = initpos
            if(color == "red") {
                line.geometry?.firstMaterial?.diffuse.contents = UIColor.red
            } else if(color == "blue") {
                line.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
            } else if(color == "green") {
                line.geometry?.firstMaterial?.diffuse.contents = UIColor.green
            }
            line.name = initName + " " + finalName + "/" + name + "-" + target
            let transform = line.worldTransform
            
            let referenceAnchor = ReferencesAnchor(nameOfItemAnchor: initName + " " + finalName + "/" + name + "-" + target, nickA: initName, nickB: finalName, classObj: target, refName: name, width: capRadius, color: color, length: length, initPos: initpos, finalPos: finalpos, version: version, transform: float4x4(transform))
            
            self.linesEachVersion.setValue(version, forKey: line.name!)
            self.sceneView.session.add(anchor: referenceAnchor)
            self.hasUpdateReference = true
            self.referencesJustAdded.append(line.name!)
        } else {
            let line = Line(geometry: SCNCapsule(capRadius: capRadius, height: CGFloat(length)), a: initpos, b: finalpos, nickA: initName, nickB: finalName, objsClass: target, refName: name, dirVector: vector)
            let interPos = SCNVector3((initpos.x + finalpos.x)/2, (initpos.y + finalpos.y)/2, (initpos.z + finalpos.z)/2)
            line.position = interPos
            if(color == "red") {
                line.geometry?.firstMaterial?.diffuse.contents = UIColor.red
            } else if(color == "blue") {
                line.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
            } else if(color == "green") {
                line.geometry?.firstMaterial?.diffuse.contents = UIColor.green
            }
            let rotation = line.calculateRotation()
            line.eulerAngles = SCNVector3(rotation.x, rotation.y, rotation.z)
            line.name = initName + " " + finalName + "/" + name + "-" + target
            let transform = line.worldTransform
            
            let referenceAnchor = ReferencesAnchor(nameOfItemAnchor: initName + " " + finalName + "/" + name + "-" + target, nickA: initName, nickB: finalName, classObj: target, refName: name, width: capRadius, color: color, length: length, initPos: initpos, finalPos: finalpos, version: version, transform: float4x4(transform))
            
            self.linesEachVersion.setValue(version, forKey: line.name!)
            self.sceneView.session.add(anchor: referenceAnchor)
            self.hasUpdateReference = true
            self.referencesJustAdded.append(line.name!)
        }
        //self.sceneView.scene.rootNode.addChildNode(cil)
    }
    //update lines
    /**
     Update rotation line
     
     - parameter line: The line to be rotated
     */
    func updateLine(line: Line, height: Float, boxLong: Float) {
        let nick = line.name
        let nickA = line.nickA
        let nickB = line.nickB
        let name = line.refName
        let target = line.objsClass
        let keys = self.objectsIdName.allKeys(for: nickA)
        let finalnodekeys = self.objectsIdName.allKeys(for: nickB)
        let nodeNameA = keys[0]
        let nodeNameB = finalnodekeys[0]
        let objectCords = self.objectsCurrentPos.value(forKey: nodeNameA as! String) as! NSMutableDictionary
        let objectFinalCords = self.objectsCurrentPos.value(forKey: nodeNameB as! String) as! NSMutableDictionary
        var initpos = SCNVector3(objectCords.value(forKey: "x") as! Float, objectCords.value(forKey: "y") as! Float, objectCords.value(forKey: "z") as! Float)
        let finalpos = SCNVector3(objectFinalCords.value(forKey: "x") as! Float, objectFinalCords.value(forKey: "y") as! Float, objectFinalCords.value(forKey: "z") as! Float)
        let interPos = SCNVector3((initpos.x + finalpos.x)/2, (initpos.y + finalpos.y)/2, (initpos.z + finalpos.z)/2)
        let linelength = finalpos - initpos
        let length = linelength.distance()
        
        //check the version with graph sintax
        var conf = NSMutableDictionary()
        
        //get previous version
        let version = self.linesEachVersion.value(forKey: line.name!) as! String
        //get the next version of current version
        for aGraphicalSyntaxClass in self.graphicalSyntax {
            let connections = aGraphicalSyntaxClass["connections"] as! NSMutableDictionary
            if connections.count > 0 {
                let keys = connections.allKeys
                for key in keys {
                    let array = connections[key] as! NSMutableArray
                    if array.count > 0 {
                        for connector in array {
                            let aux = connector as! NSMutableDictionary
                            if(aux["name"] as! String == version) {
                                conf = aux
                                break;
                            }
                        }
                    }
                }
            }
        }
        var capRadius = CGFloat(0.001)
        let format = NumberFormatter()
        format.decimalSeparator = "."
        capRadius = CGFloat(truncating: format.number(from: conf["width"] as! String)!)
        let vector = SCNVector3Make(finalpos.x - initpos.x, finalpos.y - initpos.y, finalpos.z - initpos.z)
        if(vector.x == 0 && vector.y == 0 && vector.z == 0) {
            let newLine = Line(geometry: SCNTorus(ringRadius: CGFloat(boxLong/2.5), pipeRadius: capRadius*3), a: initpos, b: finalpos, nickA: nickA, nickB: nickB, objsClass: target, refName: name, dirVector: vector)
            initpos.y = initpos.y + height/1.5
            newLine.position = initpos
            let color = conf["color"] as! String
            if(color == "red") {
                newLine.geometry?.firstMaterial?.diffuse.contents = UIColor.red
            } else if(color == "blue") {
                newLine.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
            } else if(color == "green") {
                newLine.geometry?.firstMaterial?.diffuse.contents = UIColor.green
            }
            newLine.name = nick
            newLine.rotation = SCNVector4Make(0, 0, 1, Float.pi/2)
            self.lines.remove(at: self.lines.lastIndex(of: line)!)
            if self.linesForAnchor.index(forKey: line) != nil {
                self.linesForAnchor.remove(at: self.linesForAnchor.index(forKey: line)!)
            }
            line.removeFromParentNode()
            self.lines.append(newLine)
            let text = SCNText(string: name, extrusionDepth: 0.1)
            text.font = UIFont.systemFont(ofSize: 1)
            text.flatness = 0.005
            let textNode = SCNNode(geometry: text)
            let fontScale: Float = 0.01
            textNode.scale = SCNVector3(fontScale, fontScale, fontScale)
            textNode.position = SCNVector3(0, 0.05, 0.05)
            newLine.addChildNode(textNode)
            self.sceneView.scene.rootNode.addChildNode(newLine)
            let anchor = self.sceneView.anchor(for: line)
            if ((anchor?.isKind(of: ReferencesAnchor.self)) != nil) {
                if let anRefAnchor = anchor as? ReferencesAnchor {
                    if anRefAnchor.nameOfItemAnchor == nick  {
                        anRefAnchor.initPos = initpos
                    }
                }
            }
        } else {
            let newLine = Line(geometry: SCNCapsule(capRadius: capRadius, height: CGFloat(length)), a: initpos, b: finalpos, nickA: nickA, nickB: nickB, objsClass: target, refName: name, dirVector: vector)
            newLine.position = interPos
            newLine.name = nick
            
            let color = conf["color"] as! String
            if(color == "red") {
                newLine.geometry?.firstMaterial?.diffuse.contents = UIColor.red
            } else if(color == "blue") {
                newLine.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
            } else if(color == "green") {
                newLine.geometry?.firstMaterial?.diffuse.contents = UIColor.green
            }
            let rotation = newLine.calculateRotation()
            newLine.eulerAngles = SCNVector3(rotation.x, rotation.y, rotation.z)
            
            self.lines.remove(at: self.lines.lastIndex(of: line)!)
            if self.linesForAnchor.index(forKey: line) != nil {
                self.linesForAnchor.remove(at: self.linesForAnchor.index(forKey: line)!)
            }
            line.removeFromParentNode()
            self.lines.append(newLine)
            let text = SCNText(string: name, extrusionDepth: 0.1)
            text.font = UIFont.systemFont(ofSize: 1)
            text.flatness = 0.005
            let textNode = SCNNode(geometry: text)
            let fontScale: Float = 0.01
            textNode.scale = SCNVector3(fontScale, fontScale, fontScale)
            textNode.position = SCNVector3(0, 0.05, 0.05)
            textNode.eulerAngles = SCNVector3(-rotation.x, -rotation.y, -rotation.z)
            newLine.addChildNode(textNode)
            self.sceneView.scene.rootNode.addChildNode(newLine)
            let anchor = self.sceneView.anchor(for: line)
            if ((anchor?.isKind(of: ReferencesAnchor.self)) != nil) {
                if let anRefAnchor = anchor as? ReferencesAnchor {
                    if anRefAnchor.nameOfItemAnchor == nick  {
                        anRefAnchor.initPos = initpos
                        anRefAnchor.finalPos = finalpos
                        self.linesForAnchor.updateValue(anRefAnchor, forKey: newLine)
                    }
                }
            }
        }
    }
    /**
     Delete the line of reference
     
     - parameter line: The line to be deleted
     */
    func deleteLine(line: Line) {
        self.lines.remove(at: self.lines.lastIndex(of: line)!)
        self.linesEachVersion.removeObject(forKey: line.name!)
        let anRefAnchor = self.linesForAnchor[line]!
        if self.linesForAnchor.index(forKey: line) != nil {
            self.linesForAnchor.remove(at: self.linesForAnchor.index(forKey: line)!)
        }
        line.removeFromParentNode()
        self.sceneView.session.remove(anchor: anRefAnchor)
    }
    
}
extension SCNVector3 {
    func distance() -> Float {
        return sqrtf(x*x + y*y + z*z)
    }
    static func - (left: SCNVector3, right: SCNVector3) -> SCNVector3 {
        return SCNVector3Make(left.x - right.x, left.y - right.y, left.z - right.z)
    }


}
