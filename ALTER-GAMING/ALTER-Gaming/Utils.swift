//
//  Utils.swift
//  ARModelling
//
//  Created by Miso on 04/10/2020.
//

import UIKit
import ARKit

/**
 Convert a **String** structured like a Dictionary into a **NSMutableDictionary**
 
 - parameter text: String to convert into a **NSMutableDictionary**
 */
func convertStringToDictionary(text: String) -> NSMutableDictionary {
   if let data = text.data(using: .utf8) {
       do {
           let json = try JSONSerialization.jsonObject(with: data, options: .mutableContainers) as! NSMutableDictionary
           return json
       } catch {
           print("Something went wrong")
       }
   }
   return NSMutableDictionary()
}

/**
 Convert a **NSMutableDictionary** into a **String**
 
 - parameter dictionary: NSMutableDictionary that will be converted into a **String**
 */
func convertDictionaryToString(dictionary: NSMutableDictionary) -> String {
    do {
        let jsonData = try JSONSerialization.data(withJSONObject: dictionary)
        if let json = String(data: jsonData, encoding: .utf8) {
            return json
        }
    } catch {
        print("something went wrong with parsing json")
    }
    return ""
}

/**
 Convert a **String** structured like a Array into a **NSMutableArray**
 
 - parameter text: String to convert into a **NSMutableArray**
 */
func convertStringToArray(text: String) -> NSMutableArray {
   if let data = text.data(using: .utf8) {
       do {
        let json = try JSONSerialization.jsonObject(with: data, options:.mutableContainers) as! NSMutableArray
           return json
       } catch {
           print("Something went wrong")
       }
   }
   return NSMutableArray()
}

/**
 Convert a **NSMutableArray** into a **String**
 
 - parameter array: NSMutableArray that will be converted into a **String**
 */
func convertArrayToString(array: NSMutableArray) -> String {
    do {
        let jsonData = try JSONSerialization.data(withJSONObject: array)
        if let json = String(data: jsonData, encoding: .utf8) {
            return json
        }
    } catch {
        print("something went wrong with parsing json")
    }
    return ""
}
