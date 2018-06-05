import Data.List
import Data.Ord

maxPosition :: [Int] -> Int
maxPosition (x:xs:xss) = fst (maximumBy (comparing snd) (reverse (zip [2..] (zipWith (+) (x : xs : xss) xss))))
