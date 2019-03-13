


zipStr :: String -> Char -> Int -> String
zipStr [] ch count = ch:[] ++ (show count)
zipStr (x:xs) ch count = if x == ch then zipStr xs ch (count+1) else ch:[] ++ (show count) ++ (zipStr (x:xs) x 0)

main :: IO()
main = do
  print $ zipStr "hello" 'h' 0