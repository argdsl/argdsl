//
//  ConfigurationLoadViewController.swift
//  ARModelling
//
//  Created by MISO on 17/9/21.
//

import UIKit

class ConfigurationLoadViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

    @IBOutlet weak var confLoadTableView: UITableView!
    @IBOutlet weak var loginStackView: UIStackView!
    @IBOutlet weak var button: UIButton!
    
    // MARK: Variables
    var itemsArray: [String] = []
    var itemsCodesOnly: [String] = []
    var noSCNItems: [String] = []
    var metamodel: [NSMutableDictionary] = []
    var graphicalSyntax: [NSMutableDictionary] = []
    var codesInfo: [NSMutableDictionary] = []
    var beacons: [NSMutableDictionary] = []
    var timer: Timer?
    var fireTimer: Bool = false
    var metamodelLoad: Bool = false
    var graphicLoad: Bool = false
    var codesLoad: Bool = false
    var beaconsLoad: Bool = false
    var updateTimer: Timer?
    var modelsArray: [String] = []
    var cellToGraph: NSMutableDictionary = [:]
    var cellToMetamodel: NSMutableDictionary = [:]
    var nameMetamodel: String?
    var onlyCodes: Bool?
    var external: Bool?
    var bluetooth: Bool?
    var bluetoothClasses: [String] = []
    var accesses: [NSMutableDictionary] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.loginStackView.isHidden = true
        self.button.isEnabled = false
        
        //
        self.loadTypeModels()
        
        // Table view
        self.confLoadTableView.dataSource = self
        self.confLoadTableView.delegate = self
    }
    
    func errorAlert(message: String){
        let alertcontrol = UIAlertController(title: "Note", message: message, preferredStyle: .alert)
        let alertaction = UIAlertAction(title: "OK", style: .default)
        alertcontrol.addAction(alertaction)
        self.present(alertcontrol, animated: true)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "toConfigurationView") {
            let confViewController: ConfigurationViewController = segue.destination as! ConfigurationViewController
            confViewController.graphicalSyntax = self.graphicalSyntax
            confViewController.itemsArray = self.itemsArray
            confViewController.itemsCodesOnly = self.itemsCodesOnly
            confViewController.metamodel = self.metamodel
            confViewController.nameMetamodel = self.nameMetamodel ?? ""
            confViewController.codesOnly = self.onlyCodes ?? false
            confViewController.external = self.external ?? false
            confViewController.bluetooth = self.bluetooth ?? false
            confViewController.bluetoothClasses = self.bluetoothClasses
            confViewController.accesses = self.accesses
            confViewController.codesInfo = self.codesInfo
            confViewController.beacons = self.beacons
        }
    }
    
    // MARK: Func
    @objc func timeWaiting(){
        if(self.fireTimer) {
            if(self.graphicLoad && self.metamodelLoad && self.codesLoad){
                self.fireTimer = false
                self.button.setTitle("Start", for: .normal)
                self.button.isEnabled = true
            }
        }
    }
    
    func loadTypeModels() {
        let url = URL(string: "https://alter-server.onrender.com/models?json=true")
        if (url != nil) {
            print("[NewMVC] URL object exists: ", url!)
        }
        let session = URLSession.shared
        let task = session.dataTask(with: url!) { (data, response, error) -> Void in
            if error != nil {
                print("[NewMVC] ", error!)
            } else {
                if let data = data {
                    do {

                        print("[NewMVC] Task running")
                        
                        let jsonResult = try JSONSerialization.jsonObject(
                            with: data,
                            options: JSONSerialization.ReadingOptions.mutableContainers
                        ) as! NSMutableDictionary
                        let array = jsonResult["array"] as! NSMutableArray
                        let last = array[0] as! NSMutableDictionary
                        let files = last["files"] as! NSMutableArray
                        for anElement in files {
                            // Get from the JSON each class
                            let aFile = anElement as! NSMutableDictionary
                            
                            // Save the name in itemsArray
                            let key = aFile["name"] as! String
                            
                            let metamodelString = aFile["ontological"] as! String
                            let graphicModelString = aFile["graphic"] as! String
                            
                            self.modelsArray.append(key)
                            self.cellToGraph.setValue(graphicModelString, forKey: key)
                            self.cellToMetamodel.setValue(metamodelString, forKey: key)
                        }
                    } catch let e{
                        print("[NewMVC] ", e)
                    }
                }
            }
        }
        task.resume()
        updateTimer = Timer.scheduledTimer(timeInterval:1, target:self, selector:#selector(update), userInfo: nil, repeats: true)
    }
    
    @objc func update(){
        self.confLoadTableView.reloadData()
    }
    
    func loadMetamodels(model: String) {
        self.button.isEnabled = false
        self.button.setTitle("Wait", for: .normal)
        self.graphicLoad = false
        self.metamodelLoad = false
        self.codesLoad = false
        self.itemsCodesOnly = []
        // Load the metamodel
        let url = URL(string: self.cellToMetamodel.value(forKey: model) as! String)
        if (url != nil) {
            print("[NewMVC] URL object exists: ", url!)
        }
        let session = URLSession.shared
        let task = session.dataTask(with: url!) { (data, response, error) -> Void in
            if error != nil {
                print("[NewMVC] ", error!)
            } else {
                if let data = data {
                    do {

                        print("[NewMVC] Task running")
                        
                        let jsonResult = try JSONSerialization.jsonObject(
                            with: data,
                            options: JSONSerialization.ReadingOptions.mutableContainers
                        ) as! NSMutableDictionary
                        let code = jsonResult["code"] as! String
                        if code == "200" {
                            let array = jsonResult["array"] as! NSMutableDictionary
                            let body = array["body"] as! NSMutableDictionary
                            self.nameMetamodel = (body["name"] as! String)
                            
                            self.itemsArray.removeAll()
                            self.itemsCodesOnly.removeAll()
                            self.noSCNItems.removeAll()
                            self.metamodel.removeAll()
                            self.graphicalSyntax.removeAll()
                            self.onlyCodes = body["onlyCodes"] as? Bool
                            self.external = body["external"] as? Bool
                            self.bluetooth = body["bluetooth"] as? Bool
                            if self.external! {
                                var string = "https://alter-databroker.onrender.com/getAccessList?ontological="
                                string += self.nameMetamodel! + "&json=true"
                                let url = URL(string: string)
                                if (url != nil) {
                                    print("[NewMVC] URL object exists: ", url!)
                                }
                                let session = URLSession.shared
                                let task = session.dataTask(with: url!) { (data, response, error) -> Void in
                                    if error != nil {
                                        print("[NewMVC] ", error!)
                                    } else {
                                        if let data = data {
                                            do {

                                                
                                                
                                                let jsonResult = try JSONSerialization.jsonObject(
                                                    with: data,
                                                    options: JSONSerialization.ReadingOptions.mutableContainers
                                                ) as! NSMutableDictionary
                                                let code = jsonResult["code"] as! String
                                                if code == "200" {
                                                    let array = jsonResult["array"] as! NSMutableDictionary
                                                    let body = array["body"] as! [NSMutableDictionary]
                                                    self.accesses = body
                                                    print("[NewMVC] Access Task running")
                                                }
                                            } catch let e{
                                                print("[NewMVC] ", e)
                                            }
                                        }
                                    }
                                }
                                task.resume()
                            }
                            if self.bluetooth! {
                                // Load the beacons
                                var string = "https://alter-server.onrender.com/beaconsAll?bname="
                                string += model
                                string += "&json=true"
                                let beacon_url = URL(string: string)
                                if (beacon_url != nil) {
                                    print("[NewMVC] beacon_URL object exists: ", beacon_url!)
                                }
                                let beacon_session = URLSession.shared
                                let beacon_task = beacon_session.dataTask(with: beacon_url!) { (data, response, error) -> Void in
                                    if error != nil {
                                        print("[NewMVC] ", error!)
                                    } else {
                                        if let data = data {
                                            do {

                                                print("[NewMVC] beacon_Task running")
                                                
                                                let jsonResult = try JSONSerialization.jsonObject(
                                                    with: data,
                                                    options: JSONSerialization.ReadingOptions.mutableContainers
                                                ) as! NSMutableDictionary
                                                let code = jsonResult["code"] as! String
                                                if code == "200" {
                                                    let array = jsonResult["array"]
                                                    if !(array is NSNull) {
                                                        let arrayDic = array as! NSMutableDictionary
                                                        self.beacons = arrayDic["beacons"] as! [NSMutableDictionary]
                                                    }
                                                }
                                                self.beaconsLoad = true
                                            }  catch let e{
                                                print("[NewMVC] ", e)
                                            }
                                        }
                                    }
                                }
                                beacon_task.resume()
                            }
                            let classes = body["classes"] as! NSMutableArray
                            for anElement in classes {
                                
                                // Get from the JSON each class
                                let aClass = anElement as! NSMutableDictionary
                                
                                // Save the name in itemsArray
                                let className = aClass["name"] as! String
                                
                                // Define a class for the metamodel and save it
                                let classAttributes = aClass["attributes"] as! NSMutableArray
                                let metamodelClass = NSMutableDictionary()
                                metamodelClass["name"] = className
                                let attributes = NSMutableArray()
                                for anAttribute in classAttributes {
                                    let eachAttribute = anAttribute as! NSMutableDictionary
                                    attributes.add(eachAttribute)
                                }
                                metamodelClass["attributes"] = attributes
                                let classReferences = aClass["references"] as! NSMutableArray
                                let references = NSMutableArray()
                                for anReference in classReferences {
                                    let eachReference = anReference as! NSMutableDictionary
                                    references.add(eachReference)
                                }
                                metamodelClass["references"] = references
                                if (aClass["onlyCodes"] != nil) {
                                    let onlyCodesClass = aClass["onlyCodes"] as! Bool
                                    metamodelClass["onlyCodesClass"] = onlyCodesClass
                                    if !onlyCodesClass {
                                        if (aClass["noSCN"] != nil) {
                                            let noSCNClass = aClass["noSCN"] as! Bool
                                            metamodelClass["noSCNClass"] = noSCNClass
                                            if noSCNClass {
                                                self.noSCNItems.append(className)
                                            }
                                        } else {
                                            self.itemsArray.append(className)
                                        }
                                    } else {
                                        self.itemsCodesOnly.append(className)
                                    }
                                } else {
                                    if (aClass["noSCN"] != nil) {
                                        let noSCNClass = aClass["noSCN"] as! Bool
                                        metamodelClass["noSCNClass"] = noSCNClass
                                        if noSCNClass {
                                            self.noSCNItems.append(className)
                                        }
                                    } else {
                                        self.itemsArray.append(className)
                                    }
                                }
                                if (aClass["bluetooth"] != nil) {
                                    self.bluetoothClasses.append(className)
                                }
                                if (aClass["API"] != nil) {
                                    let APIClass = aClass["API"] as! String
                                    metamodelClass["APIClass"] = APIClass
                                }
                                if (aClass["auth"] != nil) {
                                    let APIClass = aClass["auth"] as! String
                                    metamodelClass["authClass"] = APIClass
                                }
                                self.metamodel.append(metamodelClass)
                            }
                            self.metamodelLoad = true
                        }
                        else {
                            print(jsonResult["error"] as! String)
                            self.errorAlert(message: jsonResult["error"] as! String)
                        }
                        
                    } catch let e{
                        print("[NewMVC] ", e)
                    }
                }
            }
        }
        print("[NewMVC] Task resume")
        task.resume()
        
        // Load the graphic syntax
        let graphic_url = URL(string: self.cellToGraph.value(forKey: model) as! String)
        if (graphic_url != nil) {
            print("[NewMVC] graphic_URL object exists: ", graphic_url!)
        }
        let graphic_session = URLSession.shared
        let graphic_task = graphic_session.dataTask(with: graphic_url!) { (data, response, error) -> Void in
            if error != nil {
                print("[NewMVC] ", error!)
            } else {
                if let data = data {
                    do {

                        print("[NewMVC] graphic_Task running")
                        
                        let jsonResult = try JSONSerialization.jsonObject(
                            with: data,
                            options: JSONSerialization.ReadingOptions.mutableContainers
                        ) as! NSMutableDictionary
                        let code = jsonResult["code"] as! String
                        if code == "200" {
                            let array = jsonResult["array"] as! NSMutableDictionary
                            let body = array["body"] as! NSMutableDictionary
                            let classes = body["classes"] as! NSMutableArray
                            for anElement in classes {
                                
                                // Get from the JSON each class
                                let aClass = anElement as! NSMutableDictionary
                                
                                // Define a class for the metamodel and save it
                                let className = aClass["name"] as! String
                                let classVersions = aClass["versions"] as! NSMutableDictionary
                                let classVersionsName = aClass["vname"] as! NSMutableDictionary
                                let classShowAttributes = aClass["showAttributes"] as! NSMutableArray
                                let classConstraints = aClass["constraints"] as! NSMutableDictionary
                                let classConnections = aClass["connections"] as! NSMutableDictionary
                                
                                let graphicalSyntaxClass = NSMutableDictionary()
                                graphicalSyntaxClass["name"] = className
                                graphicalSyntaxClass["versions"] = classVersions
                                graphicalSyntaxClass["vname"] = classVersionsName
                                graphicalSyntaxClass["showAttributes"] = classShowAttributes
                                graphicalSyntaxClass["constraints"] = classConstraints
                                graphicalSyntaxClass["connections"] = classConnections
                                self.graphicalSyntax.append(graphicalSyntaxClass)
                            }
                            self.graphicLoad = true
                        }
                        else {
                            print(jsonResult["error"] as! String)
                            self.errorAlert(message: jsonResult["error"] as! String)
                        }
                        
                    } catch let e{
                        print("[NewMVC] ", e)
                    }
                }
            }
        }
        print("[NewMVC] graphic_Task resume")
        graphic_task.resume()
        
        // Load the codes info
        var string = "https://alter-server.onrender.com/codesInfosAll?cname="
        string += model
        string += "&json=true"
        let code_url = URL(string: string)
        if (code_url != nil) {
            print("[NewMVC] code_URL object exists: ", code_url!)
        }
        let code_session = URLSession.shared
        let code_task = code_session.dataTask(with: code_url!) { (data, response, error) -> Void in
            if error != nil {
                print("[NewMVC] ", error!)
            } else {
                if let data = data {
                    do {

                        print("[NewMVC] code_Task running")
                        
                        let jsonResult = try JSONSerialization.jsonObject(
                            with: data,
                            options: JSONSerialization.ReadingOptions.mutableContainers
                        ) as! NSMutableDictionary
                        let code = jsonResult["code"] as! String
                        if code == "200" {
                            let array = jsonResult["array"]
                            if !(array is NSNull) {
                                let arrayDic = array as! NSMutableDictionary
                                self.codesInfo = arrayDic["codes"] as! [NSMutableDictionary]
                            }
                        }
                        self.codesLoad = true
                    }  catch let e{
                        print("[NewMVC] ", e)
                    }
                }
            }
        }
        print("[NewMVC] code_Task resume")
        code_task.resume()
        self.fireTimer = true
        timer = Timer.scheduledTimer(timeInterval:1, target:self, selector:#selector(timeWaiting), userInfo: nil, repeats: true)
        
    }
    
    // MARK: Table View
    //https://www.ioscreator.com/tutorials/prototype-cells-table-view-ios-tutorial
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.modelsArray.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "modelCell", for: indexPath)
        cell.textLabel?.text = self.modelsArray[indexPath.row]
        
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let model = self.modelsArray[indexPath.row]
        self.loadMetamodels(model: model)
    }
}
