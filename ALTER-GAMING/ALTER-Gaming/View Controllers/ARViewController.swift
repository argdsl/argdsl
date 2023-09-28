//
//  ARViewController.swift
//  ARModelling
//
//  Created by Miso on 20/09/2020.
//

import UIKit
import ARKit
import Vision
import CoreBluetooth
import CoreLocation
import CoreMotion
import AVKit
import AVFoundation
import FirebaseStorage

class ARViewController: UIViewController, ARSCNViewDelegate, UITextFieldDelegate, UITableViewDelegate, UITableViewDataSource, UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout, ARSessionDelegate, SCNPhysicsContactDelegate, CLLocationManagerDelegate, CBCentralManagerDelegate , CBPeripheralDelegate, UIImagePickerControllerDelegate, UINavigationControllerDelegate {

    // MARK: IBOutlets
    @IBOutlet weak var sceneView: ARSCNView!
    @IBOutlet weak var QRButton: UIButton!
    @IBOutlet weak var saveButton: UIButton!
    @IBOutlet weak var itemsCollectionView: UICollectionView!
    @IBOutlet weak var attributesMainStackView: UIStackView!
    @IBOutlet weak var buttonStackView: UIStackView!
    @IBOutlet weak var trashButton: UIButton!
    @IBOutlet weak var submitButton: UIButton!
    @IBOutlet weak var cancelButton: UIButton!
    @IBOutlet weak var hiddenButton: UIButton!
    @IBOutlet weak var attributesScrollView: UIScrollView!
    @IBOutlet weak var attributesContentView: UIView!
    @IBOutlet weak var attributesStackView: UIStackView!
    @IBOutlet weak var saveLabel: UILabel!
    @IBOutlet weak var snapshotThumbnail: UIImageView!
    
    @IBOutlet weak var imageTipSnapshot: UIImageView!
    @IBOutlet weak var hintButton: UIButton!
    @IBOutlet weak var attributesHeightConstraint: NSLayoutConstraint!
    @IBOutlet weak var physicButton: UIButton!
    
    //MARK: Variables
    let configuration = ARWorldTrackingConfiguration()
    let auxView = UIView()
    let tableView = UITableView()

    //Collections for database info
    var graphicalSyntax: [NSMutableDictionary] = []
    var itemsArray: [String] = []
    var noSCNItems: [String] = []
    var physicItems: [String] = []
    var bluetoothClasses: [String] = []
    var itemsCodesOnly: [String] = []
    var metamodel: [NSMutableDictionary] = []
    var accesses: [NSMutableDictionary] = []
    var codesInfo: [NSMutableDictionary] = []
    var beaconsInfo: [NSMutableDictionary] = []
    var physicsInfo: [NSMutableDictionary] = []
    var gameloopInfo: [NSMutableDictionary] = []
    
    //IMPORTANT: THIS IS FOR LOAD REFERENCES FOR EXTERNAL API'S, TO RESERVE THEM WHEN THE NODE TO REFER HASN'T CREATED YET. CAREFUL MISTAKING WITH REFERENCESJUSTADDED
    var referencesReserves: [NSMutableDictionary] = []
    var currentReferencesReservedValue: [String] = []
    
    //var for selected item from itemsCollectionView
    var selectedItem: String?
    var selectedPhysicClass: String = ""
    
    //collections of objects and reference for creating and editing
    var model: [NSMutableDictionary] = [];
    var itemAnchors: [ItemAnchor] = [];
    var linesForAnchor: [Line : ReferencesAnchor] = [:]
    var objectsBoundingBox: NSMutableDictionary = [:]
    var objectsInitialPos: NSMutableDictionary = [:]
    var objectsCurrentPos: NSMutableDictionary = [:]
    var lines: [Line] = []
    var linesEachVersion: NSMutableDictionary = [:]
    var objectsList: NSMutableDictionary = [:]
    var objectsIdName: NSMutableDictionary = [:]
    var nodeToDelete: SCNNode? = nil
    var modelObjectEdited: NSMutableDictionary = [:]
    var noSCNList: [String] = []
    
    //vars for moving objects
    var panZinit = CGFloat()
    var panLocation = SCNVector3()
    var panBegin = CGPoint()
    var panCurrent = CGPoint()
    var nodeToPan : SCNNode?
    var tiltMotion : CMMotionManager = CMMotionManager()
    
    //tables delegate
    var referencesDelegate: RelationsDelegate?
    var QRDelegate: ALTER_Gaming.QRDelegate?
    var editDelegate: EditDelegate?
    
    //tables variables
    var dataSource = [String]()
    var currentTextField = UITextField()
    var addButton = UIButton()
    var closeButton = UIButton()
    
    //IMPORTANT: THIS IS NOT LIKE REFERENCES RESERVES, THIS IS FOR THE REFERENCES CREATED IN ATTRIBUTES VIEW, TO CONTROL CANCEL CASE
    var referencesJustAdded: [String] = []
    var hasUpdateReference: Bool = false
    
    var finalText: String?
    var timer: Timer?
    var nodesCount: Int = 0

    var nameMetamodel : String = ""
    var needToLoad : Bool = false
    var modelToLoad : String = ""
    var cache = NSCache<NSString, SCNScene>()
    var canSegue : Bool = false
    var menuAlertPressed : Bool = false
    var hasChanges : Bool = false
    var codesOnly : Bool = false
    var external : Bool = false
    var bluetooth : Bool = false
    var firebase : Bool = false
    var gameLoad : Bool = false
    var processingGame : Bool = false
    var gameOver : Bool = true
    var currentScales : NSMutableDictionary = [:]
    //Beacons
    var beaconInmediate : Bool = false
    var processingBeacon : Bool = false
    var itemsBeacons : NSMutableDictionary = [:]
    var itemsMinor : NSMutableDictionary = [:]
    var itemsMajor : NSMutableDictionary = [:]
    var currentUUID : String = ""
    var currentMinor : Int = 0
    var currentMajor : Int = 0
    var BluetoothDevices : [UUID] = []
    var externalParams: NSMutableDictionary = [:]
    // for load external
    var ExternalDelegate: ALTER_Gaming.ExternalDelegate?
    var currentTap: CGPoint?
    var currentNodeName: String?
    var currentSceneView: ARSCNView?
    var currentParam: String?
    var canLoadExternal: Bool = false

    // Bluetooth
    var locationManager : CLLocationManager = CLLocationManager()
    var centralManager: CBCentralManager?
    
    //Gallery
    let imagePickerController = UIImagePickerController()
    
    //Gameloop
    var currentGame: String = ""
    var score: Double = 0
    
