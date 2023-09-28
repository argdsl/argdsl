//
//  AttributesConfigurationViewController.swift
//  ARModelling
//
//  Created by MISO on 21/9/21.
//

import UIKit

class AttributesConfigurationViewController: UIViewController, UITextFieldDelegate, UITableViewDelegate, UITableViewDataSource {
    
    

    var previousInfo : String = ""
    var nameMetamodel : String = ""
    var APIOfSelectedItem : String = ""
    var nick : String = ""
    var attributesOfSelectedItem : NSMutableArray = []
    let minCardinalityOfEachAttributes = NSMutableDictionary()
    let attributesOfItem = NSMutableDictionary()
    let typeOfAttributesOfItem = NSMutableDictionary()
    let maxOfAttributesOfItem = NSMutableDictionary()
    let readOnlyOfAttributes = NSMutableDictionary()
    var metamodel: [NSMutableDictionary] = []
    var accesses: [NSMutableDictionary] = []
    var currentClass: String = ""
    var currentParam: String = ""
    var arrayParam: NSMutableDictionary = [:]

    
    var finalText: String?
    let auxView = UIView()
    let tableView = UITableView()
    var currentTextField = UITextField()
    var addButton = UIButton()
    var closeButton = UIButton()
    var dataSource : [String] = []
    
