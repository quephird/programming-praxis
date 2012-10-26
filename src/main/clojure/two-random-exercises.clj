(ns two-random-exercises)

(defn rand3 []
  (inc (rand-int 3)))

(defn rand9 []
  (let [a (rand3)
        b (* 3 (rand3))]
    (+ a b -3))
  )

(defn rand5 []
  (inc (rand-int 5)))

(defn rand7 []
  (let [a (rand5)
        b (* 5 (rand5))
        c (+ a b)]
    (if (< c 27)
      (inc (mod c 7))
      (rand7)))
  )

(println (frequencies (take 100000 (repeatedly rand9))))
(println (frequencies (take 100000 (repeatedly rand7))))

