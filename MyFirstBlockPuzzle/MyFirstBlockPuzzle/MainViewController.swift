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
    
    var test: UInt32 = 0
    
    /**
     * Main Logic
     */
    override func viewDidLoad() {
        
        super.viewDidLoad()
        
        //select target
        target = getRandomIndex(UInt32(images[Int(theme)].count))
        
        //sets up the imgViews and randomizes images
        for (i, view) in imgViews.enumerate() {
            
            let randomIndex = getRandomIndex(UInt32(images[Int(theme)].count))
            currentImg[i] = randomIndex
            
            view.image = splitImage(UIImage(named: images[Int(theme)][Int(randomIndex)])!, section: i)
            addListener(view)
        }
    }
    
    /**
     * A self generated overidden method for disposing of obects
     */
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    /**
     * this overidden function passes the current thee back to the settings controller
     * this is done just for the asthetics of the theme not changing to the default
     */
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if (sender is UIBarButtonItem) {
            let controller = (segue.destinationViewController as! SettingsViewController)
            controller.theme = theme
        }
    }
    
    /**
     * addListener - adds a touch listener to an imgView
     * 
     * @param imgView - the target imageView for a listener
     */
    func addListener(imgView: UIImageView) {
        let newListener = UITapGestureRecognizer(target: self, action: #selector(self.nextImg))
        imgView.userInteractionEnabled = true
        imgView.addGestureRecognizer(newListener)
    }
    
    /**
     * nextImg - gets the next image of an ImageView
     */
    func nextImg(event: AnyObject?) {
        
        if (event?.view == imgViews[0]) {
            let view = imgViews[0]
            currentImg[0] += 1
            if (currentImg[0] == UInt32(images[Int(theme)].count)) {
                currentImg[0] = 0
            }
            view.image = splitImage(UIImage(named: images[Int(theme)][Int(currentImg[0])])!, section: 0)
        } else if (event?.view == imgViews[1]) {
            let view = imgViews[1]
            currentImg[1] += 1
            if (currentImg[1] == UInt32(images[Int(theme)].count)) {
                currentImg[1] = 0
            }
            view.image = splitImage(UIImage(named: images[Int(theme)][Int(currentImg[1])])!, section: 1)
            
        } else if (event?.view == imgViews[2]) {
            let view = imgViews[2]
            currentImg[2] += 1
            if (currentImg[2] == UInt32(images[Int(theme)].count)) {
                currentImg[2] = 0
            }
            view.image = splitImage(UIImage(named: images[Int(theme)][Int(currentImg[2])])!, section: 2)
            
        } else if (event?.view == imgViews[3]) {
            let view = imgViews[3]
            currentImg[3] += 1
            if (currentImg[3] == UInt32(images[Int(theme)].count)) {
                currentImg[3] = 0
            }
            view.image = splitImage(UIImage(named: images[Int(theme)][Int(currentImg[3])])!, section: 3)
            
        }
    }
    
    /**
     * splitImage function - splits an initial image into quarters
     *
     * solution from (http://stackoverflow.com/questions/10661291/split-uiimage-in-half)
     * conveted from Obj-c to swift by Jake Dixon (mes)
     *
     * @param img - the original image
     * @param section - the quarter to be cut to (0, 1, 2, 3) = (TL, TR, BL, BR)
     * @return UIImage - the cut image
     */
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
    
    /**
     * getRandomIndex - gets a random integer between 0 and a max number - 1
     *
     * @param index - the max number in an array count for example
     * @return UInt32 - an int between 0 and index-1
     */
    func getRandomIndex(index: UInt32) -> UInt32 {
        let lower : UInt32 = 1
        let upper : UInt32 = index
        
        let randomNumber = arc4random_uniform(upper - lower) + lower
        
        return randomNumber
    }
}
