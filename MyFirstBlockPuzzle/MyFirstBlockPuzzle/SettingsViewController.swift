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
    //@IBOutlet weak var patternSwitch: UISwitch!
    @IBOutlet weak var patternSwitch: UISwitch!


    @IBAction func switchChanged(sender: AnyObject) {
        print("out")
        if (sender as! NSObject == pipeSwitch && sender.on) {
            shapeSwitch.on = false;
            patternSwitch.on = false;
        } else if (sender as! NSObject == shapeSwitch && sender.on) {
            pipeSwitch.on = false;
            patternSwitch.on = false;
        } else if (sender as! NSObject == patternSwitch && sender.on){
            pipeSwitch.on = false;
            shapeSwitch.on = false;
        } else {
            pipeSwitch.on = true;
            shapeSwitch.on = false;
            patternSwitch.on = false;
        }
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

