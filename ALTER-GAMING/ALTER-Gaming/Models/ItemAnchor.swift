//
//  ItemAnchor.swift
//  ARModelling
//
//  Created by Miso on 28/09/2020.
//

import UIKit
import ARKit

class ItemAnchor: ARAnchor {
    var isNotValid: Bool = false
    
    /// Identifier of the item, its value is an **UUID**  converted to a String
    let itemIdentifier: String
    var givenName: String
    /// Type of the anchor corresponds to the name of the class it is conforming in the metamodel
    let type: String
    /// Name of the current version of the representation
    var currentVersion: String
    var currentVersionInt: Int
    /// URL of the current version of the representation
    var urlOfCurrentVersion: String
    private var attributes: String
    private var references: String
    //private var arFacet: String
    private let constraints: String
    private var valueOfAttributes: String
    private var valueOfReferences: String
    private var versions: String
    /// Number of versions of the representation
    var numberOfVersions: String
    private var attributesToShow: String
    var attributesMaterials: String
    var position: SCNVector3
    var scale: SCNVector3
    var rotation: Int
    /// QR name attached to item
    var QR: String
    
    var API: String
    var auth: String
    private var param: String
    /// Previous info from the code attached. Must to be dictionary
    var previousInfo: String
    
    var beacon: String
    
    var forces: String
    
    var initForce: String
    /**
     Creates a new **ItemAnchor** object with the specified transform and the given informations.
     
     - parameter identifier: The identifier of the anchor.
     - parameter name: The name of the anchor.
     - parameter type: Corresponds to the name of the class it is conforming in the metamodel.
     - parameter currentVersion: The name of the initial version of the representation.
     - parameter urlOfCurrentVersion: The URL of the initial version of the representation.
     - parameter numberOfVersions: The number of versions available.
     - parameter versions: The list of the versions of the representation available for the anchor.
     - parameter attributes: The list of the attributes of the anchor.
     - parameter references: The list of the references of the anchor.
     - parameter constraints: The list of the constraints.
     - parameter attributesToShow: The list of attributes to show.
     - parameter attributesMaterials: The list of attributes that are materials (String of NSData of UIImage if attribute is Image).
     - parameter rotation: The rotation of the item.
     - parameter QR: QR name attached to item. If there is not QR, use ""
     - parameter previousInfo: Previous info from the code attached. Must to be dictionary. If there is not info and QR, use ""
     - parameter transform: A matrix encoding the position, orientation, and scale of the anchor relative to the world coordinate space of the AR session the anchor is placed in.
     */
    init(identifier: UUID, name: String, type: String, currentVersion: String, currentVersionInt: Int, urlOfCurrentVersion: String, numberOfVersions: String, versions: NSMutableDictionary, attributes: NSMutableArray, references: NSMutableArray, constraints: NSMutableDictionary, attributesToShow: NSMutableArray, attributesMaterials: NSMutableArray, scale: SCNVector3, rotation: Int, QR: String, API: String, auth: String, param: NSMutableDictionary, previousInfo: String, beacon: String, forces: NSMutableArray, initForce: String, transform: float4x4) {
        self.itemIdentifier = identifier.uuidString
        self.givenName = name
        self.type = type
        self.currentVersion = currentVersion
        self.currentVersionInt = currentVersionInt
        self.urlOfCurrentVersion = urlOfCurrentVersion
        self.numberOfVersions = numberOfVersions
        self.versions = convertDictionaryToString(dictionary: versions)
        self.attributes = convertArrayToString(array: attributes)
        self.references = convertArrayToString(array: references)
        //self.arFacet = convertDictionaryToString(dictionary: NSMutableDictionary())
        self.constraints = convertDictionaryToString(dictionary: constraints)
        self.valueOfAttributes = "{"
        self.previousInfo = previousInfo
        if (self.previousInfo != "") {
            self.valueOfAttributes = previousInfo
        } else {
            for attr in attributes {
                let dic = attr as! NSMutableDictionary
                self.valueOfAttributes += "\""
                self.valueOfAttributes += dic["name"] as! String
                self.valueOfAttributes += "\":\""
                self.valueOfAttributes += dic["default"] as! String
                self.valueOfAttributes += "\""
                if(attributes.index(of: attr) != attributes.count - 1) {
                    self.valueOfAttributes += ","
                }
            }
            self.valueOfAttributes += "}"
        }
        self.valueOfReferences = "{}"
        self.attributesToShow = convertArrayToString(array: attributesToShow)
        self.attributesMaterials = convertArrayToString(array: attributesMaterials)
        let orientation = SCNVector3Make(-transform.columns.2.x, -transform.columns.2.y, -transform.columns.2.z)
        self.position = SCNVector3Make(transform.columns.3.x, transform.columns.3.y, transform.columns.3.z)
        //self.position = self.position + orientation
        self.scale = scale
        self.rotation = rotation
        self.QR = QR
        self.API = API
        self.auth = auth
        self.param = convertDictionaryToString(dictionary: param)
        self.beacon = beacon
        self.forces = convertArrayToString(array: forces)
        self.initForce = initForce
        super.init(transform: transform)
    }
    
