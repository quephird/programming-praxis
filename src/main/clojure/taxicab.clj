(ns taxicab)

(defn sum-of-cubes [a b]
  (+ (* a a a) (* b b b)))

(defn approximate-cube-root [n]
  (int (Math/ceil (Math/pow n (/ 1 3)))))

(defn sum-of-cubes-pairs [n]
  (filter #(= n (sum-of-cubes (first %) (second %)))
    (for [a (range (approximate-cube-root (/ n 2)) (approximate-cube-root n))]
      [a (approximate-cube-root (- n (* a a a)))])))

(defn taxicab-number? [n e]
  (= e (count (sum-of-cubes-pairs n)))
  )

(println (sum-of-cubes-pairs 2))
(println (sum-of-cubes-pairs 3))
(println (sum-of-cubes-pairs 9))
(println (sum-of-cubes-pairs 1729))
(println (sum-of-cubes-pairs 87539319))
(println (sum-of-cubes-pairs 6963472309248))
(println (sum-of-cubes-pairs 15170835645))

(println (filter #(taxicab-number? % 2) (range 1 100000)))
