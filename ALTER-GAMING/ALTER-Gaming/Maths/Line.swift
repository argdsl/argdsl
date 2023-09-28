//
//  Line.swift
//  ARModelling
//
//  Created by MISO on 05/10/2020.
//

import Foundation
import ARKit

class Line: SCNNode {
    var pointA : SCNVector3
    var pointB : SCNVector3
    var nickA : String
    var nickB : String
    var objsClass : String
    var refName : String
    var dirVector : SCNVector3
    init(geometry: SCNGeometry,a: SCNVector3, b: SCNVector3, nickA: String,  nickB: String, objsClass: String, refName : String, dirVector: SCNVector3) {
        self.pointA = a
        self.pointB = b
        self.nickA = nickA
        self.nickB = nickB
        self.objsClass = objsClass
        self.refName = refName
        self.dirVector = dirVector
        super.init()
        self.geometry = geometry
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func setPoints(a: SCNVector3, b: SCNVector3) {
        self.pointA = a
        self.pointB = b
    }
    
    func setDirectorVector(vector: SCNVector3) {
        self.dirVector = vector
    }
    
    func calculateRotation() -> SCNVector3 {
        //XYplane
        var normal = SCNVector3(x: 0.0, y: 0.0, z: 1.0)
        var module = abs(normal.x * self.dirVector.x + normal.y * self.dirVector.y + normal.z * self.dirVector.z)
        var divider = sqrtf(normal.x * normal.x + normal.y * normal.y + normal.z * normal.z) * sqrtf(self.dirVector.x * self.dirVector.x + self.dirVector.y * self.dirVector.y + self.dirVector.z * self.dirVector.z)
        var sin = module/divider
        var eulerx = asin(sin)
        if((self.pointA.y > self.pointB.y && self.pointA.z < pointB.z) || (self.pointA.y < self.pointB.y && self.pointA.z > pointB.z)) {
            eulerx = -eulerx
        }
        //XZplane
        normal = SCNVector3(x: 0.0, y: 1.0, z: 0.0)
        module = abs(normal.x * self.dirVector.x + normal.y * self.dirVector.y + normal.z * self.dirVector.z)
        divider = sqrtf(normal.x * normal.x + normal.y * normal.y + normal.z * normal.z) * sqrtf(self.dirVector.x * self.dirVector.x + self.dirVector.y * self.dirVector.y + self.dirVector.z * self.dirVector.z)
        sin = module/divider
        var eulery = asin(sin)
        if((self.pointA.z > self.pointB.z && self.pointA.x < pointB.x) || (self.pointA.z < self.pointB.z && self.pointA.x > pointB.x)) {
            eulery = -eulery
        }
        //YZplane
        normal = SCNVector3(x: 1.0, y: 0.0, z: 0.0)
        module = abs(normal.x * self.dirVector.x + normal.y * self.dirVector.y + normal.z * self.dirVector.z)
        divider = sqrtf(normal.x * normal.x + normal.y * normal.y + normal.z * normal.z) * sqrtf(self.dirVector.x * self.dirVector.x + self.dirVector.y * self.dirVector.y + self.dirVector.z * self.dirVector.z)
        sin = module/divider
        var eulerz = -asin(sin)
        if((self.pointA.y > self.pointB.y && self.pointA.x < pointB.x) || (self.pointA.y < self.pointB.y && self.pointA.x > pointB.x)) {
            eulerz = -eulerz
        }
        return SCNVector3Make(eulerx, eulery, eulerz)
    }
}
