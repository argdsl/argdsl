//
//  ARViewController+ARSCNViewDelegateRenderer.swift
//  ARModelling
//
//  Created by Miso on 23/09/2020.
//

import UIKit
import ARKit

extension ARViewController {
    
    // MARK: Renderer
    
    func renderer(_ renderer: SCNSceneRenderer, nodeFor anchor : ARAnchor) -> SCNNode? {
        
        print("[ARVC+Renderer] nodeFor \(anchor)")
        
        var node: SCNNode?
        
        /*----------------------------------------------------
         --                   ITEM ANCHOR                   --
         ----------------------------------------------------*/
        if let itemAnchor = anchor as? ItemAnchor {
            
            //print("[ARVC+Renderer] nodeFor \(anchor) and \(String(describing: itemAnchor.type))")
            
            let cacheScene = self.cache.object(forKey: itemAnchor.currentVersion as NSString)
            let url = URL.init(string: itemAnchor.urlOfCurrentVersion)
            if(cacheScene != nil) {
                node = (self.createItemNode(itemAnchor: itemAnchor, scene: cacheScene!)).clone()
            } else if let scene = try? SCNScene(url: url!, options: nil) {
                node = (self.createItemNode(itemAnchor: itemAnchor, scene: scene)).clone()
            } else {
                print("[ARVC+Gestures] Error loading \(itemAnchor.type).scn")
            }
            if !self.needToLoad {
                self.hasChanges = true
            }
            if(node != nil){
                forceToNode(node: node!, forceName: itemAnchor.initForce, anchor: itemAnchor)
            }
            
        }
        
        /*----------------------------------------------------
         --               NO SCN ITEM ANCHOR                --
         ----------------------------------------------------*/
        if let noSCNItemAnchor = anchor as? ItemNoSCNAnchor {
            node = SCNNode()
            node?.name = noSCNItemAnchor.itemIdentifier
            let item = NSMutableDictionary()
            // add to model
            item["name"] = noSCNItemAnchor.itemIdentifier
            item["nick"] = noSCNItemAnchor.givenName
            item["class"] = noSCNItemAnchor.type
            item["current_version"] = 0
            // attributes of the new element
            let minCardinalityOfEachAttributes = NSMutableDictionary()
            let attributesOfItem = NSMutableDictionary()
            let typeOfAttributesOfItem = NSMutableDictionary()
            let maxOfAttributesOfItem = NSMutableDictionary()
            let readOnlyOfAttributes = NSMutableDictionary()
            for anAttribute in noSCNItemAnchor.getAttributes() {
                if let currentAttribute = anAttribute as? NSMutableDictionary {
                    let nameOfAttribute = currentAttribute["name"] as! NSString
                    let defaultValueOfAttribute = currentAttribute["default"]
                    let maxCardinalityOfAttribute = currentAttribute["max"]
                    let minCardinatilyOfAttribute = currentAttribute["min"]
                    let typeOfAttribute = currentAttribute["type"]
                    let readOnlyOfAttribute = currentAttribute["readOnly"]
                    let stringAttributesValue = convertDictionaryToString(dictionary: noSCNItemAnchor.getValueOfAttributes())
                    if stringAttributesValue != "{}" {
                        attributesOfItem.setObject(noSCNItemAnchor.getValueOfAttributes()[nameOfAttribute]!, forKey: nameOfAttribute)
                    } else {
                        attributesOfItem.setObject(defaultValueOfAttribute!, forKey: nameOfAttribute)
                    }
                    typeOfAttributesOfItem.setObject(typeOfAttribute!, forKey: nameOfAttribute)
                    maxOfAttributesOfItem.setObject(maxCardinalityOfAttribute!, forKey: nameOfAttribute)
                    minCardinalityOfEachAttributes.setObject(minCardinatilyOfAttribute!, forKey: nameOfAttribute)
                    readOnlyOfAttributes.setObject(readOnlyOfAttribute!, forKey: nameOfAttribute)
                }
            }
            item["attributes"] = attributesOfItem
            item["typeAttributes"] = typeOfAttributesOfItem
            item["maxAttributes"] = maxOfAttributesOfItem
            item["minAttributes"] = minCardinalityOfEachAttributes
            item["readOnlyAttributes"] = readOnlyOfAttributes
            // references of the new element
            let minCardinalityOfEachReferences = NSMutableDictionary()
            let referencesOfItem = NSMutableDictionary()
            let targetOfReferencesOfItem = NSMutableDictionary()
            let maxOfReferencesOfItem = NSMutableDictionary()
            for aReference in noSCNItemAnchor.getReferences() {
                if let currentReference = aReference as? NSMutableDictionary {
                    let nameOfReference = currentReference["name"] as! NSString
                    let maxCardinalityOfReference = currentReference["max"]
                    let minCardinalityOfReference = currentReference["min"]
                    let targetOfReference = currentReference["target"]
                    let stringReferencesValue = convertDictionaryToString(dictionary: noSCNItemAnchor.getValueOfReferences())
                    
                    if stringReferencesValue != "{}" {
                        referencesOfItem.setObject(noSCNItemAnchor.getValueOfReferences()[nameOfReference]!, forKey: nameOfReference)
                    } else {
                        referencesOfItem.setObject("", forKey: nameOfReference)
                    }
                    targetOfReferencesOfItem.setObject(targetOfReference!, forKey: nameOfReference)
                    maxOfReferencesOfItem.setObject(maxCardinalityOfReference!, forKey: nameOfReference)
                    minCardinalityOfEachReferences.setObject(minCardinalityOfReference!, forKey: nameOfReference)
                }
            }
            item["references"] = referencesOfItem
            item["targetReferences"] = targetOfReferencesOfItem
            item["maxReferences"] = maxOfReferencesOfItem
            item["minReferences"] = minCardinalityOfEachReferences
            
            item["current_version"] = 0
            item["max_version"] = 0
            
            self.model.append(item)
            self.objectsList.setValue(noSCNItemAnchor.type, forKey: noSCNItemAnchor.givenName)
            self.noSCNList.append(noSCNItemAnchor.givenName)
            self.objectsIdName.setValue(noSCNItemAnchor.givenName, forKey: noSCNItemAnchor.itemIdentifier)
            print(self.model)
            if !self.needToLoad {
                self.hasChanges = true
            }
        }
        /*----------------------------------------------------
         --                ATTRIBUTES ANCHOR                --
         ----------------------------------------------------*/
        if let attributeAnchor = anchor as? AttributesAnchor {
            var string = attributeAnchor.nameOfItemAnchor
            let valuesOfAttributes = attributeAnchor.getValueOfAttributes()
            for anAttribute in attributeAnchor.getAttributesToShow() {
                if let value = valuesOfAttributes[anAttribute] {
                    string = string + "\n\(anAttribute): \(value)"
                }
            }
            
            let text = SCNText(string: string, extrusionDepth: 0.1)
            text.font = UIFont.systemFont(ofSize: 1)
            text.flatness = 0.005
            let textNode = SCNNode(geometry: text)
            let fontScale: Float = 0.01
            textNode.scale = SCNVector3(fontScale, fontScale, fontScale)
            textNode.position = SCNVector3(0, 0.05, 0.05)
            textNode.geometry?.firstMaterial?.diffuse.contents
            self.sceneView.session.getCurrentWorldMap { (worldMap, error) in
                if worldMap != nil  {
                    print(worldMap!.anchors)
                    for anAnchor in worldMap!.anchors {
                        if (anAnchor.isKind(of: ItemAnchor.self)) {
                            if let anItemAnchor = anAnchor as? ItemAnchor {
                                if anItemAnchor.itemIdentifier == attributeAnchor.idOfItemAnchor {
                                    let rotation = anItemAnchor.rotation
                                    textNode.eulerAngles.x = (Float(0 - rotation)/180.0) * Float.pi
                                    let constraints = anItemAnchor.getConstraints()
                                    if constraints["trim"] != nil {
                                        let trim = constraints["trim"] as! Bool
                                        if trim {
                                            let boundingBox = self.objectsBoundingBox.value(forKey: anItemAnchor.itemIdentifier) as! NSMutableDictionary
                                            let min = boundingBox.value(forKey: "min") as! SCNVector3
                                            let max = boundingBox.value(forKey: "max") as! SCNVector3
                                            let meterX = max.x - min.x
                                            let textWidth = textNode.boundingBox.max.x / 100.0
                                            if (textWidth > meterX) {
                                                let trims = Int(floor(textWidth/meterX))
                                                var i = 0
                                                var comp = string.components(separatedBy: "\n")
                                                var maxChar = 0
                                                for seq in comp {
                                                    if seq.count > maxChar {
                                                        maxChar = seq.count
                                                    }
                                                }
                                                let minDist = textWidth/Float(maxChar)
                                                while i < trims {
                                                    i+=1
                                                    for line in comp {
                                                        let minChars = Int(floor(meterX/minDist))
                                                        var seq = line
                                                        if seq.count > i * minChars {
                                                            let searchIndex = i * minChars - 1
                                                            let char = seq[seq.index(seq.startIndex, offsetBy: searchIndex)]
                                                            if char == " " {
                                                                var array = Array(seq)
                                                                array[searchIndex] = "\n"
                                                                seq = String(array)
                                                                comp[comp.firstIndex(of: line)!] = seq
                                                            } else {
                                                                var j = searchIndex - 1
                                                                while j > (i - 1) * minChars {
                                                                    let char = seq[seq.index(seq.startIndex, offsetBy: j)]
                                                                    if char == " " {
                                                                        var array = Array(seq)
                                                                        array[searchIndex] = "\n"
                                                                        seq = String(array)
                                                                        comp[comp.firstIndex(of: line)!] = seq
                                                                        break
                                                                    }
                                                                    j-=1
                                                                }
                                                            }
                                                        }
                                                    }
                                                    i+=1
                                                }
                                                var newText = ""
                                                for seq in comp {
                                                    newText += seq + "\n"
                                                }
                                                let scntext = SCNText(string: newText, extrusionDepth: 0.1)
                                                scntext.font = UIFont.systemFont(ofSize: 1)
                                                scntext.flatness = 0.005
                                                textNode.geometry = scntext
                                            }
                                        }
                                    }
                                    if constraints["text"] != nil {
                                        let text = constraints["text"] as! String
                                        switch text {
                                        
                                        case "center":
                                            let boundingBox = self.objectsBoundingBox.value(forKey: anItemAnchor.itemIdentifier) as! NSMutableDictionary
                                            let min = boundingBox.value(forKey: "min") as! SCNVector3
                                            textNode.position = SCNVector3(min.x, 0.00, 0.05)
                                            break
                                        case "top":
                                            let boundingBox = self.objectsBoundingBox.value(forKey: anItemAnchor.itemIdentifier) as! NSMutableDictionary
                                            let max = boundingBox.value(forKey: "max") as! SCNVector3
                                            textNode.position = SCNVector3(0, max.y, 0.05)
                                            break
                                        case "top big":
                                            let boundingBox = self.objectsBoundingBox.value(forKey: anItemAnchor.itemIdentifier) as! NSMutableDictionary
                                            let max = boundingBox.value(forKey: "max") as! SCNVector3
                                            textNode.position = SCNVector3(0, max.y, 0.05)
                                            textNode.scale = SCNVector3Make(0.1, 0.1, 0.1)
                                            break
                                        case "big":
                                            textNode.scale = SCNVector3Make(0.1, 0.1, 0.1)
                                            break
                                        default:
                                            textNode.position = SCNVector3(0, 0.05, 0.05)
                                        }
                                    }
                                    if constraints["textColor"] != nil {
                                        let textColor = constraints["textColor"] as! String
                                        if(textColor == "black") {
                                            textNode.geometry?.firstMaterial?.diffuse.contents = UIColor.black
                                        }
                                        
                                    }
                                    var previousInfo = ""
                                    if self.needToLoad {
                                        previousInfo = self.checkLoadInfo(selectedItem: anItemAnchor.type, param: anItemAnchor.getParam(), nodename: anItemAnchor.givenName)
                                    }
                                    if previousInfo != "" {
                                        let dict = convertStringToDictionary(text: previousInfo)
                                        string = ""
                                        for anAttribute in attributeAnchor.getAttributesToShow() {
                                            if let value = dict[anAttribute] {
                                                string = string + "\n\(anAttribute): \(value)"
                                            }
                                        }
                                        text.string = string
                                    }
                                    for dic in self.referencesReserves {
                                        //if this node contains info from reference reserved, load reference
                                        let refAttr = dic["refAttr"]
                                        var hasReference = false
                                        for key in valuesOfAttributes.allKeys {
                                            let value = valuesOfAttributes[key]
                                            if value is String && refAttr is String {
                                                let strRef = refAttr as! String
                                                let strAttr = value as! String
                                                if strRef == strAttr {
                                                    hasReference = true
                                                }
                                            } else if value is Int && refAttr is Int {
                                                let intRef = refAttr as! Int
                                                let intAttr = value as! Int
                                                if intRef == intAttr {
                                                    hasReference = true
                                                }
                                            } else if refAttr is Int && value is String {
                                                let strattr = value as! String
                                                let intAttr = Int(strattr) ?? 0
                                                if intAttr != 0 {
                                                    let intRef = refAttr as! Int
                                                    if intRef == intAttr {
                                                        hasReference = true
                                                    }
                                                }
                                            }
                                        }
                                        if hasReference {
                                            for anSecondAnchor in worldMap!.anchors {
                                                if (anSecondAnchor.isKind(of: ItemAnchor.self)){
                                                    if let anSecondItemAnchor = anSecondAnchor as? ItemAnchor {
                                                        if anSecondItemAnchor.givenName == dic["nodename"] as! String {
                                                            self.drawLine(nodeInit: anSecondItemAnchor.itemIdentifier, nodeFinish: anItemAnchor.itemIdentifier, initName: anSecondItemAnchor.givenName, finalName: anItemAnchor.givenName, objectClass: dic["class"] as! String, refname: dic["refName"] as! String, target: dic["target"] as! String)
                                                            self.loadReserveReferenceToModel(item: anSecondItemAnchor, item2: anItemAnchor)
                                                            if self.referencesReserves.lastIndex(of: dic) != nil {
                                                                self.referencesReserves.remove(at: self.referencesReserves.lastIndex(of: dic)!)
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (dic["nodename"] != nil){
                                            if anItemAnchor.givenName == dic["nodename"] as! String {
                                                for anSecondAnchor in worldMap!.anchors {
                                                    if (anSecondAnchor.isKind(of: AttributesAnchor.self)){
                                                        if let anSecondAttrAnchor = anSecondAnchor as? AttributesAnchor {
                                                            let attributesOfSecondAnchor = anSecondAttrAnchor.getValueOfAttributes()
                                                            var hasReference2 = false
                                                            for key in attributesOfSecondAnchor.allKeys {
                                                                let value = attributesOfSecondAnchor[key]
                                                                if value is String && refAttr is String {
                                                                    let strRef = refAttr as! String
                                                                    let strAttr = value as! String
                                                                    if strRef == strAttr {
                                                                        hasReference2 = true
                                                                    }
                                                                } else if value is Int && refAttr is Int {
                                                                    let intRef = refAttr as! Int
                                                                    let intAttr = value as! Int
                                                                    if intRef == intAttr {
                                                                        hasReference2 = true
                                                                    }
                                                                }
                                                            }
                                                            if hasReference2 {
                                                                for anThirdAnchor in worldMap!.anchors {
                                                                    if (anThirdAnchor.isKind(of: ItemAnchor.self)){
                                                                        if let anThirdItemAnchor = anThirdAnchor as? ItemAnchor {
                                                                            if anThirdItemAnchor.givenName == anSecondAttrAnchor.nameOfItemAnchor {
                                                                                self.drawLine(nodeInit: anItemAnchor.itemIdentifier, nodeFinish: anThirdItemAnchor.itemIdentifier, initName: anItemAnchor.givenName, finalName: anThirdItemAnchor.givenName, objectClass: dic["class"] as! String, refname: dic["refName"] as! String, target: dic["target"] as! String)
                                                                                self.loadReserveReferenceToModel(item: anItemAnchor, item2: anThirdItemAnchor)
                                                                                self.referencesReserves.remove(at: self.referencesReserves.lastIndex(of: dic)!)
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    let itemNode = self.sceneView.node(for: anAnchor)
                                    if constraints["text"] != nil {
                                        let text = constraints["text"] as! String
                                        if text != "none" {
                                            itemNode?.addChildNode(textNode)
                                        }
                                    } else {
                                        itemNode?.addChildNode(textNode)
                                    }
                                    
                                    if anItemAnchor.QR != "" {
                                        self.ItemsQR.setValue(anItemAnchor.QR, forKey: anItemAnchor.givenName)
                                    }
                                    self.processing = true
                                    self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                                    break
                                }
                            }
                        }
                    }
                } else {
                    print(error!)
                    var anchorToDelete :ItemAnchor?
                    for anchor in self.itemAnchors {
                        if anchor.itemIdentifier == attributeAnchor.idOfItemAnchor {
                            anchorToDelete = anchor
                            break
                        }
                    }
                    if anchorToDelete?.beacon != "" {
                        self.itemsBeacons.removeObject(forKey: anchorToDelete?.givenName)
                    }
                    if anchorToDelete?.QR != "" {
                        self.processing = true
                        self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                        self.ItemsQR.removeObject(forKey: anchorToDelete?.givenName)
                    }
                    if anchorToDelete != nil {
                        self.itemAnchors.remove(at: self.itemAnchors.lastIndex(of: anchorToDelete!)!)
                        self.sceneView.session.remove(anchor: anchorToDelete!)
                        self.objectsInitialPos.removeObject(forKey: anchorToDelete?.itemIdentifier)
                        self.objectsCurrentPos.removeObject(forKey: (anchorToDelete?.itemIdentifier)!)
                        self.objectsList.removeObject(forKey: anchorToDelete?.givenName)
                        self.objectsIdName.removeObject(forKey: (anchorToDelete?.itemIdentifier)!)
                    }
                    for string in self.currentReferencesReservedValue {
                        self.referencesReserves.remove(at: self.referencesReserves.lastIndex(where: { $0["refAttr"] as! Int == Int(string) })!)
                    }
                    self.displayLabel(text: "Move your device to a more detailed environment and try again. Is needed to create attributes and display the node")
                    self.sceneView.session.remove(anchor: anchor)
                    if self.needToLoad {
                        self.sceneView.session.add(anchor: anchor)
                    }
                }
                self.currentReferencesReservedValue = []
            }
            node = SCNNode()
            if !self.needToLoad {
                self.hasChanges = true
            }
        }
        
        /*----------------------------------------------------
         --                REFERENCES ANCHOR                --
         ----------------------------------------------------*/
        
        if let referenceAnchor = anchor as? ReferencesAnchor {
            let name = referenceAnchor.nameOfItemAnchor
            let width = referenceAnchor.width
            let color = referenceAnchor.color
            let length = referenceAnchor.length
            let initpos = referenceAnchor.initPos
            let finalpos = referenceAnchor.finalPos
            let version = referenceAnchor.version
            let nickA = referenceAnchor.nickA
            let nickB = referenceAnchor.nickB
            let classObj = referenceAnchor.classObj
            let refName = referenceAnchor.refName
            
            let vector = SCNVector3Make(finalpos.x - initpos.x, finalpos.y - initpos.y, finalpos.z - initpos.z)
            if(vector.x == 0 && vector.y == 0 && vector.z == 0) {
                let line = Line(geometry: SCNTorus(ringRadius: width*50, pipeRadius: width*3), a: initpos, b: finalpos, nickA: nickA, nickB: nickB, objsClass: classObj, refName: refName, dirVector: vector)
                line.position = SCNVector3Make(initpos.x, initpos.y + 0.5, initpos.z)
                if(color == "red") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.red
                } else if(color == "blue") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
                } else if(color == "green") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.green
                }
                
                line.rotation = SCNVector4Make(0, 0, 1, Float.pi/2)
                line.name = name
                self.linesEachVersion.setValue(version, forKey: line.name!)
                self.lines.append(line)
                let text = SCNText(string: name, extrusionDepth: 0.1)
                text.font = UIFont.systemFont(ofSize: 1)
                text.flatness = 0.005
                let textNode = SCNNode(geometry: text)
                let fontScale: Float = 0.01
                textNode.scale = SCNVector3(fontScale, fontScale, fontScale)
                textNode.position = SCNVector3(0, 0.05, 0.05)
                line.addChildNode(textNode)
                self.linesForAnchor.updateValue(referenceAnchor, forKey: line)
                node = line
            }
            else {
                let line = Line(geometry: SCNCapsule(capRadius: width, height: CGFloat(length)), a: initpos, b: finalpos, nickA: nickA, nickB: nickB, objsClass: classObj, refName: refName, dirVector: vector)
                let interPos = SCNVector3((initpos.x + finalpos.x)/2, (initpos.y + finalpos.y)/2, (initpos.z + finalpos.z)/2)
                line.position = interPos
                if(color == "red") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.red
                } else if(color == "blue") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
                }
                let rotation = line.calculateRotation()
                line.eulerAngles = SCNVector3(rotation.x, rotation.y, rotation.z)
                line.name = name
                self.linesEachVersion.setValue(version, forKey: line.name!)
                self.lines.append(line)
                let text = SCNText(string: name, extrusionDepth: 0.1)
                text.font = UIFont.systemFont(ofSize: 1)
                text.flatness = 0.005
                let textNode = SCNNode(geometry: text)
                let fontScale: Float = 0.01
                textNode.scale = SCNVector3(fontScale, fontScale, fontScale)
                textNode.position = SCNVector3(0, 0.05, 0.05)
                line.addChildNode(textNode)
                self.linesForAnchor.updateValue(referenceAnchor, forKey: line)
                node = line
            }
            if !self.needToLoad {
                self.hasChanges = true
            }
        }
        
        self.sceneView.session.getCurrentWorldMap { (worldMap, error) in
            print("[ARVC+Renderer] Current world map: \(String(describing: worldMap?.anchors))")
        }
        
        return node
    }
    
    func renderer(_ renderer: SCNSceneRenderer, didAdd node: SCNNode, for anchor: ARAnchor) {
        print(self.objectsBoundingBox)
        if(anchor.isKind(of: ReferencesAnchor.self)) {
            let before = node as! Line
            let refAnchor = anchor as! ReferencesAnchor
            let keys = self.objectsIdName.allKeys(for: refAnchor.nickA)
            let id = keys.first
            let box = self.objectsBoundingBox[id!] as! NSMutableDictionary
            let min = box.value(forKey: "min") as! SCNVector3
            let max = box.value(forKey: "max") as! SCNVector3
            if(refAnchor.initPos.x == refAnchor.finalPos.x && refAnchor.initPos.y == refAnchor.finalPos.y && refAnchor.initPos.z == refAnchor.finalPos.z) {
                let name = refAnchor.nameOfItemAnchor
                let width = refAnchor.width
                let color = refAnchor.color
                let initpos = refAnchor.initPos
                let finalpos = refAnchor.finalPos
                let nickA = refAnchor.nickA
                let nickB = refAnchor.nickB
                let classObj = refAnchor.classObj
                let refName = refAnchor.refName
                let height = max.y - min.y
                let boxLong = max.z - min.z
                let vector = SCNVector3Make(finalpos.x - initpos.x, finalpos.y - initpos.y, finalpos.z - initpos.z)
                let line = Line(geometry: SCNTorus(ringRadius: CGFloat(boxLong/2.5), pipeRadius: width*3), a: initpos, b: finalpos, nickA: nickA, nickB: nickB, objsClass: classObj, refName: refName, dirVector: vector)
                line.position = SCNVector3Make(initpos.x, initpos.y + height/1.5, initpos.z)
                if(color == "red") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.red
                } else if(color == "blue") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.blue
                } else if(color == "green") {
                    line.geometry?.firstMaterial?.diffuse.contents = UIColor.green
                }
                
                line.rotation = SCNVector4Make(0, 0, 1, Float.pi/2)
                line.name = name
                self.lines.remove(at: self.lines.lastIndex(of: before)!)
                if self.linesForAnchor.index(forKey: before) != nil {
                    self.linesForAnchor.remove(at: self.linesForAnchor.index(forKey: before)!)
                }
                node.removeFromParentNode()
                self.lines.append(line)
                let text = SCNText(string: refName, extrusionDepth: 0.1)
                text.font = UIFont.systemFont(ofSize: 1)
                text.flatness = 0.005
                
                let textNode = SCNNode(geometry: text)
                let fontScale: Float = 0.01
                textNode.scale = SCNVector3(fontScale, fontScale, fontScale)
                textNode.position = SCNVector3(0, 0.05, 0.05)
                line.addChildNode(textNode)
                self.linesForAnchor.updateValue(refAnchor, forKey: line)
                self.sceneView.scene.rootNode.addChildNode(line)
            } else {
                self.updateLine(line: before, height: Float(0.0), boxLong: Float(0.0))
            }
        } else if(anchor.isKind(of: ItemAnchor.self)){
            let itemAnchor = anchor as! ItemAnchor
            for physicData in self.physicsInfo {
                let classPhysic = physicData["name"] as! String
                if classPhysic == itemAnchor.type {
                    var forces = NSMutableArray()
                    if physicData["forces"] != nil {
                        forces = physicData["forces"] as! NSMutableArray
                        for forceObj in forces {
                            let forceDic = forceObj as! NSMutableDictionary
                            if forceDic["gesture"] as? String == "tilt" {
                                tiltObjects()
                                break
                            }
                        }
                    }
                    break
                }
            }
        }
        print("[ARVC+Renderer] didAdd")
    }
    
    func renderer(_ renderer: SCNSceneRenderer, willUpdate: SCNNode, for: ARAnchor) {
        print("[ARVC+Renderer] willUpdate")
    }

    func renderer(_ renderer: SCNSceneRenderer, didUpdate node: SCNNode, for anchor: ARAnchor) {
        //important part to move and save moving nodes
        if anchor.isKind(of: ItemAnchor.self) {
            let anItemAnchor = anchor as! ItemAnchor
            node.position = anItemAnchor.position
            node.scale = anItemAnchor.scale
        }
        print("[ARVC+Renderer] didUpdate")
        
    }

    func renderer(_ renderer: SCNSceneRenderer, didRemove: SCNNode, for: ARAnchor) {
        print("[ARVC+Renderer] didRemove")
    }
    
    // MARK: Func

    /**
     Creates the node representation for a specific **ItemAnchor**.
     
     - parameter itemAnchor: The anchor that has been placed, this function will create its node.
     - parameter scene: The scene that holds the node representation.
     - returns: The node that represents the anchor if it exists.
     */
    func createItemNode(itemAnchor: ItemAnchor, scene: SCNScene) -> SCNNode {
        
        var node: SCNNode?
        
        
        print("[ARVC+Renderer] \(String(describing: itemAnchor.type)).scn has been successfully loaded.")
        let itemNode: SCNNode
        // Get the SCN file that corresponds to the selected item
        if self.cache.object(forKey: itemAnchor.currentVersion as NSString) == nil {
            self.cache.setObject(scene, forKey: itemAnchor.currentVersion as NSString)
        }
        itemNode = (scene.rootNode.childNode(withName: itemAnchor.type, recursively: false))!
        //let bufferNode = itemNode.clone()
        itemNode.name = itemAnchor.itemIdentifier
        
        if self.codesOnly {
            itemNode.position = SCNVector3Make(itemNode.position.x, itemNode.position.y - 0.1, itemNode.position.z)
        } else {
            itemNode.position = itemAnchor.position
        }
        itemNode.position = itemAnchor.position
        itemNode.scale = itemAnchor.scale
        itemNode.rotation = SCNVector4Make(1, 0, 0, (Float(itemAnchor.rotation)/180.0) * Float.pi)
        
        
        
        var physicsOfSelectedItem = NSMutableDictionary()
        for physicData in self.physicsInfo {
            let classPhysic = physicData["name"] as! String
            if classPhysic == itemAnchor.type {
                physicsOfSelectedItem = physicData
            }
        }
        if physicsOfSelectedItem["physicBody"] != nil {
            let physicBody = physicsOfSelectedItem["physicBody"] as! NSMutableDictionary
            if physicBody["bodyType"] as! String == "dynamic" {
                itemNode.physicsBody = SCNPhysicsBody(type: .dynamic, shape: SCNPhysicsShape(node: itemNode, options: nil))
            } else if physicBody["bodyType"] as! String == "kinematic" {
                itemNode.physicsBody = SCNPhysicsBody(type: .kinematic, shape: SCNPhysicsShape(node: itemNode, options: nil))
            } else {
                itemNode.physicsBody = SCNPhysicsBody(type: .static, shape: SCNPhysicsShape(node: itemNode, options: nil))
            }
            itemNode.physicsBody?.mass = physicBody["mass"] as! Double
            itemNode.physicsBody?.charge = physicBody["charge"] as! Double
            itemNode.physicsBody?.friction = physicBody["friction"] as! Double
            itemNode.physicsBody?.rollingFriction = physicBody["rollingFriction"] as! Double
            itemNode.physicsBody?.restitution = physicBody["restitution"] as! Double
            itemNode.physicsBody?.damping = physicBody["damping"] as! Double
            itemNode.physicsBody?.angularDamping = physicBody["angularDamping"] as! Double
            
        } else {
            itemNode.physicsBody = SCNPhysicsBody(type: .static, shape: SCNPhysicsShape(node: itemNode, options: nil))
        }
        
        if physicsOfSelectedItem["bitMasks"] != nil {
            let bitMasks = physicsOfSelectedItem["bitMasks"] as! NSMutableDictionary
            itemNode.physicsBody?.categoryBitMask = bitMasks["category"] as! Int
            itemNode.physicsBody?.collisionBitMask = bitMasks["collision"] as! Int
            itemNode.physicsBody?.contactTestBitMask = bitMasks["contactTest"] as! Int
        }
        let overlapping = itemAnchor.getConstraints()["overlapping"] as! String
        if self.checkOverLapping(node: itemNode) || overlapping == "true" {
            print("[ARVC+Renderer] \(String(describing: itemNode.boundingBox))")
            let box : NSMutableDictionary = [:]
            box.setValue(itemNode.boundingBox.min, forKey: "min")
            box.setValue(itemNode.boundingBox.max, forKey: "max")
            self.objectsBoundingBox.setValue(box, forKey: (itemNode.name)!)
            
            
            let attributeAnchor = AttributesAnchor(idOfItemAnchor: itemAnchor.itemIdentifier, nameOfItemAnchor: itemAnchor.givenName, valueOfAttributes: itemAnchor.getValueOfAttributes(), attributesToShow: itemAnchor.getAttributesToShow(), codeAttached: itemAnchor.QR, beaconAttached: itemAnchor.beacon, transform: itemAnchor.transform)
            if !self.needToLoad {
                self.sceneView.session.add(anchor: attributeAnchor)
            }
            
            if self.canLoadExternal {
                self.addToModelExternal(anchor: itemAnchor)
            }
            else {
                self.addToModel(anchor: itemAnchor)
            }
            
            
            
            let initialPosition : NSMutableDictionary = [:]
            initialPosition.setValue(itemNode.position.x, forKey: "x")
            initialPosition.setValue(itemNode.position.y, forKey: "y")
            initialPosition.setValue(itemNode.position.z, forKey: "z")
            self.objectsInitialPos.setValue(initialPosition, forKey: (itemNode.name)!)
            self.objectsCurrentPos.setValue(initialPosition, forKey: (itemNode.name)!)
            self.objectsList.setValue(itemAnchor.type, forKey: itemAnchor.givenName)
            self.objectsIdName.setValue(itemAnchor.givenName, forKey: (itemNode.name)!)
            itemAnchor.isNotValid = false
            
        } else {
            //self.model.popLast()
            self.wrongAttrAlert(message: "The object is overlapping. Try another place")
            itemAnchor.isNotValid = true
        }
            
        node = itemNode.clone()
        itemNode.name = itemAnchor.type
        /*
        if node?.childNode(withName: "image", recursively: false) != nil {
            let childMaterial = node?.childNode(withName: "image", recursively: false)
            childMaterial?.geometry = childMaterial?.geometry?.copy() as? SCNGeometry
            childMaterial?.geometry?.materials = []
        }
        */
        if !itemAnchor.attributesMaterials.isEmpty {
            for mat in convertStringToArray(text: itemAnchor.attributesMaterials) {
                let info = itemAnchor.getValueOfAttributes()
                let stringUrl = info[mat] as! String
                let media = info["media"]
                var strMedia = ""
                if media != nil {
                    strMedia = media as! String
                }
                
                let material = SCNMaterial()
                
                /*
                let auxData = NSData(base64Encoded: data64, options: .ignoreUnknownCharacters)
                if auxData != nil {
                    let imageData : NSData = auxData!
                    material.diffuse.contents = UIImage(data: imageData as Data)
                    itemNode.geometry?.materials = [material]
                }*/
                if self.firebase {
                    if let url = URL(string: stringUrl) {
                        
                        if strMedia == "video" {
                            let videoItem = AVPlayerItem(url: url)
                                    
                            let player = AVPlayer(playerItem: videoItem)
                            
                            let video = SKVideoNode(avPlayer: player)
                            //video.play()
                            
                            NotificationCenter.default.addObserver(forName: .AVPlayerItemDidPlayToEndTime, object: player.currentItem, queue: nil) { (notification) in
                                        player.seek(to: CMTime.zero)
                                        player.play()
                                        print("Looping Video")
                                    }
                            
                            let videoScene = SKScene(size: CGSize(width: 1000, height: 1000))
                            video.position = CGPoint(x: videoScene.size.width / 2, y: videoScene.size.height / 2)
                            video.yScale = -1.0
                            video.name = "video"
                            videoScene.addChild(video)
                            material.diffuse.contents = videoScene
                            material.name = "video"
                            //get child called image
                            if node?.childNode(withName: "image", recursively: false) != nil {
                                let childMaterial = node?.childNode(withName: "image", recursively: false)
                                childMaterial?.geometry = childMaterial?.geometry?.copy() as? SCNGeometry
                                childMaterial?.geometry?.firstMaterial = childMaterial?.geometry?.firstMaterial?.copy() as? SCNMaterial
                                childMaterial?.geometry?.firstMaterial = material
                            } else {
                                node?.geometry = node?.geometry?.copy() as? SCNGeometry
                                node?.geometry?.materials = [material]
                            }
                            
                            
                            //get pause and play 3d buttons
                            let urlPause = URL.init(string: "https://github.com/Albertojuanse/miso_ar_test/blob/master/Ikea/Ikea/Models.scnassets/pause.scn?raw=true")!
                            let scenePause = try? SCNScene(url: urlPause, options: nil)
                            var pauseNode: SCNNode
                            pauseNode = (scenePause?.rootNode.childNode(withName: "pause", recursively: false))!
                            pauseNode.name = itemAnchor.itemIdentifier + "pause"
                            pauseNode.position = SCNVector3(x: -0.075, y: 0.0, z: 0.1)
                            
                            let urlPlay = URL.init(string: "https://github.com/Albertojuanse/miso_ar_test/blob/master/Ikea/Ikea/Models.scnassets/play.scn?raw=true")!
                            let scenePlay = try? SCNScene(url: urlPlay, options: nil)
                            var playNode: SCNNode
                            playNode = (scenePlay?.rootNode.childNode(withName: "play", recursively: false))!
                            playNode.name = itemAnchor.itemIdentifier + "play"
                            playNode.position = SCNVector3(x: 0.075, y: 0.0, z: 0.1)
                            
                            //Add both buttons to the node as childs
                            node?.addChildNode(pauseNode)
                            node?.addChildNode(playNode)
                        } else if strMedia == "image" {/*
                            let taskImage = URLSession.shared.dataTask(with: url, completionHandler: { data, response, error in
                                material.diffuse.contents = UIImage(data: data!)
                                node?.geometry = node?.geometry?.copy() as? SCNGeometry
                                node?.geometry?.firstMaterial = node?.geometry?.firstMaterial?.copy() as? SCNMaterial
                                node?.geometry?.firstMaterial = material
                            })
                            taskImage.resume()*/
                            material.diffuse.contents = UIImage(named: "indice")
                            node?.geometry = node?.geometry?.copy() as? SCNGeometry
                            node?.geometry?.firstMaterial = node?.geometry?.firstMaterial?.copy() as? SCNMaterial
                            node?.geometry?.firstMaterial = material
                        }
                        
                    }
                } else {
                    var documentsUrl: URL {
                        return FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first!
                    }
                    let fileName = itemAnchor.givenName
                    let fileURL = documentsUrl.appendingPathComponent(fileName)
                    do {
                        let imageData = try Data(contentsOf: fileURL)
                        let image = UIImage(data: imageData)
                        if image != nil {
                            material.diffuse.contents = image
                            //get child called image
                            if node?.childNode(withName: "image", recursively: false) != nil {
                                let childMaterial = node?.childNode(withName: "image", recursively: false)
                                childMaterial?.geometry = childMaterial?.geometry?.copy() as? SCNGeometry
                                childMaterial?.geometry?.firstMaterial = childMaterial?.geometry?.firstMaterial?.copy() as? SCNMaterial
                                childMaterial?.geometry?.firstMaterial = material
                            } else {
                                node?.geometry = node?.geometry?.copy() as? SCNGeometry
                                node?.geometry?.firstMaterial = node?.geometry?.firstMaterial?.copy() as? SCNMaterial
                                node?.geometry?.firstMaterial = material
                            }
                        }
                    } catch {
                        print("Error loading image : \(error)")
                    }
                }
                break
            }
        }
        return node!
    }
    
    func checkOverLapping(node: SCNNode) -> Bool{
        if(self.objectsInitialPos.count < 1) {return true}
        let keys = self.objectsInitialPos.allKeys
        for key in keys {
            let box = self.objectsBoundingBox.value(forKey: key as! String) as! NSMutableDictionary
            let min = box.value(forKey: "min") as! SCNVector3
            let max = box.value(forKey: "max") as! SCNVector3
            let originPos = self.objectsInitialPos.value(forKey: key as! String) as! NSMutableDictionary

            //get max and min from current node
            let xmax = node.boundingBox.max.x + node.position.x
            let xmin = node.boundingBox.min.x + node.position.x
            let ymax = node.boundingBox.max.y + node.position.y
            let ymin = node.boundingBox.min.y + node.position.y
            let zmax = node.boundingBox.max.z + node.position.z
            let zmin = node.boundingBox.min.z + node.position.z

            //get max and min from previous existing node
            let originxmax = max.x + (originPos.value(forKey: "x") as! Float)
            let originxmin = min.x + (originPos.value(forKey: "x") as! Float)
            let originymax = max.y + (originPos.value(forKey: "y") as! Float)
            let originymin = min.y + (originPos.value(forKey: "y") as! Float)
            let originzmax = max.z + (originPos.value(forKey: "z") as! Float)
            let originzmin = min.z + (originPos.value(forKey: "z") as! Float)

            //overlapping if x y and z (max or min) is between max and min of existing node
            if(((xmax < originxmax && xmax > originxmin) || (xmin < originxmax && xmin > originxmin)) && ((ymax < originymax && ymax > originymin) || (ymin < originymax && xmin > originymin)) && ((zmax < originzmax && zmax > originzmin) || (zmin < originzmax && zmin > originzmin))){

                return false
            }
        }
        return true;
    }
    
    func addToModelExternal(anchor itemAnchor: ItemAnchor) {
        let item = NSMutableDictionary()
        // TODO: Change name of field for better names
        item["name"] = itemAnchor.itemIdentifier
        item["nick"] = itemAnchor.givenName
        item["class"] = itemAnchor.type
        item["current_version"] = itemAnchor.currentVersionInt
        // attributes of the new element
        let minCardinalityOfEachAttributes = NSMutableDictionary()
        let attributesOfItem = NSMutableDictionary()
        let typeOfAttributesOfItem = NSMutableDictionary()
        let maxOfAttributesOfItem = NSMutableDictionary()
        let readOnlyOfAttributes = NSMutableDictionary()
        let isParamOfAttributes = NSMutableDictionary()
        for anAttribute in itemAnchor.getAttributes() {
            if let currentAttribute = anAttribute as? NSMutableDictionary {
                let nameOfAttribute = currentAttribute["name"] as! NSString
                let defaultValueOfAttribute = currentAttribute["default"]
                let maxCardinalityOfAttribute = currentAttribute["max"]
                let minCardinatilyOfAttribute = currentAttribute["min"]
                let typeOfAttribute = currentAttribute["type"]
                let readOnlyOfAttribute = currentAttribute["readOnly"]
                let isParamOfAttribute = currentAttribute["isParam"]
                var loadAttributeValue = defaultValueOfAttribute
                var isLoaded = false
                let isParam = isParamOfAttribute as! Bool
                
                if(isParam) {
                    attributesOfItem.setObject(self.currentParam!, forKey: nameOfAttribute)
                } else {
                    var string = "https://alter-databroker.onrender.com/accessUrl?aname=" + itemAnchor.API
                    string += "&aclass=" + itemAnchor.type
                    let attString = nameOfAttribute as String
                    string += "&ain=" + self.currentParam! + "&aout=" + attString
                    if itemAnchor.auth != "" {
                        string += "&eauth=" + itemAnchor.auth
                    }
                    string += "&json=true"
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
                                    let array = jsonResult["array"] as! NSMutableDictionary
                                    let type = typeOfAttribute as! String
                                    if(type == "String") {
                                        let body = array["body"] as! NSString
                                        loadAttributeValue = body as String
                                    } else {
                                        let body = String(describing: array["body"])
                                        if body.contains("Optional") {
                                            let split = body.split(separator: "(")
                                            let split2 = split[split.count - 1].split(separator: ")")
                                            let res = split2[0]
                                            if type == "Int" || type == "Double" || type == "Float" {
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
                                    
                                    isLoaded = true
                                } catch let e{
                                    print("[NewExtNode] ", e)
                                }
                            }
                        }
                    }
                    task.resume()
                    while(!isLoaded){
                    }
                    
                    attributesOfItem.setObject(loadAttributeValue!, forKey: nameOfAttribute)
                }
                typeOfAttributesOfItem.setObject(typeOfAttribute!, forKey: nameOfAttribute)
                maxOfAttributesOfItem.setObject(maxCardinalityOfAttribute!, forKey: nameOfAttribute)
                /*self.itemTypeAttributes.setObject(typeOfAttribute!, forKey: nameOfAttribute)
                self.itemMaxAttributes.setObject(maxCardinalityOfAttribute!, forKey: nameOfAttribute)*/
                minCardinalityOfEachAttributes.setObject(minCardinatilyOfAttribute!, forKey: nameOfAttribute)
                readOnlyOfAttributes.setObject(readOnlyOfAttribute!, forKey: nameOfAttribute)
                isParamOfAttributes.setObject(isParamOfAttribute!, forKey: nameOfAttribute)
            }
        }
        item["attributes"] = attributesOfItem
        item["typeAttributes"] = typeOfAttributesOfItem
        item["maxAttributes"] = maxOfAttributesOfItem
        /*newItem["attributes"] = self.itemAttributes
        newItem["typeAttributes"] = self.itemTypeAttributes
        newItem["maxAttributes"] = self.itemMaxAttributes*/
        item["minAttributes"] = minCardinalityOfEachAttributes
        item["readOnlyAttributes"] = readOnlyOfAttributes
        // references of the new element
        let minCardinalityOfEachReferences = NSMutableDictionary()
        let referencesOfItem = NSMutableDictionary()
        let targetOfReferencesOfItem = NSMutableDictionary()
        let maxOfReferencesOfItem = NSMutableDictionary()
        for aReference in itemAnchor.getReferences() {
            if let currentReference = aReference as? NSMutableDictionary {
                let nameOfReference = currentReference["name"] as! NSString
                let maxCardinalityOfReference = currentReference["max"]
                let minCardinalityOfReference = currentReference["min"]
                let targetOfReference = currentReference["target"]
                let stringReferencesValue = convertDictionaryToString(dictionary: itemAnchor.getValueOfReferences())
                
                if stringReferencesValue != "{}" {
                    //self.itemReferences.setObject(itemAnchor.getValueOfReferences()[nameOfReference]!, forKey: nameOfReference)
                    referencesOfItem.setObject(itemAnchor.getValueOfReferences()[nameOfReference]!, forKey: nameOfReference)
                } else {
                    //self.itemReferences.setObject("", forKey: nameOfReference)
                    referencesOfItem.setObject("", forKey: nameOfReference)
                }
                targetOfReferencesOfItem.setObject(targetOfReference!, forKey: nameOfReference)
                maxOfReferencesOfItem.setObject(maxCardinalityOfReference!, forKey: nameOfReference)
                /*self.itemReferences.setObject("", forKey: nameOfReference)
                self.itemTargetReferences.setObject(targetOfReference!, forKey: nameOfReference)
                self.itemMaxReferences.setObject(maxCardinalityOfReference!, forKey: nameOfReference)*/
                minCardinalityOfEachReferences.setObject(minCardinalityOfReference!, forKey: nameOfReference)
            }
        }
        item["references"] = referencesOfItem
        item["targetReferences"] = targetOfReferencesOfItem
        item["maxReferences"] = maxOfReferencesOfItem
        /*newItem["references"] = self.itemReferences
        newItem["targetReferences"] = self.itemTargetReferences
        newItem["maxReferences"] = self.itemMaxReferences*/
        item["minReferences"] = minCardinalityOfEachReferences
        // Create an AR facet to store its representations and nodes in AR environment
        /*let arFacet = NSMutableDictionary()
        newItem["ar_facet"] = arFacet*/
        //newItem["ar_facet"] = itemAnchor.getARFacet()
        
        item["current_version"] = itemAnchor.currentVersionInt
        item["max_version"] = Int(itemAnchor.numberOfVersions)
        
        self.model.append(item)
    }
    /**
     Add a new item to the global variable *model*.
     
     - parameter anchor: The anchor that has been placed, this function add it to the global variable *model*.
     */
    func addToModel(anchor itemAnchor: ItemAnchor) {
        
        let item = NSMutableDictionary()
        // TODO: Change name of field for better names
        item["name"] = itemAnchor.itemIdentifier
        item["nick"] = itemAnchor.givenName
        item["class"] = itemAnchor.type
        item["current_version"] = itemAnchor.currentVersionInt
        // attributes of the new element
        let minCardinalityOfEachAttributes = NSMutableDictionary()
        let attributesOfItem = NSMutableDictionary()
        let typeOfAttributesOfItem = NSMutableDictionary()
        let maxOfAttributesOfItem = NSMutableDictionary()
        let readOnlyOfAttributes = NSMutableDictionary()
        for anAttribute in itemAnchor.getAttributes() {
            if let currentAttribute = anAttribute as? NSMutableDictionary {
                let nameOfAttribute = currentAttribute["name"] as! NSString
                let defaultValueOfAttribute = currentAttribute["default"]
                let maxCardinalityOfAttribute = currentAttribute["max"]
                let minCardinatilyOfAttribute = currentAttribute["min"]
                let typeOfAttribute = currentAttribute["type"]
                let readOnlyOfAttribute = currentAttribute["readOnly"]
                let stringAttributesValue = convertDictionaryToString(dictionary: itemAnchor.getValueOfAttributes())
                
                
                if stringAttributesValue != "{}" {
                    //self.itemAttributes.setObject(itemAnchor.getValueOfAttributes()[nameOfAttribute]!, forKey: nameOfAttribute)
                    attributesOfItem.setObject(itemAnchor.getValueOfAttributes()[nameOfAttribute]!, forKey: nameOfAttribute)
                } else {
                    //self.itemAttributes.setObject(defaultValueOfAttribute!, forKey: nameOfAttribute)
                    attributesOfItem.setObject(defaultValueOfAttribute!, forKey: nameOfAttribute)
                }
                typeOfAttributesOfItem.setObject(typeOfAttribute!, forKey: nameOfAttribute)
                maxOfAttributesOfItem.setObject(maxCardinalityOfAttribute!, forKey: nameOfAttribute)
                /*self.itemTypeAttributes.setObject(typeOfAttribute!, forKey: nameOfAttribute)
                self.itemMaxAttributes.setObject(maxCardinalityOfAttribute!, forKey: nameOfAttribute)*/
                minCardinalityOfEachAttributes.setObject(minCardinatilyOfAttribute!, forKey: nameOfAttribute)
                readOnlyOfAttributes.setObject(readOnlyOfAttribute!, forKey: nameOfAttribute)
            }
        }
        item["attributes"] = attributesOfItem
        item["typeAttributes"] = typeOfAttributesOfItem
        item["maxAttributes"] = maxOfAttributesOfItem
        /*newItem["attributes"] = self.itemAttributes
        newItem["typeAttributes"] = self.itemTypeAttributes
        newItem["maxAttributes"] = self.itemMaxAttributes*/
        item["minAttributes"] = minCardinalityOfEachAttributes
        item["readOnlyAttributes"] = readOnlyOfAttributes
        // references of the new element
        let minCardinalityOfEachReferences = NSMutableDictionary()
        let referencesOfItem = NSMutableDictionary()
        let targetOfReferencesOfItem = NSMutableDictionary()
        let maxOfReferencesOfItem = NSMutableDictionary()
        for aReference in itemAnchor.getReferences() {
            if let currentReference = aReference as? NSMutableDictionary {
                let nameOfReference = currentReference["name"] as! NSString
                let maxCardinalityOfReference = currentReference["max"]
                let minCardinalityOfReference = currentReference["min"]
                let targetOfReference = currentReference["target"]
                let stringReferencesValue = convertDictionaryToString(dictionary: itemAnchor.getValueOfReferences())
                
                if stringReferencesValue != "{}" {
                    //self.itemReferences.setObject(itemAnchor.getValueOfReferences()[nameOfReference]!, forKey: nameOfReference)
                    referencesOfItem.setObject(itemAnchor.getValueOfReferences()[nameOfReference]!, forKey: nameOfReference)
                } else {
                    //self.itemReferences.setObject("", forKey: nameOfReference)
                    referencesOfItem.setObject("", forKey: nameOfReference)
                }
                targetOfReferencesOfItem.setObject(targetOfReference!, forKey: nameOfReference)
                maxOfReferencesOfItem.setObject(maxCardinalityOfReference!, forKey: nameOfReference)
                /*self.itemReferences.setObject("", forKey: nameOfReference)
                self.itemTargetReferences.setObject(targetOfReference!, forKey: nameOfReference)
                self.itemMaxReferences.setObject(maxCardinalityOfReference!, forKey: nameOfReference)*/
                minCardinalityOfEachReferences.setObject(minCardinalityOfReference!, forKey: nameOfReference)
            }
        }
        item["references"] = referencesOfItem
        item["targetReferences"] = targetOfReferencesOfItem
        item["maxReferences"] = maxOfReferencesOfItem
        /*newItem["references"] = self.itemReferences
        newItem["targetReferences"] = self.itemTargetReferences
        newItem["maxReferences"] = self.itemMaxReferences*/
        item["minReferences"] = minCardinalityOfEachReferences
        // Create an AR facet to store its representations and nodes in AR environment
        /*let arFacet = NSMutableDictionary()
        newItem["ar_facet"] = arFacet*/
        //newItem["ar_facet"] = itemAnchor.getARFacet()
        
        item["current_version"] = itemAnchor.currentVersionInt
        item["max_version"] = Int(itemAnchor.numberOfVersions)
        
        self.model.append(item)
    }
    func checkLoadInfo(selectedItem: String, param: NSMutableDictionary, nodename: String) -> String {
        var classOfSelectedItem = NSMutableDictionary()
        // retrieves the information relative to the selected item in the metamodel
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
        let referencesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
        let APIOfSelectedItem = accessOfSelectedItem["name"] as? String ?? ""
        let authOfSelectedItem = accessOfSelectedItem["auth"] as? String ?? ""
        let classTrigger = accessOfSelectedItem["trigger"] as? NSMutableDictionary ?? nil
        var previousInfo = ""
        if APIOfSelectedItem != "" && classTrigger != nil {
            let trigger = classTrigger!["onLoad"] as! Bool
            if trigger {
                previousInfo = getPreviousInfoExternal(attributesOfSelectedItem: attributesOfSelectedItem, referencesOfSelectedItem: referencesOfSelectedItem, classOfSelectedItem: classOfSelectedItem, APIOfSelectedItem: APIOfSelectedItem, authOfSelectedItem: authOfSelectedItem, param: param, nodename: nodename)
            }
        }
        return previousInfo
    }
    func loadReserveReferenceToModel(item: ItemAnchor, item2: ItemAnchor) {
        let node = self.sceneView.node(for: item)
        // Search for the result's object in the model, as an object or as an attributes
        var itemDic: NSMutableDictionary = [:]
        var itemFound = false
        for eachItemDic in self.model {
            if let eachNameOfItemInModel = eachItemDic["name"] as? String {
                print("eachNode : \(eachNameOfItemInModel) AND oldNode : \(String(describing: node!.name))")
                if eachNameOfItemInModel == node!.name {
                    itemDic = eachItemDic
                    itemFound = true
                }
            }
        }
        if (itemFound) {
            let itemReferences = itemDic["references"] as! NSMutableDictionary
            let targetReferences = itemDic["targetReferences"] as! NSMutableDictionary
            //Note: item refereneces and target should have the same keys at the same order
            for key in itemReferences.allKeys {
                let target = targetReferences[key] as! String
                if item2.type == target {
                    itemReferences[key] = item2.givenName
                }
            }
            print(self.model)
        }
    }
}
