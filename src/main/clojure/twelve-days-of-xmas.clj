(ns twelve-days-of-xmas)

; Brute force
(defn gifts [n]
  (apply +
    (map #(apply + (range 1 (inc %))) (range 1 (inc n))))
  )

(println (gifts 12))

; Mathematical formula
(defn gifts2 [n]
  (/ (* n (+ n 1) (+ n 2)) 6)
  )

(println (gifts2 12))

