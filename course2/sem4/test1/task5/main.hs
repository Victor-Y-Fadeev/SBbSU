import System.Random
import Data.Tree

nextRandom :: Int -> IO Int
nextRandom last = do
    n  <- randomRIO (0, 1000)
    return (last + n)

randomizeIO :: Tree a -> IO (Tree Int)
randomizeIO tree = do
    pair <- randomizeTree tree 0 
    return (fst pair)    
    where
        randomizeTree (Node { subForest = forest }) num = do
            n <- nextRandom num
            f <- randomizeForest forest n
            return (Node { rootLabel = n, subForest = fst f }, snd f)
        randomizeForest [] num = return ([], num)
        randomizeForest (x:xs) num = do
            tree <- randomizeTree x num
            forest <- randomizeForest xs (snd tree)
            return ((fst tree):(fst forest), snd forest)

showTree :: IO (Tree Int) -> IO ()
showTree tree = do
    t <- tree
    putStr (drawTree (fmap show t))
