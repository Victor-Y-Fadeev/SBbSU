evenNumbers :: [Int] -> Int
evenNumbers list = foldr (+) 0 (map (flip mod 2) list)

evenNumbers' :: [Int] -> Int
evenNumbers' list = length (filter even list)

evenNumbers'' :: [Int] -> Int
evenNumbers'' list = foldr (\x y -> x + (flip mod 2 y)) 0 (list)
