module Main where

-- 어떤 아이가 n개의 계단을 오른다. 한 번에 1계단 오르기도 하고, 2계단이나 3계단을 오르기도 한다. 계단을 오르는 방법이 몇 가지가 있는지 계산하는 메서드를 구현하라. (추가로, 시간복잡도는 얼마인지 생각해보자)
-- f(N) = f(N - 1) + f(N - 2) + f(N - 3)

solution :: Int -> Int
solution 0 = 1
solution 1 = 1
solution n = solution(n - 1) + solution(n - 2) + solution(n - 3)

main :: IO()
main = do
--  print "Hello"
  print $ solution(6)
