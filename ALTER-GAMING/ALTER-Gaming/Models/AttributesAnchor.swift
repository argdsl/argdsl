//
//  AttributesAnchor.swift
//  ARModelling
//
//  Created by Miso on 30/09/2020.
//

import UIKit
import ARKit

class AttributesAnchor: ARAnchor {
    
    /// Identifier of the ItemAnchor which the AttributesAnchor is attached to.
    let idOfItemAnchor: String
    /// Name of the ItemAnchor which the AttributesAnchor is attached to.
    var nameOfItemAnchor: String
    /// List of attributes of the ItemAnchor which the AttributesAnchor is attached to.
    private var valueOfAttributes: String
    private var attributesToShow: String
    
    var codeAttached: String
    var beaconAttached: String
    /**
     Creates a new AttributesAnchor object with the specified transform and the informations relative to the ItemAnchor which it is attached to.
     
     - parameter idOfItemAnchor: The identifier of the ItemAnchor which the AttributesAnchor is attached to.
     - parameter nameOfItemAnchor: The name of the ItemAnchor which the AttributesAnchor is attached to.
     - parameter valueOfAttributes: List of values of attributes of the ItemAnchor which the AttributesAnchor is attached to.
     - parameter attributesToShow: The list of attributes to show.
     - parameter codeAttached: The barcode attached to the node
     - parameter beaconAttached: The barcode attached to the node
     - parameter transform: A matrix encoding the position, orientation, and scale of the anchor relative to the world coordinate space of the AR session the anchor is placed in.
     */
    init(idOfItemAnchor: String, nameOfItemAnchor: String, valueOfAttributes: NSMutableDictionary, attributesToShow: NSMutableArray, codeAttached: String, beaconAttached: String, transform: float4x4) {
        self.idOfItemAnchor = idOfItemAnchor
        self.nameOfItemAnchor = nameOfItemAnchor
        self.valueOfAttributes = convertDictionaryToString(dictionary: valueOfAttributes)
        self.attributesToShow = convertArrayToString(array: attributesToShow)
        self.codeAttached = codeAttached
        self.beaconAttached = beaconAttached
        super.init(transform: transform)
    }
    
    required init(anchor: ARAnchor) {
        self.idOfItemAnchor = (anchor as! AttributesAnchor).idOfItemAnchor
        self.nameOfItemAnchor = (anchor as! AttributesAnchor).nameOfItemAnchor
        self.valueOfAttributes = (anchor as! AttributesAnchor).valueOfAttributes
        self.attributesToShow = (anchor as! AttributesAnchor).attributesToShow
        self.codeAttached = (anchor as! AttributesAnchor).codeAttached
        self.beaconAttached = (anchor as! AttributesAnchor).beaconAttached
        super.init(anchor: anchor)
    }
    
    required init?(coder: NSCoder) {
        if let idOfItemAnchor = coder.decodeObject(forKey: "idOfItemAnchor") as? String,
           let nameOfItemAnchor = coder.decodeObject(forKey: "nameOfItemAnchor") as? String,
           let valueOfAttributes = coder.decodeObject(forKey: "valueOfAttributes") as? String,
           let attributesToShow = coder.decodeObject(forKey: "attributesToShow") as? String,
           let codeAttached = coder.decodeObject(forKey: "codeAttached") as? String,
           let beaconAttached = coder.decodeObject(forKey: "beaconAttached") as? String{
            self.idOfItemAnchor = idOfItemAnchor
            self.nameOfItemAnchor = nameOfItemAnchor
            self.valueOfAttributes = valueOfAttributes
            self.attributesToShow = attributesToShow
            self.codeAttached = codeAttached
            self.beaconAttached = beaconAttached
        } else {
            return nil
        }
        super.init(coder: coder)
    }
    
    override func encode(with coder: NSCoder) {
        super.encode(with: coder)
        coder.encode(self.idOfItemAnchor, forKey: "idOfItemAnchor")
        coder.encode(self.nameOfItemAnchor, forKey: "nameOfItemAnchor")
        coder.encode(self.valueOfAttributes, forKey: "valueOfAttributes")
        coder.encode(self.attributesToShow, forKey: "attributesToShow")
        coder.encode(self.codeAttached, forKey: "codeAttached")
        coder.encode(self.beaconAttached, forKey: "beaconAttached")
    }
    
    override class var supportsSecureCoding: Bool {
        return true
    }
    
    // MARK: Accessors
    func setValueOfAttributes(value: NSMutableDictionary) {
        self.valueOfAttributes = convertDictionaryToString(dictionary: value)
    }
    
    func getValueOfAttributes() -> NSMutableDictionary {
        return convertStringToDictionary(text: self.valueOfAttributes)
    }
    
    func setAttributesToShow(value: NSMutableArray) {
        self.attributesToShow = convertArrayToString(array: value)
    }
    
    func getAttributesToShow() -> NSMutableArray {
        return convertStringToArray(text: self.attributesToShow)
    }
    
}
