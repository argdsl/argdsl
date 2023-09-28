//
//  ItemNoSCNAnchor.swift
//  ARModelling
//
//  Created by MISO on 23/7/21.
//

import UIKit
import ARKit

class ItemNoSCNAnchor: ARAnchor {
    var isNotValid: Bool = false
    
    /// Identifier of the item, its value is an **UUID**  converted to a String
    let itemIdentifier: String
    var givenName: String
    /// Type of the anchor corresponds to the name of the class it is conforming in the metamodel
    let type: String
    
    private var attributes: String
    private var references: String
    private var valueOfAttributes: String
    private var valueOfReferences: String
    init(identifier: UUID, name: String, type: String, attributes: NSMutableArray, references: NSMutableArray, transform: float4x4) {
        self.itemIdentifier = identifier.uuidString
        self.givenName = name
        self.type = type
        self.attributes = convertArrayToString(array: attributes)
        self.references = convertArrayToString(array: references)
        self.valueOfAttributes = "{}"
        self.valueOfReferences = "{}"
        super.init(transform: transform)
    }
    
    required init(anchor: ARAnchor) {
        self.itemIdentifier = (anchor as! ItemNoSCNAnchor).itemIdentifier
        self.givenName = (anchor as! ItemNoSCNAnchor).givenName
        self.type = (anchor as! ItemNoSCNAnchor).type
        self.attributes = (anchor as! ItemNoSCNAnchor).attributes
        self.references = (anchor as! ItemNoSCNAnchor).references
        self.valueOfAttributes = (anchor as! ItemNoSCNAnchor).valueOfAttributes
        self.valueOfReferences = (anchor as! ItemNoSCNAnchor).valueOfReferences
        super.init(anchor: anchor)
    }
    
    required init?(coder: NSCoder) {
        if let itemIdentifier = coder.decodeObject(forKey: "itemIdentifier") as? String,
           let givenName = coder.decodeObject(forKey: "givenName") as? String,
           let type = coder.decodeObject(forKey: "type") as? String,
           let attributes = coder.decodeObject(forKey: "attributes") as? String,
           let references = coder.decodeObject(forKey: "references") as? String,
           let valueOfAttributes = coder.decodeObject(forKey: "valueOfAttributes") as? String,
           let valueOfReferences = coder.decodeObject(forKey: "valueOfReferences") as? String {
            self.itemIdentifier = itemIdentifier
            self.givenName = givenName
            self.type = type
            self.attributes = attributes
            self.references = references
            self.valueOfAttributes = valueOfAttributes
            self.valueOfReferences = valueOfReferences
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
        coder.encode(self.attributes, forKey: "attributes")
        coder.encode(self.references, forKey: "references")
        coder.encode(self.valueOfAttributes, forKey: "valueOfAttributes")
        coder.encode(self.valueOfReferences, forKey: "valueOfReferences")
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
}
