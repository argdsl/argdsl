//
//  Force.swift
//  ARModelling
//
//  Created by MISO on 1/6/22.
//

import Foundation
import ARKit

class Force {
    var force : SCNVector3
    var finalForce : SCNVector3
    var orientation : SCNVector3
    var orientationDefault : SCNVector3
    
    init(force : SCNVector3, orientation : SCNVector3) {
        self.force = force
        self.finalForce = SCNVector3Zero
        self.orientation = orientation
        self.orientationDefault = SCNVector3Make(0.0, 0.0, -1.0)
        calculateFinalForce()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func calculateFinalForce() {
        let alpha = acos2Vectors(u: self.orientation, v: self.orientationDefault)
        let rows = [
            simd_float3(cos(alpha), 0, sin(alpha)),
            simd_float3(0         , 1,          0),
            simd_float3(-sin(alpha),0, cos(alpha))
        ]
        let finalVector = float3x3(rows: rows) * simd_float3(x: self.force.x, y: self.force.y, z: self.force.z)
        self.finalForce.x = finalVector.x
        self.finalForce.y = finalVector.y
        self.finalForce.z = finalVector.z
    }
    
    func acos2Vectors(u : SCNVector3, v : SCNVector3) -> Float {
        let scalar = u.x * v.x + u.y * v.y + u.z * v.z
        let modules = moduleVector(v: u) * moduleVector(v: v)
        let cosaplha = scalar / modules
        return acos(cosaplha)
    }
    
    func moduleVector(v : SCNVector3) -> Float {
        let module = sqrt(pow(v.x, 2) + pow(v.y, 2) + pow(v.z, 2))
        return module
    }
}
