digitSum :: Int -> Int
digitSum x = digitSum' 0 (abs x) where
    digitSum' x 0 = x
    digitSum' x y = digitSum' (x  + mod y 10) (div y 10)
