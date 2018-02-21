module Main where

main :: IO ()
main = do
  print $ check 5 5 0
  print $ check 4 5 0
  print $ check 6 4 0


check :: Int -> Int -> Int -> Int
check a b acc = if a > b then (if 0 == acc then acc else acc + 3) else check (a + 1) b (acc + 1)
