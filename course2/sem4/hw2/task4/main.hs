inList :: Int -> [Int] -> Int
inList x list = snd (head (filter (\elem -> fst elem == x) (zip list [1..])))
