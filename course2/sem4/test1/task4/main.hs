add :: [(Int, Int)] -> (Int, Int) -> [(Int, Int)]
add [] pair = [pair]
add (x:xs) pair
    | (snd x) > (snd pair) = x : (add xs pair)
    | otherwise            = pair:x:xs

valueWithPriority :: [(Int, Int)] -> Int -> Maybe Int
valueWithPriority [] _ = Nothing
valueWithPriority (x:xs) priority
    | (snd x) == priority = (Just (fst x))
    | (snd x) > priority  = (valueWithPriority xs priority)
    | otherwise           = Nothing

queueMenu :: [(Int, Int)] -> IO ()
queueMenu queue = do
    putStrLn "0 - exit"
    putStrLn "1 - adding a value with a given priority"
    putStrLn "2 - get the value with the given priority"
    putStrLn "3 - get the value with the highest priority"
    putStrLn "4 - print the queue"
    
    command <- getLine
    case command of
        '0':_ -> return ()
        '1':_ -> do
            value <- getLine
            priority <- getLine
            queueMenu (add queue (read value, read priority))
        '2':_ -> do
            priority <- getLine
            print (valueWithPriority queue (read priority))
            queueMenu queue
        '3':_ -> do
            print (fst (head queue))
            queueMenu queue
        '4':_ -> do
            print queue
            queueMenu queue
        _:_ ->
            queueMenu queue

main :: IO ()
main = do
    queueMenu []
