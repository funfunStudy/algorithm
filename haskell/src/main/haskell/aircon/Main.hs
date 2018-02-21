module Main where

main :: IO ()
main = do
  print $ check 90 [10, 10, 10, 10, 10, 10, 10, 10, 10]
  print $ check 1000 [77, 77, 70, 11, 34, 35, 41, 83, 54]
  print $ check 50 [10, 20, 30, 40, 50, 60, 50, 40, 30]


check :: Int -> [Int] -> String
check a list = if sum list > a then "NO" else "YES"