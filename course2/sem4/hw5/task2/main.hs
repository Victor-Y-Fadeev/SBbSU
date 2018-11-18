multiplication :: Int -> [Int]
multiplication n = [1..n] >>= (\i -> [1..n] >>= (\j -> [i * j]))
