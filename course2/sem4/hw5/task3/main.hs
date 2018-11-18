import Control.Monad

neighbor :: [Int] -> Maybe Int
neighbor [_, _] = Nothing
neighbor (x:xs:xss:xsss) = mplus (if ((x < xs) && (xs > xss)) then (Just xs) else Nothing) (neighbor (xs:xss:xsss))