    required init(anchor: ARAnchor) {
        self.itemIdentifier = (anchor as! ItemAnchor).itemIdentifier
        self.givenName = (anchor as! ItemAnchor).givenName
        self.type = (anchor as! ItemAnchor).type
        self.currentVersion = (anchor as! ItemAnchor).currentVersion
        self.currentVersionInt = (anchor as! ItemAnchor).currentVersionInt
        self.urlOfCurrentVersion = (anchor as! ItemAnchor).urlOfCurrentVersion
        self.numberOfVersions = (anchor as! ItemAnchor).numberOfVersions
        self.versions = (anchor as! ItemAnchor).versions
        self.attributes = (anchor as! ItemAnchor).attributes
        self.references = (anchor as! ItemAnchor).references
        //self.arFacet = (anchor as! ItemAnchor).arFacet
        self.constraints = (anchor as! ItemAnchor).constraints
        self.valueOfAttributes = (anchor as! ItemAnchor).valueOfAttributes
        self.valueOfReferences = (anchor as! ItemAnchor).valueOfReferences
        self.attributesToShow = (anchor as! ItemAnchor).attributesToShow
        self.attributesMaterials = (anchor as! ItemAnchor).attributesMaterials
        self.position = (anchor as! ItemAnchor).position
        self.scale = (anchor as! ItemAnchor).scale
        self.rotation = (anchor as! ItemAnchor).rotation
        self.QR = (anchor as! ItemAnchor).QR
        self.API = (anchor as! ItemAnchor).API
        self.auth = (anchor as! ItemAnchor).auth
        self.param = (anchor as! ItemAnchor).param
        self.beacon = (anchor as! ItemAnchor).beacon
        self.previousInfo = (anchor as! ItemAnchor).previousInfo
        self.initForce = (anchor as! ItemAnchor).initForce
        self.forces = (anchor as! ItemAnchor).forces
        super.init(anchor: anchor)
    }
    
    required init?(coder: NSCoder) {
        if let itemIdentifier = coder.decodeObject(forKey: "itemIdentifier") as? String,
           let givenName = coder.decodeObject(forKey: "givenName") as? String,
           let type = coder.decodeObject(forKey: "type") as? String,
           let currentVersion = coder.decodeObject(forKey: "currentVersion") as? String,
           let currentVersionInt = coder.decodeObject(forKey: "currentVersionInt") as? String,
           let urlOfCurrentVersion = coder.decodeObject(forKey: "urlOfCurrentVersion") as? String,
           let numberOfVersions = coder.decodeObject(forKey: "numberOfVersions") as? String,
           let versions = coder.decodeObject(forKey: "versions") as? String,
           let attributes = coder.decodeObject(forKey: "attributes") as? String,
           let references = coder.decodeObject(forKey: "references") as? String,
           //let arFacet = coder.decodeObject(forKey: "arFacet") as? String,
           let constraints = coder.decodeObject(forKey: "constraints") as? String,
           let valueOfAttributes = coder.decodeObject(forKey: "valueOfAttributes") as? String,
           let valueOfReferences = coder.decodeObject(forKey: "valueOfReferences") as? String,
           let attributesToShow = coder.decodeObject(forKey: "attributesToShow") as? String,
           let attributesMaterials = coder.decodeObject(forKey: "attributesMaterials") as? String,
           let QR = coder.decodeObject(forKey: "QR") as? String,
           let API = coder.decodeObject(forKey: "API") as? String,
           let auth = coder.decodeObject(forKey: "auth") as? String,
           let param = coder.decodeObject(forKey: "param") as? String,
           let beacon = coder.decodeObject(forKey: "beacon") as? String,
           let previousInfo = coder.decodeObject(forKey: "previousInfo") as? String,
           let forces = coder.decodeObject(forKey: "forces") as? String,
           let initPosx = coder.decodeObject(forKey: "initPosx") as? CGFloat,
           let initPosy = coder.decodeObject(forKey: "initPosy") as? CGFloat,
           let initPosz = coder.decodeObject(forKey: "initPosz") as? CGFloat,
           let scalex = coder.decodeObject(forKey: "scalex") as? CGFloat,
           let scaley = coder.decodeObject(forKey: "scalex") as? CGFloat,
           let scalez = coder.decodeObject(forKey: "scalez") as? CGFloat,
           let rotation = coder.decodeObject(forKey: "rotation") as? String,
           let initForce = coder.decodeObject(forKey: "initForce") as? String{
            self.itemIdentifier = itemIdentifier
            self.givenName = givenName
            self.type = type
            self.currentVersion = currentVersion
            self.currentVersionInt = Int(currentVersionInt) ?? 1
            self.urlOfCurrentVersion = urlOfCurrentVersion
            self.numberOfVersions = numberOfVersions
            self.versions = versions
            self.attributes = attributes
            self.references = references
            //self.arFacet = arFacet
            self.constraints = constraints
            self.valueOfAttributes = valueOfAttributes
            self.valueOfReferences = valueOfReferences
            self.attributesToShow = attributesToShow
            self.attributesMaterials = attributesMaterials
            self.position = SCNVector3Make(Float(initPosx), Float(initPosy), Float(initPosz))
            self.scale = SCNVector3Make(Float(scalex), Float(scaley), Float(scalez))
            self.rotation = Int(rotation) ?? 0
            self.QR = QR
            self.API = API
            self.auth = auth
            self.param = param
            self.beacon = beacon
            self.previousInfo = previousInfo
            self.forces = forces
            self.initForce = initForce
        } else {
            return nil
        }
        super.init(coder: coder)
    }
    
