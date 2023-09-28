//
//  ARViewController+Physics.swift
//  ARModelling
//
//  Created by MISO on 14/7/22.
//

import Foundation
import ARKit

extension ARViewController {
    func doAction(actionName: String){
        for game in self.gameloopInfo {
            let gameName = game["name"] as! String
            var basicAction = ""
            let triggerActions = game["actionsTriggers"] as! NSMutableArray
            for action in triggerActions {
                let actionObj = action as! NSMutableDictionary
                if actionName == actionObj["name"] as! String {
                    if (actionObj["action"] != nil) {
                        basicAction = actionObj["action"] as! String
                    }
                    break
                }
            }
            if self.currentGame != "" && self.currentGame == gameName {
                if actionName == "win" || basicAction == "win"{
                    self.gameOver = true
                    let text = game["win"] as! String + ". SCORE :" + String(self.score)
                    self.currentScales = [:]
                    self.displayLabel(text: text)
                    self.deleteItems()
                    self.deleteButtons(game: game)
                } else if actionName == "lose" || basicAction == "lose" {
                    self.gameOver = true
                    self.currentScales = [:]
                    let text = game["lose"] as! String + ". SCORE :" + String(self.score)
                    self.displayLabel(text: text)
                    self.deleteItems()
                    self.deleteButtons(game: game)
                } else if actionName == "start" || basicAction == "start" {
                    self.gameOver = false
                    self.displayLabel(text: game["start"] as! String)
                    let scoreSystem = game["scoreSystem"] as! NSMutableDictionary
                    let scoreStart = scoreSystem["start"] as! Double
                    self.score = scoreStart
                    //Check and start timetriggers
                    let triggerActions = game["actionsTriggers"] as! NSMutableArray
                    for action in triggerActions {
                        let actionObj = action as! NSMutableDictionary
                        if actionObj["timeTrigger"] != nil {
                            let time = actionObj["timeTrigger"] as! Double
                            let userInfo : NSMutableDictionary = [:]
                            userInfo.setValue(actionObj["name"] as! String, forKey: "name")
                            let timer = Timer.scheduledTimer(timeInterval: time, target: self, selector: #selector(timeTriggerAction(sender:)), userInfo: userInfo, repeats: true)
                            
                        }
                    }
                } else {
                    //check actionsTriggers
                    let triggerActions = game["actionsTriggers"] as! NSMutableArray
                    for action in triggerActions {
                        let actionObj = action as! NSMutableDictionary
                        if actionName == actionObj["name"] as! String {
                            if actionObj["message"] != nil {
                                let message = actionObj["message"] as! String
                                if message != "" {
                                    self.displayLabel(text: message)
                                }
                            }
                            if actionObj["scoreChange"] != nil {
                                score += actionObj["scoreChange"] as! Double
                                let scoreSystem = game["scoreSystem"] as! NSMutableDictionary
                                let finish = scoreSystem["finish"] as! Double
                                if finish <= score && finish != -1 {
                                    doAction(actionName: "win")
                                    return
                                }
                            }
                            if basicAction == "restart" {
                                self.deleteItems()
                                let objInit = game["objInit"] as! NSMutableArray
                                for obj in objInit {
                                    let gameobj = obj as! NSMutableDictionary
                                    let objClass = gameobj["class"] as! String
                                    if objClass == "player" {
                                        print("A")
                                    }
                                    var objX = 0.0
                                    var objY = 0.0
                                    var objZ = 0.0
                                    var transform = simd_float4x4(
                                        SIMD4<Float>(1, 0, 0, 0),
                                        SIMD4<Float>(0, 1, 0, 0),
                                        SIMD4<Float>(0, 0, 1, 0),
                                        SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1)
                                    )
                                    let objName = gameobj["name"] as! String
                                    objX = gameobj["posX"] as! Double
                                    objY = gameobj["posY"] as! Double
                                    objZ = gameobj["posZ"] as! Double
                                    if objX == 999 {
                                        transform = self.transformFrameCamera ?? simd_float4x4(
                                            SIMD4<Float>(1, 0, 0, 0),
                                            SIMD4<Float>(0, 1, 0, 0),
                                            SIMD4<Float>(0, 0, 1, 0),
                                            SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1))
                                        
                                    } else {
                                        transform = simd_float4x4(
                                            SIMD4<Float>(1, 0, 0, 0),
                                            SIMD4<Float>(0, 1, 0, 0),
                                            SIMD4<Float>(0, 0, 1, 0),
                                            SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1))
                                    }
                                    
                                    
                                    var rotation = 0
                                    if gameobj["rotation"] != nil {
                                        rotation = gameobj["rotation"] as! Int
                                    }
                                    var attributes : NSMutableArray = []
                                    if gameobj["attributes"] != nil {
                                        attributes = gameobj["attributes"] as! NSMutableArray
                                    }
                                    
                                    transform = simd_float4x4(
                                        SIMD4<Float>(1, 0, 0, 0),
                                        SIMD4<Float>(0, 1, 0, 0),
                                        SIMD4<Float>(0, 0, 1, 0),
                                        SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1)
                                    )
                                    var scale = 1.0
                                    if self.currentScales[objName] != nil {
                                        scale = self.currentScales[objName] as! Double
                                    }
                                    if actionObj["sceneChanges"] != nil {
                                        let scnChanges = actionObj["sceneChanges"] as! NSMutableArray
                                        for scn in scnChanges {
                                            let scnChangeObj = scn as! NSMutableDictionary
                                            let scnName = scnChangeObj["name"] as! String
                                            let scnClass = scnChangeObj["class"] as! String
                                            if objName == scnName && objClass == scnClass {
                                                if scnChangeObj["scale"] != nil {
                                                    let scnscale = scnChangeObj["scale"] as! Double
                                                    if scnscale != 0 {
                                                        scale += scnscale
                                                        self.currentScales.setValue(scale, forKey: scnName)
                                                    }
                                                }
                                                break
                                            }
                                            
                                        }
                                    }
                                    self.createNode(objName: objName, objClass: objClass, transform: transform, force: "", attributes: attributes, rotation: rotation, scaling: scale)
                                }
                            }
                            if actionObj["physicChanges"] != nil {
                                let physicChanges = actionObj["physicChanges"] as! NSMutableDictionary
                                let physicClass = physicChanges["class"] as! String
                                for node in self.sceneView.scene.rootNode.childNodes {
                                    let anchor = self.sceneView.anchor(for: node)
                                    if anchor != nil {
                                        if (anchor!.isKind(of: ItemAnchor.self)) {
                                            let itemAnchor = anchor as! ItemAnchor
                                            if itemAnchor.type == physicClass {
                                                if physicChanges["scale"] != nil {
                                                    let scale = physicChanges["scale"] as! Double
                                                    let pinchAction = SCNAction.scale(by: 1.0 + scale, duration: 0)
                                                    node.runAction(pinchAction)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if actionObj["sceneChanges"] != nil {
                                let scnChanges = actionObj["sceneChanges"] as! NSMutableArray
                                for scn in scnChanges {
                                    let scnChangeObj = scn as! NSMutableDictionary
                                    let objName = scnChangeObj["name"] as! String
                                    let objClass = scnChangeObj["class"] as! String
                                    let action = scnChangeObj["action"] as! String
                                    var force = ""
                                    if scnChangeObj["force"] != nil{
                                        force = scnChangeObj["force"] as! String
                                    }
                                    var position = ""
                                    if scnChangeObj["position"] != nil{
                                        position = scnChangeObj["position"] as! String
                                    }
                                    var objX = 0.0
                                    var objY = 0.0
                                    var objZ = 0.0
                                    var transform = simd_float4x4(
                                        SIMD4<Float>(1, 0, 0, 0),
                                        SIMD4<Float>(0, 1, 0, 0),
                                        SIMD4<Float>(0, 0, 1, 0),
                                        SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1)
                                    )
                                    if position == "front" {
                                        let matrix = self.sceneView.pointOfView?.transform
                                        transform = simd_float4x4(
                                            SIMD4<Float>(matrix!.m11, matrix!.m12, matrix!.m13, matrix!.m14),
                                                SIMD4<Float>(matrix!.m21, matrix!.m22, matrix!.m23, matrix!.m24),
                                                SIMD4<Float>(matrix!.m31, matrix!.m32, matrix!.m33, matrix!.m34),
                                            SIMD4<Float>(matrix!.m41, matrix!.m42 - 0.1, matrix!.m43, matrix!.m44)
                                        )
                                    }
                                    if action == "create" {
                                        self.createNode(objName: objName, objClass: objClass, transform: transform, force: force, attributes: [], rotation: 0, scaling: 1.0)
                                    } else if action == "delete" {
                                        for node in self.sceneView.scene.rootNode.childNodes {
                                            let anchor = self.sceneView.anchor(for: node)
                                            if anchor != nil {
                                                if (anchor!.isKind(of: ItemAnchor.self)) {
                                                    let item = anchor as! ItemAnchor
                                                    if item.givenName == objName{
                                                        let nick = self.objectsIdName.value(forKey: node.name!) as! String
                                                        self.sceneView.session.remove(anchor: anchor!)
                                                        node.removeFromParentNode()
                                                        self.objectsInitialPos.removeObject(forKey: node.name)
                                                        self.objectsBoundingBox.removeObject(forKey: node.name)
                                                        self.objectsIdName.removeObject(forKey: node.name)
                                                        self.objectsList.removeObject(forKey: nick)
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    } else if action == "edit" {
                                        var itemDic: NSMutableDictionary = [:]
                                        var itemFound = false
                                        //var arfacetDic: NSMutableDictionary = [:] ->(see next /* */ block)<-
                                        //var facetFound = false
                                        for eachItemDic in self.model {

                                            
                                            if let eachNameOfItemInModel = eachItemDic["nick"] as? String {
                                                if eachNameOfItemInModel == objName {
                                                    itemDic = eachItemDic
                                                    itemFound = true
                                                }
                                            }
                                        }
                                        if (itemFound) {
                                            if scnChangeObj["attribute"] != nil{
                                                let objAttribute = scnChangeObj["attribute"] as! String
                                                let itemAttributes = itemDic["attributes"] as! NSMutableDictionary
                                                if itemAttributes[objAttribute] != nil {
                                                    if (Int(itemAttributes[objAttribute] as! String) != nil) {
                                                        var attr = Int(itemAttributes[objAttribute] as! String)
                                                        attr! += scnChangeObj["changeValue"] as! Int
                                                        let str = String(attr!)
                                                        itemAttributes[objAttribute] = str
                                                    } else {
                                                        var attr = itemAttributes[objAttribute] as! String
                                                        attr += scnChangeObj["changeValue"] as! String
                                                        itemAttributes[objAttribute] = attr
                                                    }
                                                }
                                                print("[ARVC] Model", self.model)
                                            } else if force != "" {
                                                for node in self.sceneView.scene.rootNode.childNodes {
                                                    let anchor = self.sceneView.anchor(for: node)
                                                    if anchor != nil {
                                                        if (anchor!.isKind(of: ItemAnchor.self)) {
                                                            let itemAnchor = anchor as! ItemAnchor
                                                            if itemAnchor.type == objClass && itemAnchor.givenName == objName {
                                                                forceToNode(node: node, forceName: force, anchor: itemAnchor)
                                                                break
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if scnChangeObj["scale"] != nil {
                                                let scale = scnChangeObj["scale"] as! Double
                                                if scale != 0 {
                                                    for node in self.sceneView.scene.rootNode.childNodes {
                                                        let anchor = self.sceneView.anchor(for: node)
                                                        if anchor != nil {
                                                            if (anchor!.isKind(of: ItemAnchor.self)) {
                                                                let itemAnchor = anchor as! ItemAnchor
                                                                if itemAnchor.type == objClass && itemAnchor.givenName == objName {
                                                                    let pinchAction = SCNAction.scale(by: 1.0 + scale, duration: 0)
                                                                    node.runAction(pinchAction)
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
                            break
                        }
                    }
                }
                if !self.gameOver {
                    checkRules()
                }
                
            }
        }
    }
    
    @objc func timeTriggerAction(sender: Timer){
        if self.gameOver {
            sender.invalidate()
            return
        }
        let info = sender.userInfo as! NSMutableDictionary
        doAction(actionName: info["name"] as! String)
    }
    func deleteButtons(game: NSMutableDictionary){
        DispatchQueue.main.async {
            for gameButton in self.view.subviews {
                if gameButton.isKind(of: UIButton.self) {
                    let button = gameButton as! UIButton
                    if game["gamePad"] != nil{
                        let gamepads = game["gamePad"] as! NSMutableArray
                        for gpad in gamepads {
                            let objGpad = gpad as! NSMutableDictionary
                            let gname = objGpad["name"] as! String
                            if gname == button.currentTitle {
                                button.removeFromSuperview()
                            }
                        }
                    }
                    
                }
            }
            if self.physicButton.currentTitle == "Start" {
                self.physicButton.setTitleColor(UIColor.systemRed, for: .normal)
            }
        }
    }
    func deleteItems(){
        for node in self.sceneView.scene.rootNode.childNodes {
            let anchor = self.sceneView.anchor(for: node)
            if anchor != nil {
                if (anchor!.isKind(of: ItemAnchor.self)) {
                    let nick = self.objectsIdName.value(forKey: node.name!) as! String
                    self.sceneView.session.remove(anchor: anchor!)
                    node.removeFromParentNode()
                    self.objectsInitialPos.removeObject(forKey: node.name)
                    self.objectsBoundingBox.removeObject(forKey: node.name)
                    self.objectsIdName.removeObject(forKey: node.name)
                    self.objectsList.removeObject(forKey: nick)
                }
            }
        }
    }
    
    func checkRules() {
        for game in self.gameloopInfo {
            let gameName = game["name"] as! String
            if self.currentGame != "" && self.currentGame == gameName {
                let objects = game["objInit"] as! NSMutableArray
                for obj in objects {
                    let objInit = obj as! NSMutableDictionary
                    let name = objInit["name"] as! String
                    let className = objInit["class"] as! String
                    if objInit["rules"] != nil {
                        let rules = objInit["rules"] as! NSMutableArray
                        for r in rules {
                            let rule = r as! NSMutableDictionary
                            let condition = rule["condition"] as! NSMutableDictionary
                            let action = rule["action"] as! String
                            if applyCondition(condition: condition, name: name, className: className) {
                                doAction(actionName: action)
                            }
                        }
                    }
                }
            }
        }
    }
    func applyCondition(condition: NSMutableDictionary, name: String, className: String) -> Bool {
        var lefts = "", rights = ""
        let operation = condition["operation"] as! String
        if operation == "And" || operation == "Or" {
            let right = condition["right"] as! NSMutableDictionary
            let left = condition["left"] as! NSMutableDictionary
            if operation == "And" {
                return applyCondition(condition: left, name: name, className: className) && applyCondition(condition: right, name: name, className: className)
            } else {
                return applyCondition(condition: left, name: name, className: className) || applyCondition(condition: right, name: name, className: className)
            }
        } else if operation == "Not" {
            let left = condition["left"] as! NSMutableDictionary
            return !applyCondition(condition: left, name: name, className: className)
        } else {
            lefts = condition["lefts"] as! String
            rights = condition["rights"] as! String
            if lefts.contains("All"){
            } else {
                var itemDic: NSMutableDictionary = [:]
                var itemFound = false
                for eachItemDic in self.model {
                    if let eachNameOfItemInModel = eachItemDic["nick"] as? String {
                        if eachNameOfItemInModel == name {
                            itemDic = eachItemDic
                            itemFound = true
                        }
                    }
                }
                if itemFound {
                    let itemAttributes = itemDic["attributes"] as! NSMutableDictionary
                    if itemAttributes[lefts] != nil {
                        let itemAttr = itemAttributes[lefts] as! String
                        if operation == "equal" {
                            if itemAttr == rights {
                                return true
                            } else {
                                return false
                            }
                        } else if operation == "greater" {
                            if itemAttr > rights {
                                return true
                            } else {
                                return false
                            }
                        } else if operation == "greaterEqual" {
                            if itemAttr >= rights {
                                return true
                            } else {
                                return false
                            }
                        } else if operation == "lower" {
                            if itemAttr < rights {
                                return true
                            } else {
                                return false
                            }
                        } else if operation == "lowerEqual" {
                            if itemAttr <= rights {
                                return true
                            } else {
                                return false
                            }
                        }
                    }
                }
            }
        }
        return false
    }
    func tiltObjects(){
        for physicData in self.physicsInfo {
            let classPhysic = physicData["name"] as! String
            var forces = NSMutableArray()
            if physicData["forces"] != nil {
                forces = physicData["forces"] as! NSMutableArray
                for forceObj in forces {
                    let forceDic = forceObj as! NSMutableDictionary
                    if forceDic["gesture"] as? String == "tilt" {
                        break
                    }
                }
            }
            for node in self.sceneView.scene.rootNode.childNodes {
                let anAnchor = self.sceneView.anchor(for: node)
                if anAnchor != nil {
                    if (anAnchor!.isKind(of: ItemAnchor.self)) {
                        if let anItemAnchor = anAnchor as? ItemAnchor {
                            if anItemAnchor.type == classPhysic {
                                if tiltMotion.isDeviceMotionAvailable {
                                    node.geometry?.firstMaterial?.emission.contents = UIColor.green
                                    tiltMotion.deviceMotionUpdateInterval = 0.1
                                    let q = OperationQueue()
                                    tiltMotion.startDeviceMotionUpdates(to: q, withHandler: { [weak self] motion, error in
                                        if let attitude = motion?.attitude {
                                            
                                            DispatchQueue.main.async {
                                                let rotateAction = SCNAction.rotateTo(x: attitude.pitch, y: attitude.yaw, z: -attitude.roll, duration: 0.1, usesShortestUnitArc: true)
                                                node.runAction(rotateAction)
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
}
