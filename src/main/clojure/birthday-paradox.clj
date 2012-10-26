(ns birthday-paradox)

(defn- generate-random-birthdays [number-of-people number-of-trials]
  (for [_ (range number-of-trials)]
    (for [_ (range number-of-people)]
      (rand-int 365)))
  )

(defn- has-same-birthdays? [birthday-list]
  (> (count (filter #(> % 1) (map second (frequencies birthday-list)))) 0)
  )

(defn- percentage-same-birthdays [number-of-people number-of-trials]
  (let [results (map #(has-same-birthdays? %) (generate-random-birthdays number-of-people number-of-trials))]
    (float (/ (count (filter true? results)) (count results)))))

(println (percentage-same-birthdays 23 1000))
(println (percentage-same-birthdays 57 1000))




