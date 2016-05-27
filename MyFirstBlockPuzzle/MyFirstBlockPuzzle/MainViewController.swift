//
//  MainViewController.swift
//  MyFirstBlockPuzzle
//
//  Created by Jake Dixon on 26/05/2016.
//  Copyright © 2016 Jake Dixon. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    @IBOutlet weak var topLeft: UIImageView!
    @IBOutlet weak var topRight: UIImageView!
    @IBOutlet weak var bottomRight: UIImageView!
    @IBOutlet weak var bottomLeft: UIImageView!

    
    override func viewDidLoad() {
        
    super.viewDidLoad()
        
        //testimg images
        topLeft.image = UIImage(named: "pipe1")
        topRight.image = UIImage(named: "pipe2")
        bottomLeft.image = UIImage(named: "pipe3")
        bottomRight.image = UIImage(named: "pipe4")
        // Do any additional setup after loading the view.
    }
    @IBAction func randomButton(sender: AnyObject) {
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
