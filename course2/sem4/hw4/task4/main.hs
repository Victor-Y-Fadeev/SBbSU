import Data.Map

add :: (Map String String) -> (String, String) -> (Map String String)
add book (name, phone) = insert phone name book

findByPhone :: (Map String String) -> String -> Maybe String
findByPhone book phone = Data.Map.lookup phone book

findByName :: (Map String String) -> String -> Maybe String
findByName book name = foldrWithKey (\phone current _ -> if (current == name) then (Just phone) else Nothing) Nothing book

save :: (Map String String) -> String
save book = concatMap (\(phone, name) -> phone ++ " " ++ name ++ "\n") (toList book)

load :: String -> (Map String String)
load str = (Prelude.foldl (add) (Data.Map.empty)) (Prelude.map (\str -> (head (tail (words str)), head (words str))) (lines str))

textMenu :: IO()
textMenu = do
    putStrLn "0 - exit"
    putStrLn "1 - add record (name and phone)"
    putStrLn "2 - find the phone by name"
    putStrLn "3 - find the name by phone"
    putStrLn "4 - save the current data to a file"
    putStrLn "5 - read data from file"

phonebook :: (Map String String) -> IO ()
phonebook book = do
    textMenu
    
    command <- getLine
    case command of
        '0':_ -> return ()
        '1':_ -> do
            name <- getLine
            phone <- getLine            
            phonebook (add book (name, phone))
        '2':_ -> do
            name <- getLine
            print (findByName book name)
            phonebook book
        '3':_ -> do
            phone <- getLine
            print (findByPhone book phone)
            phonebook book
        '4':_ -> do
            filename <- getLine
            writeFile filename (save book)
            phonebook book
        '5':_ -> do
            filename <- getLine
            str <- readFile filename
            phonebook (load str)
        _:_ ->
            phonebook book

main :: IO ()
main = do
    phonebook (Data.Map.empty)
