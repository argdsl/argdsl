//
//  MenuViewController.swift
//  ARModelling
//
//  Created by Miso on 20/09/2020.
//

import UIKit

class MenuViewController: UIViewController {

    // MARK: IBOutlet
    @IBOutlet weak var horizontalMenu2: UIStackView!
    @IBOutlet weak var loginStackView: UIStackView!
    
    @IBOutlet weak var tutorialButton: UIButton!
    @IBOutlet weak var configButton: UIButton!
    @IBOutlet weak var loadButton: UIButton!
    @IBAction func myUnwindAction(unwindSegue: UIStoryboardSegue){
        print("bye")
    }


    // MARK: Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // layout
        self.tutorialButton.isHidden = true
        self.loginStackView.isHidden = true
        self.configButton.isHidden = true
        self.loadButton.isHidden = true
    }

}
