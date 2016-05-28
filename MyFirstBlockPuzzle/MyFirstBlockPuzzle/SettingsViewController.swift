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
    
    var theme: UInt32 = 0


    @IBAction func switchChanged(sender: AnyObject) {
        print("out")
        if (sender as! NSObject == pipeSwitch && sender.on) {
            theme = 0
            shapeSwitch.on = false;
            patternSwitch.on = false;
        } else if (sender as! NSObject == shapeSwitch && sender.on) {
            theme = 1
            pipeSwitch.on = false;
            patternSwitch.on = false;
        } else if (sender as! NSObject == patternSwitch && sender.on){
            theme = 2
            pipeSwitch.on = false;
            shapeSwitch.on = false;
        } else {
            theme = 0
            pipeSwitch.on = true;
            shapeSwitch.on = false;
            patternSwitch.on = false;
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        
        if (theme == 1) {
            pipeSwitch.on = false;
            shapeSwitch.on = true;
            patternSwitch.on = false;
        } else if (theme == 2) {
            pipeSwitch.on = false;
            shapeSwitch.on = false;
            patternSwitch.on = true;
        }
    }

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        let controller = (segue.destinationViewController as! MainViewController)
        controller.theme = theme
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

