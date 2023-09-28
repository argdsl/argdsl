//
//  ARViewController+Gestures.swift
//  ARModelling
//
//  Created by Miso on 20/09/2020.
//

import UIKit
import ARKit

extension ARViewController {

    class mySwipeRecognizer: UISwipeGestureRecognizer {
        var lastTap : Set<UITouch>?
        var lastPoint : CGPoint?
        override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent) {
            lastTap = touches
            let touchpoint:CGPoint? = touches.first?.location(in: self.view)
            lastPoint = touchpoint
            super.touchesMoved(touches, with:event)
        }
    }
    // MARK: Functions
    func registerGestureRecognizers() {
        // Tap gesture is used to add objects
        let tapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(tapped))
        self.sceneView.addGestureRecognizer(tapGestureRecognizer)

        // Pinch gesture is used to resize the object
        let pinchGestureRecognizer = UIPinchGestureRecognizer(target: self, action: #selector(pinch))
        self.sceneView.addGestureRecognizer(pinchGestureRecognizer)

        // Long press gesture is used to play or pause videos if button is pressed
        let longPressGestureRecognizer = UILongPressGestureRecognizer(target: self, action: #selector(playOrPause))
        longPressGestureRecognizer.minimumPressDuration = 0.1
        self.sceneView.addGestureRecognizer(longPressGestureRecognizer)

        // Swipe gesture is used to change the graphic syntax version
        let swipeGestureRecognizer = mySwipeRecognizer(target: self, action: #selector(swiped))
        self.sceneView.addGestureRecognizer(swipeGestureRecognizer)

        // Pan gesture is used to move the object
        let panGestureRecognizer = UIPanGestureRecognizer(target: self, action: #selector(move))
        panGestureRecognizer.require(toFail: swipeGestureRecognizer)
        self.sceneView.addGestureRecognizer(panGestureRecognizer)
        
        // Rotate gesture is used to rotate object
        let rotationGestureRecognizer = UIRotationGestureRecognizer(target: self, action: #selector(rotate))
        self.sceneView.addGestureRecognizer(rotationGestureRecognizer)
    }

    @objc func playOrPause(sender: UILongPressGestureRecognizer) {
        // Get from the scene the tapped position
        let sceneView = sender.view as! ARSCNView
        let tapLocation = sender.location(in: sceneView)
        
        // Get results of a SceneKit hit testing
        let sceneResult: [SCNHitTestResult] = sceneView.hitTest(tapLocation,
                                                                options: [SCNHitTestOption.firstFoundOnly: true])

        guard let rayCast: SCNHitTestResult = sceneResult.first
        else {
            print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
            return
        }
        
        let oldNode = rayCast.node
        if (oldNode.name != nil) {

            let oldNodeName = oldNode.name!
            print("[ARVC+Gestures] Scene raycast result is node", oldNodeName)
            
            //In pause cause, raycast detect the box. We will take his parent node (the entire pause)
            var nodeToCheck : SCNNode
            if oldNodeName == "box" {
                nodeToCheck = oldNode.parent ?? oldNode
            } else {
                nodeToCheck = oldNode
            }
            
            // Check if the result's node is in the view. Must be the parent if play or pause
            if self.sceneView.scene.rootNode.childNodes.contains(nodeToCheck.parent ?? nodeToCheck){
                var itemFound = false
                for eachItemDic in self.model {
                    if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                        print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(oldNodeName)")
                        if eachNameOfItemInModel + "play" == nodeToCheck.name || eachNameOfItemInModel + "pause" == nodeToCheck.name {
                            itemFound = true
                            break
                        }
                    }
                }
                if itemFound {
                    let contain = (nodeToCheck.name?.contains("play")) ?? false
                    let containPause = (nodeToCheck.name?.contains("pause"))!
                    //Check before retrieving parents and SKVideoNode, to avoid bugs
                    if contain {
                        let videoNode = nodeToCheck.parent
                        var videoMaterial : SCNMaterial?
                        if videoNode?.childNode(withName: "image", recursively: false) != nil {
                            let image = videoNode?.childNode(withName: "image", recursively: false)
                            videoMaterial =  image?.geometry?.material(named: "video")
                        } else {
                            videoMaterial = videoNode?.geometry?.material(named: "video")
                        }
                        let skscene = videoMaterial?.diffuse.contents as! SKScene
                        let video = skscene.childNode(withName: "video") as! SKVideoNode
                        video.play()
                    } else if containPause {
                        let videoNode = nodeToCheck.parent
                        var videoMaterial : SCNMaterial?
                        if videoNode?.childNode(withName: "image", recursively: false) != nil {
                            let image = videoNode?.childNode(withName: "image", recursively: false)
                            videoMaterial =  image?.geometry?.material(named: "video")
                        } else {
                            videoMaterial = videoNode?.geometry?.material(named: "video")
                        }
                        let skscene = videoMaterial?.diffuse.contents as! SKScene
                        let video = skscene.childNode(withName: "video") as! SKVideoNode
                        video.pause()
                    }
                }
            }
        }
    }
    
    
    @objc func rotate(sender: UIRotationGestureRecognizer) {
        // Get from the scene the tapped position
        let sceneView = sender.view as! ARSCNView
        let tapLocation = sender.location(in: sceneView)

        // Get results of a SceneKit hit testing
        let sceneResult: [SCNHitTestResult] = sceneView.hitTest(tapLocation,
                                                                options: [SCNHitTestOption.firstFoundOnly: true])

        guard let rayCast: SCNHitTestResult = sceneResult.first
        else {
            print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
            return
        }
        
        let oldNode = rayCast.node
        if (oldNode.name != nil) {

            let oldNodeName = oldNode.name!
            print("[ARVC+Gestures] Scene raycast result is node", oldNodeName)
            
            // Check if the result's node is in the view
            if self.sceneView.scene.rootNode.childNodes.contains(oldNode){
                var itemFound = false
                for eachItemDic in self.model {
                    
                    if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                        print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(oldNode.name)")
                        if eachNameOfItemInModel == oldNode.name {
                            itemFound = true
                        }
                    }
                }
                
                if itemFound {
                    let rotateAction = SCNAction.rotate(by: sender.rotation, around: SCNVector3Make(0, 0, 1), duration: 0)
                    oldNode.runAction(rotateAction)
                }
            }
        }
    }
    
    // Gestures do 2 types of raycasting
    // - World raycasting, based on ARRaycastQuery supported by ARKit to find world surfaces, etc.
    // - Scene raycasting, based on SCNHitTest supported by SceneKit to find virtual nodes.

    @objc func tapped(sender: UITapGestureRecognizer) {
        
        // Get from the scene the tapped position
        let sceneView = sender.view as! ARSCNView
        let tapLocation = sender.location(in: sceneView)

        // Get results of a SceneKit hit testing
        let sceneResult: [SCNHitTestResult] = sceneView.hitTest(tapLocation,
                                                                options: [SCNHitTestOption.firstFoundOnly: true])

        guard let rayCast: SCNHitTestResult = sceneResult.first
        else {
            print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
            return
        }

        // Change a graphical model by other
        let oldNode = rayCast.node
        if (oldNode.name != nil) {

            let oldNodeName = oldNode.name!
            print("[ARVC+Gestures] Scene raycast result is node", oldNodeName)
        }
        if self.physicButton.currentTitleColor == .green {
            if self.sceneView.scene.rootNode.childNodes.contains(oldNode) {
                var itemAnchor : ItemAnchor
                let anchor = self.sceneView.anchor(for: oldNode)
                if anchor != nil {
                    if (anchor!.isKind(of: ItemAnchor.self)) {
                        itemAnchor = anchor as! ItemAnchor
                        if self.physicItems == [] || itemAnchor.type != self.selectedPhysicClass {
                            self.physicItems = convertStringToArray(text: itemAnchor.forces) as! [String]
                            self.itemsCollectionView.reloadData()
                            self.selectedPhysicClass = itemAnchor.type
                        } else {
                            let forceName = self.selectedItem
                            //self.forceToNode(node: oldNode, forceName: forceName!, anchor: itemAnchor)
                            var physicsOfSelectedItem = NSMutableDictionary()
                            var forces : NSMutableArray = []
                            for physicData in self.physicsInfo {
                                let classPhysic = physicData["name"] as! String
                                if classPhysic == itemAnchor.type {
                                    physicsOfSelectedItem = physicData
                                }
                            }
                            if physicsOfSelectedItem["forces"] != nil {
                                forces = physicsOfSelectedItem["forces"] as! NSMutableArray
                            }
                            for forceObj in forces {
                                let forceDic = forceObj as! NSMutableDictionary
                                if forceName == forceDic["name"] as? String && forceName != nil {
                                    let forceGesture = forceDic["gesture"] as! String
                                    if forceGesture == "touch" {
                                        var forceVector = SCNVector3Make(0, 1, -0.5)
                                        if forceDic["xVector"] != nil {
                                            let x = forceDic["xVector"] as! Double
                                            let y = forceDic["yVector"] as! Double
                                            let z = forceDic["zVector"] as! Double
                                            forceVector = SCNVector3Make(Float(x), Float(y), Float(z))
                                        }
                                        guard let pointOfView = self.sceneView.pointOfView?.transform else {return}
                                        let orientation = SCNVector3Make(-pointOfView.m31, -pointOfView.m32, -pointOfView.m33)
                                        let force = Force(force: forceVector, orientation: orientation)
                                        oldNode.physicsBody?.applyForce(force.finalForce, asImpulse: true)
                                    } else if forceGesture == "pan" {
                                        self.nodeToPan = oldNode
                                        oldNode.geometry?.firstMaterial?.emission.contents = UIColor.green
                                    } else if forceGesture == "tilt" {
                                        let triggers = self.getPhysicsTriggers(classPhysic: itemAnchor.type)
                                        if triggers != [] {
                                            for trigger in triggers {
                                                let objtrr = trigger as! NSMutableDictionary
                                                let objname = objtrr["name"] as! String
                                                if objname == "tilt" {
                                                    let text = objtrr["action"] as! String
                                                    self.doAction(actionName: text)
                                                }
                                            }
                                        }
                                        if tiltMotion.isDeviceMotionAvailable {
                                            oldNode.geometry?.firstMaterial?.emission.contents = UIColor.green
                                            tiltMotion.deviceMotionUpdateInterval = 0.1
                                            let q = OperationQueue()
                                            tiltMotion.startDeviceMotionUpdates(to: q, withHandler: { [weak self] motion, error in
                                                if let attitude = motion?.attitude {
                                                    
                                                    DispatchQueue.main.async {
                                                        let rotateAction = SCNAction.rotateTo(x: attitude.pitch, y: attitude.yaw, z: -attitude.roll, duration: 0.1, usesShortestUnitArc: true)
                                                        oldNode.runAction(rotateAction)
                                                    }
                                                }
                                            })
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if(self.selectedItem == nil) {
                return
            }
            let editcontrol = UIAlertController(title: "Edit", message: "Write the new name", preferredStyle: .alert)
            //action of the modal. User writes the word, create new object
            let alertaction = UIAlertAction(title: "Cancel", style: .cancel)
            editcontrol.addAction(alertaction)
            let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
                guard let textfield = editcontrol.textFields?.first else { return }
                let text = textfield.text
                //use the content of textfield to create the new object
                if (text != nil) {
                    if(text!.count == 0){
                        self.repeatedAlert(message: "The name must not be empty", tapLocation: tapLocation, sceneView: sceneView)
                    } else {
                        if(self.objectsList.allKeys.isEmpty || self.objectsList.value(forKey: text!) == nil) {
                            self.addElement(at: tapLocation, withName: text!, to: sceneView)
                        } else {
                            self.repeatedAlert(message: "Object " + text! + " already exists. Write another", tapLocation: tapLocation, sceneView: sceneView)
                        }
                        
                    }
                } else {
                    self.repeatedAlert(message: "There was an error while getting the name. Try again", tapLocation: tapLocation, sceneView: sceneView)
                }
            }
            //open editable textfield
            editcontrol.addTextField(configurationHandler: { (textField) -> Void in
                textField.text = self.selectedItem
                var i = 0
                while(true) {
                    if(self.objectsList.allKeys.isEmpty || self.objectsList.value(forKey: textField.text!) == nil) {
                        break;
                    }
                    textField.text = self.selectedItem! + " " + String(i)
                    i+=1
                }
                
            })
            editcontrol.addAction(editalertaction)
            self.present(editcontrol, animated: true)
        }
    }

    func repeatedAlert(message: String, tapLocation: CGPoint, sceneView: ARSCNView) {
        let editcontrol = UIAlertController(title: "Edit", message: message, preferredStyle: .alert)
        //action of the modal. User writes the word, create new object
        let alertaction = UIAlertAction(title: "Cancel", style: .cancel)
        editcontrol.addAction(alertaction)
        let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
            guard let textfield = editcontrol.textFields?.first else { return }
            let text = textfield.text
            //use the content of textfield to create the new object
            if (text != nil) {
                if(text!.count == 0){
                    self.repeatedAlert(message: "The name must not be empty", tapLocation: tapLocation, sceneView: sceneView)
                } else {
                    if(self.objectsList.allKeys.isEmpty || self.objectsList.value(forKey: text!) == nil) {
                        self.addElement(at: tapLocation, withName: text!, to: sceneView)
                    } else {
                        self.repeatedAlert(message: "Object " + text! + " already exists. Write another", tapLocation: tapLocation, sceneView: sceneView)
                    }
                    
                }
            } else {
                self.repeatedAlert(message: "There was an error while getting the name. Try again", tapLocation: tapLocation, sceneView: sceneView)
            }
        }
        //open editable textfield
        editcontrol.addTextField()
        editcontrol.addAction(editalertaction)
        self.present(editcontrol, animated: true)
    }
    
    @objc func pinch (sender: UIPinchGestureRecognizer) {
        // TODO: Change to raycast. Alberto J. 2020/06/29
        let sceneView = sender.view as! ARSCNView
        let pinchLocation = sender.location(in: sceneView)
        let hitTest = sceneView.hitTest(pinchLocation)
        if !hitTest.isEmpty {
            let results = hitTest.first!
            let node = results.node
            
            var item: NSMutableDictionary = [:]
            var itemFound = false
            var isParent = false
            for anItem in self.model {
                if let nameOfItemInModel = anItem["name"] as? String {
                    if nameOfItemInModel == node.name {
                        item = anItem
                        itemFound = true
                    } else {
                        let parent = node.parent
                        if parent != nil {
                            let parentName = parent?.name
                            if nameOfItemInModel == parentName {
                                item = anItem
                                itemFound = true
                                isParent = true
                            }
                        }
                    }
                }
            }
            
            if(itemFound) {
                //Get the graph syntax to get min and max measure that should be shown
                var graphicalSyntaxClass = NSMutableDictionary()
                for aGraphicalSyntaxClass in self.graphicalSyntax {
                    let className = aGraphicalSyntaxClass["name"] as! String
                    //if className == self.selectedItem {
                    if className == item["class"] as! String {
                        graphicalSyntaxClass = aGraphicalSyntaxClass
                    }
                }
                let classConstraints = graphicalSyntaxClass["constraints"] as! NSMutableDictionary
                let max = classConstraints["sizeMax"] as! String
                let min = classConstraints["sizeMin"] as! String
                if(sender.scale > 1){
                    sender.scale = 1.01
                } else if(sender.scale < 1){
                    sender.scale = 0.99
                }

                let pinchAction = SCNAction.scale(by: sender.scale, duration: 0)

                if isParent {
                    if((node.parent?.scale.x)! < (max as NSString).floatValue){
                        if((node.parent?.scale.x)! > (min as NSString).floatValue){
                            node.parent?.runAction(pinchAction)
                        } else {
                            if(sender.scale > 1){
                                node.parent?.runAction(pinchAction)
                            }
                        }

                    } else {
                        if(sender.scale < 1){
                            node.parent?.runAction(pinchAction)
                        }
                    }
                    sender.scale = 1.0
                    let anchor = self.sceneView.anchor(for: (node.parent)!)!
                    if (anchor.isKind(of: ItemAnchor.self)) {
                        if let anItemAnchor = anchor as? ItemAnchor {
                            if anItemAnchor.itemIdentifier == node.parent?.name  {
                                anItemAnchor.scale = node.parent!.scale
                            }
                        }
                    }
                } else {
                    if(node.scale.x < (max as NSString).floatValue){
                        if(node.scale.x > (min as NSString).floatValue){
                            node.runAction(pinchAction)
                        } else {
                            if(sender.scale > 1){
                                node.runAction(pinchAction)
                            }
                        }

                    } else {
                        if(sender.scale < 1){
                            node.runAction(pinchAction)
                        }
                    }
                    sender.scale = 1.0
                    let anchor = self.sceneView.anchor(for: node)!
                    if (anchor.isKind(of: ItemAnchor.self)) {
                        if let anItemAnchor = anchor as? ItemAnchor {
                            if anItemAnchor.itemIdentifier == node.name  {
                                anItemAnchor.scale = node.scale
                            }
                        }
                    }
                }/*
                self.sceneView.session.getCurrentWorldMap { (worldMap, error) in
                    for anAnchor in worldMap!.anchors {
                        if (anAnchor.isKind(of: ItemAnchor.self)) {
                            if let anItemAnchor = anAnchor as? ItemAnchor {
                                if anItemAnchor.itemIdentifier == node.name  {
                                    anItemAnchor.scale = node.scale
                                }
                            }
                        }
                    }
                }*/
            }
        }
    }

    @objc func showAttributes(sender: UISwipeGestureRecognizer) {
        
        // Get from the scene the tapped position
        let sceneView = sender.view as! ARSCNView
        let tapLocation = sender.location(in: sceneView)

        // Get results of a SceneKit hit testing
        let sceneResult: [SCNHitTestResult] = sceneView.hitTest(tapLocation, options: [SCNHitTestOption.firstFoundOnly: true])

        guard let rayCast: SCNHitTestResult = sceneResult.first
        else {
            print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
            return
        }

        // Compose and show the attributes
        let oldNode = rayCast.node
        if (oldNode.name != nil) {

            let oldNodeName = oldNode.name!
            print("[ARVC+Gestures] Scene raycast result is node", oldNodeName)

            // Check if the result's node is in the view
            if self.sceneView.scene.rootNode.childNodes.contains(oldNode) {

                // LEA: "save" the node for potential deletion
                self.nodeToDelete = oldNode

                // Search for the result's object in the model, as an object or as an attributes
                var itemDic: NSMutableDictionary = [:]
                var itemFound = false
                //var arfacetDic: NSMutableDictionary = [:] ->(see next /* */ block)<-
                //var facetFound = false
                for eachItemDic in self.model {

                    
                    if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                        print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(oldNode.name)")
                        if eachNameOfItemInModel == oldNode.name {
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
                    let itemReadOnlyAttributes = itemDic["readOnlyAttributes"] as! NSMutableDictionary
                    let itemReferences = itemDic["references"] as! NSMutableDictionary
                    let itemTargetReferences = itemDic["targetReferences"] as! NSMutableDictionary
                    let itemMaxReferences = itemDic["maxReferences"] as! NSMutableDictionary

                    //print("[ARVC+Gestures] Shown attributes: ", string)

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

                }  else {
                    print("[ARVC+Gestures] Scene raycast result not found in model", oldNodeName)
                }

                print("[ARVC+Gestures] Model", self.model)

            } else {
                // If nil, the raycast did not get a model's object
                print("[ARVC+Gestures] Scene raycast result is node named (null)")
            }

        }

    }

    @objc func swiped(sender: mySwipeRecognizer) {
        print("------------------------ COUCOU SWIPED")

        // Get from the scene the tapped position
        let sceneView = sender.view as! ARSCNView
        let tapLocation = sender.location(in: sceneView)

        if self.physicButton.currentTitleColor == UIColor.green {
            if self.nodeToPan != nil {
                print(tapLocation)
                print(sender.lastPoint)
                physicControl(sender: sender, tapLocation: tapLocation, oldNode: self.nodeToPan!)
            }
        } else {
            // Get results of a SceneKit hit testing
            let sceneResult: [SCNHitTestResult] = sceneView.hitTest(tapLocation,
                                                                    options: [SCNHitTestOption.firstFoundOnly: true])

            guard let rayCast: SCNHitTestResult = sceneResult.first
            else {
                print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
                return
            }

            // Change a graphical model by other
            let oldNode = rayCast.node
            if (oldNode.name != nil) {

                let oldNodeName = oldNode.name!
                print("[ARVC+Gestures] Scene raycast result is node", oldNodeName)
                
                var nodeToCheck = oldNode
                
                //check parent if is part of him detected
                if oldNodeName == "Cube" || oldNodeName.contains("geo") {
                    nodeToCheck = oldNode.parent ?? oldNode
                }
                // Check if the result's node is in the view
                if self.sceneView.scene.rootNode.childNodes.contains(nodeToCheck) {
                    //check if is line
                    for line in self.lines {
                        if((line.name?.contains(nodeToCheck.name!)) == true) {
                            changeVersionLine(line: line)
                        }
                    }
                    // Search for the result's object
                    var itemDic: NSMutableDictionary = [:]
                    var itemFound = false
                    for eachItemDic in self.model {

                        
                        let eachNameOfItemInModel = eachItemDic["name"] as! String
                        if eachNameOfItemInModel == nodeToCheck.name {
                            itemDic = eachItemDic
                            itemFound = true
                        }

                    }
                    if (itemFound) {

                        // Update the model
                        var currentVersion = itemDic["current_version"] as! Int
                        let maxVersion = itemDic["max_version"] as! Int
                        if currentVersion < maxVersion {
                            currentVersion += 1
                        } else {
                            currentVersion = 1
                        }
                        itemDic["current_version"] = currentVersion
                        let selectedItem = itemDic["class"] as! String
                        let itemName = itemDic["name"] as! String

                        // Search for its graphical syntax
                        var graphicalSyntaxClass = NSMutableDictionary()
                        for aGraphicalSyntaxClass in self.graphicalSyntax {
                            let className = aGraphicalSyntaxClass["name"] as! String
                            if className == selectedItem {
                                graphicalSyntaxClass = aGraphicalSyntaxClass
                            }
                        }

                        // Get the version's sources and change its graphical syntax in scene
                        let classVersions = graphicalSyntaxClass["versions"] as! NSMutableDictionary
                        let classVersionsNames = graphicalSyntaxClass["vname"] as! NSMutableDictionary
                        let firstSource = classVersions["v\(currentVersion)"] as! String;
                        let sourceName = classVersionsNames["v\(currentVersion)"] as! String;

                        for node in self.sceneView.scene.rootNode.childNodes {
                            let anAnchor = self.sceneView.anchor(for: node)
                            if anAnchor != nil {
                                if (anAnchor!.isKind(of: ItemAnchor.self)) {
                                    if let anItemAnchor = anAnchor as? ItemAnchor {
                                        if anItemAnchor.itemIdentifier == itemName  {
                                            print("\n\n \(anItemAnchor.currentVersion) and \(anItemAnchor.urlOfCurrentVersion) \n\n")
                                            anItemAnchor.currentVersion = sourceName
                                            anItemAnchor.urlOfCurrentVersion = firstSource
                                            print("\n\n \(anItemAnchor.currentVersion) and \(anItemAnchor.urlOfCurrentVersion) \n\n")
                                            let itemAnchorBuffer = ItemAnchor(identifier: anItemAnchor.identifier, name: anItemAnchor.givenName, type: anItemAnchor.type, currentVersion: anItemAnchor.currentVersion, currentVersionInt: currentVersion, urlOfCurrentVersion: anItemAnchor.urlOfCurrentVersion, numberOfVersions: anItemAnchor.numberOfVersions, versions: anItemAnchor.getVersions(), attributes: anItemAnchor.getAttributes(), references: anItemAnchor.getReferences(), constraints: anItemAnchor.getConstraints(), attributesToShow: anItemAnchor.getAttributesToShow(), attributesMaterials: convertStringToArray(text: anItemAnchor.attributesMaterials), scale: anItemAnchor.scale , rotation: anItemAnchor.rotation, QR: anItemAnchor.QR, API: anItemAnchor.API, auth: anItemAnchor.auth, param: anItemAnchor.getParam(), previousInfo: "", beacon: anItemAnchor.beacon, forces: convertStringToArray(text: anItemAnchor.forces), initForce: anItemAnchor.initForce, transform: anItemAnchor.transform)
                                            itemAnchorBuffer.setValueOfAttributes(value: anItemAnchor.getValueOfAttributes())
                                            itemAnchorBuffer.setValueOfReferences(value: anItemAnchor.getValueOfReferences())
                                            itemAnchorBuffer.scale = anItemAnchor.scale
                                            //to avoid jump to case loading model
                                            self.needToLoad = false
                                            
                                            for node2 in self.sceneView.scene.rootNode.childNodes {
                                                let anAnchor2 = self.sceneView.anchor(for: node2)
                                                if anAnchor2 != nil {
                                                    if (anAnchor2!.isKind(of: AttributesAnchor.self)) {
                                                        if let anAttributesAnchor = anAnchor2 as? AttributesAnchor {
                                                            if anAttributesAnchor.idOfItemAnchor == itemName  {
                                                                let attributesAnchorBuffer = AttributesAnchor(idOfItemAnchor: anItemAnchor.itemIdentifier, nameOfItemAnchor: anItemAnchor.givenName, valueOfAttributes: anItemAnchor.getValueOfAttributes(), attributesToShow: anItemAnchor.getAttributesToShow(), codeAttached: anAttributesAnchor.codeAttached, beaconAttached: anAttributesAnchor.beaconAttached, transform: anItemAnchor.transform)
                                                                self.sceneView.session.remove(anchor: anAttributesAnchor)
                                                                self.sceneView.session.add(anchor: attributesAnchorBuffer)
                                                            }
                                                        }
                                                    }
                                                }
                                                
                                            }
                                            self.sceneView.session.remove(anchor: anItemAnchor)
                                            self.itemAnchors.remove(at: self.itemAnchors.lastIndex(of: anItemAnchor)!)
                                            self.sceneView.session.add(anchor: itemAnchorBuffer)
                                            self.itemAnchors.append(itemAnchorBuffer)
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        print("[ARVC+Gestures] Scene raycast result not found in model", oldNodeName)
                    }

                    print("[ARVC+Gestures] Model", self.model)

                } else {
                    // If nil, the raycast did not get a model's object
                    print("[ARVC+Gestures] Scene raycast result is node named (null)")
                }

            }
        }
    }

    func changeVersionLine(line: Line) {
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
        let initpos = SCNVector3(objectCords.value(forKey: "x") as! Float, objectCords.value(forKey: "y") as! Float, objectCords.value(forKey: "z") as! Float)
        let finalpos = SCNVector3(objectFinalCords.value(forKey: "x") as! Float, objectFinalCords.value(forKey: "y") as! Float, objectFinalCords.value(forKey: "z") as! Float)
        let interPos = SCNVector3((initpos.x + finalpos.x)/2, (initpos.y + finalpos.y)/2, (initpos.z + finalpos.z)/2)
        let linelength = finalpos - initpos
        let length = linelength.distance()
        
        //check the version with graph sintax
        var graphicalSyntaxClass = NSMutableDictionary()
        for aGraphicalSyntaxClass in self.graphicalSyntax {
            let className = aGraphicalSyntaxClass["name"] as! String
            if className == target {
                graphicalSyntaxClass = aGraphicalSyntaxClass
            }
        }
        let classConnections = graphicalSyntaxClass["connections"] as! NSMutableDictionary
        let arrayConnectors = classConnections[name] as! NSMutableArray
        
        //get previous version
        let version = self.linesEachVersion.value(forKey: line.name!) as! String
        
        //get the next version of current version. If is current version the last, take first
        var conf = NSMutableDictionary()
        var next = false
        for connector in arrayConnectors {
            let aux = connector as! NSMutableDictionary
            if(aux["name"] as! String == version) {
                next = true
            } else if(next == true) {
                conf = aux
                next = false
                break;
            }
        }
        if(next == true) {
            conf = arrayConnectors[0] as! NSMutableDictionary
        }
        var capRadius = CGFloat(0.001)
        let format = NumberFormatter()
        format.decimalSeparator = "."
        capRadius = CGFloat(truncating: format.number(from: conf["width"] as! String)!)
        let vector = SCNVector3Make(finalpos.x - initpos.x, finalpos.y - initpos.y, finalpos.z - initpos.z)
        
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
        self.linesEachVersion.setValue(conf["name"] as! String, forKey: newLine.name!)
        self.sceneView.scene.rootNode.addChildNode(newLine)
    }
    
    //https://medium.com/@literalpie/dragging-objects-in-scenekit-and-arkit-3568212a90e5
    @objc func move(sender : UIPanGestureRecognizer){
        // Get from the scene the tapped position
        let sceneView = sender.view as! ARSCNView
        let tapLocation = sender.location(in: sceneView)

        // Get results of a SceneKit hit testing
        let sceneResult: [SCNHitTestResult] = sceneView.hitTest(tapLocation,
                                                                options: [SCNHitTestOption.firstFoundOnly: true])
        if self.physicButton.currentTitleColor == UIColor.green {
            if self.nodeToPan != nil {
                physicControl(sender: sender, tapLocation: tapLocation, oldNode: self.nodeToPan!)
            } else {
                guard let rayCast: SCNHitTestResult = sceneResult.first
                else {
                    print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
                    return
                }
                let oldNode = rayCast.node
                if (oldNode.name != nil) {
                    var nodeToCheck = oldNode
                    if self.nodeToPan?.name != nil {
                        nodeToCheck = self.nodeToPan!
                    }
                    if self.sceneView.scene.rootNode.childNodes.contains(nodeToCheck){
                        physicControl(sender: sender, tapLocation: tapLocation, oldNode: oldNode)
                    }
                }
            }
        } else {
            guard let rayCast: SCNHitTestResult = sceneResult.first
            else {
                print("[ARVC+Gestures] Scene raycast over", tapLocation, "did not get any result.")
                return
            }
            let oldNode = rayCast.node
            if (oldNode.name != nil) {
                var oldNodeName = ""
                let nodeToCheck = oldNode
                if oldNode.name != nil {
                    oldNodeName = oldNode.name!
                } else {
                    return
                }
                
                print("[ARVC+Gestures] Scene raycast result is node", oldNodeName)
                // Check if the result's node is in the view
                if self.sceneView.scene.rootNode.childNodes.contains(nodeToCheck){
                    
                    var itemDic: NSMutableDictionary = [:]
                    var itemFound = false
                    for eachItemDic in self.model {
                        
                        if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                            print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(oldNode.name)")
                            if eachNameOfItemInModel == oldNode.name {
                                itemDic = eachItemDic
                                itemFound = true
                            }
                        }
                    }
                    if oldNodeName == "Box" {
                        //panGesture has 2 states: began(start of pan) and changed(change position)
                        switch sender.state {
                        case .began:
                            //init z position
                            self.panZinit = CGFloat(sceneView.projectPoint(oldNode.worldPosition).z)
                            //pan init location
                            self.panLocation = rayCast.worldCoordinates
                        case .changed:
                            let touchPos = sceneView.unprojectPoint(SCNVector3(tapLocation.x, tapLocation.y, self.panZinit))
                            let move = SCNVector3(touchPos.x - self.panLocation.x, touchPos.y - self.panLocation.y, touchPos.z - panLocation.z)
                            oldNode.localTranslate(by: move)
                            self.panLocation = touchPos
                        default:
                            break
                        }
                    }
                    if itemFound {
                        //panGesture has 2 states: began(start of pan) and changed(change position)
                        switch sender.state {
                        case .began:
                            //init z position
                            self.panZinit = CGFloat(sceneView.projectPoint(oldNode.worldPosition).z)
                            //pan init location
                            self.panLocation = rayCast.worldCoordinates
                        case .changed:
                            var originPos : NSMutableDictionary = [:]
                            originPos = self.objectsInitialPos.value(forKey: oldNodeName) as! NSMutableDictionary
                            let xinit = originPos.value(forKey: "x") as! CGFloat
                            let yinit = originPos.value(forKey: "y") as! CGFloat
                            let zinit = originPos.value(forKey: "z") as! CGFloat
                            //Get the graph syntax to get x and y max distance to original position
                            var graphicalSyntaxClass = NSMutableDictionary()
                            for aGraphicalSyntaxClass in self.graphicalSyntax {
                                let className = aGraphicalSyntaxClass["name"] as! String
                                //if className == self.selectedItem {
                                if className == itemDic["class"] as! String {
                                    graphicalSyntaxClass = aGraphicalSyntaxClass
                                }
                            }
                            let classConstraints = graphicalSyntaxClass["constraints"] as! NSMutableDictionary
                            let xmax = classConstraints["xToOriginPos"] as! String
                            let format = NumberFormatter()
                            format.decimalSeparator = "."
                            let xformat = format.number(from: xmax)
                            let ymax = classConstraints["yToOriginPos"] as! String
                            let yformat = format.number(from: ymax)
                            let zmax = classConstraints["zToOriginPos"] as! String
                            let zformat = format.number(from: zmax)
                            let touchPos = sceneView.unprojectPoint(SCNVector3(tapLocation.x, tapLocation.y, self.panZinit))
                            let move = SCNVector3(touchPos.x - self.panLocation.x, touchPos.y - self.panLocation.y, touchPos.z - panLocation.z)

                            //don't move if x and/or y are over limits
                            if((xinit - CGFloat(oldNode.worldPosition.x + move.x)) < CGFloat(truncating: xformat!) && (yinit - CGFloat(oldNode.worldPosition.y + move.y)) < CGFloat(truncating: yformat!) && (zinit - CGFloat(oldNode.worldPosition.z + move.z)) < CGFloat(truncating: zformat!) && (xinit - CGFloat(oldNode.worldPosition.x + move.x)) > -CGFloat(truncating: xformat!) && (yinit - CGFloat(oldNode.worldPosition.y + move.y)) > -CGFloat(truncating: yformat!) && (zinit - CGFloat(oldNode.worldPosition.z + move.z)) > -CGFloat(truncating: zformat!)){
                                oldNode.localTranslate(by: move)
                                let posDict :NSMutableDictionary = [:]
                                posDict.setValue(oldNode.position.x, forKey: "x")
                                posDict.setValue(oldNode.position.y, forKey: "y")
                                posDict.setValue(oldNode.position.z, forKey: "z")
                                self.objectsCurrentPos.setValue(posDict, forKey: oldNodeName)
                                let nick = objectsIdName.value(forKey: oldNodeName) as! String
                                for line in self.lines {
                                    if(line.nickA == nick || line.nickB == nick) {
                                        var height = Float(0.0)
                                        var boxLong = Float(0.0)
                                        if line.nickA == line.nickB {
                                            let keys = self.objectsIdName.allKeys(for: line.nickA)
                                            let id = keys.first
                                            let box = self.objectsBoundingBox[id!] as! NSMutableDictionary
                                            let minB = box.value(forKey: "min") as! SCNVector3
                                            let maxB = box.value(forKey: "max") as! SCNVector3
                                            height = maxB.y - minB.y
                                            boxLong = maxB.z - minB.z
                                        }
                                        updateLine(line: line, height: height, boxLong: boxLong)
                                    }
                                }
                                self.panLocation = touchPos
                                let anchor = self.sceneView.anchor(for: oldNode)!
                                if (anchor.isKind(of: ItemAnchor.self)) {
                                    if let anItemAnchor = anchor as? ItemAnchor {
                                        if anItemAnchor.givenName == nick {
                                            anItemAnchor.position = oldNode.position
                                        }
                                    }
                                }
                            }
                        default:
                            break
                        }
                    }
                }
            }
        }
    }

    func physicControl(sender : UIPanGestureRecognizer, tapLocation: CGPoint, oldNode: SCNNode) {
        switch sender.state {
        case .began:
            self.panBegin = tapLocation
            self.panCurrent = tapLocation
            self.nodeToPan = oldNode
        case .ended, .cancelled:
            let xDif = panCurrent.x - panBegin.x
            let yDif = panBegin.y - panCurrent.y //The y is bigger in the bottom of the device
            let forceVector = SCNVector3Make(Float(xDif)/200.0, Float(yDif)/200.0, yDif < 0 ? 0.5 : -0.5)
            guard let pointOfView = self.sceneView.pointOfView?.transform else {return}
            let orientation = SCNVector3Make(-pointOfView.m31, -pointOfView.m32, -pointOfView.m33)
            let force = Force(force: forceVector, orientation: orientation)
            //self.nodeToPan?.geometry?.firstMaterial?.emission.contents = UIColor.black
            self.nodeToPan?.physicsBody?.applyForce(force.finalForce, asImpulse: true)
            self.nodeToPan = nil
            
        case .changed:
            self.panCurrent = tapLocation
        default:
            break
        }
    }
    
    func physicControl(sender : UISwipeGestureRecognizer, tapLocation: CGPoint, oldNode: SCNNode) {
        
    }
    
    // MARK: Utils
    func addElement(at tapLocation: CGPoint, withName name: String, to sceneView: ARSCNView) {
        
        if let selectedItem = self.selectedItem {
            if self.external {
                var trigger = false
                for anAccessClass in self.accesses {
                    let classAccess = anAccessClass["class"] as! String
                    if classAccess == selectedItem {
                        let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                        trigger = classTrigger["onCreate"] as! Bool
                    }
                }
                if trigger {
                    let editcontrol = UIAlertController(title: "Edit", message: "Is an external class. Do you want to load data online?", preferredStyle: .alert)
                    //action of the modal. User writes the word, create new object
                    let alertaction = UIAlertAction(title: "No", style: .cancel) { (action) in
                        self.loadLocal(at: tapLocation, withName: name, to: sceneView)
                    }
                    editcontrol.addAction(alertaction)
                    let externalaction = UIAlertAction(title: "Yes", style: .default) { (action) in
                        self.loadExternal(at: tapLocation, withName: name, to: sceneView, message: "")
                    }
                    editcontrol.addAction(externalaction)
                    self.present(editcontrol, animated: true)
                } else {
                    self.loadLocal(at: tapLocation, withName: name, to: sceneView)
                }
                
            } else {
                self.loadLocal(at: tapLocation, withName: name, to: sceneView)
            }
        }
    }
    func loadLocal(at tapLocation: CGPoint, withName name: String, to sceneView: ARSCNView) {
        var classOfSelectedItem = NSMutableDictionary()
        // retrieves the information relative to the selected item in the metamodel
        for aMetamodelClass in self.metamodel {
            let nameOfCurrentClass = aMetamodelClass["name"] as! String
            if nameOfCurrentClass == selectedItem {
                classOfSelectedItem = aMetamodelClass
            }
        }
        let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
        let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
        if self.noSCNItems.contains(self.selectedItem!) {
            let anchor = ItemNoSCNAnchor(identifier: UUID(), name: name, type: self.selectedItem!, attributes: attributesOfSelectedItem, references: referencesOfSelectedItem, transform: simd_float4x4())
            //to avoid jump to case loading model
            self.needToLoad = false
            
            self.sceneView.session.add(anchor: anchor)
        } else {
            var graphicalSyntaxOfSelectedItem = NSMutableDictionary()
            // retrieves the information relative to the selected item in graphical syntax
            for aGraphicalSyntaxClass in self.graphicalSyntax {
                let nameOfCurrentClass = aGraphicalSyntaxClass["name"] as! String
                if nameOfCurrentClass == selectedItem {
                    graphicalSyntaxOfSelectedItem = aGraphicalSyntaxClass
                }
            }
            
            // Set alignment
            var alignment: ARRaycastQuery.TargetAlignment = .any // by default it is .any
            if let constraintsOfSelectedItem = graphicalSyntaxOfSelectedItem["constraints"] as? NSMutableDictionary {
                if let planeAlignment = constraintsOfSelectedItem["plane"] as? String {
                    if planeAlignment == "horizontal" {
                        alignment = .horizontal
                    } else if planeAlignment == "vertical" {
                        alignment = .vertical
                    }
                }
            }
            let estimatedPlane: ARRaycastQuery.Target = .estimatedPlane
            
            if let raycastQuery = sceneView.raycastQuery(from: tapLocation, allowing: estimatedPlane, alignment: alignment) {
                let worldResult: [ARRaycastResult] = sceneView.session.raycast(raycastQuery)
                guard let raycast: ARRaycastResult = worldResult.first
                else {
                    print("[ARVC+Gestures] World raycast over", tapLocation, "did not get any result.")
                    return
                }
                
                
                var accessOfSelectedItem = NSMutableDictionary()
                var timeTrigger = 0.0
                for anAccessClass in self.accesses {
                    let classAccess = anAccessClass["class"] as! String
                    let method = anAccessClass["method"] as! String
                    if classAccess == selectedItem && method == "GET" {
                        accessOfSelectedItem = anAccessClass
                    }
                }
                
                var physicsOfSelectedItem = NSMutableDictionary()
                for physicData in self.physicsInfo {
                    let classPhysic = physicData["name"] as! String
                    if classPhysic == selectedItem {
                        physicsOfSelectedItem = physicData
                    }
                }
                let forces : NSMutableArray = []
                
                if physicsOfSelectedItem["forces"] != nil {
                    let forcesArray = physicsOfSelectedItem["forces"] as! NSMutableArray
                    for forceObj in forcesArray {
                        let force = forceObj as! NSMutableDictionary
                        forces.add(force["name"] as! String)
                    }
                }
                let APIOfSelectedItem = accessOfSelectedItem["name"] as? String ?? ""
                let authOfSelectedItem = accessOfSelectedItem["auth"] as? String ?? ""
                let classTrigger = accessOfSelectedItem["trigger"] as? NSMutableDictionary ?? nil
                timeTrigger = classTrigger?["timeTrigger"] as? Double ?? 0.0
                
                var param : NSMutableDictionary = [:]
                
                
                //check local params
                if self.currentParam == "" {
                    for attribute in attributesOfSelectedItem {
                        let attr = attribute as! NSMutableDictionary
                        let name = attr["name"] as! String
                        let def = attr["default"] as! String
                        let type = attr["type"] as! String
                        let isParam = attr["isParam"] as! Bool
                        let loc : CLLocation? = locationManager.location
                        if isParam {
                            if type != "Longitude" && type != "Latitude" {
                                param.setValue(def, forKey: name)
                            } else if type == "Longitude" {
                                let long = "\(loc?.coordinate.longitude ?? 0.0)"
                                param.setValue(long, forKey: name)
                            } else if type == "Latitude" {
                                let lat = "\(loc?.coordinate.latitude ?? 0.0)"
                                param.setValue(lat, forKey: name)
                            }
                        }
                    }
                } else if self.currentParam != nil {
                    param = ["currentParam" : self.currentParam ?? ""]
                }
                
                var previousInfo = ""
                if canLoadExternal || (param != [:] && self.currentParam == "") {
                    previousInfo = getPreviousInfoExternal(attributesOfSelectedItem: attributesOfSelectedItem, referencesOfSelectedItem: referencesOfSelectedItem, classOfSelectedItem: classOfSelectedItem, APIOfSelectedItem: APIOfSelectedItem, authOfSelectedItem: authOfSelectedItem, param: param, nodename: name)
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
                        var transform = raycast.worldTransform
                        let rotationString = constraintsOfSelectedItem["rotation"] as! String
                        let rotation = Int(rotationString) ?? 0
                        var scale = SCNVector3Make(1.0, 1.0, 1.0)
                        if constraintsOfSelectedItem["sizeInit"] != nil {
                            let sizeString = constraintsOfSelectedItem["sizeInit"] as! String
                            let size = Float(sizeString) ?? 1.0
                            scale = SCNVector3Make(size, size, size)
                        }
                        if let distanceOfSelectedItem = graphicalSyntaxOfSelectedItem["distances"] as? NSMutableArray {
                            transform = checkDistance(distances: distanceOfSelectedItem, transform: transform, name: name)
                            if transform == matrix_identity_float4x4 {
                                return
                            }
                        }
                        let anchor = ItemAnchor(identifier: UUID(), name: name, type: self.selectedItem!, currentVersion: nameOfCurrentVersion, currentVersionInt: 1, urlOfCurrentVersion: urlString!, numberOfVersions: numberOfVersions.description, versions:     listOfVersions, attributes: attributesOfSelectedItem, references: referencesOfSelectedItem, constraints: constraintsOfSelectedItem, attributesToShow: attributesToShow, attributesMaterials: attributesMaterials, scale: scale, rotation: rotation, QR: "", API: APIOfSelectedItem, auth: authOfSelectedItem, param: param, previousInfo: previousInfo, beacon: "", forces: forces, initForce: "", transform: transform)
                        //to avoid jump to case loading model
                        self.needToLoad = false
                        
                        self.sceneView.session.add(anchor: anchor)
                        self.itemAnchors.append(anchor)
                    }
                    if timeTrigger != 0.0 && self.timer == nil {
                        self.timer = Timer.scheduledTimer(timeInterval:timeTrigger, target:self, selector:#selector(timeWaiting), userInfo: nil, repeats: true)
                    }
                }
            }
        }
    }
    
    func checkDistance(distances: NSMutableArray, transform: simd_float4x4, name: String) -> simd_float4x4 {
        let nodes = self.sceneView.scene.rootNode.childNodes
        var posList : [NSMutableDictionary] = []
        let firstObj : NSMutableDictionary = [:]
        var newTransform = transform
        let previousPos = SCNVector3Make(transform.columns.3.x, transform.columns.3.y, transform.columns.3.z)
        firstObj.setValue(previousPos, forKey: name)
        posList.append(firstObj)
        for node in nodes {
            let anchor = self.sceneView.anchor(for: node)
            if anchor != nil {
                if (anchor!.isKind(of: ItemAnchor.self)) {
                    if let anItemAnchor = anchor as? ItemAnchor {
                        //if object exist check class if distance is determinated
                        for dis in distances {
                            let objDis = dis as! NSMutableDictionary
                            if objDis["class"] as! String == self.selectedItem! && anItemAnchor.type == self.selectedItem! {
                                //if both true, check distance
                                let obj : NSMutableDictionary = [:]
                                obj.setValue(anItemAnchor.position, forKey: anItemAnchor.givenName)
                                posList.append(obj)
                                let min = objDis["min"] as! Double
                                let max = objDis["max"] as! Double
                                let module = pow(previousPos.x - anItemAnchor.position.x, 2) + pow(previousPos.y - anItemAnchor.position.y, 2) + pow(previousPos.z - anItemAnchor.position.z, 2)
                                let previousDis = sqrt(module)
                                if previousDis < Float(min) && (Float(min) != -1) {
                                    newTransform = matrix_identity_float4x4
                                    self.displayLabel(text: "The object does not satisfy with the minimum distance to object " + anItemAnchor.givenName + ". Must be " + String(min) + " meters")
                                    return newTransform
                                } else if previousDis > Float(max) && (Float(min) != -1) {
                                    newTransform = matrix_identity_float4x4
                                    self.displayLabel(text: "The object does not satisfy with the maximum distance to object " + anItemAnchor.givenName + ". Must be " + String(max) + " meters")
                                    return newTransform
                                }
                            }
                        }
                    }
                }
            }
        }
        return transform
    }
    
    func loadExternal(at tapLocation: CGPoint, withName name: String, to sceneView: ARSCNView, message: String) {
        var param = ""
        var type = ""
        var classOfSelectedItem = NSMutableDictionary()
        // retrieves the information relative to the selected item in the metamodel
        for aMetamodelClass in self.metamodel {
            let nameOfCurrentClass = aMetamodelClass["name"] as! String
            if nameOfCurrentClass == self.selectedItem {
                classOfSelectedItem = aMetamodelClass
            }
        }
        
        let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
        for attr in attributesOfSelectedItem {
            let attrInfo = attr as! NSMutableDictionary
            type = attrInfo["type"] as! String
            if type != "Latitude" && type != "Longitude" {
                let isParam = attrInfo["isParam"] as! Bool
                if isParam {
                    param = attrInfo["name"] as! String
                    break
                }
            }
        }
        if param == "" {
            self.currentTap = tapLocation
            self.currentNodeName = name
            self.currentSceneView = sceneView
            self.newExternalElement(param: "")
        } else {
            var message2 = message
            if message2 == "" {
                message2 = "Write the corresponding param: " + param + " (" + type + ")"
            }
            let editcontrol = UIAlertController(title: "Choose", message: message2, preferredStyle: .alert)
            //action of the modal. User writes the word, create new object
            let alertaction = UIAlertAction(title: "Cancel", style: .cancel)
            editcontrol.addAction(alertaction)
            let externalaction = UIAlertAction(title: "OK", style: .default) { (action) in
                guard let textfield = editcontrol.textFields?.first else { return }
                let text = textfield.text
                //use the content of textfield to create the new object
                if (text != nil) {
                    if(text!.count == 0){
                        self.loadExternal(at: tapLocation, withName: name, to: sceneView, message: "The param must not be empty. Write the corresponding param: " + param + " (" + type + ")")
                    } else {
                        var accessOfSelectedItem = NSMutableDictionary()
                        for anAccessClass in self.accesses {
                            let classAccess = anAccessClass["class"] as! String
                            if classAccess == self.selectedItem {
                                accessOfSelectedItem = anAccessClass
                            }
                        }
                        
                        let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                        var check = false
                        var isOk = false
                        var string = "https://alter-databroker.onrender.com/checkInput?aname=" + APIOfSelectedItem
                        let classattr = classOfSelectedItem["name"] as! String
                        string += "&aclass=" + classattr
                        string += "&ain=" + text! + "&json=true"
                        let url = URL(string: string)
                        if (url != nil) {
                            print("[NewExtNode] URL object exists: ", url!)
                        }
                        let session = URLSession.shared
                        let task = session.dataTask(with: url!) { (data, response, error) -> Void in
                            if error != nil {
                                print("[NewExtNode] ", error!)
                            } else {
                                if let data = data {
                                    do {
                                        let jsonResult = try JSONSerialization.jsonObject(
                                            with: data,
                                            options: JSONSerialization.ReadingOptions.mutableContainers
                                        ) as! NSMutableDictionary
                                        let code = jsonResult["code"] as! NSString
                                        if code == "200" {
                                            isOk = true
                                        } else {
                                            isOk = false
                                        }
                                        check = true
                                    } catch let e{
                                        print("[NewExtNode] ", e)
                                    }
                                }
                            }
                        }
                        task.resume()
                        while(!check){}
                        if isOk {
                            self.currentTap = tapLocation
                            self.currentNodeName = name
                            self.currentSceneView = sceneView
                            self.newExternalElement(param: text!)
                        } else {
                            self.loadExternal(at: tapLocation, withName: name, to: sceneView, message: "Your param has been rejected. Try again: " + param + " (" + type + ")")
                        }
                    }
                } else {
                    self.loadExternal(at: tapLocation, withName: name, to: sceneView, message: "There was an error while getting the param. Try again: " + param + " (" + type + ")")
                }
            }
            //open editable textfield
            editcontrol.addTextField()
            editcontrol.addAction(externalaction)
            self.present(editcontrol, animated: true)
        }
        
    }
    func newExternalElement(param: String) {
        self.currentParam = param
        if param != "" {
            self.canLoadExternal = true
        }
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
        self.loadLocal(at: self.currentTap!, withName: self.currentNodeName!, to: self.currentSceneView!)
    }
    
    func show(attributes: NSMutableDictionary, typeAttributes: NSMutableDictionary, maxAttributes: NSMutableDictionary, readOnlyAttributes: NSMutableDictionary, references: NSMutableDictionary, targetReferences: NSMutableDictionary, maxReferences: NSMutableDictionary)
    {
        // Show attributes information

        // Remove previous subviews
        for eachView in self.attributesScrollView.subviews {
            if eachView is UIButton || eachView is UIStackView ||  eachView == self.attributesContentView {

            } else {
                eachView.removeFromSuperview();
            }
        }

        for eachView in self.attributesContentView.subviews {
            if eachView is UIButton || eachView is UIStackView {

            } else {
                eachView.removeFromSuperview();
            }
        }

        for eachView in self.attributesStackView.subviews {
            if eachView is UIButton {

            } else {
                eachView.removeFromSuperview();
            }
        }
        var count = 0
        let currentObjectLabel = UILabel();
        currentObjectLabel.translatesAutoresizingMaskIntoConstraints = false
        currentObjectLabel.font = UIFont.systemFont(ofSize: 30.0)
        currentObjectLabel.text = self.modelObjectEdited["nick"] as! String
        currentObjectLabel.textAlignment = .center
        self.attributesStackView.addArrangedSubview(currentObjectLabel)
        count+=1
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
                let eachTypeAttribute = typeAttributes[eachName] as! String
                let eachMaxAttribute = maxAttributes[eachName] as! String
                let eachReadOnlyAttribute = readOnlyAttributes[eachName] as! Bool

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
                } else if (eachTypeAttribute == "Image") {
                    attributesTextField.keyboardType = UIKeyboardType.emailAddress;
                    attributesTextField.addTarget(self, action: #selector(self.selectPhotoAlbum(_:)), for: .touchDown)
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
        //add references label
        if (references.count > 0) {
            let referencesTitleLabel = UILabel();
            referencesTitleLabel.translatesAutoresizingMaskIntoConstraints = false
            referencesTitleLabel.font = UIFont.systemFont(ofSize: 17.0)
            referencesTitleLabel.text = "References:";
            // Add the label
            self.attributesStackView.addArrangedSubview(referencesTitleLabel)
            count+=1
            // For each reference compose a layout with label and textField
            let allNames = references.allKeys
            for eachName in allNames {
                let eachReference = references[eachName] as! String
                let eachTargetReference = targetReferences[eachName] as! String
                //let eachMaxReference = maxReferences[eachName] as! String

                // Set reference's name label
                let referencesNameLabel = UILabel();
                referencesNameLabel.translatesAutoresizingMaskIntoConstraints = false
                referencesNameLabel.font = UIFont.systemFont(ofSize: 17.0)
                referencesNameLabel.text = eachName as! String + "(" + eachTargetReference + ")" ;
                // Add the label
                self.attributesStackView.addArrangedSubview(referencesNameLabel)
                count+=1
                // Set reference's textField

                let referencesTextField = UITextField();
                referencesTextField.keyboardType = UIKeyboardType.emailAddress;
                referencesTextField.addTarget(self, action: #selector(self.addReferencesTable(_:)), for: .touchDown)
                referencesTextField.delegate = self
                referencesTextField.translatesAutoresizingMaskIntoConstraints = false;
                referencesTextField.borderStyle = UITextField.BorderStyle.roundedRect;
                referencesTextField.text = eachReference ;
                // Add the label
                self.attributesStackView.addArrangedSubview(referencesTextField)
                count+=1
            }
        }
        self.attributesHeightConstraint.constant = CGFloat(count*(8+30))
        self.attributesMainStackView.layoutIfNeeded()
    }
    
}
