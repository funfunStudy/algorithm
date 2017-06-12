module Main where

main :: IO ()
main = do
    getLine
    interact (unlines . map hello . lines)

hello :: String -> String
hello = ("Hello, " ++) . (++ "!")