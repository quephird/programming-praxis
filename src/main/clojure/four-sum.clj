(ns four-sum)

(defn four-sum [l]
  (set
    (map #(sort > %)
      (for [l1 l l2 l l3 l l4 l :when (zero? (+ l1 l2 l3 l4))]
        [l1 l2 l3 l4])))
  )

(println (four-sum  [2 3 1 0 -4 -1]))

