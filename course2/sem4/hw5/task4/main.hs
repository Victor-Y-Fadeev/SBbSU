import Expression
import Parser

differentiate :: Expression -> Expression
differentiate e = Expression { expression = (differentiate' (expression e)) } where
    differentiate' [] = []
    differentiate' (x:xs)
        | (power x) == 0    = differentiate' xs
        | otherwise         = [(Term { coefficient = ((coefficient x) * (fromIntegral (power x))), power = ((power x) - 1) })] ++ (differentiate' xs)

main :: IO ()
main = getLine >>= putStrLn . show . differentiate . parser
