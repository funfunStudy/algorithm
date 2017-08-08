//
//  main.swift
//  DrawRect
//
//  Created by 박새미 on 2017. 8. 8..
//  Copyright © 2017년 박새미. All rights reserved.
//

import Foundation


print("문제의 수를 입력?")


func getAnotherPoint(points: Array<CGPoint>) -> CGPoint {
  return CGPoint(x: points.map{ $0.x }.getResult(),
                 y: points.map{ $0.y }.getResult())
}


func inputThreePoints() -> Array<CGPoint> {
  
  var points = Array<CGPoint>()
  for _ in 1...3 {
    if let point = readLine()?.pointVlaue {
      points.append(point)
      
    } else {
      exit(1)
    }
  }
  
  return points
}


if let response = readLine() {
  let inputNum = Int(response)!
  for _ in 1...inputNum {
    print( getAnotherPoint(points: inputThreePoints()) )
  }
  
}

