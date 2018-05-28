listSum :: [Int] -> [Int] -> [Int] -> [Int]
listSum [] [] [] = []
listSum a b c = (((head' a) + (head' b) + (head' c)) : (listSum (tail' a) (tail' b) (tail' c))) where
    head' [] = 0
    head' list = head list
    tail' [] = []
    tail' list = tail list
