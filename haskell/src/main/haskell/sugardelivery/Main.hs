module Main where

main :: IO ()
main = do
  print $ solve (62 `div` 5) (62 `mod` 5)
  print $ solve (18 `div` 5) (18 `mod` 5)
  print $ solve (4 `div` 5) (4 `mod` 5)
  print $ solve (6 `div` 5) (6 `mod` 5)
  print $ solve (9 `div` 5) (9 `mod` 5)
  print $ solve (11 `div` 5) (11 `mod` 5)

solve :: (Integral a) => a -> a -> a
solve x _
    | -1 == x = -1
solve x r = if 0 == r `mod` 3 then r `div` 3 + x else solve (x-1) (r+5)