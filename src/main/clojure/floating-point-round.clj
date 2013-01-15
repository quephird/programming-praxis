(ns floating-point-round)

(defn fpr [n decimal-places]
  (let [power-of-ten (Math/pow 10 decimal-places)
        tmp (* n power-of-ten)
        tmp2 (int tmp)
        test-digit (rem (int (* tmp 10)) 10)
        tmp3 (if (>= test-digit 5) (inc tmp2) tmp2)]
    (/ tmp3 power-of-ten))
  )

(println (fpr 123.456789 3))
(println (fpr 123.456489 3))
(println (fpr 123.456489 0))
(println (fpr 123.456489 -1))
