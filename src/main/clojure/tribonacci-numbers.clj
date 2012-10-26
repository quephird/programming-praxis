(ns tribonacci-numbers)

(defn tribonacci-iter [n]
  (cond
    (= 0 n) 0
    (= 1 n) 0
    (= 2 n) 1
    :else (+ (tribonacci-iter (- n 1))
             (tribonacci-iter (- n 2))
             (tribonacci-iter (- n 3))))
  )

(defn columns [m]
  (for [column-idx (range (count (first m)))]
    (map #(nth % column-idx) m)))

(defn matrix-multiply [m1 m2]
  (let [m2-columns (columns m2)]
    (for [m1-row m1]
      (for [m2-column m2-columns]
        (reduce + (map * m1-row m2-column)))))
  )

(defn matrix-power [m p]
  (if (= 1 p)
    m
    (matrix-multiply m (matrix-power m (dec p))))
  )

(def tribonacci-matrix
  [[1 1 0]
   [1 0 1]
   [1 0 0]])

(defn tribonacci-matrix-power [n]
  (cond
    (= 0 n) 0
    (= 1 n) 0
    :else (first (last (matrix-power tribonacci-matrix (dec n)))))
  )

(println (map tribonacci-iter (range 12)))
(println (map tribonacci-matrix-power (range 12)))

