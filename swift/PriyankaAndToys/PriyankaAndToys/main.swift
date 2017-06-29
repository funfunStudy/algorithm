//
//  main.swift
//  PriyankaAndToys
//
//  Created by Moonbeom KWON on 2017. 6. 29..
//  Copyright © 2017년 mbkyle. All rights reserved.
//

import Foundation

print("Hello, PriyankaAndToys!")

let numOfDolls = readLine(strippingNewline: true)
let dollArray = readLine(strippingNewline: true)?.components(separatedBy: " ")

guard let dollCount = numOfDolls, let dollList = dollArray else {
    exit(1)
}

let numbers = dollList.map {Int($0) ?? 0}.sorted()


func getResult(nums: [Int], acc: Int) -> Int {
    
    guard nums.count != 0 else {
        return acc
    }
    
    
    let maxTuple = nums.enumerated().map {index, _ -> (index: Int, count: Int) in
        
        return (index: index, count: getCount(nums: Array( nums[index ..< nums.count] )))
        
    }.max {a, b in a.count < b.count}
    
    
    if let target = maxTuple {
        
        var paramNumbers = nums
        paramNumbers.removeSubrange(target.index ..< (target.index + target.count))
        
        return getResult(nums: paramNumbers,
                         acc: acc + 1)
        
    } else {
        return acc
    }
}


func getCount(nums: [Int]) -> Int {
    let limit = (nums.first ?? 0) + 4
    return nums.prefix(while: { $0 <= limit}).count
}




print(getResult(nums: numbers, acc: 0))