    override func encode(with coder: NSCoder) {
        super.encode(with: coder)
        coder.encode(self.itemIdentifier, forKey: "itemIdentifier")
        coder.encode(self.givenName, forKey: "givenName")
        coder.encode(self.type, forKey: "type")
        coder.encode(self.currentVersion, forKey: "currentVersion")
        coder.encode(String(self.currentVersionInt), forKey: "currentVersionInt")
        coder.encode(self.urlOfCurrentVersion, forKey: "urlOfCurrentVersion")
        coder.encode(self.numberOfVersions, forKey: "numberOfVersions")
        coder.encode(self.versions, forKey: "versions")
        coder.encode(self.attributes, forKey: "attributes")
        coder.encode(self.references, forKey: "references")
        //coder.encode(self.arFacet, forKey: "arFacet")
        coder.encode(self.constraints, forKey: "constraints")
        coder.encode(self.valueOfAttributes, forKey: "valueOfAttributes")
        coder.encode(self.valueOfReferences, forKey: "valueOfReferences")
        coder.encode(self.attributesToShow, forKey: "attributesToShow")
        coder.encode(self.attributesMaterials, forKey: "attributesMaterials")
        coder.encode(CGFloat(self.position.x), forKey: "initPosx")
        coder.encode(CGFloat(self.position.y), forKey: "initPosy")
        coder.encode(CGFloat(self.position.z), forKey: "initPosz")
        coder.encode(CGFloat(self.scale.x), forKey: "scalex")
        coder.encode(CGFloat(self.scale.y), forKey: "scaley")
        coder.encode(CGFloat(self.scale.z), forKey: "scalez")
        coder.encode(String(self.rotation), forKey: "rotation")
        coder.encode(self.QR, forKey: "QR")
        coder.encode(self.API, forKey: "API")
        coder.encode(self.auth, forKey: "auth")
        coder.encode(self.param, forKey: "param")
        coder.encode(self.beacon, forKey: "beacon")
        coder.encode(self.previousInfo, forKey: "previousInfo")
        coder.encode(self.forces, forKey: "forces")
        coder.encode(self.initForce, forKey: "initForce")
    }
    
    override class var supportsSecureCoding: Bool {
        return true
    }
    
    // MARK: Accessors
    func setAttributes(value: NSMutableArray) {
        self.attributes = convertArrayToString(array: value)
    }
    
    func getAttributes() -> NSMutableArray {
        return convertStringToArray(text: self.attributes)
    }
    
    func setReferences(value: NSMutableArray) {
        self.references = convertArrayToString(array: value)
    }
    
    func getReferences() -> NSMutableArray {
        return convertStringToArray(text: self.references)
    }
    
    /*func setARFacet(value: NSMutableDictionary) {
        self.arFacet = convertDictionaryToString(dictionary: value)
    }
    
    func getARFacet() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.arFacet)
    }*/
    
    func getConstraints() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.constraints)
    }
        
    func setValueOfAttributes(value: NSMutableDictionary) {
        self.valueOfAttributes = convertDictionaryToString(dictionary: value)
    }
    
    func getValueOfAttributes() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.valueOfAttributes)
    }
    
    func setValueOfReferences(value: NSMutableDictionary) {
        self.valueOfReferences = convertDictionaryToString(dictionary: value)
    }
    
    func getValueOfReferences() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.valueOfReferences)
    }
    
    func setVersions(value: NSMutableDictionary) {
        self.versions = convertDictionaryToString(dictionary: value)
    }
    
    func getVersions() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.versions)
    }
    
    func setParam(value: NSMutableDictionary) {
        self.param = convertDictionaryToString(dictionary: value)
    }
    
    func getParam() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.param)
    }
    
    func setAttributesToShow(value: NSMutableArray) {
        self.attributesToShow = convertArrayToString(array: value)
    }
    
    func getAttributesToShow() -> NSMutableArray {
        return convertStringToArray(text: self.attributesToShow)
    }
    
}
extension SCNVector3 {
    static func + (left: SCNVector3, right: SCNVector3) -> SCNVector3 {
        return SCNVector3Make(left.x + right.x, left.y + right.y, left.z + right.z)
    }
}
