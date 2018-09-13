module Expression where

data Term = Term {
    coefficient :: Float,
    power       :: Int
} deriving (Show, Eq)

data Expression = Expression {
    expression  :: [Term]
}

addToExpression :: Expression -> Term -> Expression
addToExpression e t = Expression { expression = (add (expression e) t) } where
    add [] t = [t]
    add l (Term { coefficient = 0 }) = l
    add (x:xs) t
        | (power x) < (power t)     = x:(add xs t)
        | (power x) == (power t)    = if ((coefficient x) + (coefficient t)) /= 0 then (x { coefficient = (coefficient x) + (coefficient t) }):xs else xs
        | (power x) > (power t)     = t:x:xs

instance Show Expression where
    show (Expression []) = show "0"
    show (Expression (x:xs)) = show ((firstSign x) ++ (toString x) ++ (concatMap (\t -> (showSign t) ++ (toString t)) xs)) where
        firstSign t = if (coefficient t) < 0 then "- " else ""
        showSign t = if (coefficient t) < 0 then " - " else " + "
        toString (Term { coefficient = c, power = p })
            | p <= 0            = (show (abs(c))) ++ (showPower "" p)
            | p > 0 && c == 1   = "x" ++ (showPower "" (p - 1))
            | otherwise         = (show (abs(c))) ++ (showPower "" p)
        showPower s 0 = s
        showPower s p = if p > 0 then (showPower (s ++ " * x") (p - 1)) else (showPower (s ++ " / x") (p + 1))
