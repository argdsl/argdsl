//
//  QRDelegate.swift
//  ARModelling
//
//  Created by MISO on 03/11/2020.
//
import UIKit

class QRDelegate: NSObject, UITableViewDelegate, UITableViewDataSource {
    var dataSource = [String]()
    
    init(dataSource: [String]) {
        self.dataSource = dataSource
    }
    
    func setData(dataSource: [String]) {
        self.dataSource = dataSource
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return dataSource.count
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        cell.textLabel?.text = dataSource[indexPath.row]
        return cell
    }
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath){
        let cells = tableView.visibleCells
        for cell in cells {
            if cell.backgroundColor == UIColor.green {
                cell.backgroundColor = UIColor.systemBackground
            }
        }
        let cell = tableView.cellForRow(at: indexPath)
        cell!.selectionStyle = .none
        if cell?.backgroundColor == UIColor.green {
            cell?.backgroundColor = UIColor.systemBackground
        } else {
            cell?.backgroundColor = UIColor.green
        }
    }
    
}
