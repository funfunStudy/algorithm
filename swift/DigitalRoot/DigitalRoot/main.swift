//
//  main.swift
//  DigitalRoot
//
//  Created by Moonbeom KWON on 2017. 8. 28..
//  Copyright © 2017년 mbkyle. All rights reserved.
//

import Foundation

print("Hello, World!")

var inputList: NSMutableArray = NSMutableArray()

repeat {
    if let input: String = readLine() {
        if Int(input) == 0 {
            break
        } else if input.trimmingCharacters(in: .whitespaces).characters.count > 0 {
            inputList.add(input)
        }
    }
    
} while true


func getDigitalRoot(input: String) -> Int {
    let rootNumber: Int = Array(input.characters).map{ Int(String($0))! }.reduce(0, +)
    
    if rootNumber > 10 {
        return getDigitalRoot(input: String(rootNumber))
        
    } else {
        return rootNumber
    }
}


print("\n\n")
for inputString in inputList {
    if let input = inputString as? String {
        print(getDigitalRoot(input: input))
    }
}
