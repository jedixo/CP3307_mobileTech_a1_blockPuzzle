//
//  StatisticsViewController.swift
//  MyFirstBlockPuzzle
//
//  Created by Jake Dixon on 26/05/2016.
//  Copyright © 2016 Jake Dixon. All rights reserved.
//

import UIKit

class StatisticsViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    /**
     
     i give up... ive tried table views, table view controllers, single views, text outputs and i cant get it to read from core data
     
     
     var fetchedResultsController: NSFetchedResultsController {
     if _fetchedResultsController != nil {
     return _fetchedResultsController!
     }
     
     let fetchRequest = NSFetchRequest()
     // Edit the entity name as appropriate.
     let entity = NSEntityDescription.entityForName("Puzzle", inManagedObjectContext: self.managedObjectContext!)
     fetchRequest.entity = entity
     
     // Set the batch size to a suitable number.
     fetchRequest.fetchBatchSize = 20
     
     // Edit the sort key as appropriate.
     let sortDescriptor = NSSortDescriptor(key: "id", ascending: false)
     
     fetchRequest.sortDescriptors = [sortDescriptor]
     
     // Edit the section name key path and cache name if appropriate.
     // nil for section name key path means "no sections".
     let aFetchedResultsController = NSFetchedResultsController(fetchRequest: fetchRequest, managedObjectContext: self.managedObjectContext!, sectionNameKeyPath: nil, cacheName: "Master")
     aFetchedResultsController.delegate = self
     _fetchedResultsController = aFetchedResultsController
     
     do {
     try _fetchedResultsController!.performFetch()
     } catch {
     // Replace this implementation with code to handle the error appropriately.
     // abort() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
     //print("Unresolved error \(error), \(error.userInfo)")
     abort()
     }
     
     return _fetchedResultsController!
     }
     var _fetchedResultsController: NSFetchedResultsController? = nil
     
     func controllerWillChangeContent(controller: NSFetchedResultsController) {
     //self.tableView.beginUpdates()
     }
     
     func controller(controller: NSFetchedResultsController, didChangeSection sectionInfo: NSFetchedResultsSectionInfo, atIndex sectionIndex: Int, forChangeType type: NSFetchedResultsChangeType) {
     // switch type {
     // case .Insert:
     //  self.tableView.insertSections(NSIndexSet(index: sectionIndex), withRowAnimation: .Fade)
     // case .Delete:
     //  self.tableView.deleteSections(NSIndexSet(index: sectionIndex), withRowAnimation: .Fade)
     // default:
     //     return
     // }
     }
     
     func controller(controller: NSFetchedResultsController, didChangeObject anObject: AnyObject, atIndexPath indexPath: NSIndexPath?, forChangeType type: NSFetchedResultsChangeType, newIndexPath: NSIndexPath?) {
     switch type {
     case .Insert:
     tableView.insertRowsAtIndexPaths([newIndexPath!], withRowAnimation: .Fade)
     case .Delete:
     tableView.deleteRowsAtIndexPaths([indexPath!], withRowAnimation: .Fade)
     case .Update:
     self.configureCell(tableView.cellForRowAtIndexPath(indexPath!)!, withObject: anObject as! Puzzle)
     case .Move:
     tableView.moveRowAtIndexPath(indexPath!, toIndexPath: newIndexPath!)
     }
     }
     
     func controllerDidChangeContent(controller: NSFetchedResultsController) {
     
     }*/
}
