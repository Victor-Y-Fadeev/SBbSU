decomposition :: Int -> [[Int]]
decomposition k = decomposition' k k where
    decomposition' 0 _ = [[]]
    decomposition' n m
        | n < m     = decomposition' n n
        | otherwise = concatMap (\i -> map (\j -> [i] ++ j) (decomposition' (n - i) i)) [m, (m - 1)..1]

toDisplay :: Int -> IO ()
toDisplay n = putStrLn (concatMap (\(x:xs) -> (show n) ++ " = " ++ (show x) ++ (concatMap (\i -> " + " ++ (show i)) xs) ++ "\n") (decomposition n))
