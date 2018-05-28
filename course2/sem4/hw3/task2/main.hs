sequence :: [Int]
sequence = sequence179 sequence0 where
    sequence179 (x:xs) = (x * 10 + 1) :((x * 10 + 7) : ((x * 10 + 9) : (sequence179 xs)))
    sequence0 = 0 : sequenceFin
