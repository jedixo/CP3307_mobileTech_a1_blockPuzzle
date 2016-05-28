//
//  MainViewController.swift
//  MyFirstBlockPuzzle
//
//  Created by Jake Dixon on 26/05/2016.
//  Copyright © 2016 Jake Dixon. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    
    @IBOutlet var imgViews: [UIImageView]!
    var images: [[String]] = [["pipe1", "pipe2", "pipe3", "pipe4", "pipe5", "pipe6"], ["shape1","shape2","shape3","shape4","shape5"],
                              ["patterns1","patterns2","patterns3","patterns4","patterns5","patterns6"]]
    
    var theme: UInt32 = 0
    var currentImg: [UInt32] = [0,0,0,0]
    var target: UInt32 = 0
    
    override func viewDidLoad() {
        
    super.viewDidLoad()
        
        print(images)
        print(imgViews)
        
        //select theme
    
        //select target
        target = getRandomIndex(UInt32(images[Int(theme)].count))
        
        //sets up the imgViews and randomizes images
        for (i, view) in imgViews.enumerate() {
            let index = i
            let randomIndex = getRandomIndex(UInt32(images[Int(theme)].count))
            currentImg[index] = randomIndex
            view.image = splitImage(UIImage(named: images[Int(theme)][Int(randomIndex)])!, section: index)
            addListener(view)
        }
    }
    
    
    func addListener(imgView: UIImageView) {
        let newListener = UITapGestureRecognizer(target: self, action: #selector(self.listenerMethod))
        imgView.userInteractionEnabled = true
        imgView.addGestureRecognizer(newListener)
    }
    
    func listenerMethod() {
        print("listening")
    }
    
    
    
    @IBAction func randomButton(sender: AnyObject) {
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func splitImage(img: UIImage, section: Int) -> UIImage {
        var imgstartw = 0 as CGFloat
        var imgstarth = 0 as CGFloat
        var imgWidth  = 0 as CGFloat
        var imgHeight = 0 as CGFloat
        
        if (section == 0) {
            imgWidth = img.size.width / 2
            imgHeight = img.size.height / 2
        } else if (section == 1) {
            imgstartw = img.size.width / 2
            imgWidth = img.size.width
            imgHeight = img.size.height / 2
        } else if (section == 2) {
            imgstarth = img.size.height / 2
            imgWidth = img.size.width / 2
            imgHeight = img.size.height
        } else {
            imgstartw = img.size.width / 2
            imgstarth = img.size.height / 2
            imgWidth = img.size.width
            imgHeight = img.size.height
        }
        
        let leftImgFrame = CGRectMake(imgstartw, imgstarth, imgWidth, imgHeight);
        let left = CGImageCreateWithImageInRect(img.CGImage, leftImgFrame);
        
        return UIImage(CGImage:left!)
    }
    
    func getRandomIndex(index: UInt32) -> UInt32 {
        let lower : UInt32 = 1
        let upper : UInt32 = index
        
        let randomNumber = arc4random_uniform(upper - lower) + lower
        
        return randomNumber
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if (sender is UIBarButtonItem) {
            let controller = (segue.destinationViewController as! SettingsViewController)
            controller.theme = theme
        }
    }
}
