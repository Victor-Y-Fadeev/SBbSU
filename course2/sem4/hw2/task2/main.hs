degrees :: Int -> [Int]
degrees n = [ 2 ^ x | x <- [0..n]]
