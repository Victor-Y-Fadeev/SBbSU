fibonacci :: Integer -> Integer
fibonacci n = fibonacci' n 1 0 where
    fibonacci' n prev curr
        | n == 0 = curr
        | n > 0  = fibonacci' (n - 1) curr (prev + curr)
        | n < 0  = fibonacci' (n + 1) curr (prev - curr)