    @IBOutlet weak var attributesScrollView: UIScrollView!
    @IBOutlet weak var attributesStackView: UIStackView!
    override func viewDidLoad() {
        super.viewDidLoad()
        let attributes = convertStringToDictionary(text: previousInfo)
        for eachView in self.attributesStackView.subviews {
            eachView.removeFromSuperview();
        }
        for anAttribute in attributesOfSelectedItem {
            if let currentAttribute = anAttribute as? NSMutableDictionary {
                let nameOfAttribute = currentAttribute["name"] as! NSString
                let defaultValueOfAttribute = currentAttribute["default"]
                let maxCardinalityOfAttribute = currentAttribute["max"]
                let minCardinatilyOfAttribute = currentAttribute["min"]
                let typeOfAttribute = currentAttribute["type"]
                let readOnlyOfAttribute = currentAttribute["readOnly"]
                
                
                if previousInfo != "{}" {
                    attributesOfItem.setObject(attributes[nameOfAttribute]!, forKey: nameOfAttribute)
                } else {
                    attributesOfItem.setObject(defaultValueOfAttribute!, forKey: nameOfAttribute)
                }
                typeOfAttributesOfItem.setObject(typeOfAttribute!, forKey: nameOfAttribute)
                maxOfAttributesOfItem.setObject(maxCardinalityOfAttribute!, forKey: nameOfAttribute)
                minCardinalityOfEachAttributes.setObject(minCardinatilyOfAttribute!, forKey: nameOfAttribute)
                readOnlyOfAttributes.setObject(readOnlyOfAttribute!, forKey: nameOfAttribute)
            }
        }
        var count = 0/*
        let currentObjectLabel = UILabel();
        currentObjectLabel.translatesAutoresizingMaskIntoConstraints = false
        currentObjectLabel.font = UIFont.systemFont(ofSize: 30.0)
        currentObjectLabel.text = self.nick
        currentObjectLabel.textAlignment = .center
        self.attributesStackView.addArrangedSubview(currentObjectLabel)
        count+=1*/
        // Show attribute title label
        if (attributes.count > 0) {
            let attributesTitleLabel = UILabel();
            attributesTitleLabel.translatesAutoresizingMaskIntoConstraints = false
            attributesTitleLabel.font = UIFont.systemFont(ofSize: 17.0)
            attributesTitleLabel.text = "Attributes:";
            // Add the label
            self.attributesStackView.addArrangedSubview(attributesTitleLabel)
            count+=1

            // For each attribute compose a layout with label and textField
            let allNames = attributes.allKeys
            for eachName in allNames {
                let eachAttribute = attributes[eachName] as! String
                let eachTypeAttribute = typeOfAttributesOfItem[eachName] as! String
                let eachMaxAttribute = maxOfAttributesOfItem[eachName] as! String
                let eachReadOnlyAttribute = readOnlyOfAttributes[eachName] as! Bool

                // Set attribute's name label
                let attributesNameLabel = UILabel();
                attributesNameLabel.translatesAutoresizingMaskIntoConstraints = false
                attributesNameLabel.font = UIFont.systemFont(ofSize: 17.0)
                attributesNameLabel.text = eachName as? String;
                // Add the label
                self.attributesStackView.addArrangedSubview(attributesNameLabel)
                count+=1
                // Set attribute's textField

                let attributesTextField = UITextField();
                if(eachMaxAttribute != "1"){
                    print("[ARVC+Gestures] is not unique " + eachAttribute);
                    attributesTextField.keyboardType = UIKeyboardType.emailAddress;
                    attributesTextField.addTarget(self, action: #selector(self.addTable(_:)), for: .touchDown)
                } else {
                    print("[ARVC+Gestures] is unique " + eachAttribute);
                }
                if(eachTypeAttribute == "Int"){
                    //change keyboard type for integers
                    attributesTextField.keyboardType = UIKeyboardType.numberPad;
                } else if (eachTypeAttribute == "Bool") {
                    attributesTextField.keyboardType = UIKeyboardType.emailAddress;
                    attributesTextField.addTarget(self, action: #selector(self.changeText(_:)), for: .touchDown)
                }
                attributesTextField.delegate = self
                attributesTextField.translatesAutoresizingMaskIntoConstraints = false;
                attributesTextField.borderStyle = UITextField.BorderStyle.roundedRect;
                attributesTextField.text = eachAttribute;
                if eachReadOnlyAttribute {
                    attributesTextField.isUserInteractionEnabled = false
                    attributesTextField.backgroundColor = .gray
                }
                // Add the label
                self.attributesStackView.addArrangedSubview(attributesTextField)
                count+=1
            }
        }
    }
    
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
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.dataSource.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        cell.textLabel?.text = self.dataSource[indexPath.row]
        return cell
    }
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
    
    func wrongAttrAlert(message: String){
        let alertcontrol = UIAlertController(title: "Error", message: message, preferredStyle: .alert)
        let alertaction = UIAlertAction(title: "OK", style: .default)
        alertcontrol.addAction(alertaction)
        self.present(alertcontrol, animated: true)
    }
    
    @IBAction func saveAction(_ sender: Any) {
        let itemAttributes = self.attributesOfItem
        let itemTypeAttributes = self.typeOfAttributesOfItem
        let itemMaxAttributes = self.maxOfAttributesOfItem
        let itemMinAttributes = self.minCardinalityOfEachAttributes
        let allNames = itemAttributes.allKeys
        // Update the model
        let textFields = NSMutableArray()
        let textReferencesFields = NSMutableArray()
        var i = 0;
        //var j = 0;
        for eachSubview in self.attributesStackView.subviews {
            if eachSubview is UITextField && i < allNames.count {
                let name = allNames[i]
                let messagename = name as! String
                let type = itemTypeAttributes[name] as! String
                let aux = eachSubview as! UITextField
                let min = itemMinAttributes[name] as! String
                let max = itemMaxAttributes[name] as! String
                if(min != "0" && aux.text!.isEmpty){
                    self.wrongAttrAlert(message: "Attribute " + messagename + " must have at least " + min + ". Correct it")
                    return
                }
                if(max != "1"){
                    let itemList = aux.text?.split(separator: " ")
                    if(itemList!.count < Int(min)!){
                        self.wrongAttrAlert(message: "Attribute " + messagename + " must have at least " + min + ". Correct it")
                        return
                    } else if(max != "-1" && itemList!.count > Int(max)!){
                        self.wrongAttrAlert(message: "Attribute " + messagename + " must have less than " + max + ". Correct it")
                        return
                    } else if (type == "Int"){
                        for item in itemList! {
                            if(Int(item) == nil){
                                self.wrongAttrAlert(message: "Attribute " + messagename + " is integer. Correct it")
                                return
                            }
                        }
                    } else if (type == "Bool"){
                        for item in itemList! {
                            if(item != "true" || item != "false"){
                                self.wrongAttrAlert(message: "Attribute " + messagename + " must be 'true' or 'false'. Correct it")
                                return
                            }
                        }
                    }
                } else {
                    if(type == "Int"){
                        if(Int(aux.text!) == nil){
                            self.wrongAttrAlert(message: "Attribute " + messagename + " is integer. Correct it")
                            return
                        }
                    } else if (type == "Bool"){
                        if(aux.text! != "true" && aux.text! != "false"){
                            self.wrongAttrAlert(message: "Attribute " + messagename + " must be 'true' or 'false'. Correct it")
                            return
                        }
                    }

                }
                i+=1
                textFields.add(eachSubview)
            } else if eachSubview is UITextField {
                //let name = allReferences[j]
                textReferencesFields.add(eachSubview)
                //j+=1
            }
        }
        
        var index = 0;

        for eachElement in textFields {
            let eachTextField = eachElement as! UITextField
            itemAttributes[allNames[index]] = eachTextField.text
            index += 1;
        }
        
        var classOfSelectedItem = NSMutableDictionary()
        for aMetamodelClass in self.metamodel {
            let nameOfCurrentClass = aMetamodelClass["name"] as! String
            if nameOfCurrentClass == currentClass {
                classOfSelectedItem = aMetamodelClass
            }
        }
        var accessOfSelectedItem = NSMutableDictionary()
        var trigger = false
        for anAccessClass in self.accesses {
            let classAccess = anAccessClass["class"] as! String
            if classAccess == currentClass {
                let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                trigger = classTrigger["onChange"] as! Bool
                if trigger {
                    accessOfSelectedItem = anAccessClass
                    break
                }
            }
        }
        if accessOfSelectedItem.count != 0 {
            
            if trigger {
                let method = accessOfSelectedItem["method"] as! String
                if method == "POST" {
                    var json: [String: Any] = ["codeId" : self.currentParam]
                    if arrayParam != [:] {
                        
                    } else {
                        json = ["codeId" : self.currentParam]
                    }
                    
                    let bodyAccess = accessOfSelectedItem["body"] as! NSMutableArray
                    for body in bodyAccess {
                        let objBody = body as! NSMutableDictionary
                        let key = objBody["attr"] as! String
                        let APIBody = objBody["APIBody"] as! String
                        if itemAttributes[key] != nil {
                            json.updateValue(itemAttributes[key] as! String, forKey: APIBody)
                        }
                    }
                    let jsonData = try? JSONSerialization.data(withJSONObject: json)
                    
                    var string = "https://alter-databroker.onrender.com/postUrl?aname="
                    string += self.APIOfSelectedItem
                    
                    string += "&aclass="
                    string += self.currentClass + "&ain="
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
                    string += "&json=true"
                    
                    let url = URL(string: string)!
                    print(string)
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
        }
    }
}
