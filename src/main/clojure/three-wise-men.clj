(ns three-wise-men)

(println
  (filter #(= (apply * %) 65520000)
    (for [x (range 1 6551)
          y (range 1 (- 6550 x))
          :while (> (- 6552 x y) x y)]
      [x y (- 6552 x y)])))
