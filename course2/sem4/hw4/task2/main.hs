add :: [Int] -> Int -> [Int]
add [] n = [n]
add (x:xs) n
    | x < n     = x : (add xs n)
    | otherwise = n:x:xs

remove :: [Int] -> Int -> [Int]
remove [] _ = []
remove (x:xs) n
    | x == n = xs
    | x < n  = x:(remove xs n)
    | x > n  = x:xs

listMenu :: [Int] -> IO ()
listMenu list = do
    putStrLn "0 - exit"
    putStrLn "1 - add value to sorted list"
    putStrLn "2 - remove value from list"
    putStrLn "3 - print list"
    
    command <- getLine
    case command of
        '0':_ -> return ()
        '1':_ -> do
            value <- getLine
            listMenu (add list (read value))
        '2':_ -> do
            value <- getLine
            listMenu (remove list (read value))
        '3':_ -> do
            print list
            listMenu list
        _:_ ->
            listMenu list

main :: IO ()
main = do
    listMenu []
