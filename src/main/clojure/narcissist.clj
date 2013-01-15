(ns narcissist)

(defn narcissistic? [n]
  (let [digits (map #(Integer/parseInt (str %)) (str n))
        digit-count (count digits)]
    (= n (int (reduce + (map #(Math/pow % digit-count) digits))))
    )
  )

(println (narcissistic? 1))
(println (narcissistic? 22))
(println (narcissistic? 153))

(println (take 25 (filter narcissistic? (range))))
