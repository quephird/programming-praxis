(ns pandigital-sums)

(defn- permutations [l]
  (if (empty? l)
    (list l)
    (apply concat
      (for [idx (range (count l))]
        (map #(conj % (l idx)) (permutations (into [] (concat (subvec l 0 idx) (subvec l (inc idx) (count l))))))))
    )
  )

(println (permutations []))
(println (permutations [1]))
(println (permutations [1 2 3 4]))

(defn- pandigital-sum? [l]
  (if (or
        (zero? (first l))
        (zero? (nth l 3))
        (zero? (nth l 6)))
    false
    (let [a (Integer/parseInt (apply str (map str (take 3 l))))
          b (Integer/parseInt (apply str (map str (take 3 (drop 3 l)))))
          c (Integer/parseInt (apply str (map str (take 4 (drop 6 l)))))]
      (= (+ a b) c))
    )
  )

(println (pandigital-sum? [1 2 3 4 5 6 7 8 9 0]))

(filter pandigital-sum? (permutations [1 2 3 4 5 6 7 8 9 0]))
