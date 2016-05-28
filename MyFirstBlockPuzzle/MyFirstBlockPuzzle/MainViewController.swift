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
        topLeft.image = splitImage(UIImage(named: "pipe1")!, section: 0)
        topLeft.clipsToBounds = true
        topLeft.contentMode = .ScaleAspectFit
        topRight.image = splitImage(UIImage(named: "pipe1")!, section: 1)
        topRight.clipsToBounds = true
        topRight.contentMode = .ScaleAspectFit
        bottomLeft.image = splitImage(UIImage(named: "pipe1")!, section: 2)
        bottomLeft.clipsToBounds = true
        bottomLeft.contentMode = .ScaleAspectFit
        bottomRight.image = splitImage(UIImage(named: "pipe1")!, section: 3)
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
    
    func splitImage(img: UIImage, section: integer_t) -> UIImage {
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
    
    
    
    
//     (void)splitImage:(UIImage *)image
//    {
//    CGFloat imgWidth = image.size.width/2;
//    CGFloat imgheight = image.size.height;
    
//    CGRect leftImgFrame = CGRectMake(0, 0, imgWidth, imgheight);
//    CGRect rightImgFrame = CGRectMake(imgWidth, 0, imgWidth, imgheight);
    
//    CGImageRef left = CGImageCreateWithImageInRect(image.CGImage, leftImgFrame);
//    CGImageRef right = CGImageCreateWithImageInRect(image.CGImage, rightImgFrame);
    
    // These are the images we want!
//    UIImage *leftImage = [UIImage imageWithCGImage:left];
//    UIImage *rightImage = [UIImage imageWithCGImage:right];
    
    // Don't forget to free the memory!
//    CGImageRelease(left);
//    CGImageRelease(right);
//    }

}
