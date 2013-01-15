(ns tonelli-shanks)

(defn express-as-power-of-two [p]
  (loop [e 0
         s (dec p)]
    (if (even? s)
      (recur (inc e) (/ s 2))
      [s e])))

(println (express-as-power-of-two 113))

(defn modulo-pow [n e m]
  (loop [n' n
         e' e
         rv 1]
    (cond
      (zero? e')
        rv
      (odd? e')
        (recur (rem (* n' n') m) (quot e' 2) (rem (* rv n') m))
      :else
        (recur (rem (* n' n') m) (quot e' 2) rv))))

(println (modulo-pow 3 0 80))
(println (modulo-pow 3 1 80))
(println (modulo-pow 3 2 80))
(println (modulo-pow 3 3 80))
(println (modulo-pow 3 4 80))
(println (modulo-pow 3 5 80))

(defn find-minimum-congruency [p]
  (loop [n 2]
    (if (= (dec p) (modulo-pow n (/ (dec p) 2) p))
      n
      (recur (inc n)))))

(println (find-minimum-congruency 113))

(defn big-power [n e]
  (.pow (BigInteger. (str n)) e)
  )

(println (big-power 2 45))

(defn find-minimum-congruency-2 [b p]
  (loop [m 0]
    (if (= 1 (modulo-pow b (big-power 2 m) p))
      m
      (recur (inc m)))))

(println (find-minimum-congruency-2 15 113))

(defn modular-square-root [a p]
  (let [[s e] (express-as-power-of-two p)
        n (find-minimum-congruency p)]
    (loop [x (modulo-pow a (/ (inc s) 2) p)
           b (modulo-pow a s p)
           g (modulo-pow n s p)
           r e]
      (let [m (find-minimum-congruency-2 b p)]
        (if (zero? m)
          x
          (recur (rem (* x (modulo-pow g (big-power 2 (- r m 1)) p)) p)
                 (rem (* b (modulo-pow g (big-power 2 (- r m)) p)) p)
                 (modulo-pow g (big-power 2 (- r m)) p)
                 m))
        )
      )
    )
  )

(println (modular-square-root 2 113))
(println (modular-square-root 5 40961))
