import Data.Tree

search :: Tree a -> [a]
search tree = concatMap (snd) (takeWhile (\(t, _) -> not (null t)) (iterate (\(t, _) -> (concatMap (subForest) t, (map (rootLabel) t))) ([tree], [])))
