--let f g l = List.map g (List.tail l)
let f g = List.map g . (List.tail)
