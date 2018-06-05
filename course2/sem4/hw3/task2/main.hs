order :: [Int]
order = 1 : 7 : 9 : (concatMap order179 order) where
    order179 x = [x * 10 + 1, x * 10 + 7, x * 10 + 9]
