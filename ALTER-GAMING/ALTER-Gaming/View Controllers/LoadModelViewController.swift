//
//  NewModelViewController.swift
//  ARModelling
//
//  Created by Miso on 20/09/2020.
//

import UIKit

class LoadModelViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    // MARK: IBOutlet
    @IBOutlet weak var loginStackView: UIStackView!
    @IBOutlet weak var button: UIButton!
    @IBOutlet weak var loadModelTableView: UITableView!
    
    
    // MARK: Variables
    var itemsArray: [String] = []
    var itemsCodesOnly: [String] = []
    var noSCNItems: [String] = []
    var metamodel: [NSMutableDictionary] = []
    var graphicalSyntax: [NSMutableDictionary] = []
    var physics: [NSMutableDictionary] = []
    var gameloops: [NSMutableDictionary] = []
    var codesInfo: [NSMutableDictionary] = []
    var beaconsInfo: [NSMutableDictionary] = []
    var timer: Timer?
    var second = 0
    var listOfMetamodelsName: [String] = []
    var listOfModelsName : [[String]] = [] // one table of string for the name of the rows per sections of table view
    var graphicalSyntaxURLs : NSMutableDictionary = [:]
    var metamodelURLs : NSMutableDictionary = [:]
    var fireTimer: Bool = false
    var urlLoad: Bool = false
    var updateTimer: Timer?
    var nameMetamodel: String?
    var nameOfModelToLoad : String?
    var onlyCodes: Bool?
    var external: Bool?
    var bluetooth: Bool?
    var firebase: Bool?
    var physic: Bool?
    var gameloop: Bool?
    var codesLoad: Bool = false
    var beaconsLoad: Bool = false
    var physicsLoad: Bool = false
    var gameloopLoad: Bool = false
    var accesses: [NSMutableDictionary] = []
    
    // MARK: Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //layout
        self.loginStackView.isHidden = true
        self.button.isEnabled = false
        self.button.setTitle("Wait", for: .normal)
        // old way to go to ikea example
        /*timer = Timer.scheduledTimer(timeInterval:1, target:self, selector:#selector(timeWaiting), userInfo: nil, repeats: true)
        self.loadMetamodels()*/
        
        // Retrieves list of names for cells
        self.namesRetriever()
        
        //
        self.loadTypeModels()
        
        // Table view
        self.loadModelTableView.dataSource = self
        self.loadModelTableView.delegate = self
    }
    
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        if(identifier == "fromLoadToARView") {
            if(self.graphicalSyntax.isEmpty || self.graphicalSyntax.isEmpty) {
                self.errorAlert(message: "Something is wrong with loading the models. Please, select again the pallette")
                return false
            } else if(self.accesses.isEmpty && self.external!) {
                self.errorAlert(message: "Something is wrong with loading external data from this pallette. Please, select again the pallette")
                return false
            }
            
        }
        return true
    }
    
    func errorAlert(message: String){
        let alertcontrol = UIAlertController(title: "Error", message: message, preferredStyle: .alert)
        let alertaction = UIAlertAction(title: "OK", style: .default)
        alertcontrol.addAction(alertaction)
        self.present(alertcontrol, animated: true)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "fromLoadToARView") {
            let arViewController: ARViewController = segue.destination as! ARViewController
            arViewController.graphicalSyntax = self.graphicalSyntax
            arViewController.itemsArray = self.itemsArray
            arViewController.itemsCodesOnly = self.itemsCodesOnly
            arViewController.metamodel = self.metamodel
            arViewController.nameMetamodel = self.nameMetamodel ?? ""
            arViewController.needToLoad = true
            arViewController.modelToLoad = self.nameOfModelToLoad ?? ""
            arViewController.codesOnly = self.onlyCodes ?? false
            arViewController.external = self.external ?? false
            arViewController.bluetooth = self.bluetooth ?? false
            arViewController.firebase = self.firebase ?? false
            arViewController.accesses = self.accesses
            arViewController.codesInfo = self.codesInfo
            arViewController.noSCNItems = self.noSCNItems
            arViewController.physicsInfo = self.physics
        }
    }

    // MARK: Func
    func loadTypeModels() {
        let url = URL(string: "https://alter-server.onrender.com/models?json=true")
        if (url != nil) {
            print("[LoadMVC] URL object exists: ", url!)
        }
        let session = URLSession.shared
        let task = session.dataTask(with: url!) { (data, response, error) -> Void in
            if error != nil {
                print("[LoadMVC] ", error!)
            } else {
                if let data = data {
                    do {

                        print("[LoadMVC] Task running")
                        
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
                            
                            if !(self.listOfMetamodelsName.contains(key)){
                                if !(self.listOfModelsName.count <= self.listOfMetamodelsName.count) {
                                    self.listOfMetamodelsName.append(key)
                                }
                            }
                            
                            self.graphicalSyntaxURLs.setValue(graphicModelString, forKey: key)
                            self.metamodelURLs.setValue(metamodelString, forKey: key)
                        }
                        self.urlLoad = true
                    } catch let e{
                        print("[LoadMVC] ", e)
                    }
                }
            }
        }
        task.resume()
        //updateTimer = Timer.scheduledTimer(timeInterval:1, target:self, selector:#selector(update), userInfo: nil, repeats: true)
    }
    
    @objc func timeWaiting(){
        if(self.fireTimer) {
            second+=1
            if(second >= 2 && self.fireTimer == true){
                self.fireTimer = false
                second = 0
                self.button.setTitle("Start", for: .normal)
                self.button.isEnabled = true
            }
        }
    }
    
    @objc func update(){
        self.loadModelTableView.reloadData()
    }
    
    func loadMetamodels(model: String) {
        if urlLoad {
            self.itemsCodesOnly = []
            // Load the metamodel
            let url = URL(string: self.metamodelURLs.value(forKey: model) as! String)
            if (url != nil) {
                print("[LoadMVC] URL object exists: ", url!)
            }
            let session = URLSession.shared
            let task = session.dataTask(with: url!) { (data, response, error) -> Void in
                if error != nil {
                    print("[LoadMVC] ", error!)
                } else {
                    if let data = data {
                        do {

                            print("[LoadMVC] Task running")
                            
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
                                self.firebase = body["firebase"] as? Bool
                                if self.external! {
                                    var dataLoad = false
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

                                                    print("[NewMVC] Access Task running")
                                                    
                                                    let jsonResult = try JSONSerialization.jsonObject(
                                                        with: data,
                                                        options: JSONSerialization.ReadingOptions.mutableContainers
                                                    ) as! NSMutableDictionary
                                                    let code = jsonResult["code"] as! String
                                                    if code == "200" {
                                                        let array = jsonResult["array"] as! NSMutableDictionary
                                                        let body = array["body"] as! [NSMutableDictionary]
                                                        self.accesses = body
                                                        dataLoad = true
                                                    }
                                                } catch let e{
                                                    print("[NewMVC] ", e)
                                                    dataLoad = true
                                                }
                                            }
                                        }
                                    }
                                    task.resume()
                                }
                                if self.physic != nil {
                                    if self.physic! {
                                        var string = "https://alter-server.onrender.com/physics?pname="
                                        string += model
                                        string += "&json=true"
                                        let physic_url = URL(string: string)
                                        if (physic_url != nil) {
                                            print("[NewMVC] physic_URL object exists: ", physic_url!)
                                        }
                                        let physic_session = URLSession.shared
                                        let physic_task = physic_session.dataTask(with: physic_url!) { (data, response, error) -> Void in
                                            if error != nil {
                                                print("[NewMVC] ", error!)
                                            } else {
                                                if let data = data {
                                                    do {

                                                        print("[NewMVC] physic_Task running")
                                                        
                                                        let jsonResult = try JSONSerialization.jsonObject(
                                                            with: data,
                                                            options: JSONSerialization.ReadingOptions.mutableContainers
                                                        ) as! NSMutableDictionary
                                                        let code = jsonResult["code"] as! String
                                                        if code == "200" {
                                                            let array = jsonResult["array"]
                                                            if !(array is NSNull) {
                                                                let arrayDic = array as! NSMutableDictionary
                                                                self.physics = arrayDic["physics"] as! [NSMutableDictionary]
                                                            }
                                                        }
                                                        self.physicsLoad = true
                                                    }  catch let e{
                                                        print("[NewMVC] ", e)
                                                    }
                                                }
                                            }
                                        }
                                        physic_task.resume()
                                    }
                                }
                                if self.gameloop != nil {
                                    if self.gameloop! {
                                        var string = "https://alter-server.onrender.com/gameloop?gname="
                                        string += model
                                        string += "&json=true"
                                        let gameloop_url = URL(string: string)
                                        if (gameloop_url != nil) {
                                            print("[NewMVC] gameloop_URL object exists: ", gameloop_url!)
                                        }
                                        let gameloop_session = URLSession.shared
                                        let gameloop_task = gameloop_session.dataTask(with: gameloop_url!) { (data, response, error) -> Void in
                                            if error != nil {
                                                print("[NewMVC] ", error!)
                                            } else {
                                                if let data = data {
                                                    do {

                                                        print("[NewMVC] physic_Task running")
                                                        
                                                        let jsonResult = try JSONSerialization.jsonObject(
                                                            with: data,
                                                            options: JSONSerialization.ReadingOptions.mutableContainers
                                                        ) as! NSMutableDictionary
                                                        let code = jsonResult["code"] as! String
                                                        if code == "200" {
                                                            let array = jsonResult["array"]
                                                            if !(array is NSNull) {
                                                                let arrayDic = array as! NSMutableDictionary
                                                                let body = arrayDic["body"] as! NSMutableDictionary
                                                                self.gameloops = body["game"] as! [NSMutableDictionary]
                                                            }
                                                        }
                                                        self.gameloopLoad = true
                                                    }  catch let e{
                                                        print("[NewMVC] ", e)
                                                    }
                                                }
                                            }
                                        }
                                        gameloop_task.resume()
                                    }
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
                                                            self.beaconsInfo = arrayDic["beacons"] as! [NSMutableDictionary]
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
                                    
                                    if (aClass["API"] != nil) {
                                        let APIClass = aClass["API"] as! String
                                        metamodelClass["APIClass"] = APIClass
                                    }
                                    if (aClass["auth"] != nil) {
                                        let APIClass = aClass["auth"] as! String
                                        metamodelClass["authClass"] = APIClass
                                    }
                                    if (aClass["autoID"] != nil) {
                                        let APIauto = aClass["autoID"] as! Bool
                                        metamodelClass["autoID"] = APIauto
                                    }
                                    self.metamodel.append(metamodelClass)
                                    
                                }
                            }
                            else {
                                print(jsonResult["error"] as! String)
                                self.errorAlert(message: jsonResult["error"] as! String)
                            }
                            
                        } catch let e{
                            print("[LoadMVC] ", e)
                        }
                    }
                }
            }
            print("[LoadMVC] Task resume")
            task.resume()
            
            // Load the graphic syntax
            let graphic_url = URL(string: self.graphicalSyntaxURLs.value(forKey: model) as! String)
            if (graphic_url != nil) {
                print("[LoadMVC] graphic_URL object exists: ", graphic_url!)
            }
            let graphic_session = URLSession.shared
            let graphic_task = graphic_session.dataTask(with: graphic_url!) { (data, response, error) -> Void in
                if error != nil {
                    print("[LoadMVC] ", error!)
                } else {
                    if let data = data {
                        do {

                            print("[LoadMVC] graphic_Task running")
                            
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
                                    if aClass["showAttributes"] != nil {
                                        graphicalSyntaxClass["showAttributes"] = classShowAttributes
                                    }
                                    
                                    graphicalSyntaxClass["constraints"] = classConstraints
                                    if aClass["connections"] != nil {
                                        graphicalSyntaxClass["connections"] = classConnections
                                    }
                                    if aClass["materialAttributes"] != nil {
                                        graphicalSyntaxClass["materialAttributes"] = aClass["materialAttributes"] as! NSMutableArray
                                    }
                                    if aClass["distances"] != nil {
                                        graphicalSyntaxClass["distances"] = aClass["distances"] as! NSMutableArray
                                    }
                                    self.graphicalSyntax.append(graphicalSyntaxClass)
                                    
                                }
                            }
                            else {
                                print(jsonResult["error"] as! String)
                                self.errorAlert(message: jsonResult["error"] as! String)
                            }
                            
                            
                        } catch let e{
                            print("[LoadMVC] ", e)
                        }
                    }
                }
            }
            print("[LoadMVC] graphic_Task resume")
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
        
        
    }
    
    func namesRetriever() {
        let fm = FileManager.default
        
        do {
            var path = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).path
            self.listOfMetamodelsName = try fm.contentsOfDirectory(atPath: path)
            
            for item in self.listOfMetamodelsName {
                if item == "picture" {
                    self.listOfMetamodelsName.remove(at: self.listOfMetamodelsName.firstIndex(of: item)!)
                }
                else {
                    print("[LoadMVC] Found \(item)")
                    path = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).appendingPathComponent(item).path
                    self.listOfModelsName.append(try fm.contentsOfDirectory(atPath: path))
                }
                
            }
            print("[LoadMVC] listOfList \(self.listOfModelsName)")
        } catch {
            print("[LoadMVC] Error with namesRetriever")
        }
    }
    
    // MARK: Table View
    //https://www.ioscreator.com/tutorials/prototype-cells-table-view-ios-tutorial
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if section < self.listOfMetamodelsName.count {
            if(self.listOfModelsName.count < self.listOfMetamodelsName.count) && (self.listOfModelsName.count < section) {
                return 0
            } else {
                return self.listOfModelsName[section].count
            }
        }
        
        return 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "modelCell", for: indexPath)
        cell.textLabel?.text = self.listOfModelsName[indexPath.section][indexPath.row]
        
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return self.listOfMetamodelsName.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let model = self.listOfMetamodelsName[indexPath.section]
        self.nameOfModelToLoad = self.listOfModelsName[indexPath.section][indexPath.row]
        self.loadMetamodels(model: model)
    }
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        if section < self.listOfMetamodelsName.count {
            return self.listOfMetamodelsName[section]
        }

        return nil
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
      if editingStyle == .delete {
        
        do {
            
            // delete file
            let fileManager = FileManager.default
            var url = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).appendingPathComponent(self.listOfMetamodelsName[indexPath.section]).appendingPathComponent(self.listOfModelsName[indexPath.section][indexPath.row])
            try fileManager.removeItem(at: url)
            
            //delete in row
            self.listOfModelsName[indexPath.section].remove(at: indexPath.row)
            self.loadModelTableView.deleteRows(at: [indexPath], with: .automatic)
            if(listOfModelsName[indexPath.section].isEmpty) {
                // delete folder
                url = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).appendingPathComponent(self.listOfMetamodelsName[indexPath.section])
                try fileManager.removeItem(at: url)
                // delete section
                self.listOfMetamodelsName.remove(at: indexPath.section)
                self.listOfModelsName.remove(at: indexPath.section)
                self.loadModelTableView.deleteSections([indexPath.section], with: .automatic)
            }
        } catch {
            print("[LoadMVC] error delete")
        }
        
      }
    }

}
