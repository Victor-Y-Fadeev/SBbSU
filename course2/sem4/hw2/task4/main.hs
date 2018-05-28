inList :: Int -> [Int] -> Int
inLine x [] = (-1 / 0)
inList x (t:ts) | x == t    = 1
                | x /= t    = 1 + inList x ts
