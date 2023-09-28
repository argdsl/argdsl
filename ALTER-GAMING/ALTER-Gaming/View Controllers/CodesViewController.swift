//
//  CodesViewController.swift
//  ARModelling
//
//  Created by MISO on 5/10/21.
//

import UIKit
import ARKit
import Vision

class CodesViewController: UIViewController, ARSCNViewDelegate, ARSessionDelegate, UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return dataSource.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        cell.textLabel?.text = self.dataSource[indexPath.row]
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

    var barcodeRequests = [VNRequest]()
    var detectedDataAnchor: ARAnchor?
    var processing = false
    var qrDetected = false
    var codesName : [String] = []
    var metamodel: [NSMutableDictionary] = []
    var nameMetamodel: String = ""
    var dataSource = [String]()
    var processingTimer: Timer?
    var QRCurrentName: String = ""
    
    var addButton = UIButton()
    var closeButton = UIButton()
    
    let configuration = ARWorldTrackingConfiguration()
    let auxView = UIView()
    let tableView = UITableView()
    
    @IBOutlet weak var sceneView: ARSCNView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        for aMetamodelClass in self.metamodel {
            dataSource.append(aMetamodelClass["name"] as! String)
        }
        
        self.sceneView.debugOptions = [ARSCNDebugOptions.showFeaturePoints]
        self.configuration.planeDetection = [.horizontal, .vertical]
        self.sceneView.session.run(configuration)
        self.sceneView.delegate = self
        self.sceneView.autoenablesDefaultLighting = true
        self.sceneView.session.delegate = self
        self.startQrCodeDetection()
    }
    
    func startQrCodeDetection() {
        // Create a Barcode Detection Request
        let request = VNDetectBarcodesRequest(completionHandler: self.requestHandler)
        // Set it to recognize QR code only
        request.symbologies = [.qr, .code128, .code39]
        self.barcodeRequests = [request]
    }
    
    func session(_ session: ARSession, didUpdate frame: ARFrame) {
        DispatchQueue.global(qos: .userInitiated).async {
            do {
                if self.processing {
                  return
                }
                self.processing = true
                // Create a request handler using the captured image from the ARFrame
                let imageRequestHandler = VNImageRequestHandler(cvPixelBuffer: frame.capturedImage,
                                                                options: [:])
                // Process the request
                try imageRequestHandler.perform(self.barcodeRequests)
            } catch {

            }
        }
    }
    func requestHandler(request: VNRequest, error: Error?) {
        // Get the first result out of the results, if there are any
        if let results = request.results, let result = results.first as? VNBarcodeObservation {
            guard let payload = result.payloadStringValue else {
                self.processing = false
                return
            }
            if self.codesName.contains(payload) {
                self.processing = false
                return
            }
            DispatchQueue.main.async {
                if(!self.qrDetected) {
                    self.qrDetected = true
                    let alertcontrol = UIAlertController(title: "Note", message: "QR " + payload + " detected. Do you want to add a new object?", preferredStyle: .alert)
                    let alertaction = UIAlertAction(title: "Not now", style: .default) {
                        (action) in
                        self.processing = true
                        self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                    }
                    let editalertaction = UIAlertAction(title: "Yes", style: .default) { (action) in
                        self.QRCurrentName = payload
                        self.showTypesTable()
                    }
                    alertcontrol.addAction(editalertaction)
                    alertcontrol.addAction(alertaction)
                    self.present(alertcontrol, animated: true)
                }
            }
        } else {
            self.processing = false
        }
    }
    @objc func waitProcessing(){
        self.processing = false
        self.qrDetected = false
    }
    
    func showTypesTable() {
        self.auxView.frame = self.view.frame
        if(!self.auxView.isDescendant(of: self.view)){
            self.view.addSubview(self.auxView)
        }
        self.auxView.isHidden = false;
        self.auxView.backgroundColor = UIColor.black.withAlphaComponent(0.4)
        self.tableView.frame = CGRect(x: self.view.bounds.minX + 20, y: 200, width: self.view.bounds.width - 40, height: 300)
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        if(!self.tableView.isDescendant(of: self.view)){
            self.view.addSubview(tableView)
        }
        self.tableView.isHidden = false;
        self.addButton = UIButton(frame: CGRect(x: self.view.bounds.minX + 20, y: 150, width: 150, height: 50))
        self.addButton.setTitle("Add", for: .normal)
        self.addButton.backgroundColor = .black
        self.addButton.addTarget(self, action: #selector(self.newQRObject), for: .touchUpInside)
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
        if self.processing {
            self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
        }
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    @objc func newQRObject() {
        let cells = self.tableView.visibleCells
        var selectedRows = [String]()
        var name = ""
        for cell in cells {
            if cell.backgroundColor == UIColor.green {
                name = (cell.textLabel?.text)!
                selectedRows.append(cell.textLabel!.text!)
                cell.backgroundColor = UIColor.systemBackground
            }
        }
        let editcontrol = UIAlertController(title: "Edit", message: "Write the new name", preferredStyle: .alert)
        //action of the modal. User writes the word, table and data update
        let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
            guard let textfield = editcontrol.textFields?.first else { return }
            let text = textfield.text
            //use the content of textfield to update dataSource and tableView
            if (text != nil) {
                if(text!.count == 0){
                    self.addQR(name: "", selectedClass: name)
                } else {
                    self.addQR(name: text!, selectedClass: name)
                }
            } else {
                self.addQR(name: "", selectedClass: name)
            }
        }
        //open editable textfield
        editcontrol.addTextField()
        editcontrol.addAction(editalertaction)
        self.present(editcontrol, animated: true)
        self.addButton.isHidden = true;
        self.closeButton.isHidden = true;
        self.auxView.isHidden = true;
        self.tableView.isHidden = true
    }
    func addQR(name: String, selectedClass: String) {
        let json = ["name" : self.nameMetamodel, "code" : self.QRCurrentName, "class" : selectedClass, "nodename" : name]
        let jsonData = try? JSONSerialization.data(withJSONObject: json)
        let string = "https://alter-server.onrender.com/pushCodesInfos?json=true"
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
        self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
    }
}
