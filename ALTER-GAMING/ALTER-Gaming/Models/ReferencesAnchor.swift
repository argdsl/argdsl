//
//  ReferencesAnchor.swift
//  ARModelling
//
//  Created by MISO on 16/10/2020.
//

import UIKit
import ARKit

class ReferencesAnchor: ARAnchor {
    
    /// Name of the ItemAnchor which the ReferencesAnchor is attached to.
    var nameOfItemAnchor: String
    /// Nick of the first node
    var nickA: String
    /// Nick of the second node
    var nickB: String
    /// Name of the class target
    var classObj: String
    /// Name of the reference
    var refName: String
    /// Width of the line object
    var width: CGFloat
    /// Color of the line object
    var color: String
    /// Length of the line object
    var length: CGFloat
    /// Position of the first node
    var initPos: SCNVector3
    /// Position of the second node
    var finalPos: SCNVector3
    /// Name of the line's version
    var version: String
    /**
     Creates a new ReferencesAnchor object with the specified transform and the informations relative to the nodes and line which it is attached to.
     
     - parameter nameOfItemAnchor: The name of the ItemAnchor which the ReferencesAnchor is attached to.
     - parameter nickA: Nick of the first node
     - parameter nickB: Nick of the second node
     - parameter classObj: Name of the class target
     - parameter refName: Name of the reference
     - parameter width: Width of the line object
     - parameter color: Color of the line object
     - parameter length: Length of the line object
     - parameter initPos: Position of the first node
     - parameter finalPos: Position of the second node
     - parameter version: Name of the line's version
     - parameter transform: A matrix encoding the position, orientation, and scale of the anchor relative to the world coordinate space of the AR session the anchor is placed in.
     */
    init(nameOfItemAnchor: String, nickA: String, nickB: String, classObj: String, refName: String, width: CGFloat, color: String, length: Float, initPos: SCNVector3, finalPos: SCNVector3, version: String, transform: float4x4) {
        self.nameOfItemAnchor = nameOfItemAnchor
        self.nickA = nickA
        self.nickB = nickB
        self.classObj = classObj
        self.refName = refName
        self.width = width
        self.color = color
        self.length = CGFloat(length)
        self.initPos = initPos
        self.finalPos = finalPos
        self.version = version
        super.init(transform: transform)
    }
    
    required init(anchor: ARAnchor) {
        self.nameOfItemAnchor = (anchor as! ReferencesAnchor).nameOfItemAnchor
        self.nickA = (anchor as! ReferencesAnchor).nickA
        self.nickB = (anchor as! ReferencesAnchor).nickB
        self.classObj = (anchor as! ReferencesAnchor).classObj
        self.refName = (anchor as! ReferencesAnchor).refName
        self.width = (anchor as! ReferencesAnchor).width
        self.color = (anchor as! ReferencesAnchor).color
        self.length = (anchor as! ReferencesAnchor).length
        self.initPos = (anchor as! ReferencesAnchor).initPos
        self.finalPos = (anchor as! ReferencesAnchor).finalPos
        self.version = (anchor as! ReferencesAnchor).version
        super.init(anchor: anchor)
    }
    
    required init?(coder: NSCoder) {
        if let nameOfItemAnchor = coder.decodeObject(forKey: "nameOfItemAnchor") as? String,
           let nickA = coder.decodeObject(forKey: "nickA") as? String,
           let nickB = coder.decodeObject(forKey: "nickB") as? String,
           let classObj = coder.decodeObject(forKey: "classObj") as? String,
           let refName = coder.decodeObject(forKey: "refName") as? String,
           let width = coder.decodeObject(forKey: "width") as? CGFloat,
           let color = coder.decodeObject(forKey: "color") as? String,
           let length = coder.decodeObject(forKey: "length") as? CGFloat,
           let initPosx = coder.decodeObject(forKey: "initPosx") as? CGFloat,
           let initPosy = coder.decodeObject(forKey: "initPosy") as? CGFloat,
           let initPosz = coder.decodeObject(forKey: "initPosz") as? CGFloat,
           let finalPosx = coder.decodeObject(forKey: "finalPosx") as? CGFloat,
           let finalPosy = coder.decodeObject(forKey: "finalPosy") as? CGFloat,
           let finalPosz = coder.decodeObject(forKey: "finalPosz") as? CGFloat,
           let version = coder.decodeObject(forKey: "version") as? String{
            self.nameOfItemAnchor = nameOfItemAnchor
            self.nickA = nickA
            self.nickB = nickB
            self.classObj = classObj
            self.refName = refName
            self.width = width
            self.color = color
            self.length = length
            self.initPos = SCNVector3(initPosx, initPosy, initPosz)
            self.finalPos = SCNVector3(finalPosx, finalPosy, finalPosz)
            self.version = version
        } else {
            return nil
        }
        super.init(coder: coder)
    }
    override func encode(with coder: NSCoder) {
        super.encode(with: coder)
        coder.encode(self.nameOfItemAnchor, forKey: "nameOfItemAnchor")
        coder.encode(self.nickA, forKey: "nickA")
        coder.encode(self.nickB, forKey: "nickB")
        coder.encode(self.classObj, forKey: "classObj")
        coder.encode(self.refName, forKey: "refName")
        coder.encode(self.width, forKey: "width")
        coder.encode(self.color, forKey: "color")
        coder.encode(self.length, forKey: "length")
        coder.encode(CGFloat(self.initPos.x), forKey: "initPosx")
        coder.encode(CGFloat(self.initPos.y), forKey: "initPosy")
        coder.encode(CGFloat(self.initPos.z), forKey: "initPosz")
        coder.encode(CGFloat(self.finalPos.x), forKey: "finalPosx")
        coder.encode(CGFloat(self.finalPos.y), forKey: "finalPosy")
        coder.encode(CGFloat(self.finalPos.z), forKey: "finalPosz")
        coder.encode(self.version, forKey: "version")
    }
    override class var supportsSecureCoding: Bool {
        return true
    }
}
