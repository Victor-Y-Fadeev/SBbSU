degrees :: Int -> [Int]
degrees n = [ 2 ^ i | i <- [0..n]]
