//
//  ARViewController+Persistence.swift
//  ARModelling
//
//  Created by Miso on 20/09/2020.
//

import ARKit

extension ARViewController {
    
    /**
     Save the current model in the file *nameModel*.
     
     - parameter nameModel: Name of the file.
     */
    func saveMap(nameModel: String) {
        
        sceneView.session.getCurrentWorldMap { (worldMap, error) in
            
            print("[ARVC+Persistence] Current world map: \(String(describing: worldMap?.anchors))")
            
            guard let worldMap = worldMap else {
                return self.displayLabel(text: "Error getting current world map.")
            }
            
            // Add a snapshot image indicating where the map was captured.
            guard let snapshotAnchor = SnapshotAnchor(capturing: self.sceneView)
                else { fatalError("Can't take snapshot") }
            worldMap.anchors.append(snapshotAnchor)
            
            do {
                try self.archive(worldMap: worldMap, nameModel: nameModel)
                self.displayLabel(text: "World map saved")
                self.hasChanges = false
            } catch {
                fatalError("Error saving world map: \(error.localizedDescription)")
            }
            
        }
    }
    
    /**
     Archive the **ARWorldMap** in the file *nameModel*.
     
     - parameter worldMap: The **ARWorldMap** that is going to be serialized.
     - parameter nameModel: Name of the file.
     */
    func archive(worldMap: ARWorldMap, nameModel: String) throws {
        self.createDirectory(nameOfLanguage: self.nameMetamodel)
        for anAnchor in worldMap.anchors {
            if (anAnchor.isKind(of: AttributesAnchor.self)) {
                if let anAttributesAnchor = anAnchor as? AttributesAnchor {
                    if anAttributesAnchor.codeAttached != "" {
                        for anchor in worldMap.anchors {
                            if (anchor.isKind(of: ItemAnchor.self)) {
                                if let anItemAnchor = anchor as? ItemAnchor {
                                    if anItemAnchor.givenName == anAttributesAnchor.nameOfItemAnchor {
                                        var json: [String: Any] = ["codeId" : anAttributesAnchor.codeAttached]
                                        let attributesDic = anAttributesAnchor.getValueOfAttributes()
                                        
                                        for key in attributesDic.allKeys {
                                            json.updateValue(attributesDic[key]!, forKey: key as! String)
                                        }
                                        let jsonData = try? JSONSerialization.data(withJSONObject: json)
                                        
                                        var string = "https://alter-databroker.onrender.com/postUrl?aname="
                                        string += self.nameMetamodel
                                        
                                        string += "&aclass="
                                        string += anItemAnchor.type + "&ain="
                                        string += anAttributesAnchor.codeAttached.replacingOccurrences(of: " ", with: "+") + "&json=true"
                                        
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
                                        
                                        var json2: [String: Any] = ["code" : anAttributesAnchor.codeAttached]
                                        let dict = NSMutableDictionary()
                                        dict.setValue(anItemAnchor.type, forKey: "class")
                                        dict.setValue(anItemAnchor.givenName, forKey: "nodename")
                                        dict.setValue(self.nameMetamodel, forKey: "name")
                                        
                                        for key in dict.allKeys {
                                            json2.updateValue(dict[key]!, forKey: key as! String)
                                        }
                                        let jsonData2 = try? JSONSerialization.data(withJSONObject: json2)
                                        
                                        let string2 = "https://alter-server.onrender.com/pushCodesInfos?json=true"
                                        let url2 = URL(string: string2)!
                                        var request2 = URLRequest(url: url2)
                                        request2.httpMethod = "POST"
                                        request2.httpBody = jsonData2
                                        request2.setValue("application/json", forHTTPHeaderField: "Content-Type")
                                        request2.setValue("application/json", forHTTPHeaderField: "Accept")
                                        
                                        let task2 = URLSession.shared.dataTask(with: request2) { data, response, error in
                                            guard let data = data, error == nil else {
                                                print(error?.localizedDescription ?? "No data")
                                                return
                                            }
                                            let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
                                            if let responseJSON = responseJSON as? [String: Any] {
                                                print(responseJSON)
                                            }
                                        }
                                        task2.resume()
                                        break
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        let url = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).appendingPathComponent(self.nameMetamodel).appendingPathComponent(nameModel)
        let data = try! NSKeyedArchiver.archivedData(withRootObject: worldMap, requiringSecureCoding: true)
        try data.write(to: url, options: [.atomic])
    }
    
    /**
     Create the directory named after the name of the metamodel if it does not already exist. The files of the model will be saved in this directory.
     
     - parameter nameOfLanguage: Name of the metamodel, the directory will be named using it.
     */
    func createDirectory(nameOfLanguage: String) {
        let paths = NSSearchPathForDirectoriesInDomains(.documentDirectory, .userDomainMask, true)
        let documentsDirectory = paths[0]
        let docURL = URL(string: documentsDirectory)!
        let dataPath = docURL.appendingPathComponent(nameOfLanguage)
        if !FileManager.default.fileExists(atPath: dataPath.absoluteString) {
            do {
                try FileManager.default.createDirectory(atPath: dataPath.absoluteString, withIntermediateDirectories: true, attributes: nil)
            } catch {
                print("[ARVC+Persistence] ", error.localizedDescription);
            }
        }
    }
    
    /**
     Load the **ARWorldMap** previously saved in the directory of the metamodel, inside the file named after the model. The configuration is reseted in order to display all the saved anchors and its node.
     */
    func loadModel() {
        
        let worldMap: ARWorldMap = {
            guard let data = try? Data(contentsOf: FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).appendingPathComponent(self.nameMetamodel).appendingPathComponent(self.modelToLoad))
                else { fatalError("[ARVC+Persistence] fatalError: url") }
            do {
                guard let worldMap = try NSKeyedUnarchiver.unarchivedObject(ofClass: ARWorldMap.self, from: data)
                    else { fatalError("[ARVC+Persistence] fatalError: no ARWorldMap in archive") }
                return worldMap
            } catch {
                fatalError("[ARVC+Persistence] fatalError: Can't unarchive ARWorldMap from url \(error)")
            }
        }()
        
        // Display the snapshot image stored in the world map to aid user in relocalizing.
        if let snapshotData = worldMap.snapshotAnchor?.imageData,
            let snapshot = UIImage(data: snapshotData) {
            self.snapshotThumbnail.image = snapshot
            self.imageTipSnapshot.image = snapshot
            self.imageTipSnapshot.contentMode = .scaleAspectFit
        } else {
            print("No snapshot image in world map")
        }
        // Remove the snapshot anchor from the world map since we do not need it in the scene.
        worldMap.anchors.removeAll(where: { $0 is SnapshotAnchor })
        
        self.configuration.initialWorldMap = worldMap
        sceneView.session.run(configuration, options: [.resetTracking, .removeExistingAnchors])
        
    }
    
    /*
    func retrieveWorldMapData() -> Data? {
        do {
            let url = try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true).appendingPathComponent(self.nameMetamodel).appendingPathComponent(self.modelToLoad)
            return try Data(contentsOf: url)
        } catch {
            self.displayLabel(text: "Error retrieving world map data.")

            return nil
        }
    }*/
    
    /*func unarchive(worldMapData data: Data) -> ARWorldMap? {
        let unarchievedObject = try? NSKeyedUnarchiver.unarchivedObject(ofClass: ARWorldMap.self, from: data)
        let worldMap = unarchievedObject
        return worldMap
    }*/
    
    /*func resetTrackingConfiguration(with worldMap: ARWorldMap? = nil) {
        let configuration = ARWorldTrackingConfiguration()
        configuration.planeDetection = [.horizontal]
        
        let options: ARSession.RunOptions = [.resetTracking, .removeExistingAnchors]
        if let worldMap = worldMap {
            configuration.initialWorldMap = worldMap
            self.displayLabel(text: "Found saved world map.")
        } else {
            self.displayLabel(text: "Move camera around to map your surrounding space.")
        }
        
        sceneView.debugOptions = [.showFeaturePoints]
        sceneView.session.run(configuration, options: options)
    }*/
    
    /**
     Display a custom message *text* in the *saveLabel* during 4 seconds,
     */
    func displayLabel(text: String) {
        DispatchQueue.main.async {
            self.saveLabel.text = text
            self.saveLabel.isHidden = false
            DispatchQueue.main.asyncAfter(deadline: .now() + 4) {
                self.saveLabel.isHidden = true
            }
        }
    }
    
}

extension ARWorldMap {
    var snapshotAnchor: SnapshotAnchor? {
        return anchors.compactMap { $0 as? SnapshotAnchor }.first
    }
}
