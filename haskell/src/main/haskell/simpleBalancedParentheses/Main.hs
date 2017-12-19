module Main where

main :: IO ()
main = do
    line <- getLine
    putStrLn $ boolToString $ checkBalance line 0

checkBalance :: String -> Int -> Bool
checkBalance [] n = 0 == n
checkBalance (x:xs) n
    | x == '(' = checkBalance xs (n + 1)
    | otherwise = checkBalance xs (n - 1)

boolToString :: Bool -> String
boolToString True = "TRUE"
boolToString False = "FALSE"