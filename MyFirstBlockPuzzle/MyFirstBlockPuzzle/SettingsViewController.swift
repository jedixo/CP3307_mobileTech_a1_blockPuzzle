//
//  ViewController.swift
//  MyFirstBlockPuzzle
//
//  Created by Jake Dixon on 22/05/2016.
//  Copyright © 2016 Jake Dixon. All rights reserved.
//

import UIKit

class SettingsViewController: UIViewController {
    @IBOutlet weak var pipeSwitch: UISwitch!
    @IBOutlet weak var shapeSwitch: UISwitch!
    @IBOutlet weak var patternSwitch: UISwitch!


    @IBAction func switchChanged(sender: AnyObject) {
        print("wrks")
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

