(ns fractran)

(def primegame [17/91 78/85 19/51 23/38 29/33 77/29 95/23 77/19 1/17 11/13 13/11 15/14 15/2 55/1])

(defn run [p n]
  (lazy-seq
    (when-let [new-n (first (filter #(not (ratio? %)) (map #(* n %) p)))]
      (if (nil? new-n)
        (list new-n)
        (cons new-n (run p new-n)))))
  )

(defn power-of-two [n]
  (loop [tmp n retval 0]
    (cond
      (= 1 tmp) retval
      (ratio? tmp) nil
      :else (recur (/ tmp 2) (inc retval))))
  )

(def primes (filter #(not (nil? %)) (map power-of-two (run primegame 2))))

(println (take 20 (run primegame 2)))
(println (take 15 primes))