    // Gives the document directory path for writing and reading the world map data
    var worldMapURL: URL = {
        do {
            return try FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true)
                .appendingPathComponent("worldMapURL")
        } catch {
            fatalError("Error getting world map URL from document directory.")
        }
    }()

    //MARK: -Barcode
    //https://stackoverflow.com/questions/45090716/arkit-how-to-put-3d-object-on-qrcode
    var barcodeRequests = [VNRequest]()
    var detectedDataAnchor: ARAnchor?
    var processing = false
    var qrDetected = false
    var hitTestQR: ARHitTestResult? = nil
    var rayCastQR: ARRaycastResult? = nil
    var QRCurrentName: String = ""
    var orientationFrameCamera: simd_float3? = nil
    var transformFrameCamera: simd_float4x4? = nil
    /// ItemName -> key , QR name -> value
    var ItemsQR: NSMutableDictionary = [:]
    var QRIgnored: NSMutableArray = []
    var processingTimer: Timer?
    
    func startQrCodeDetection() {
        // Create a Barcode Detection Request
        let request = VNDetectBarcodesRequest(completionHandler: self.requestHandler)
        // Set it to recognize QR code only
        request.symbologies = [.qr, .code128, .code39]
        self.barcodeRequests = [request]
    }
    
    func session(_ session: ARSession, didUpdate frame: ARFrame) {
        switch frame.camera.trackingState {
            case .normal:
            if self.gameloopInfo != [] && !gameLoad && !self.processingGame {
                self.processingGame = true
                let firstGame = self.gameloopInfo.first
                self.currentGame = firstGame?["name"] as! String
                gameLoad = true
            }
        case .notAvailable:
            print("not avaiable")
        case .limited(_):
            print("limited")
        }
        self.transformFrameCamera = frame.camera.transform
        if self.beaconInmediate {
            DispatchQueue.global(qos: .userInitiated).async {
                do {
                    if self.processingBeacon {
                        return
                    }
                    self.processingBeacon = true
                    let keys = self.itemsBeacons.allKeys
                    for k in keys {
                        if self.itemsBeacons.value(forKey: k as! String) as! String == self.currentUUID && self.itemsMinor.value(forKey: k as! String) as! Int == self.currentMinor && self.itemsMajor.value(forKey: k as! String) as! Int == self.currentMajor {
                            self.processingBeacon = false
                            return
                        }
                    }
                    let currentTransform = frame.camera.transform
                    print(currentTransform)
                    self.loadBeacon(transform: currentTransform)
                }
            }
        }
        if self.QRButton.currentTitleColor != UIColor.systemRed {
            DispatchQueue.global(qos: .userInitiated).async {
                do {
                    if self.processing {
                      return
                    }
                    self.processing = true
                    self.orientationFrameCamera = frame.camera.eulerAngles
                    // Create a request handler using the captured image from the ARFrame
                    let imageRequestHandler = VNImageRequestHandler(cvPixelBuffer: frame.capturedImage,
                                                                    options: [:])
                    // Process the request
                    try imageRequestHandler.perform(self.barcodeRequests)
                } catch {

                }
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
            self.QRCurrentName = payload
            
            // Get the bounding box for the bar code and find the center
            var rect = result.boundingBox
            
            // Flip coordinates
            rect = rect.applying(CGAffineTransform(scaleX: 1, y: -1))
            rect = rect.applying(CGAffineTransform(translationX: 0, y: 1))
            // Get center
            let center = CGPoint(x: rect.midX, y: rect.midY)
            
            //check if is an QR ignored or detected before
            if(!self.ItemsQR.allKeys(for: payload).isEmpty || self.QRIgnored.contains(payload)) {
                if(!self.QRIgnored.contains(payload)) {
                    self.updateQRItem(payload: payload, center: center)
                }
                
                return
            } else if !self.qrDetected {
                self.displayLabel(text: "Loading code")
            }
            
            if let raycastQuery = self.sceneView.raycastQuery(from: center, allowing: .estimatedPlane, alignment: .any) {
                let worldResult: [ARRaycastResult] = self.sceneView.session.raycast(raycastQuery)
                if worldResult.first == nil {
                    self.rayCastQR = nil
                } else {
                    let raycast: ARRaycastResult = worldResult.first!
                    self.rayCastQR = raycast
                }
                
            } else {
                print("bruh")
            }
            
            if self.rayCastQR == nil {
                if let hitTestResults = sceneView?.hitTest(center, types: [.featurePoint] ),
                    let hitTestResult = hitTestResults.first {
                    self.hitTestQR = hitTestResult
                    if hitTestResult == nil {
                        self.processing = false
                        return
                    }
                }
            }
            
            DispatchQueue.main.async {
                if(!self.qrDetected) {
                    self.qrDetected = true
                    self.dataSource = []
                    var diccode = NSMutableDictionary()
                    var dataload = false
                    var isdata = false
                    var errorCode = false
                    for aMetamodelClass in self.metamodel {
                        self.dataSource.append(aMetamodelClass["name"] as! String)
                    }
                    for info in self.codesInfo {
                        diccode = info
                        if info["name"] as! String == payload {
                            isdata = true
                            break;
                        }
                    }
                    //If no data in codesInfo, check Input
                    if (!isdata) {
                        for anAccessClass in self.accesses {
                            let APIOfSelectedItem = anAccessClass["name"] as! String
                            var string = "https://alter-databroker.onrender.com/checkInput?aname=" + APIOfSelectedItem
                            let classattr = anAccessClass["class"] as! String
                            string += "&aclass=" + classattr
                            string += "&ain=" + payload + "&json=true"
                            let url = URL(string: String(string).replacingOccurrences(of: " ", with: "+"))
                            if (url != nil) {
                                print("[Check Code] URL object exists: ", url!)
                            }
                            let session = URLSession.shared
                            let task = session.dataTask(with: url!) { (data, response, error) -> Void in
                                if error != nil {
                                    print("[Check Code] ", error!)
                                } else {
                                    if let data = data {
                                        do {
                                            let jsonResult = try JSONSerialization.jsonObject(
                                                with: data,
                                                options: JSONSerialization.ReadingOptions.mutableContainers
                                            ) as! NSMutableDictionary
                                            let code = jsonResult["code"] as! NSString
                                            if code == "200" {
                                                isdata = true
                                            } else {
                                                isdata = false
                                            }
                                            dataload = true
                                        } catch let e{
                                            print("[Check Code] ", e)
                                        }
                                    }
                                }
                            }
                            task.resume()
                            while(!dataload){}
                            if isdata {
                                diccode["name"] = payload
                                diccode["class"] = classattr
                                diccode["nodename"] = ""
                                break;
                            }
                        }
                    }
                    var classOfSelectedItem = NSMutableDictionary()
                    // retrieves the information relative to the selected item in the metamodel
                    if isdata {
                        let className = diccode["class"] as! String
                        for aMetamodelClass in self.metamodel {
                            let nameOfCurrentClass = aMetamodelClass["name"] as! String
                            if nameOfCurrentClass == className {
                                classOfSelectedItem = aMetamodelClass
                            }
                        }
                        var accessOfSelectedItem = NSMutableDictionary()
                        var trigger = false
                        for anAccessClass in self.accesses {
                            let classAccess = anAccessClass["class"] as! String
                            let method = anAccessClass["method"] as! String
                            if classAccess == className && method == "GET" {
                                accessOfSelectedItem = anAccessClass
                                let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                                trigger = classTrigger["onCreate"] as! Bool
                            }
                        }
                        let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
                        let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
                        let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                        let authOfSelectedItem = accessOfSelectedItem["auth"] as! String
                        
                        var previousInfo = ""
                        let param : NSMutableDictionary = [ "codeId" : payload ]
                        previousInfo = self.getPreviousInfoExternal(attributesOfSelectedItem: attributesOfSelectedItem, referencesOfSelectedItem: referencesOfSelectedItem, classOfSelectedItem: classOfSelectedItem, APIOfSelectedItem: APIOfSelectedItem, authOfSelectedItem: authOfSelectedItem, param: param, nodename: diccode["nodename"] as! String)
                        self.currentParam = payload
                        var hasReference = false
                        if previousInfo == "" {
                            isdata = false
                        }
                        if (isdata && trigger) {
                            let dataClass = diccode["class"] as! String
                            if classOfSelectedItem["autoID"] != nil {
                                let autoID = classOfSelectedItem["autoID"] as! Bool
                                if autoID {
                                    var name = diccode["nodename"] as! String
                                    if name == "" {
                                        var i = 0
                                        name = dataClass
                                        while(true) {
                                            if(self.objectsList.allKeys.isEmpty || self.objectsList.value(forKey: name) == nil) {
                                                break;
                                            }
                                            name = dataClass + " " + String(i)
                                            i+=1
                                        }
                                    }
                                    self.addQRElement(name: name, selectedItem: dataClass, info: previousInfo)
                                }
                            } else {
                                let alertcontrol = UIAlertController(title: "Note", message: "QR " + payload + " detected. Class is " + dataClass + ". There is data stored in this object. Do you want to add a new object with save data?", preferredStyle: .alert)
                                let alertaction = UIAlertAction(title: "Not now", style: .default) {
                                    (action) in
                                    self.processing = true
                                    self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                                }
                                alertcontrol.addAction(alertaction)
                                let ignoreaction = UIAlertAction(title: "Ignore", style: .default) { (action) in
                                    self.QRIgnored.add(payload)
                                    self.processing = true
                                    self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                                }
                                alertcontrol.addAction(ignoreaction)
                                let defaultalertaction = UIAlertAction(title: "Yes, without data", style: .default) { (action) in
                                    self.showTypesTable()
                                }
                                alertcontrol.addAction(defaultalertaction)
                                let loadalertaction = UIAlertAction(title: "Yes", style: .default) { (action) in
                                    // Search references saved that hasn't got a node name. These are the reference for this node, because they are just added before
                                    let nodename = diccode["nodename"] as! String
                                    if nodename != "" {
                                        if hasReference {
                                            for dic in self.referencesReserves {
                                                if dic.value(forKey: "nodename") == nil {
                                                    dic.setValue(diccode["nodename"] as! String, forKey: "nodename")
                                                }
                                            }
                                        }
                                        self.addQRElement(name: diccode["nodename"] as! String, selectedItem: diccode["class"] as! String, info: previousInfo)
                                    } else {
                                        let editcontrol = UIAlertController(title: "Edit", message: "Write the new name of the item", preferredStyle: .alert)
                                        //action of the modal. User writes the word, table and data update
                                        let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
                                            guard let textfield = editcontrol.textFields?.first else { return }
                                            let text = textfield.text
                                            //use the content of textfield to update dataSource and tableView
                                            if (text != nil) {
                                                if(text!.count == 0){
                                                    self.addQRElement(name: "", selectedItem: diccode["class"] as! String, info: previousInfo)
                                                } else {
                                                    self.addQRElement(name: text!, selectedItem: diccode["class"] as! String, info: previousInfo)
                                                }
                                            } else {
                                                self.addQRElement(name: "", selectedItem: diccode["class"] as! String, info: previousInfo)
                                            }
                                        }
                                        //open editable textfield
                                        editcontrol.addTextField()
                                        editcontrol.addAction(editalertaction)
                                        self.present(editcontrol, animated: true)
                                    }
                                    
                                }
                                alertcontrol.addAction(loadalertaction)
                                self.present(alertcontrol, animated: true)
                            }
                            
                        }
                    }  else {
                        for name in self.dataSource {
                            if(payload.lowercased().contains(name)) {
                                let editcontrol = UIAlertController(title: "Edit", message: "QR " + payload + " detected. Class is " + name + ". Write the new name", preferredStyle: .alert)
                                //action of the modal. User writes the word, table and data update
                                let editalertaction = UIAlertAction(title: "Done", style: .default) { (action) in
                                    guard let textfield = editcontrol.textFields?.first else { return }
                                    let text = textfield.text
                                    //use the content of textfield to update dataSource and tableView
                                    if (text != nil) {
                                        if(text!.count == 0){
                                            self.addQRElement(name: "", selectedItem: name, info: "")
                                        } else {
                                            self.addQRElement(name: text!, selectedItem: name, info: "")
                                        }
                                    } else {
                                        self.addQRElement(name: "", selectedItem: name, info: "")
                                    }
                                }
                                //open editable textfield
                                editcontrol.addTextField()
                                editcontrol.addAction(editalertaction)
                                self.present(editcontrol, animated: true)
                                break;
                            }
                        }
                        let alertcontrol = UIAlertController(title: "Note", message: "QR " + payload + " detected. Do you want to add a new object?", preferredStyle: .alert)
                        let alertaction = UIAlertAction(title: "Not now", style: .default) {
                            (action) in
                            self.processing = true
                            self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                        }
                        alertcontrol.addAction(alertaction)
                        let ignoreaction = UIAlertAction(title: "Ignore", style: .default) { (action) in
                            self.QRIgnored.add(payload)
                            self.processing = true
                            self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
                        }
                        alertcontrol.addAction(ignoreaction)
                        let editalertaction = UIAlertAction(title: "Yes", style: .default) { (action) in
                            self.showTypesTable()
                        }
                        alertcontrol.addAction(editalertaction)
                        self.present(alertcontrol, animated: true)
                    }
                    
                }
                self.processing = false
            }
        } else {
            self.processing = false
        }
    }
        
    @objc func waitProcessing(){
        self.processing = false
        self.qrDetected = false
    }
    
    func updateQRItem(payload: String, center: CGPoint) {
        let childs = self.sceneView.scene.rootNode.childNodes
        for node in childs {
            let anchor = self.sceneView.anchor(for: node)
            if (anchor != nil) {
                if(anchor!.isKind(of: ItemAnchor.self)) {
                    if let anItemAnchor = anchor as? ItemAnchor {
                        if anItemAnchor.QR == payload {
                            if let raycastQuery = self.sceneView.raycastQuery(from: center, allowing: .estimatedPlane, alignment: .any) {
                                let worldResult: [ARRaycastResult] = self.sceneView.session.raycast(raycastQuery)
                                guard let raycast: ARRaycastResult = worldResult.first
                                else {
                                    
                                    return
                                }
                                let transform = raycast.worldTransform
                                let thirdColumn = transform.columns.3
                                anItemAnchor.position = SCNVector3(x: thirdColumn.x, y: thirdColumn.y, z: thirdColumn.z)
                            } else {
                                print("bruh")
                            }
                            break
                        }
                    }
                }
            }
        }
        self.processingTimer = Timer.scheduledTimer(timeInterval: 10, target:self, selector:#selector(self.waitProcessing), userInfo: nil, repeats: false)
    }
    
    // MARK: Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()

        // ARKit scene view initialization
        self.sceneView.debugOptions = [ARSCNDebugOptions.showFeaturePoints]
        self.configuration.planeDetection = [.horizontal, .vertical]
        self.sceneView.session.run(configuration)
        self.sceneView.delegate = self
        self.sceneView.autoenablesDefaultLighting = true
        self.sceneView.session.delegate = self

        // Layout
        self.itemsCollectionView.isHidden = self.itemsArray.isEmpty && self.noSCNItems.isEmpty
        self.attributesMainStackView.isHidden = true
        self.buttonStackView.isHidden = true
        self.trashButton.isHidden = true
        self.submitButton.isHidden = true
        self.cancelButton.isHidden = true
        self.attributesScrollView.isHidden = true
        self.attributesContentView.isHidden = true
        self.attributesStackView.isHidden = true
        self.snapshotThumbnail.isHidden = true
        self.imageTipSnapshot.isHidden = true
        self.hintButton.isHidden = true
        self.physicButton.isHidden = true
        
        if(!self.physicsInfo.isEmpty) {
            self.physicButton.isHidden = false
            if(!self.gameloopInfo.isEmpty){
                self.physicButton.setTitle("Start", for: .normal)
            }
        }
        if(self.needToLoad) {
            self.hintButton.isHidden = false
            self.snapshotThumbnail.isHidden = false
            self.loadModel()
            self.snapshotThumbnail.isHidden = true
            /*guard let worldMapData = retrieveWorldMapData(),
                  let worldMap = unarchive(worldMapData: worldMapData) else { return }
            resetTrackingConfiguration(with: worldMap)*/
        }

        // items collection view
        self.itemsCollectionView.dataSource = self
        self.itemsCollectionView.delegate = self

        // Gesture recognizers
        self.registerGestureRecognizers()

        self.referencesDelegate = RelationsDelegate(dataSource: self.dataSource)
        self.editDelegate = EditDelegate(dataSource: self.dataSource)
        self.QRDelegate = ALTER_Gaming.QRDelegate(dataSource: self.dataSource)
        self.sceneView.scene.physicsWorld.contactDelegate = self
        self.startQrCodeDetection()
        
        //Bluetooth
        self.locationManager.requestAlwaysAuthorization()
        self.locationManager.delegate = self
        self.centralManager = CBCentralManager(delegate: self, queue: .main)
        
        //Time trigger
        timer = nil
        
        //Gallery
        self.imagePickerController.delegate = self
        self.imagePickerController.sourceType = .photoLibrary
        self.imagePickerController.mediaTypes = ["public.image", "public.movie"]

        
        //Delete temp files
        var documentsUrl: URL {
            return FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first!
        }
        let fileManager = FileManager.default
        var imagesFolderPath = NSTemporaryDirectory()
        imagesFolderPath = imagesFolderPath.replacingOccurrences(of: "tmp", with: "Documents")
        do {
            let imagesPaths = try fileManager.contentsOfDirectory(atPath: imagesFolderPath)
            for img in imagesPaths {
                try fileManager.removeItem(atPath: imagesFolderPath + img)
            }
        } catch {
            print("Could not clear temp folder: \(error)")
        }
        
        //trying collision
        /*
        let pos = SCNVector3(0,8,-0.25)
        let box = SCNNode(geometry: SCNBox(width: 0.1, height: 0.1, length: 0.1, chamferRadius: 0.1))
        box.position = pos
        let body = SCNPhysicsBody(type: .dynamic, shape: SCNPhysicsShape(geometry: SCNBox(width: 0.1, height: 0.1, length: 0.1, chamferRadius: 0.1), options: nil))
        box.physicsBody = body
        box.physicsBody?.categoryBitMask = 2
        box.physicsBody?.collisionBitMask = 5
        box.physicsBody?.contactTestBitMask = 5
        
        box.name = "Box"
        
        self.sceneView.scene.rootNode.addChildNode(box)
        
        let pos2 = SCNVector3(0.3,0,-0.25)
        let sphere = SCNNode(geometry: SCNSphere(radius: 0.1))
        sphere.position = pos2
        let body2 = SCNPhysicsBody(type: .kinematic, shape: SCNPhysicsShape(geometry: SCNSphere(radius: 0.1), options: nil))
        sphere.physicsBody = body2
        sphere.physicsBody?.categoryBitMask = 1
        sphere.physicsBody?.collisionBitMask = 2
        sphere.physicsBody?.contactTestBitMask = 2
        
        sphere.name = "Sphere"
        
        self.sceneView.scene.rootNode.addChildNode(sphere)
        
        let pos3 = SCNVector3(0,-0.3,-0.25)
        let plane = SCNNode(geometry: SCNBox(width: 0.4, height: 0.1, length: 0.4, chamferRadius: 0))
        plane.position = pos3
        let body3 = SCNPhysicsBody(type: .static, shape: SCNPhysicsShape(geometry: SCNBox(width: 0.4, height: 0.1, length: 0.4, chamferRadius: 0), options: nil))
        plane.physicsBody = body3
        plane.physicsBody?.categoryBitMask = 4
        plane.physicsBody?.collisionBitMask = 2
        plane.physicsBody?.contactTestBitMask = 2
        
        plane.name = "Plane"
        
        self.sceneView.scene.rootNode.addChildNode(plane)*/
    }
    
    override func viewDidAppear(_ animated: Bool) {
        if !itemsCodesOnly.isEmpty {
            var message = ""
            for item in itemsCodesOnly {
                message += item
                if itemsCodesOnly.last != item {
                    message += ", "
                }
            }
            message += " are classes that you can only add by QR or Barcode detection. You can do this activating the QR button and pointing the code to the center"
            let alertcontrol = UIAlertController(title: "Note", message: message, preferredStyle: .alert)
            let alertaction = UIAlertAction(title: "OK", style: .default)
            alertcontrol.addAction(alertaction)
            self.present(alertcontrol, animated: true)
        }
    }
    
    // MARK: Func
    
    @objc func timeWaiting(){
        let screenRect = UIScreen.main.bounds
        let screenWidth = screenRect.size.width
        let screenHeight = screenRect.size.height
        
        let detectedNodes = NSMutableArray()
        
        let seccWidth = screenWidth/100
        let seccHeight = screenHeight/100
        for i in 1...100 {
            for j in 1...100 {
                let point = CGPoint(x:seccWidth*CGFloat(i),y:seccHeight*CGFloat(j))
                let sceneResult: [SCNHitTestResult] = sceneView.hitTest(point,
                                                                        options: [SCNHitTestOption.firstFoundOnly: true])
                if sceneResult.first != nil {
                    let rayCast: SCNHitTestResult = sceneResult.first!
                    // Change a graphical model by other to update data
                    let oldNode = rayCast.node
                    if (oldNode.name != nil) {

                        let oldNodeName = oldNode.name!

                        // Check if the result's node is in the view
                        if self.sceneView.scene.rootNode.childNodes.contains(oldNode) {
                            // Search for the result's object
                            var itemDic: NSMutableDictionary = [:]
                            var itemFound = false
                            for eachItemDic in self.model {

                                
                                let eachNameOfItemInModel = eachItemDic["name"] as! String
                                if eachNameOfItemInModel == oldNode.name {
                                    itemDic = eachItemDic
                                    itemFound = true
                                }
                            }
                            if (itemFound && !detectedNodes.contains(oldNode)) {
                                detectedNodes.add(oldNode)
                                let selectedItem = itemDic["class"] as! String
                                let itemName = itemDic["name"] as! String
                                
                                var classOfSelectedItem = NSMutableDictionary()
                                // retrieves the information relative to the selected item in the metamodel
                                for aMetamodelClass in self.metamodel {
                                    let nameOfCurrentClass = aMetamodelClass["name"] as! String
                                    if nameOfCurrentClass == selectedItem {
                                        classOfSelectedItem = aMetamodelClass
                                    }
                                }
                                let anchor = self.sceneView.anchor(for: oldNode) as! ItemAnchor
                                
                                let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
                                let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
                                
                                var accessOfSelectedItem = NSMutableDictionary()
                                
                                for anAccessClass in self.accesses {
                                    let classAccess = anAccessClass["class"] as! String
                                    if classAccess == selectedItem {
                                        let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                                        let trigger = classTrigger["timeTrigger"] as! Double
                                        if(trigger != 0) {
                                            accessOfSelectedItem = anAccessClass
                                        }
                                    }
                                }
                                var previousInfo = ""
                                let APIOfSelectedItem = accessOfSelectedItem["name"] as? String ?? ""
                                let authOfSelectedItem = accessOfSelectedItem["auth"] as? String ?? ""
                                if (APIOfSelectedItem != "") {
                                    previousInfo = self.getPreviousInfoExternal(attributesOfSelectedItem: attributesOfSelectedItem, referencesOfSelectedItem: referencesOfSelectedItem, classOfSelectedItem: classOfSelectedItem, APIOfSelectedItem: APIOfSelectedItem, authOfSelectedItem: authOfSelectedItem, param: anchor.getParam(), nodename: anchor.givenName)
                                    anchor.setValueOfAttributes(value: convertStringToDictionary(text: previousInfo))
                                    let itemAnchorBuffer = ItemAnchor(identifier: anchor.identifier, name: anchor.givenName, type: anchor.type, currentVersion: anchor.currentVersion, currentVersionInt: anchor.currentVersionInt, urlOfCurrentVersion: anchor.urlOfCurrentVersion, numberOfVersions: anchor.numberOfVersions, versions: anchor.getVersions(), attributes: anchor.getAttributes(), references: anchor.getReferences(), constraints: anchor.getConstraints(), attributesToShow: anchor.getAttributesToShow(), attributesMaterials: convertStringToArray(text: anchor.attributesMaterials), scale: anchor.scale, rotation: anchor.rotation, QR: anchor.QR, API: anchor.API, auth: anchor.auth, param: anchor.getParam(), previousInfo: previousInfo, beacon: "", forces: convertStringToArray(text: anchor.forces), initForce: anchor.initForce, transform: anchor.transform)
                                    itemAnchorBuffer.setValueOfAttributes(value: anchor.getValueOfAttributes())
                                    itemAnchorBuffer.setValueOfReferences(value: anchor.getValueOfReferences())
                                    itemAnchorBuffer.scale = anchor.scale
                                    
                                    //to avoid jump to case loading model
                                    self.needToLoad = false
                                    
                                    self.sceneView.session.remove(anchor: anchor)
                                    if self.itemAnchors.lastIndex(of: anchor) != nil {
                                        self.itemAnchors.remove(at: self.itemAnchors.lastIndex(of: anchor)!)
                                    }
                                    
                                    self.sceneView.session.add(anchor: itemAnchorBuffer)
                                    self.itemAnchors.append(itemAnchorBuffer)
                                    
                                    for child in oldNode.childNodes {
                                        let attrAnchor = self.sceneView.anchor(for: child)
                                        if attrAnchor!.isKind(of: AttributesAnchor.self) {
                                            if let anAttributesAnchor = attrAnchor as? AttributesAnchor {
                                                if anAttributesAnchor.idOfItemAnchor == itemName  {
                                                    let attributesAnchorBuffer = AttributesAnchor(idOfItemAnchor: anchor.itemIdentifier, nameOfItemAnchor: anchor.givenName, valueOfAttributes: anchor.getValueOfAttributes(), attributesToShow: anchor.getAttributesToShow(), codeAttached: anAttributesAnchor.codeAttached, beaconAttached: anAttributesAnchor.beaconAttached, transform: anchor.transform)
                                                    self.sceneView.session.remove(anchor: anAttributesAnchor)
                                                    self.sceneView.session.add(anchor: attributesAnchorBuffer)
                                                    break
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                
                

                
            }
        }
        
    }
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        if self.physicButton.currentTitleColor == .green {
            return self.physicItems.count
        }
        return self.itemsArray.count + self.noSCNItems.count
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "item", for: indexPath) as! ItemCell
        if self.physicButton.currentTitleColor == .green {
            cell.itemLabel.text = self.physicItems[indexPath.row]
            cell.backgroundColor = UIColor.orange
        } else {
            if indexPath.row >= self.itemsArray.count {
                cell.itemLabel.text = self.noSCNItems[indexPath.row - self.itemsArray.count]
                cell.backgroundColor = UIColor.blue
            } else {
                cell.itemLabel.text = self.itemsArray[indexPath.row]
                cell.backgroundColor = UIColor.orange
            }
        }
        
        return cell
    }

    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        let cell = collectionView.cellForItem(at: indexPath)
        if self.physicButton.currentTitleColor == .green {
            self.selectedItem = self.physicItems[indexPath.row]
            if self.physicItems[indexPath.row] == "push" {
                tiltMotion.stopDeviceMotionUpdates()
                self.displayLabel(text: "touch the object")
            } else if self.physicItems[indexPath.row] == "drag" {
                tiltMotion.stopDeviceMotionUpdates()
                self.displayLabel(text: "select the object and draw a line")
            } else if self.physicItems[indexPath.row] == "tilt" {
                self.displayLabel(text: "select the object and tilt the device")
            }
            cell?.backgroundColor = UIColor.green
        } else {
            if indexPath.row >= self.itemsArray.count {
                self.selectedItem = self.noSCNItems[indexPath.row - self.itemsArray.count]
                cell?.backgroundColor = UIColor.yellow
            } else {
                self.selectedItem = self.itemsArray[indexPath.row]
                cell?.backgroundColor = UIColor.green
            }
        }
    }

    func collectionView(_ collectionView: UICollectionView, didDeselectItemAt indexPath: IndexPath) {
        let cell = collectionView.cellForItem(at: indexPath)
        if cell?.backgroundColor == UIColor.yellow {
            cell?.backgroundColor = UIColor.blue
        } else {
            cell?.backgroundColor = UIColor.orange
        }
    }

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        if self.physicButton.currentTitleColor == .green {
            let dif = self.physicItems[indexPath.row].count - 6
            var width = CGFloat(50.0)
            let height = CGFloat(50.0)
            if (self.physicItems[indexPath.row].count > 6) {
                width += CGFloat(dif) * 13.0
            }
            return CGSize(width: width, height: height)
        } else {
            if indexPath.row >= self.itemsArray.count {
                let dif = self.noSCNItems[indexPath.row - self.itemsArray.count].count - 6
                var width = CGFloat(50.0)
                let height = CGFloat(50.0)
                if (self.noSCNItems[indexPath.row - self.itemsArray.count].count > 6) {
                    width += CGFloat(dif) * 13.0
                }
                return CGSize(width: width, height: height)
            } else {
                let dif = self.itemsArray[indexPath.row].count - 6
                var width = CGFloat(50.0)
                let height = CGFloat(50.0)
                if (self.itemsArray[indexPath.row].count > 6) {
                    width += CGFloat(dif) * 13.0
                }
                return CGSize(width: width, height: height)
            }
        }
    }
    // MARK: IBActions
    
    @IBAction func handleHintButton(_ sender: Any) {
        if self.hintButton.currentTitleColor == UIColor.systemRed {
            self.hintButton.setTitleColor(UIColor.green, for: .normal)
            self.imageTipSnapshot.isHidden = false
            self.imageTipSnapshot.layer.borderWidth = 2
            self.imageTipSnapshot.layer.borderColor = CGColor(red: 0, green: 256, blue: 0, alpha: 1)
        } else {
            self.hintButton.setTitleColor(UIColor.systemRed, for: .normal)
            self.imageTipSnapshot.isHidden = true
        }
    }
    @IBAction func handleEditButton(_ sender: Any) {
        if self.objectsList.allKeys.isEmpty {
            let editcontrol = UIAlertController(title: "Edit", message: "There is no objects. Create one", preferredStyle: .alert)
            //action of the modal.
            let alertaction = UIAlertAction(title: "OK", style: .cancel)
            editcontrol.addAction(alertaction)
            self.present(editcontrol, animated: true)
        } else {
            self.addEditTable()
        }
    }
    
    @IBAction func handleQRButton(_ sender: Any) {
        if self.QRButton.currentTitleColor == UIColor.systemRed {
            self.QRButton.setTitleColor(UIColor.green, for: .normal)
        } else {
            self.QRButton.setTitleColor(UIColor.systemRed, for: .normal)
        }
    }
    @IBAction func handlePhysicButton(_ sender: Any) {
        if self.physicButton.currentTitleColor == UIColor.systemRed {
            self.physicButton.setTitleColor(UIColor.green, for: .normal)
        } else {
            self.physicButton.setTitleColor(UIColor.systemRed, for: .normal)
        }
        if self.physicButton.currentTitle == "Start" {
            for game in self.gameloopInfo {
                let gameName = game["name"] as! String
                if self.currentGame != "" && self.currentGame == gameName {
                    self.gameOver = false
                    let gameScore = game["scoreSystem"] as! NSMutableDictionary
                    self.score = gameScore["start"] as! Double
                    let gamePad = game["gamePad"] as! NSMutableArray
                    let objInit = game["objInit"] as! NSMutableArray
                    for obj in objInit {
                        let gameobj = obj as! NSMutableDictionary
                        let objClass = gameobj["class"] as! String
                        if objClass == "player" {
                            print("A")
                        }
                        var objX = 0.0
                        var objY = 0.0
                        var objZ = 0.0
                        var transform = simd_float4x4(
                            SIMD4<Float>(1, 0, 0, 0),
                            SIMD4<Float>(0, 1, 0, 0),
                            SIMD4<Float>(0, 0, 1, 0),
                            SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1)
                        )
                        let objName = gameobj["name"] as! String
                        objX = gameobj["posX"] as! Double
                        objY = gameobj["posY"] as! Double
                        objZ = gameobj["posZ"] as! Double
                        if objX == 999 {
                            transform = self.transformFrameCamera ?? simd_float4x4(
                                SIMD4<Float>(1, 0, 0, 0),
                                SIMD4<Float>(0, 1, 0, 0),
                                SIMD4<Float>(0, 0, 1, 0),
                                SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1))
                            
                        } else {
                            transform = simd_float4x4(
                                SIMD4<Float>(1, 0, 0, 0),
                                SIMD4<Float>(0, 1, 0, 0),
                                SIMD4<Float>(0, 0, 1, 0),
                                SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1))
                        }
                        
                        
                        var rotation = 0
                        if gameobj["rotation"] != nil {
                            rotation = gameobj["rotation"] as! Int
                        }
                        var attributes : NSMutableArray = []
                        if gameobj["attributes"] != nil {
                            attributes = gameobj["attributes"] as! NSMutableArray
                        }
                        
                        transform = simd_float4x4(
                            SIMD4<Float>(1, 0, 0, 0),
                            SIMD4<Float>(0, 1, 0, 0),
                            SIMD4<Float>(0, 0, 1, 0),
                            SIMD4<Float>(Float(objX), Float(objY), Float(objZ), 1)
                        )
                        self.createNode(objName: objName, objClass: objClass, transform: transform, force: "", attributes: attributes, rotation: rotation, scaling: 1.0)
                    }
                    for pad in gamePad {
                        let padEl = pad as! NSMutableDictionary
                        let name = padEl["name"] as! String
                        let trigger = padEl["trigger"] as! String
                        let center = self.view.center
                        var rect = CGRect(x: center.x - 100, y: center.y, width: 200, height: 40)
                        if name == "up" || name == "UP" {
                            rect = CGRect(x: center.x - 100, y: center.y - 100, width: 200, height: 40)
                        } else if name == "down" || name == "DOWN" {
                            rect = CGRect(x: center.x - 100, y: center.y + 100, width: 200, height: 40)
                        } else if name == "right" || name == "RIGHT" {
                            rect = CGRect(x: center.x + 100, y: center.y, width: 200, height: 40)
                        } else if name == "left" || name == "LEFT" {
                            rect = CGRect(x: center.x - 300, y: center.y, width: 200, height: 40)
                        }
                        
                        let action = UIAction(title: name) { (act) in
                            self.doAction(actionName: trigger)
                        }
                        let button = UIButton(frame: rect, primaryAction: action)
                        button.setTitle(name, for: .normal)
                        button.backgroundColor = .black
                        self.view.addSubview(button)
                        button.isHidden = false
                    }
                }
            }
            self.doAction(actionName: "start")
        }
        self.itemsCollectionView.reloadData()
    }
    @IBAction func handleTrashButton(_ sender: Any) {

        // Hide the edit interface
        self.itemsCollectionView.isHidden = self.itemsArray.isEmpty
        self.attributesMainStackView.isHidden = true
        self.buttonStackView.isHidden = true
        self.trashButton.isHidden = true
        self.submitButton.isHidden = true
        self.cancelButton.isHidden = true
        self.attributesScrollView.isHidden = true
        self.attributesContentView.isHidden = true
        self.attributesStackView.isHidden = true
        self.hasUpdateReference = false
        self.referencesJustAdded = []
        
        let nick = self.objectsIdName.value(forKey: nodeToDelete!.name!) as! String
        
        for child in self.sceneView.scene.rootNode.childNodes {
            let anAnchor = self.sceneView.anchor(for: child)
            if anAnchor != nil {
                if (anAnchor!.isKind(of: ItemAnchor.self)) {
                    if let anItemAnchor = anAnchor as? ItemAnchor {
                        if anItemAnchor.itemIdentifier == self.nodeToDelete?.name! {
                            var classOfSelectedItem = NSMutableDictionary()
                            // retrieves the information relative to the selected item in the metamodel
                            for aMetamodelClass in self.metamodel {
                                let nameOfCurrentClass = aMetamodelClass["name"] as! String
                                if nameOfCurrentClass == anItemAnchor.type {
                                    classOfSelectedItem = aMetamodelClass
                                }
                            }
                            var accessOfSelectedItem = NSMutableDictionary()
                            var trigger = false
                            for anAccessClass in self.accesses {
                                let classAccess = anAccessClass["class"] as! String
                                if classAccess == anItemAnchor.type {
                                    let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                                    trigger = classTrigger["onDelete"] as! Bool
                                    if trigger {
                                        accessOfSelectedItem = anAccessClass
                                    }
                                }
                            }
                            if accessOfSelectedItem.count != 0 {
                                let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                                let authOfSelectedItem = accessOfSelectedItem["auth"] as! String
                                if trigger {
                                    let method = accessOfSelectedItem["method"] as! String
                                    if method == "DELETE" {
                                        var string = "https://alter-databroker.onrender.com/deleteUrl?aname=" + APIOfSelectedItem
                                        let classattr = classOfSelectedItem["name"] as! String
                                        string += "&aclass=" + classattr
                                        var count = 0
                                        for key in anItemAnchor.getParam().allKeys {
                                            let val = anItemAnchor.getParam()[key] as! String
                                            if count != 0 {
                                                string += "&ain" + String(count) + "="
                                            }
                                            string += val
                                            count += 1
                                        }
                                        if authOfSelectedItem != "" {
                                            string += "&eauth=" + authOfSelectedItem
                                        }
                                        string += "&json=true"
                                        let url = URL(string: string)
                                        if (url != nil) {
                                            print("[NewExtNode] URL object exists: ", url!)
                                        }
                                        let session = URLSession.shared
                                        let task = session.dataTask(with: url!) { (data, response, error) -> Void in
                                            if error != nil {
                                                print("[NewExtNode] ", error!)
                                            } else {
                                                guard let data = data, error == nil else {
                                                    print(error?.localizedDescription ?? "No data")
                                                    return
                                                }
                                                let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
                                                if let responseJSON = responseJSON as? [String: Any] {
                                                    print(responseJSON)
                                                }
                                            }
                                        }
                                        task.resume()
                                    }
                                }
                            }
                            
                            for line in self.lines {
                                if(line.nickA == nick || line.nickB == nick) {
                                    for node in self.sceneView.scene.rootNode.childNodes {
                                        if node.isKind(of: Line.self) {
                                            let anRefAnchor = self.linesForAnchor[line]!
                                            let refAnchorName = line.nickA + " " + line.nickB + "/" + line.refName + "-" + line.objsClass
                                            if self.referencesJustAdded.contains(refAnchorName) {
                                                self.referencesJustAdded.remove(at: self.referencesJustAdded.lastIndex(of: refAnchorName)!)
                                            }
                                            self.deleteLine(line: line)
                                            self.sceneView.session.remove(anchor: anRefAnchor)
                                        }
                                    }
                                    self.deleteLine(line: line)
                                }
                            }
                            self.sceneView.session.remove(anchor: anItemAnchor)
                        }
                    }
                } else if (anAnchor!.isKind(of: ItemNoSCNAnchor.self)) {
                    if let anItemAnchor = anAnchor as? ItemNoSCNAnchor {
                        if anItemAnchor.itemIdentifier == self.nodeToDelete?.name! {
                            self.sceneView.session.remove(anchor: anItemAnchor)
                        }
                    }
                }
            }
        }
        

        nodeToDelete?.removeFromParentNode()
        self.objectsInitialPos.removeObject(forKey: nodeToDelete?.name)
        self.objectsBoundingBox.removeObject(forKey: nodeToDelete?.name)
        self.objectsIdName.removeObject(forKey: nodeToDelete?.name)
        self.objectsList.removeObject(forKey: nick)

    }

    @IBAction func handleCancelAction(_ sender: Any) {
        if self.hasUpdateReference && !self.referencesJustAdded.isEmpty {
            for node in self.sceneView.scene.rootNode.childNodes {
                if node.isKind(of: Line.self) {
                    let line = node as! Line
                    let refAnchorName = line.nickA + " " + line.nickB + "/" + line.refName + "-" + line.objsClass
                    if line.nickA == self.modelObjectEdited["nick"] as! String && self.referencesJustAdded.contains(refAnchorName) {
                        self.referencesJustAdded.remove(at: self.referencesJustAdded.lastIndex(of: refAnchorName)!)
                        let anRefAnchor = self.linesForAnchor[line]!
                        self.deleteLine(line: line)
                        self.sceneView.session.remove(anchor: anRefAnchor)
                        if self.referencesJustAdded.isEmpty {
                            self.hasUpdateReference = false
                            break
                        }
                    }
                }
            }
        }
        // Hide the edit interface
        self.itemsCollectionView.isHidden = self.itemsArray.isEmpty
        self.attributesMainStackView.isHidden = true
        self.buttonStackView.isHidden = true
        self.trashButton.isHidden = true
        self.submitButton.isHidden = true
        self.cancelButton.isHidden = true
        self.attributesScrollView.isHidden = true
        self.attributesContentView.isHidden = true
        self.attributesStackView.isHidden = true
    }
    @IBAction func handleHiddenButton(_ sender: Any) {
        let childs = self.sceneView.scene.rootNode.childNodes
        for node in childs {
            let anchor = self.sceneView.anchor(for: node)
            if anchor != nil {
                if anchor!.isKind(of: ItemAnchor.self) {
                    if let anItemAnchor = anchor as? ItemAnchor {
                        if anItemAnchor.itemIdentifier == self.modelObjectEdited["name"] as! String {
                            let node = self.sceneView.node(for: anItemAnchor)
                            let child = node?.childNodes.first
                            child?.isHidden = !child!.isHidden
                            if child!.isHidden {
                                self.hiddenButton.setTitle("Show", for: .normal)
                            } else {
                                self.hiddenButton.setTitle("Hide", for: .normal)
                            }
                            break
                        }  
                    }
                }
            }
        }
    }
    @IBAction func handleSubmitButton(_ sender: Any) {
        
        //print("[Submit] \(self.modelObjectEdited["class"])")

        // Get the attributes from the model
        let itemAttributes = self.modelObjectEdited["attributes"] as! NSMutableDictionary
        let itemReferences = self.modelObjectEdited["references"] as! NSMutableDictionary
        let itemTypeAttributes = self.modelObjectEdited["typeAttributes"] as! NSMutableDictionary
        let itemMaxAttributes = self.modelObjectEdited["maxAttributes"] as! NSMutableDictionary
        let itemMinAttributes = self.modelObjectEdited["minAttributes"] as! NSMutableDictionary
        let allNames = itemAttributes.allKeys
        let allReferences = itemReferences.allKeys
        // Update the model
        let textFields = NSMutableArray()
        let textReferencesFields = NSMutableArray()
        var i = 0;
        //var j = 0;
        for eachSubview in self.attributesStackView.subviews {
            if eachSubview is UITextField && i < allNames.count {
                let name = allNames[i]
                let messagename = name as! String
                let type = itemTypeAttributes[name] as! String
                let aux = eachSubview as! UITextField
                let min = itemMinAttributes[name] as! String
                let max = itemMaxAttributes[name] as! String
                if(min != "0" && aux.text!.isEmpty){
                    self.wrongAttrAlert(message: "Attribute " + messagename + " must have at least " + min + ". Correct it")
                    return
                }
                if(max != "1"){
                    let itemList = aux.text?.split(separator: " ")
                    if(itemList!.count < Int(min)!){
                        self.wrongAttrAlert(message: "Attribute " + messagename + " must have at least " + min + ". Correct it")
                        return
                    } else if(max != "-1" && itemList!.count > Int(max)!){
                        self.wrongAttrAlert(message: "Attribute " + messagename + " must have less than " + max + ". Correct it")
                        return
                    } else if (type == "Int"){
                        for item in itemList! {
                            if(Int(item) == nil){
                                self.wrongAttrAlert(message: "Attribute " + messagename + " is integer. Correct it")
                                return
                            }
                        }
                    } else if (type == "Bool"){
                        for item in itemList! {
                            if(item != "true" && item != "false"){
                                self.wrongAttrAlert(message: "Attribute " + messagename + " must be 'true' or 'false'. Correct it")
                                return
                            }
                        }
                    }
                } else {
                    if(type == "Int"){
                        if(Int(aux.text!) == nil){
                            self.wrongAttrAlert(message: "Attribute " + messagename + " is integer. Correct it")
                            return
                        }
                    } else if (type == "Bool"){
                        if(aux.text! != "true" && aux.text! != "false"){
                            self.wrongAttrAlert(message: "Attribute " + messagename + " must be 'true' or 'false'. Correct it")
                            return
                        }
                    }

                }
                i+=1
                textFields.add(eachSubview)
            } else if eachSubview is UITextField {
                //let name = allReferences[j]
                textReferencesFields.add(eachSubview)
                //j+=1
            }
        }
        var index = 0;

        for eachElement in textFields {
            let eachTextField = eachElement as! UITextField
            itemAttributes[allNames[index]] = eachTextField.text
            index += 1;
        }
        self.modelObjectEdited["attributes"] = itemAttributes
        index = 0;

        for eachElement in textReferencesFields {
            let eachTextField = eachElement as! UITextField
            itemReferences[allReferences[index]] = eachTextField.text
            index += 1;
        }
        self.modelObjectEdited["references"] = itemReferences
        let itemReferenceTarget = self.modelObjectEdited["targetReferences"] as! NSMutableDictionary

        // Hide the edit interface
        self.itemsCollectionView.isHidden = self.itemsArray.isEmpty
        self.attributesMainStackView.isHidden = true
        self.buttonStackView.isHidden = true
        self.trashButton.isHidden = true
        self.submitButton.isHidden = true
        self.cancelButton.isHidden = true
        self.attributesScrollView.isHidden = true
        self.attributesContentView.isHidden = true
        self.attributesStackView.isHidden = true
        self.hasUpdateReference = false
        self.referencesJustAdded = []

        // Update the graphycal syntax
        // Place the attributes over the object
        let string = ""

        //Get the graph syntax to get attributes that should be shown
        var graphicalSyntaxClass = NSMutableDictionary()
        for aGraphicalSyntaxClass in self.graphicalSyntax {
            let className = aGraphicalSyntaxClass["name"] as! String
            //if className == self.selectedItem {
            if className == self.modelObjectEdited["class"] as! String {
                graphicalSyntaxClass = aGraphicalSyntaxClass
            }
        }
        

        print("[ARVC] Shown attributes: ", string)
        print("[ARVC] Model", self.model)
        //call API for POST or GET data when trigger
        let anAnchor = self.sceneView.anchor(for: self.nodeToDelete!)
        if anAnchor != nil {
            if (anAnchor!.isKind(of: ItemAnchor.self)) {
                if let anItemAnchor = anAnchor as? ItemAnchor {
                    if anItemAnchor.givenName == self.modelObjectEdited["nick"] as! String {
                        
                        var elementToRemove = Int()
                        var count = 0
                        for anElementOfModel in self.model {
                            if anElementOfModel["name"] as! String == anItemAnchor.itemIdentifier {
                                elementToRemove = count
                                
                            }
                            count+=1
                        }
                        self.model.remove(at: elementToRemove)
                        var classOfSelectedItem = NSMutableDictionary()
                        // retrieves the information relative to the selected item in the metamodel
                        for aMetamodelClass in self.metamodel {
                            let nameOfCurrentClass = aMetamodelClass["name"] as! String
                            if nameOfCurrentClass == anItemAnchor.type {
                                classOfSelectedItem = aMetamodelClass
                            }
                        }
                        var accessOfSelectedItem = NSMutableDictionary()
                        var trigger = false
                        for anAccessClass in self.accesses {
                            let classAccess = anAccessClass["class"] as! String
                            if classAccess == anItemAnchor.type {
                                let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                                trigger = classTrigger["onChange"] as! Bool
                                if trigger {
                                    accessOfSelectedItem = anAccessClass
                                    break
                                }
                            }
                        }
                        let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
                        let referencesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
                        var previousInfo = ""
                        if accessOfSelectedItem.count != 0 {
                            let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                            let authOfSelectedItem = accessOfSelectedItem["auth"] as! String
                            
                            if trigger {
                                let method = accessOfSelectedItem["method"] as! String
                                if method == "GET" {
                                    previousInfo = self.getPreviousInfoExternal(attributesOfSelectedItem: attributesOfSelectedItem, referencesOfSelectedItem: referencesOfSelectedItem, classOfSelectedItem: classOfSelectedItem, APIOfSelectedItem: APIOfSelectedItem, authOfSelectedItem: authOfSelectedItem, param: ["currentParam" : self.currentParam!], nodename: anItemAnchor.givenName)
                                }
                                else if method == "POST" {
                                    for child2 in self.sceneView.scene.rootNode.childNodes {
                                        let anAnchor2 = self.sceneView.anchor(for: child2)
                                        if anAnchor2 != nil {
                                            if (anAnchor2!.isKind(of: AttributesAnchor.self)) {
                                                if let anAttributesAnchor = anAnchor2 as? AttributesAnchor {
                                                    if (anAttributesAnchor.codeAttached != "" || anAttributesAnchor.beaconAttached != "") && anItemAnchor.givenName == anAttributesAnchor.nameOfItemAnchor {
                                                        var json: [String: Any] = [:]
                                                        if anAttributesAnchor.codeAttached != "" {
                                                            json = ["codeId" : anAttributesAnchor.codeAttached]
                                                        } else {
                                                            json = ["beaconPeripherial" : anAttributesAnchor.beaconAttached]
                                                        }
                                                        let attributesDic = anAttributesAnchor.getValueOfAttributes()
                                                        let bodyAccess = accessOfSelectedItem["body"] as! NSMutableArray
                                                        for body in bodyAccess {
                                                            let objBody = body as! NSMutableDictionary
                                                            let key = objBody["attr"] as! String
                                                            let APIBody = objBody["APIBody"] as! String
                                                            if attributesDic[key] != nil {
                                                                json.updateValue(itemAttributes[key] as! String, forKey: APIBody)
                                                            } else {
                                                                if itemReferences[key] != nil {
                                                                    if itemReferences[key] as! String == "" {
                                                                        json.updateValue("", forKey: APIBody)
                                                                    } else {
                                                                        let refAttr = self.getRefAttrKey(worldMap: nil, reference: itemReferences[key] as! String, class: itemReferenceTarget[key] as! String)
                                                                        let isArray = objBody["isArray"]
                                                                        if isArray != nil {
                                                                            let array = refAttr.components(separatedBy: ",")
                                                                            json.updateValue(array, forKey: APIBody)
                                                                            
                                                                        } else {
                                                                            json.updateValue(refAttr, forKey: APIBody)
                                                                        }
                                                                        
                                                                    }
                                                                    
                                                                }
                                                            }
                                                        }
                                                        var jsonData = try? JSONSerialization.data(withJSONObject: json)
                                                        
                                                        var string = "https://alter-databroker.onrender.com/postUrl?aname="
                                                        string += self.nameMetamodel
                                                        
                                                        string += "&aclass="
                                                        string += anItemAnchor.type + "&ain="
                                                        if anAttributesAnchor.codeAttached != "" {
                                                            string += anAttributesAnchor.codeAttached + "&json=true"
                                                        } else {
                                                            string += anAttributesAnchor.beaconAttached + "&json=true"
                                                        }
                                                        
                                                        
                                                        let url = URL(string: string)!
                                                        print(string)
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
                                                        if anItemAnchor.QR != "" {
                                                            json = ["name" : self.nameMetamodel, "code" : anAttributesAnchor.codeAttached, "class" : anItemAnchor.type, "nodename" : anItemAnchor.givenName]
                                                            jsonData = try? JSONSerialization.data(withJSONObject: json)
                                                            string = "https://alter-server.onrender.com/pushCodesInfos?json=true"
                                                            let url2 = URL(string: string)!
                                                            var request2 = URLRequest(url: url2)
                                                            request2.httpMethod = "POST"
                                                            request2.httpBody = jsonData
                                                            request2.setValue("application/json", forHTTPHeaderField: "Content-Type")
                                                            request2.setValue("application/json", forHTTPHeaderField: "Accept")
                                                            let task2 = URLSession.shared.dataTask(with: request2) { data, response, error in
                                                                guard let data = data, error == nil else {
                                                                    print(error?.localizedDescription ?? "No data")
                                                                    return
                                                                }
                                                                let responseJSON = try? JSONSerialization.jsonObject(with: data, options: [])
                                                                if let responseJSON = responseJSON as? [String: Any] {
                                                                    print(responseJSON)
                                                                }
                                                            }
                                                            task2.resume()
                                                        }
                                                        
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        anItemAnchor.setValueOfAttributes(value: self.modelObjectEdited["attributes"] as! NSMutableDictionary)
                        anItemAnchor.setValueOfReferences(value: self.modelObjectEdited["references"] as! NSMutableDictionary)
                        let itemAnchorBuffer = ItemAnchor(identifier: anItemAnchor.identifier, name: anItemAnchor.givenName, type: anItemAnchor.type, currentVersion: anItemAnchor.currentVersion, currentVersionInt: anItemAnchor.currentVersionInt, urlOfCurrentVersion: anItemAnchor.urlOfCurrentVersion, numberOfVersions: anItemAnchor.numberOfVersions, versions: anItemAnchor.getVersions(), attributes: anItemAnchor.getAttributes(), references: anItemAnchor.getReferences(), constraints: anItemAnchor.getConstraints(), attributesToShow: anItemAnchor.getAttributesToShow(), attributesMaterials: convertStringToArray(text: anItemAnchor.attributesMaterials), scale: anItemAnchor.scale, rotation: anItemAnchor.rotation, QR: anItemAnchor.QR, API: anItemAnchor.API, auth: anItemAnchor.auth, param: anItemAnchor.getParam(), previousInfo: previousInfo, beacon: anItemAnchor.beacon, forces: convertStringToArray(text: anItemAnchor.forces), initForce: anItemAnchor.initForce, transform: anItemAnchor.transform)
                        itemAnchorBuffer.setValueOfAttributes(value: anItemAnchor.getValueOfAttributes())
                        itemAnchorBuffer.setValueOfReferences(value: anItemAnchor.getValueOfReferences())
                        itemAnchorBuffer.scale = anItemAnchor.scale
                        let keys = self.objectsIdName.allKeys(for: self.modelObjectEdited["nick"] as! String)
                        let posDict = self.objectsCurrentPos[keys.first] as! NSMutableDictionary
                        let x = posDict["x"] as! Float
                        let y = posDict["y"] as! Float
                        let z = posDict["z"] as! Float
                        //to avoid jump to case loading model
                        self.needToLoad = false
                        
                        itemAnchorBuffer.position = SCNVector3Make(x, y, z)
                        self.sceneView.session.remove(anchor: anItemAnchor)
                        self.objectsIdName.removeObject(forKey: anItemAnchor.itemIdentifier)
                        self.objectsInitialPos.removeObject(forKey: anItemAnchor.itemIdentifier)
                        self.objectsCurrentPos.removeObject(forKey: anItemAnchor.itemIdentifier)
                        self.sceneView.session.add(anchor: itemAnchorBuffer)
                    }
                }
            } else if (anAnchor!.isKind(of: ItemNoSCNAnchor.self)) {
                if let anItemAnchor = anAnchor as? ItemNoSCNAnchor {
                    if anItemAnchor.givenName == self.modelObjectEdited["nick"] as! String {
                        var elementToRemove = Int()
                        var count = 0
                        for anElementOfModel in self.model {
                            if anElementOfModel["name"] as! String == anItemAnchor.itemIdentifier {
                                elementToRemove = count
                                
                            }
                            count+=1
                        }
                        self.model.remove(at: elementToRemove)
                        
                        anItemAnchor.setValueOfAttributes(value: self.modelObjectEdited["attributes"] as! NSMutableDictionary)
                        anItemAnchor.setValueOfReferences(value: self.modelObjectEdited["references"] as! NSMutableDictionary)
                        let itemAnchorBuffer = ItemNoSCNAnchor(identifier: anItemAnchor.identifier, name: anItemAnchor.givenName, type: anItemAnchor.type, attributes: anItemAnchor.getAttributes(), references: anItemAnchor.getReferences(), transform: anItemAnchor.transform)
                        itemAnchorBuffer.setValueOfAttributes(value: anItemAnchor.getValueOfAttributes())
                        itemAnchorBuffer.setValueOfReferences(value: anItemAnchor.getValueOfReferences())
                        //to avoid jump to case loading model
                        self.needToLoad = false
                        
                        self.sceneView.session.remove(anchor: anItemAnchor)
                        self.objectsIdName.removeObject(forKey: anItemAnchor.itemIdentifier)
                        self.sceneView.session.add(anchor: itemAnchorBuffer)
                    }
                }
            }
        }
        
    }

    @IBAction func handleSaveButton(_ sender: Any) {

        let alertController = UIAlertController(title: "Save",
                                                message: "Enter a name for the saved model",
                                                preferredStyle: UIAlertController.Style.alert)
        let saveAction = UIAlertAction(title: "Save", style: .default, handler: { (_) in
            let nameTextField = alertController.textFields![0]
            let name = (nameTextField.text ?? "").isEmpty ? "My Model" : nameTextField.text!
            // SAVE

            self.createDirectory(nameOfLanguage: self.nameMetamodel)

            self.saveMap(nameModel: name)
            if self.menuAlertPressed {
                self.menuAlertPressed = false
                self.performSegue(withIdentifier: "back", sender: sender)
            }
            
        })
        let cancelAction = UIAlertAction(title: "Cancel", style: .destructive, handler: { (_) in
            // CANCEL
        })
        alertController.addTextField { (textField) in
            textField.placeholder = "My Model"
        }
        alertController.addAction(saveAction)
        alertController.addAction(cancelAction)

        guard let currentFrame = sceneView.session.currentFrame else {
            return
        }
        switch currentFrame.worldMappingStatus {
        case .notAvailable, .limited:
            self.saveLabel.text = "Move your device to a more detailed environment and try again"
            self.saveLabel.isHidden = false
            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                self.saveLabel.isHidden = true
            }
            self.menuAlertPressed = false
        case .extending, .mapped:
            self.sceneView.isPlaying = false
            self.present(alertController, animated: true, completion: nil)
            self.sceneView.isPlaying = true        }

    }
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        if self.menuAlertPressed {
            self.menuAlertPressed = false
            return self.canSegue
        }
        if self.hasChanges {
            let alertController = UIAlertController(title: "Save",
                                                    message: "There are unsaved changes. Do you want to save",
                                                    preferredStyle: UIAlertController.Style.alert)
            let saveAction = UIAlertAction(title: "Yes", style: .default, handler: { (_) in
                self.canSegue = true
                self.menuAlertPressed = true
                self.handleSaveButton(sender ?? self)
            })
            let dontSaveAction = UIAlertAction(title: "No", style: .destructive, handler: { (_) in
                self.canSegue = true
                self.menuAlertPressed = true
                self.performSegue(withIdentifier: "back", sender: sender)
            })
            alertController.addAction(saveAction)
            alertController.addAction(dontSaveAction)
            self.present(alertController, animated: true, completion: nil)
            
            return self.canSegue
        }
        return true
    }
    
    //Common funcs
    
    /**
     Get information from API
     
     - parameter attributesOfSelectedItem: the list of attributes of selected type
     - parameter classOfSelectedItem: ontological information of the class selected
     - parameter APIOfSelectedItem: main URL of the API
     - parameter authOfSelectedItem: auth info if needed
     - parameter param: the param of the request
     - returns: the information in String with Dictionary form
     */
    func getPreviousInfoExternal(attributesOfSelectedItem: NSMutableArray, referencesOfSelectedItem: NSMutableArray, classOfSelectedItem: NSMutableDictionary, APIOfSelectedItem: String, authOfSelectedItem: String, param: NSMutableDictionary, nodename: String) -> String{
        var previousInfo = ""
        previousInfo = "{"
        for attr in attributesOfSelectedItem {
            let attrInfo = attr as! NSMutableDictionary
            let type = attrInfo["type"] as! String
            let isParam = attrInfo["isParam"] as! Bool
            var isLoaded = false
            var loadAttributeValue = attrInfo["default"] as! String
            if isParam {
                let name = attrInfo["name"] as! String
                let value = param[name] as! String
                
                previousInfo += "\""
                previousInfo += attrInfo["name"] as! String
                previousInfo += "\":\""
                previousInfo += value
                previousInfo += "\""
                if(attributesOfSelectedItem.index(of: attr) != attributesOfSelectedItem.count - 1) {
                    previousInfo += ","
                }
            } else {
                var string = "https://alter-databroker.onrender.com/accessUrl?aname=" + APIOfSelectedItem
                let classattr = classOfSelectedItem["name"] as! String
                string += "&aclass=" + classattr
                let attString = attrInfo["name"] as! String
                string += "&ain="
                var count = 0
                for key in param.allKeys {
                    let val = param[key] as! String
                    if count != 0 {
                        string += "&ain" + String(count).replacingOccurrences(of: " ", with: "+") + "="
                    }
                    string += val.replacingOccurrences(of: " ", with: "+")
                    count += 1
                }
                string += "&aout=" + attString
                if authOfSelectedItem != "" {
                    string += "&eauth=" + authOfSelectedItem
                }
                string += "&json=true"
                let url = URL(string: string)
                if (url != nil) {
                    print("[NewExtNode] URL object exists: ", url!)
                }
                let session = URLSession.shared
                let task = session.dataTask(with: url!) { (data, response, error) -> Void in
                    if error != nil {
                        print("[NewExtNode] ", error!)
                    } else {
                        if let data = data {
                            do {
                                let jsonResult = try JSONSerialization.jsonObject(
                                    with: data,
                                    options: JSONSerialization.ReadingOptions.mutableContainers
                                ) as! NSMutableDictionary
                                let array = jsonResult["array"] as! NSMutableDictionary
                                if(type == "String" || type == "Image") {
                                    let body = array["body"] as! NSString
                                    loadAttributeValue = body as String
                                } else {
                                    let body = String(describing: array["body"])
                                    if body.contains("Optional") {
                                        let split = body.split(separator: "(")
                                        let split2 = split[split.count - 1].split(separator: ")")
                                        let res = split2[0]
                                        if type == "Int" || type == "Double" || type == "Float" {
                                            loadAttributeValue = String(res)
                                        } else if type == "Bool" {
                                            if res == "1" {
                                                loadAttributeValue = "true"
                                            } else {
                                                loadAttributeValue = "false"
                                            }
                                        }
                                    } else {
                                        loadAttributeValue = body
                                    }
                                }
                                
                                isLoaded = true
                            } catch let e{
                                print("[NewExtNode] ", e)
                            }
                        }
                    }
                }
                task.resume()
                while(!isLoaded){
                }
                previousInfo += "\""
                previousInfo += attrInfo["name"] as! String
                previousInfo += "\":\""
                previousInfo += loadAttributeValue
                previousInfo += "\""
                if(attributesOfSelectedItem.index(of: attr) != attributesOfSelectedItem.count - 1) {
                    previousInfo += ","
                }
            }
        }
        previousInfo += "}"
        for ref in referencesOfSelectedItem {
            var isLoaded = false
            let refInfo = ref as! NSMutableDictionary
            var string = "https://alter-databroker.onrender.com/accessUrl?aname=" + APIOfSelectedItem
            let classref = classOfSelectedItem["name"] as! String
            string += "&aclass=" + classref
            let refString = refInfo["name"] as! String
            string += "&ain="
            var count = 0
            for key in param.allKeys {
                let val = param[key] as! String
                if count != 0 {
                    string += "&ain" + String(count).replacingOccurrences(of: " ", with: "+") + "="
                }
                string += val.replacingOccurrences(of: " ", with: "+")
                count += 1
            }
            string += "&aout=" + refString
            if authOfSelectedItem != "" {
                string += "&eauth=" + authOfSelectedItem
            }
            string += "&json=true"
            let url = URL(string: string)
            if (url != nil) {
                print("[LoadRef] URL object exists: ", url!)
            }
            let session = URLSession.shared
            let task3 = session.dataTask(with: url!) { (data, response, error) -> Void in
                if error != nil {
                    print("[LoadRef] ", error!)
                } else {
                    if let data = data {
                        do {
                            let jsonResult = try JSONSerialization.jsonObject(
                                with: data,
                                options: JSONSerialization.ReadingOptions.mutableContainers
                            ) as! NSMutableDictionary
                            if(jsonResult["code"] as! String != "200") {
                                
                            } else {
                                let array = jsonResult["array"] as! NSMutableDictionary
                                let body = array["body"]
                                if body != nil {
                                    let dict = NSMutableDictionary()
                                    dict.setValue(classref, forKey: "class")
                                    if body is String {
                                        let stringAttr = body as! String
                                        if stringAttr != "" {
                                            dict.setValue(stringAttr, forKey: "refAttr")
                                            self.currentReferencesReservedValue.append(body as! String)
                                            dict.setValue(refString, forKey: "refName")
                                            dict.setValue(refInfo["target"] as! String, forKey: "target")
                                            dict.setValue(nodename, forKey: "nodename")
                                            
                                            self.referencesReserves.append(dict)
                                        }
                                    } else if body is Int {
                                        let intBody = body as! Int
                                        dict.setValue(body as! Int, forKey: "refAttr")
                                        self.currentReferencesReservedValue.append(String(intBody))
                                        dict.setValue(refString, forKey: "refName")
                                        dict.setValue(refInfo["target"] as! String, forKey: "target")
                                        dict.setValue(nodename, forKey: "nodename")
                                        self.referencesReserves.append(dict)
                                    } else if body is NSMutableArray {
                                        let array = body as! NSMutableArray
                                        for ref in array {
                                            if ref is String {
                                                let stringAttr = ref as! String
                                                if stringAttr != "" {
                                                    dict.setValue(stringAttr, forKey: "refAttr")
                                                    self.currentReferencesReservedValue.append(ref as! String)
                                                    dict.setValue(refString, forKey: "refName")
                                                    dict.setValue(refInfo["target"] as! String, forKey: "target")
                                                    dict.setValue(nodename, forKey: "nodename")
                                                    
                                                    self.referencesReserves.append(dict)
                                                }
                                            } else if ref is Int {
                                                let intBody = ref as! Int
                                                dict.setValue(ref as! Int, forKey: "refAttr")
                                                self.currentReferencesReservedValue.append(String(intBody))
                                                dict.setValue(refString, forKey: "refName")
                                                dict.setValue(refInfo["target"] as! String, forKey: "target")
                                                dict.setValue(nodename, forKey: "nodename")
                                                self.referencesReserves.append(dict)
                                            }
                                        }
                                    }
                                }
                                isLoaded = true
                            }
                        } catch let e{
                            print("[LoadCode] ", e)
                        }
                    }
                }
            }
            task3.resume()
            while(!isLoaded){
            }
        }
        return previousInfo
    }
    func getRefAttrKey(worldMap: ARWorldMap?, reference: String, class: String) -> String {
        //isArray
        if reference.contains(",") {
            let array = reference.components(separatedBy: ",")
            var result = ""
            for ref in array {
                if worldMap != nil {
                    for anAnchor in worldMap!.anchors {
                        if (anAnchor.isKind(of: AttributesAnchor.self)) {
                            if let anAttributesAnchor = anAnchor as? AttributesAnchor {
                                if ref == anAttributesAnchor.nameOfItemAnchor {
                                    let attributesDic = anAttributesAnchor.getValueOfAttributes()
                                    let metamodelClass = self.metamodel.last(where: { $0["name"] as! String == `class` })!
                                    let attributesInfo = metamodelClass["attributes"] as! NSMutableArray
                                    for info in attributesInfo {
                                        let infoDic = info as! NSMutableDictionary
                                        if infoDic["isKey"] as! Bool {
                                            let value = attributesDic[infoDic["name"]] as! String
                                            result += value
                                            if array[array.count - 1] != ref {
                                                result += ","
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    for child in self.sceneView.scene.rootNode.childNodes {
                        let anAnchor = self.sceneView.anchor(for: child)
                        if anAnchor != nil {
                            if (anAnchor!.isKind(of: AttributesAnchor.self)) {
                                if let anAttributesAnchor = anAnchor as? AttributesAnchor {
                                    if ref == anAttributesAnchor.nameOfItemAnchor {
                                        let attributesDic = anAttributesAnchor.getValueOfAttributes()
                                        let metamodelClass = self.metamodel.last(where: { $0["name"] as! String == `class` })!
                                        let attributesInfo = metamodelClass["attributes"] as! NSMutableArray
                                        for info in attributesInfo {
                                            let infoDic = info as! NSMutableDictionary
                                            if infoDic["isKey"] as! Bool {
                                                let infoDic = info as! NSMutableDictionary
                                                if infoDic["isKey"] as! Bool {
                                                    let value = attributesDic[infoDic["name"]] as! String
                                                    result += value
                                                    if array[array.count - 1] != ref {
                                                        result += ","
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result
        } else {
            if worldMap != nil {
                for anAnchor in worldMap!.anchors {
                    if (anAnchor.isKind(of: AttributesAnchor.self)) {
                        if let anAttributesAnchor = anAnchor as? AttributesAnchor {
                            if reference == anAttributesAnchor.nameOfItemAnchor {
                                let attributesDic = anAttributesAnchor.getValueOfAttributes()
                                let metamodelClass = self.metamodel.last(where: { $0["name"] as! String == `class` })!
                                let attributesInfo = metamodelClass["attributes"] as! NSMutableArray
                                for info in attributesInfo {
                                    let infoDic = info as! NSMutableDictionary
                                    if infoDic["isKey"] as! Bool {
                                        let value = attributesDic[infoDic["name"]] as! String
                                        return value
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            } else {
               for child in self.sceneView.scene.rootNode.childNodes {
                   let anAnchor = self.sceneView.anchor(for: child)
                   if anAnchor != nil {
                       if (anAnchor!.isKind(of: AttributesAnchor.self)) {
                           if let anAttributesAnchor = anAnchor as? AttributesAnchor {
                               if reference == anAttributesAnchor.nameOfItemAnchor {
                                   let attributesDic = anAttributesAnchor.getValueOfAttributes()
                                   let metamodelClass = self.metamodel.last(where: { $0["name"] as! String == `class` })!
                                   let attributesInfo = metamodelClass["attributes"] as! NSMutableArray
                                   for info in attributesInfo {
                                       let infoDic = info as! NSMutableDictionary
                                       if infoDic["isKey"] as! Bool {
                                           let value = attributesDic[infoDic["name"]] as! String
                                           return value
                                       }
                                   }
                                   break;
                               }
                           }
                       }
                   }
               }
           }
        }
        
        return ""
    }
    
    //Physics funcs
    func physicsWorld(_ world: SCNPhysicsWorld, didBegin contact: SCNPhysicsContact) {
        let nodeA = contact.nodeA
        let nodeB = contact.nodeB
        let anchorA = self.sceneView.anchor(for: nodeA)
        guard let itemA = anchorA as? ItemAnchor else {
            return
        }
        let anchorB = self.sceneView.anchor(for: nodeB)
        guard let itemB = anchorB as? ItemAnchor else {
            return
        }
        if self.gameloopInfo != [] {
            for info in self.gameloopInfo {
                let infoCollisions = info["collisions"] as! NSMutableArray
                for obj in infoCollisions {
                    let objMut = obj as! NSMutableDictionary
                    let infoClassA = objMut["classA"] as! String
                    let infoClassB = objMut["classB"] as! String
                    if (itemA.type == infoClassA && itemB.type == infoClassB) || (itemA.type == infoClassB && itemB.type == infoClassA) {
                        doAction(actionName: objMut["action"] as! String)
                        if objMut["delete"] != nil {
                            let delete = objMut["delete"] as! Bool
                            if delete {
                                nodeA.removeFromParentNode()
                                self.objectsInitialPos.removeObject(forKey: nodeA.name)
                                self.objectsBoundingBox.removeObject(forKey: nodeA.name)
                                self.objectsIdName.removeObject(forKey: nodeA.name)
                                self.objectsList.removeObject(forKey: itemA.givenName)
                                self.sceneView.session.remove(anchor: itemA)
                                nodeB.removeFromParentNode()
                                self.objectsInitialPos.removeObject(forKey: nodeB.name)
                                self.objectsBoundingBox.removeObject(forKey: nodeB.name)
                                self.objectsIdName.removeObject(forKey: nodeB.name)
                                self.objectsList.removeObject(forKey: itemB.givenName)
                                self.sceneView.session.remove(anchor: itemB)
                            }
                        }
                        return
                    }
                }
            }
        }
        print("CONTACTO")
    }
    
    func getPhysicsTriggers(classPhysic: String) -> NSMutableArray {
        if self.gameloopInfo != [] {
            for info in self.gameloopInfo {
                let infoObjInit = info["objInit"] as! NSMutableArray
                for obj in infoObjInit {
                    let objMut = obj as! NSMutableDictionary
                    let infoClass = objMut["class"] as! String
                    if infoClass == classPhysic {
                        if objMut["trigger"] == nil {
                            return []
                        }
                        let triggers = objMut["trigger"] as! NSMutableArray
                        return triggers
                    }
                }
            }
        }
        return []
    }
    
    func renderer(_ renderer: SCNSceneRenderer, didSimulatePhysicsAtTime time: TimeInterval) {
        for node in self.sceneView.scene.rootNode.childNodes {
            let anchor = self.sceneView.anchor(for: node)
            if anchor != nil {
                if (anchor!.isKind(of: ItemAnchor.self)) {
                    let itemAnchor = anchor as! ItemAnchor
                    let triggers = self.getPhysicsTriggers(classPhysic: itemAnchor.type)
                    if triggers != [] {
                        for trigger in triggers {
                            let objtrr = trigger as! NSMutableDictionary
                            let objname = objtrr["name"] as! String
                            if objname == "fall" {
                                if node.physicsBody?.velocity.y ?? 0 < -8 && !self.gameOver {
                                    let text = objtrr["action"] as! String
                                    self.doAction(actionName: text)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    //Bluetooth
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        if central.state == CBManagerState.poweredOn {
            central.scanForPeripherals(withServices: nil, options: [CBCentralManagerScanOptionAllowDuplicatesKey:true, CBConnectPeripheralOptionNotifyOnConnectionKey: false, CBConnectPeripheralOptionNotifyOnDisconnectionKey: false, CBConnectPeripheralOptionNotifyOnNotificationKey: false])
        } else {
            print("Bluetooth is not on.")
        }
    }
    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String : Any], rssi RSSI: NSNumber) {
        
        if !self.BluetoothDevices.contains(peripheral.identifier){
            self.BluetoothDevices.append(peripheral.identifier)
            if peripheral.name != nil {
                let proximityUUID = peripheral.identifier
                let beaconID = peripheral.name!
                var peripherial = ""
                for b in self.beaconsInfo {
                    peripherial = b["peripherial"] as! String
                    if beaconID.contains(peripherial) {
                        let uuid = UUID(uuidString: b["uuid"] as! String)!
                        let major = b["major"] as! Int
                        let majorValue = CLBeaconMajorValue(major)
                        let minor = b["minor"] as! Int
                        let minorValue = CLBeaconMinorValue(minor)
                        let constraint = CLBeaconIdentityConstraint(uuid: uuid, major: majorValue, minor: minorValue)
                        let region = CLBeaconRegion(uuid: proximityUUID, identifier: beaconID)
                        self.locationManager.startMonitoring(for: region)
                        self.locationManager.startRangingBeacons(satisfying: constraint)
                        break
                    }
                }
            }
            
        }
    }
    func locationManager(_ manager: CLLocationManager, didEnterRegion region: CLRegion) {
        if region is CLBeaconRegion {
            // Start ranging only if the devices supports this service.
            if CLLocationManager.isRangingAvailable() {
                manager.startRangingBeacons(in: region as! CLBeaconRegion)
           

                // Store the beacon so that ranging can be stopped on demand.
                //beaconsToRange.append(region as! CLBeaconRegion)
            }
        }
    }
    func locationManager(_ manager: CLLocationManager, didRange beacons: [CLBeacon], satisfying beaconConstraint: CLBeaconIdentityConstraint) {
        if beacons.count > 0 {
            let nearestBeacon = beacons.first!
            print(nearestBeacon.accuracy)
            switch nearestBeacon.proximity {
            case .immediate:
                // Display information about the relevant exhibit.
                print("TE QUEMAAAAAS")
                self.currentUUID = nearestBeacon.uuid.uuidString
                self.currentMinor = nearestBeacon.minor.intValue
                self.currentMajor = nearestBeacon.major.intValue
                if !self.beaconInmediate {
                    self.beaconInmediate = true
                    
                }
                break
            case .near:
                print("Caliente")
                if nearestBeacon.accuracy <= 0.8 && nearestBeacon.accuracy != -1.0 {
                    self.currentUUID = nearestBeacon.uuid.uuidString
                    self.currentMinor = nearestBeacon.minor.intValue
                    self.currentMajor = nearestBeacon.major.intValue
                    if !self.beaconInmediate {
                        self.beaconInmediate = true
                        
                    }
                }
                break
            default:
               // Dismiss exhibit information, if it is displayed.
               print("Frio")
               break
            }
        }
    }
    func loadBeacon(transform: simd_float4x4){
        var beacon : NSMutableDictionary = [:]
        var previousInfo = ""
        var count = 0
        for b in self.beaconsInfo {
            let uuid = b["uuid"] as! String
            let minor = b["minor"] as! Int
            let major = b["major"] as! Int
            if uuid == self.currentUUID && minor == self.currentMinor && major == self.currentMajor {
                beacon = b
                //Get the class of the beacon selected
                
                let selectedItem = beacon["class"] as! String
                var classOfSelectedItem = NSMutableDictionary()
                for aMetamodelClass in self.metamodel {
                    let nameOfCurrentClass = aMetamodelClass["name"] as! String
                    if nameOfCurrentClass == selectedItem {
                        classOfSelectedItem = aMetamodelClass
                    }
                }
                
                //Get external access info
                
                var accessOfSelectedItem = NSMutableDictionary()
                var trigger = false
                for anAccessClass in self.accesses {
                    let classAccess = anAccessClass["class"] as! String
                    let method = anAccessClass["method"] as! String
                    if classAccess == selectedItem && method == "GET" {
                        accessOfSelectedItem = anAccessClass
                        let classTrigger = anAccessClass["trigger"] as! NSMutableDictionary
                        trigger = classTrigger["onCreate"] as! Bool
                    }
                }
                let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
                let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
                let APIOfSelectedItem = accessOfSelectedItem["name"] as! String
                let authOfSelectedItem = accessOfSelectedItem["auth"] as! String
                
                //Check and fill external data with the information of external access
                
                if trigger == true {
                    var param : NSMutableDictionary = [:]
                    param = beacon["param"] as! NSMutableDictionary
                    previousInfo = self.getPreviousInfoExternal(attributesOfSelectedItem: attributesOfSelectedItem, referencesOfSelectedItem: referencesOfSelectedItem, classOfSelectedItem: classOfSelectedItem, APIOfSelectedItem: APIOfSelectedItem, authOfSelectedItem: authOfSelectedItem, param: param, nodename: beacon["nodename"] as! String)
                    
                    var graphicalSyntaxOfSelectedItem = NSMutableDictionary()
                    // retrieves the information relative to the selected item in graphical syntax
                    for aGraphicalSyntaxClass in self.graphicalSyntax {
                        let nameOfCurrentClass = aGraphicalSyntaxClass["name"] as! String
                        if nameOfCurrentClass == selectedItem {
                            graphicalSyntaxOfSelectedItem = aGraphicalSyntaxClass
                        }
                    }
                    if let versionsOfSelectedItem = graphicalSyntaxOfSelectedItem["versions"] as? NSMutableDictionary {
                        let currentVersion = 1
                        let nameOfVersions = graphicalSyntaxOfSelectedItem["vname"] as! NSMutableDictionary
                        
                        let listOfVersions = NSMutableDictionary()
                        var numberOfVersions = 0
                        for name in nameOfVersions {
                            listOfVersions[name.value] = versionsOfSelectedItem[name.key]
                            numberOfVersions+=1
                        }
                        let nameOfCurrentVersion = nameOfVersions["v\(currentVersion)"] as! String
                        let urlOfCurrentVersion = versionsOfSelectedItem["v\(currentVersion)"] as! String
                        let url = URL(string: urlOfCurrentVersion)
                        let urlString = url?.absoluteString
                        let attributesToShow = graphicalSyntaxOfSelectedItem["showAttributes"] as! NSMutableArray
                        var attributesMaterials : NSMutableArray = []
                        if graphicalSyntaxOfSelectedItem["materialAttributes"] != nil {
                            attributesMaterials = graphicalSyntaxOfSelectedItem["materialAttributes"] as! NSMutableArray
                        }
                        if let constraintsOfSelectedItem = graphicalSyntaxOfSelectedItem["constraints"] as? NSMutableDictionary {
                            
                            //set transform to not rotate the object
                            
                            let column0 : simd_float4 = [1.0, 0.0, 0.0, 0.0]
                            let column1 : simd_float4 = [0.0, 1.0, 0.0, 0.0]
                            let column2 : simd_float4 = [0.0, 0.0, 1.0, 0.0]
                            let column3 : simd_float4 = [transform.columns.3.x + Float(count) * 0.3, transform.columns.3.y, transform.columns.3.z, 1.0]
                            let newtransform = simd_float4x4(columns: (column0, column1, column2, column3))
                            
                            count += 1
                            
                            var scale = SCNVector3Make(1.0, 1.0, 1.0)
                            if constraintsOfSelectedItem["sizeInit"] != nil {
                                let sizeString = constraintsOfSelectedItem["sizeInit"] as! String
                                let size = Float(sizeString) ?? 1.0
                                scale = SCNVector3Make(size, size, size)
                            }
                            
                            let anchor = ItemAnchor(identifier: UUID(), name: beacon["nodename"] as! String, type: selectedItem, currentVersion: nameOfCurrentVersion, currentVersionInt: 1, urlOfCurrentVersion: urlString!, numberOfVersions: numberOfVersions.description, versions:     listOfVersions, attributes: attributesOfSelectedItem, references: referencesOfSelectedItem, constraints: constraintsOfSelectedItem, attributesToShow: attributesToShow, attributesMaterials: attributesMaterials, scale: scale, rotation: 0, QR: self.QRCurrentName, API: APIOfSelectedItem, auth: authOfSelectedItem, param: param, previousInfo: previousInfo, beacon: beacon["peripherial"] as! String, forces: [], initForce: "", transform: newtransform)
                            //to avoid jump to case loading model
                            self.needToLoad = false
                            self.sceneView.session.add(anchor: anchor)
                            self.itemAnchors.append(anchor)
                            self.itemsBeacons.setValue(self.currentUUID, forKey: beacon["nodename"] as! String)
                            self.itemsMinor.setValue(self.currentMinor, forKey: beacon["nodename"] as! String)
                            self.itemsMajor.setValue(self.currentMajor, forKey: beacon["nodename"] as! String)
                        }
                    }
                }
            }
        }
        if count == 0 {
            //TODO create beacon local object
            self.processingBeacon = false
            return
        }
        self.currentUUID = ""
        self.currentMajor = 0
        self.currentMinor = 0
        self.processingBeacon = false
    }
    func createNode(objName: String, objClass: String, transform: simd_float4x4, force: String, attributes: NSMutableArray,  rotation: Int, scaling: Double){
        var classOfSelectedItem = NSMutableDictionary()
        // retrieves the information relative to the selected item in the metamodel
        for aMetamodelClass in self.metamodel {
            let nameOfCurrentClass = aMetamodelClass["name"] as! String
            if nameOfCurrentClass == objClass {
                classOfSelectedItem = aMetamodelClass
            }
        }
        let attributesOfSelectedItem = classOfSelectedItem["attributes"] as! NSMutableArray
        let referencesOfSelectedItem = classOfSelectedItem["references"] as! NSMutableArray
        
        var graphicalSyntaxOfSelectedItem = NSMutableDictionary()
        // retrieves the information relative to the selected item in graphical syntax
        for aGraphicalSyntaxClass in self.graphicalSyntax {
            let nameOfCurrentClass = aGraphicalSyntaxClass["name"] as! String
            if nameOfCurrentClass == objClass {
                graphicalSyntaxOfSelectedItem = aGraphicalSyntaxClass
            }
        }
        if self.noSCNItems.contains(objClass) {
            let anchor = ItemNoSCNAnchor(identifier: UUID(), name: objName, type: objClass, attributes: attributesOfSelectedItem, references: referencesOfSelectedItem, transform: transform)
            //to avoid jump to case loading model
            self.needToLoad = false
            
            self.sceneView.session.add(anchor: anchor)
        } else {
            
        }
        
        // Set alignment
        var alignment: ARRaycastQuery.TargetAlignment = .any // by default it is .any
        if let constraintsOfSelectedItem = graphicalSyntaxOfSelectedItem["constraints"] as? NSMutableDictionary {
            if let planeAlignment = constraintsOfSelectedItem["plane"] as? String {
                if planeAlignment == "horizontal" {
                    alignment = .horizontal
                } else if planeAlignment == "vertical" {
                    alignment = .vertical
                }
            }
        }
        let estimatedPlane: ARRaycastQuery.Target = .estimatedPlane
        var accessOfSelectedItem = NSMutableDictionary()
        var timeTrigger = 0.0
        for anAccessClass in self.accesses {
            let classAccess = anAccessClass["class"] as! String
            let method = anAccessClass["method"] as! String
            if classAccess == objClass && method == "GET" {
                accessOfSelectedItem = anAccessClass
            }
        }
        
        var physicsOfSelectedItem = NSMutableDictionary()
        for physicData in self.physicsInfo {
            let classPhysic = physicData["name"] as! String
            if classPhysic == objClass {
                physicsOfSelectedItem = physicData
            }
        }
        let forces : NSMutableArray = []
        
        if physicsOfSelectedItem["forces"] != nil {
            let forcesArray = physicsOfSelectedItem["forces"] as! NSMutableArray
            for forceObj in forcesArray {
                let force = forceObj as! NSMutableDictionary
                forces.add(force["name"] as! String)
            }
        }
        let APIOfSelectedItem = accessOfSelectedItem["name"] as? String ?? ""
        let authOfSelectedItem = accessOfSelectedItem["auth"] as? String ?? ""
        let classTrigger = accessOfSelectedItem["trigger"] as? NSMutableDictionary ?? nil
        timeTrigger = classTrigger?["timeTrigger"] as? Double ?? 0.0
        
        var param : NSMutableDictionary = [:]
        
        
        //check local params
        if self.currentParam == "" {
            for attribute in attributesOfSelectedItem {
                let attr = attribute as! NSMutableDictionary
                let name = attr["name"] as! String
                let def = attr["default"] as! String
                let type = attr["type"] as! String
                let isParam = attr["isParam"] as! Bool
                let loc : CLLocation? = locationManager.location
                if isParam {
                    if type != "Longitude" && type != "Latitude" {
                        param.setValue(def, forKey: name)
                    } else if type == "Longitude" {
                        let long = "\(loc?.coordinate.longitude ?? 0.0)"
                        param.setValue(long, forKey: name)
                    } else if type == "Latitude" {
                        let lat = "\(loc?.coordinate.latitude ?? 0.0)"
                        param.setValue(lat, forKey: name)
                    }
                }
            }
        } else if self.currentParam != nil {
            param = ["currentParam" : self.currentParam ?? ""]
        }
        
        var previousInfo = ""
        if attributes.count != 0 {
            previousInfo = "{"
            for attr in attributes {
                let attrInfo = attr as! NSMutableDictionary
                let name = attrInfo["name"] as! String
                let value = attrInfo["value"] as! String
                
                previousInfo += "\""
                previousInfo += name
                previousInfo += "\":\""
                previousInfo += value
                previousInfo += "\""
                if(attributesOfSelectedItem.index(of: attr) != attributesOfSelectedItem.count - 1) {
                    previousInfo += ","
                }
            }
            previousInfo += "}"
        }
        if let versionsOfSelectedItem = graphicalSyntaxOfSelectedItem["versions"] as? NSMutableDictionary {
            let currentVersion = 1
            let nameOfVersions = graphicalSyntaxOfSelectedItem["vname"] as! NSMutableDictionary
            //let numberOfVersions = nameOfVersions.count
            //newItem["max_version"] = numberOfVersions
            // "v\(currentVersion)" stands for v1
            let listOfVersions = NSMutableDictionary()
            var numberOfVersions = 0
            for name in nameOfVersions {
                listOfVersions[name.value] = versionsOfSelectedItem[name.key]
                numberOfVersions+=1
            }
            let nameOfCurrentVersion = nameOfVersions["v\(currentVersion)"] as! String
            let urlOfCurrentVersion = versionsOfSelectedItem["v\(currentVersion)"] as! String
            let url = URL(string: urlOfCurrentVersion)
            let urlString = url?.absoluteString
            let attributesToShow = graphicalSyntaxOfSelectedItem["showAttributes"] as! NSMutableArray
            var attributesMaterials : NSMutableArray = []
            if graphicalSyntaxOfSelectedItem["materialAttributes"] != nil {
                attributesMaterials = graphicalSyntaxOfSelectedItem["materialAttributes"] as! NSMutableArray
            }
            
            // Add anchor
            if let constraintsOfSelectedItem = graphicalSyntaxOfSelectedItem["constraints"] as? NSMutableDictionary {
                var scale = SCNVector3Make(1.0, 1.0, 1.0)
                if scaling != 1.0 {
                    scale = SCNVector3Make(Float(scaling), Float(scaling), Float(scaling))
                } else if constraintsOfSelectedItem["sizeInit"] != nil {
                    let sizeString = constraintsOfSelectedItem["sizeInit"] as! String
                    let size = Float(sizeString) ?? 1.0
                    scale = SCNVector3Make(size, size, size)
                }
                let anchor = ItemAnchor(identifier: UUID(), name: objName, type: objClass, currentVersion: nameOfCurrentVersion, currentVersionInt: 1, urlOfCurrentVersion: urlString!, numberOfVersions: numberOfVersions.description, versions: listOfVersions, attributes: attributesOfSelectedItem, references: referencesOfSelectedItem, constraints: constraintsOfSelectedItem, attributesToShow: attributesToShow, attributesMaterials: attributesMaterials, scale: scale, rotation: rotation, QR: "", API: APIOfSelectedItem, auth: authOfSelectedItem, param: param, previousInfo: previousInfo, beacon: "", forces: forces, initForce: force, transform: transform)
                self.sceneView.session.add(anchor: anchor)
                self.itemAnchors.append(anchor)
            }
        }
    }
    func forceToNode(node: SCNNode, forceName: String, anchor: ItemAnchor) {
        var forces : NSMutableArray = []
        var physicsOfSelectedItem = NSMutableDictionary()
        for physicData in self.physicsInfo {
            let classPhysic = physicData["name"] as! String
            if classPhysic == anchor.type {
                physicsOfSelectedItem = physicData
            }
        }
        if physicsOfSelectedItem["forces"] != nil {
            forces = physicsOfSelectedItem["forces"] as! NSMutableArray
        }
        var forceVector = SCNVector3Make(0, 1, -0.5)
        for f in forces {
            let obj = f as! NSMutableDictionary
            let stringForce = obj["name"] as! String
            if stringForce == forceName {
                if physicsOfSelectedItem["forces"] != nil {
                    let forcesArray = physicsOfSelectedItem["forces"] as! NSMutableArray
                    for f2 in forcesArray {
                        let forceObj = f2 as! NSMutableDictionary
                        if forceName == forceObj["name"] as! String {
                            if forceObj["xVector"] != nil {
                                let x = forceObj["xVector"] as! Double
                                let y = forceObj["yVector"] as! Double
                                let z = forceObj["zVector"] as! Double
                                forceVector = SCNVector3Make(Float(x), Float(y), Float(z))
                            }
                        }
                    }
                }
            }
        }
        guard let pointOfView = self.sceneView.pointOfView?.transform else {return}
        let orientation = SCNVector3Make(-pointOfView.m31, -pointOfView.m32, -pointOfView.m33)
        let forceApply = Force(force: forceVector, orientation: orientation)
        node.physicsBody?.applyForce(forceApply.finalForce, asImpulse: true)
    }
}
