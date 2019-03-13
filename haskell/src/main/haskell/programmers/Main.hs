module Main where

solution :: [Int] -> [Int] -> [Int]
solution p s = innerSolution (zip p s) []

innerSolution :: [(Int, Int)] -> [Int] -> [Int]
innerSolution [] acc = reverse acc
innerSolution ps acc
  | 0 < finishCount = innerSolution (drop finishCount ps) (finishCount:acc)
  | otherwise       = innerSolution (oneDay ps) acc
  where finishCount = length $ takeWhile (\x -> fst x >= 100) ps

oneDay :: [(Int, Int)] -> [(Int, Int)]
oneDay list = map up list
  where up = \t -> (fst t + snd t, snd t)

main :: IO()
main = do
  print $ solution [93, 30, 55] [1, 30, 5]
