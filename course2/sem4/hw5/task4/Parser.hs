module Parser where

import Expression

parser :: String -> Expression
parser (' ':xs) = parser xs
parser (x:xs)
    | x == '+'              = parseNumerator xs (Expression { expression = [] }) (Term { coefficient = 1, power = 0 })
    | x == '-'              = parseNumerator xs (Expression { expression = [] }) (Term { coefficient = -1, power = 0 })
    | x == 'x' || x == 'X'  = parseNumerator xs (Expression { expression = [] }) (Term { coefficient = 1, power = 1 })
    | x >= '0' && x <= '9'  = multiplyNumber (x:xs) (Expression { expression = [] }) (Term { coefficient = 1, power = 0 }) 0
    | otherwise             = Expression { expression = [] }
    where
        multiplyNumber [] l t n     = multiplyNumber [' '] l t n
        multiplyNumber (x:xs) l t n
            | x >= '0' && x <= '9'  = multiplyNumber xs l t (n * 10 + (fromEnum x) - (fromEnum '0'))
            | x == '.'              = multiplyFraction xs l t n 1
            | otherwise             = parseNumerator (x:xs) l (t { coefficient = ((coefficient t) * (fromIntegral n)) })

        multiplyFraction [] l t n f = multiplyFraction [' '] l t n f
        multiplyFraction (x:xs) l t n f
            | x >= '0' && x <= '9'  = multiplyFraction xs l t (n * 10 + (fromEnum x) - (fromEnum '0')) (f * 10)
            | otherwise             = parseNumerator (x:xs) l (t { coefficient = ((coefficient t) * (fromIntegral n) / f) })

        parseNumerator [] l t = addToExpression l t
        parseNumerator (x:xs) l t
            | x == ' ' || x == '*'  = parseNumerator xs l t
            | x == '/'              = parseDenominator xs l t
            | x == '+'              = parseNumerator xs (addToExpression l t) (Term { coefficient = 1, power = 0 })
            | x == '-'              = parseNumerator xs (addToExpression l t) (Term { coefficient = -1, power = 0 })
            | x == 'x' || x == 'X'  = parseNumerator xs l (t { power = ((power t) + 1) })
            | x >= '0' && x <= '9'  = multiplyNumber (x:xs) l t 0
            | otherwise             = Expression { expression = [] }

        divideNumber [] l t n       = divideNumber [' '] l t n
        divideNumber (x:xs) l t n
            | x >= '0' && x <= '9'  = divideNumber xs l t (n * 10 + (fromEnum x) - (fromEnum '0'))
            | x == '.'              = divideFraction xs l t n 1
            | otherwise             = parseNumerator (x:xs) l (t { coefficient = ((coefficient t) / (fromIntegral n)) })

        divideFraction [] l t n f   = divideFraction [' '] l t n f
        divideFraction (x:xs) l t n f
            | x >= '0' && x <= '9'  = divideFraction xs l t (n * 10 + (fromEnum x) - (fromEnum '0')) (f * 10)
            | otherwise             = parseNumerator (x:xs) l (t { coefficient = ((coefficient t) / (fromIntegral n) * f) })

        parseDenominator [] l t     = parseNumerator [] l t
        parseDenominator (x:xs) l t
            | x == ' ' || x == '/'  = parseDenominator xs l t
            | x == 'x' || x == 'X'  = parseNumerator xs l (t { power = ((power t) - 1) })
            | x >= '0' && x <= '9'  = divideNumber (x:xs) l t 0
            | otherwise             = parseNumerator (x:xs) l t
