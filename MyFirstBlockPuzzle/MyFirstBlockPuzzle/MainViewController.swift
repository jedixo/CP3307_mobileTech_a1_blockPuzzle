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
        topLeft.image = scaleImage("pipe1")
        topLeft.clipsToBounds = true
        topLeft.contentMode = .ScaleAspectFit
        topRight.image = scaleImage("pipe2")
        topRight.clipsToBounds = true
        topRight.contentMode = .ScaleAspectFit
        bottomLeft.image = scaleImage("pipe3")
        bottomLeft.clipsToBounds = true
        bottomLeft.contentMode = .ScaleAspectFit
        bottomRight.image = scaleImage("pipe4")
        bottomRight.clipsToBounds = true
        bottomRight.contentMode = .ScaleAspectFit
        // Do any additional setup after loading the view.
    }
    @IBAction func randomButton(sender: AnyObject) {
    }
    
    func scaleImage(imgName: String) -> UIImage {
        let image = UIImage(named: imgName)
        
        let size = CGSizeApplyAffineTransform(image!.size, CGAffineTransformMakeScale(0.5, 0.5))
        let hasAlpha = false
        let scale: CGFloat = 0.0 // Automatically use scale factor of main screen
        
        UIGraphicsBeginImageContextWithOptions(size, !hasAlpha, scale)
        image!.drawInRect(CGRect(origin: CGPointZero, size: size))
        
        let scaledImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        return scaledImage

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
