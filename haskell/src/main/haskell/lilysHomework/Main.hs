module Main where

minIdx :: [Int] -> Int -> Int
minIdx (x:[]) idx = idx
minIdx (x:xs) idx = if x < minimum xs then idx else (minIdx xs (idx + 1))

maxIdx :: [Int] -> Int -> Int
maxIdx (x:[]) idx = idx
maxIdx (x:xs) idx = if x > maximum xs then idx else (maxIdx xs (idx + 1))

swap :: [Int] -> Int -> [Int]
swap [] _ = []
swap (x:xs) 0 = xs
swap (x:xs) a = take (a-1) xs ++ [x] ++ drop a xs

solutionMin :: [Int] -> Int -> Int
solutionMin [] a = a
solutionMin l a = let min = minIdx l 0; cnt = if min > 0 then a + 1 else a in solutionMin (swap l min) cnt

solutionMax :: [Int] -> Int -> Int
solutionMax [] a = a
solutionMax l a = let max = maxIdx l 0; cnt = if max > 0 then a + 1 else a in solutionMax (swap l max) cnt

solution :: [Int] -> Int
solution [] = 0
solution l = minimum ((solutionMin l 0):(solutionMax l 0):[])

--isSorted :: (Int -> Int -> Bool) -> [Int] -> Bool
--isSorted f [] = True
--isSorted f (_:[]) = True
--isSorted f (x:y:xs) = (f x y) && isSorted f (y:xs)

--isDecSorted xs = isSorted (<) xs
--isAscSorted xs = isSorted (>) xs

main :: IO ()
main = do
  print $ minIdx [3, 2, 4] 0
  print $ minIdx [1, 2, 3] 0
  print $ minIdx [5, 3, 2] 0
  print $ swap [3,5,2,6,1] 0
  print $ swap [3,5,2,6,1] 1
  print $ swap [3,5,2,6,1] 2
  print $ swap [3,5,2,6,1] 3
  print $ swap [3,5,2,6,1] 4
--  print $ isDecSorted [3,5,2,6,1]
--  print $ isDecSorted [1,2,3,4]
--  print $ isAscSorted [3,5,2,6,1]
--  print $ isAscSorted [4,3,2,1]
--  print $ isAscSorted [1,2,3,4]
  print $ maxIdx [3,5,2,6,1] 0
  print $ solutionMin [3,5,2,6,1] 0
  print $ solutionMax [3,5,2,6,1] 0
  print $ solution [3,5,2,6,1]