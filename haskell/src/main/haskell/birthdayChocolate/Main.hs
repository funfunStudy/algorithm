module Main where

solution::[Int] -> Int -> Int -> Int -> Int
solution l sm p r = if length l < p
                    then r
                    else
                      if (sum $ take p l) == sm
                      then solution (drop 1 l) sm p (r + 1)
                      else solution (drop 1 l) sm p r

solution2::[Int] -> Int -> Int -> Int -> Int
solution2 list@(_:xs) sm p r =
                    if length list < p
                    then r
                    else
                      if (sum $ take p list) == sm
                      then solution xs sm p (r + 1)
                      else solution xs sm p r

main :: IO ()
main = do
  putStrLn $ show (solution [1, 2, 1, 3, 2] 3 2 0)
  putStrLn $ show (solution2 [1, 2, 1, 3, 2] 3 2 0)


-- tailrec fun result(list: List<Int>, result: Int) : Int {
--   if(list.size > itemCnt){
--     if(list.take(itemCnt).sum == result){
--       result(list.drop(itemCnt), result +1)
--     } else {
--       result(list.drop(itemCnt), result)
--     }
--   } else {
--     result
--   }
-- }:


