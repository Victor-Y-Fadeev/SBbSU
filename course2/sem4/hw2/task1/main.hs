reverse :: [a] -> [a]
reverse list = reverse' [] list where
    reverse' list [] = list
    reverse' list (x:xs) = reverse' (x : list) xs
