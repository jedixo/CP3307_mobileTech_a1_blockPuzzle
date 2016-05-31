//
//  ViewController.swift
//  MyFirstBlockPuzzle
//
//  Created by Jake Dixon on 22/05/2016.
//  Copyright © 2016 Jake Dixon. All rights reserved.
//

import UIKit

/**
 * Settings View Controller - controls the settings scene
 * used to select a theme of the puzzle
 */
class SettingsViewController: UIViewController {
    
    //switches
    @IBOutlet weak var pipeSwitch: UISwitch!
    @IBOutlet weak var shapeSwitch: UISwitch!
    @IBOutlet weak var patternSwitch: UISwitch!
    
    //backgrounf images
    var images: [String] = ["eg1", "eg2", "eg3"]
    
    //currently selected theme
    var theme: UInt32 = 0

    /**
     * switch has changed function - updates the selected theme 
     * also makes the switches act as radio buttons
     */
    @IBAction func switchChanged(sender: AnyObject) {
        
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
        
        setBgImg(theme)
    }
    
    /**
     * main view load function
     * controlls the initial theme and setup
     */
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
        setBgImg(theme)
    }

    /**
     * overidden segue function
     * passes the theme between scenes
     */
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        let controller = (segue.destinationViewController as! MainViewController)
        controller.theme = theme
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    /**
     * sets the background image for the scene
     */
    func setBgImg(image: UInt32) {
        let bgimg = UIImage(named: images[Int(image)])
        let bgimgview = UIImageView(frame: self.view.frame)

        bgimgview.image = bgimg
        bgimgview.image? = (bgimgview.image?.imageWithRenderingMode(.AlwaysTemplate))!
        bgimgview.tintColor = UIColor.orangeColor().colorWithAlphaComponent(0.2)
        
        if (self.view.subviews[0] is UIImageView) {
            self.view.subviews[0].removeFromSuperview()
        }
        
        self.view.insertSubview(bgimgview, atIndex: 0)
    }
}

