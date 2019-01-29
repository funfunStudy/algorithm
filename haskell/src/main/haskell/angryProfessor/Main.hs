module Main where

main:: IO ()
main = do
  check
  putStrLn $ show "Hello??"

checkNum :: Num a => [a] -> Int -> Bool
checkNum [] _ = False
checkNum xs limit = let x = length $ filter (\ x -> x >= 0) xs in x > limit