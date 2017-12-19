module Main where

main :: IO ()
main = do
    line <- getLine
    putStrLn $ if checkBalance line 0 then "TRUE" else "FALSE"

checkBalance :: String -> Int -> Bool
checkBalance [] n = 0 == n
checkBalance (x:xs) n
    | x == '(' = checkBalance xs (n + 1)
    | otherwise = checkBalance xs (n - 1)