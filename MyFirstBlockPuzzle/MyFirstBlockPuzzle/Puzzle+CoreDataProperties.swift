//
//  Puzzle+CoreDataProperties.swift
//  MyFirstBlockPuzzle
//
//  Created by Jake Dixon on 29/05/2016.
//  Copyright © 2016 Jake Dixon. All rights reserved.
//
//  Choose "Create NSManagedObject Subclass…" from the Core Data editor menu
//  to delete and recreate this implementation file for your updated model.
//

import Foundation
import CoreData

extension Puzzle {

    @NSManaged var theme: String?
    @NSManaged var touches: NSNumber?

}
