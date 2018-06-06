--let f g l = List.map g (List.tail l)
--let f g = List.map g . (List.tail)
let f = List.map . List.tail
