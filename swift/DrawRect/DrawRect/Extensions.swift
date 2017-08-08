//
//  Extensions.swift
//  DrawRect
//
//  Created by 박새미 on 2017. 8. 8..
//  Copyright © 2017년 박새미. All rights reserved.
//

import Foundation



extension String {
  
  var floatValue: Float {
    return (self as NSString).floatValue
  }
  
  
  var pointVlaue: CGPoint? {
    let components = self.components(separatedBy: " ")
    if components.count > 1 {
      return CGPoint(x: CGFloat(components[0].floatValue),
                     y: CGFloat(components[1].floatValue))
      
    } else {
      return nil
    }
  }
}


extension Array where Element == CGFloat {
  
  func getResult() -> CGFloat {
    if self.dropFirst().contains(self.first!) {
      return self.filter(){ $0 != self.first }.first!
    } else {
      return self.first!
    }
  }
}
