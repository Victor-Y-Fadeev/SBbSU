crossLine :: Int -> Int -> Int -> String
crossLine n line num
    | num > n                          = ""
    | line == num || line == (n - num) = 'X' : crossLine n line (num + 1)
    | otherwise                        = ' ' : crossLine n line (num + 1)

cross :: Int -> IO ()
cross n = cross' n 0 where
    cross' n m
        | m > n     = return ()
        | otherwise = do
            putStrLn (crossLine n m 0)
            cross' n (m + 1)
