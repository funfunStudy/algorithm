module Main where

import Data.List
-- progresses	speeds	  return
--[93,30,55]	[1,30,5]	[2,1]

--[94, 60, 60]
--[95, 90, 65]
--[96, 120, 70]
--[97, 120, 75]
--[98, 120, 80]
--[99, 120, 85]
--[100, 120, 90] -> 2
--[100, 120, 95]
--[100, 120, 100] -> 1

main:: IO()
main = do
    print [fst prog + speed | prog <- zip [93, 30, 55] [0..],
       let speed = [1, 30, 5] !! snd prog]
    print $ doDay [93, 30, 55] [1,30,5] []
    print $ solution2 [93,30,55] [1,30,5]

doDay::[Int]->[Int]->[Int]->[Int]
doDay [] [] acc = reverse acc
doDay p s acc = let dt = map (\(a,b)->a+b) (zip p s)
                    finCnt = length $ takeWhile (>=100) dt
                in
                  if finCnt == 0
                  then doDay dt s acc
                  else doDay (drop finCnt dt) (drop finCnt s) (finCnt:acc)

solution2::[Int]->[Int]->[Int]
solution2 p s = let dt = map (\(a,b)-> ceiling ((realToFrac (100 - a)) / (realToFrac b))) (zip p s)
                in map (\a -> length a) $ groupBy (\a b -> a >= b) dt
