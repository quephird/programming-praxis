; Solution to http://programmingpraxis.com/2012/10/19/

(ns prime-partitions)

; The next two function implementations are really hacky,
; but I thought this was part of the challenge of the exercise.
(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    (= n 3) true
    (zero?
      (count
        (filter (comp not ratio?) (map #(/ n %) (filter #(> % 1) (range (inc (Math/round (Math/sqrt n))))))))) true
    :else false)
  )

(defn prime-factors [n]
  (filter #(not (ratio? (/ n %))) (filter prime? (drop 2 (range (inc n)))))
  )

(defn- sopf [n]
  (reduce + (prime-factors n))
  )

(def sopf (memoize sopf))

; The "primed"  versions of +, -, and * are used below to autopromote
; ints to BigIntegers; not doing so eventually results in a ArithmeticException
; integer overflow error.
(defn- kappa [n]
  (if (< n 2)
    0
    (/ (+' (sopf n) (reduce +' (map #(*' (sopf %) (#'kappa (-' n %))) (drop 1 (range n))))) n))
  )

(def kappa (memoize kappa))

; This is a bit hackish but the strategy here is to "pump" initial values of
; kappa(n) into the cache that memoize maintains; attempting to immediately
; evaluate kappa(1000) results in a StackOverflowError.
(doseq [i (drop 2 (range 1001))]
  (if (= i 1000)
    (println (kappa i))
    (kappa i)))
