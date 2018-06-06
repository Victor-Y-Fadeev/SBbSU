import System.Random
import Data.Tree

randomize :: Tree a -> (Tree Int, Int)
randomize tree = randomizeTree tree 0 where
    randomizeTree (Node { rootLabel = r, subForest = f }) n = (Node { rootLabel = n, subForest = fst (randomizeForest f (n + 1)) }, snd (randomizeForest f (n + 1)))
    randomizeForest [] n = ([], n)
    randomizeForest (x:xs) n = ((fst (randomizeTree x n)):(fst (randomizeForest xs (snd (randomizeTree x n)))), snd (randomizeForest xs (snd (randomizeTree x n))))

randomList :: Int -> IO [(Int, Int)]
randomList 0 = return []
randomList n = do
    x  <- randomRIO (0, 1000)
    xs <- randomList' (n - 1) 1 x
    return ((0, x):xs)
    where
        randomList' 0 _ _ = return []
        randomList' n i last = do
            x  <- randomRIO (0, 1000)
            xs <- randomList' (n - 1) (i + 1) (x + last)
            return ((i, x + last):xs)
