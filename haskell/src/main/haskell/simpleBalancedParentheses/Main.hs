module Main where

main :: IO ()
main = do
    line <- getLine
    putStrLn $ if checkBalance line 0 then "TRUE" else "FALSE"

checkBalance :: String -> Int -> Bool
checkBalance [] n = 0 == n
checkBalance [x] n = if 0 > n then False else True
checkBalance (x:xs) n
    | x == '(' = checkBalance xs (n + 1)
    | otherwise = checkBalance xs (n - 1)