//
//  BeaconViewController.swift
//  ARModelling
//
//  Created by MISO on 24/9/21.
//

import UIKit

class BeaconViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.classes.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        cell.textLabel?.text = self.dataSource[indexPath.row]
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath){
        let cell = tableView.cellForRow(at: indexPath)
        cell!.selectionStyle = .none
        if cell?.backgroundColor == UIColor.green {
            cell?.backgroundColor = UIColor.systemBackground
        } else {
            cell?.backgroundColor = UIColor.green
            for c in tableView.visibleCells {
                if c != cell {
                    c.backgroundColor = UIColor.systemBackground
                }
            }
        }
    }

    var nameMetamodel : String = ""
    var classes : [String] = []
    
    let auxView = UIView()
    let tableView = UITableView()
    var dataSource : [String] = []
    var addButton = UIButton()
    var closeButton = UIButton()
    
    @IBOutlet weak var peripherialTextField: UITextField!
    @IBOutlet weak var uuidTextField: UITextField!
    @IBOutlet weak var majorTextField: UITextField!
    @IBOutlet weak var minorTextField: UITextField!
    @IBOutlet weak var classTextField: UITextField!
    @IBOutlet weak var nodenameTextField: UITextField!
    @IBOutlet weak var idTextField: UITextField!
    @IBOutlet weak var createButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    func sendAlert(message: String){
        let alertcontrol = UIAlertController(title: "Error", message: message, preferredStyle: .alert)
        let alertaction = UIAlertAction(title: "OK", style: .default)
        alertcontrol.addAction(alertaction)
        self.present(alertcontrol, animated: true)
    }
    
    @IBAction func chooseClass(_ sender: Any) {
        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)
        self.tableView.frame = CGRect(x: self.view.bounds.minX + 20, y: 200, width: self.view.bounds.width - 40, height: 300)
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.dataSource = []
        for item in self.classes {
            self.dataSource.append(item)
        }
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.reloadData()
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(self.tableView)
        }
        self.tableView.isHidden = false;
        self.addButton = UIButton(frame: CGRect(x: self.view.bounds.minX + 20, y: 150, width: 150, height: 50))
        self.addButton.setTitle("Select", for: .normal)
        self.addButton.backgroundColor = .black
        self.addButton.addTarget(self, action: #selector(self.closeSelection), for: .touchUpInside)
        if(!self.addButton.isDescendant(of: auxView)){
            self.auxView.addSubview(self.addButton)
        }
        self.addButton.isHidden = false;
        self.closeButton = UIButton(frame: CGRect(x: self.view.bounds.maxX - 170, y: 150, width: 150, height: 50))
        self.closeButton.setTitle("Close", for: .normal)
        self.closeButton.backgroundColor = .black
        self.closeButton.addTarget(self, action: #selector(self.closeEdit), for: .touchUpInside)
        if(!self.closeButton.isDescendant(of: auxView)){
            self.auxView.addSubview(self.closeButton)
        }
        self.closeButton.isHidden = false
    }
    @objc func closeEdit() {
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    
    @objc func closeSelection() {
        
        let cells = self.tableView.visibleCells
        var selectedRow: String = ""
        for cell in cells {
            if cell.backgroundColor == UIColor.green {
                selectedRow = cell.textLabel!.text!
                break
            }
        }
        if selectedRow == "" {
            return
        } else {
            self.classTextField.text = selectedRow
        }
        
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    
    @IBAction func createButtonAction(_ sender: Any) {
        let range = NSRange(location: 0, length: uuidTextField.text!.utf16.count)
        let regex = try! NSRegularExpression(pattern: "[0-9A-F]{8}+-+[0-9A-F]{4}+-+[0-9A-F]{4}+-+[0-9A-F]{4}+-+[0-9A-F]{12}")
        if regex.firstMatch(in: uuidTextField.text!, options: [], range: range) == nil {
            self.sendAlert(message: "The uuid is not correct. Must be like the example 12345678-9ABC-DEF0-ABCD-123456789012. Remember to use hexadecimal numbers")
            return
        }
        var json: [String: Any]
        json = ["name" : self.nameMetamodel, "beacon" : uuidTextField.text!, "class" : classTextField.text!, "nodename" : nodenameTextField.text!, "major" : majorTextField.text!, "minor" : minorTextField.text!, "peripherial" : peripherialTextField.text!, "id" : idTextField.text!]
        let jsonData = try? JSONSerialization.data(withJSONObject: json)
        let string = "https://alter-server.onrender.com/pushBeacons?json=true"
        let url = URL(string: string)!
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.httpBody = jsonData
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.setValue("application/json", forHTTPHeaderField: "Accept")
        let task = URLSession.shared.dataTask(with: request) { data, response, error in
            guard let data = data, error == nil else {
                print(error?.localizedDescription ?? "No data")
                return
            }
            let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
            if let responseJSON = responseJSON as? [String: Any] {
                print(responseJSON)
            }
        }
        task.resume()
    }
}
