(ns zeckendorf)

(defn fibonacci [n]
  (cond
    (= 0 n) 0
    (= 1 n) 1
    :else (+ (fibonacci (- n 1))
             (fibonacci (- n 2))))
  )

(defn largest-fib-lte [n]
  (last (take-while #(<= % n) (map fibonacci (range))))
  )

(defn zeckendorf [n]
  (let [f (largest-fib-lte n)]
    (if (= f n)
      (list f)
      (concat (list f) (zeckendorf (- n f)))))
  )

(println (zeckendorf 1000))
(println (zeckendorf 100))
(println (zeckendorf 13))
