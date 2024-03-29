(ns autumn-equinox)

(defn julian [year month day hour minute second]
  (let [a (quot (- 14 month) 12)
        y (+ year 4800 (- a))
        m (+ month (* 12 a) -3)]
    (+ day (/ hour 24.0) (/ minute 24.0 60.0) (/ second 24.0 60.0 60.0)
      (quot (+ (* 153 m) 2) 5)
      (* 365 y)
      (quot y 4)
      (- (quot y 100))
      (quot y 400)
      (- 32045))))

(defn gregorian [julian]
  (let [j (Math/floor julian)
        hms (* (- julian j) 24 60 60)
        hour (int (Math/floor (/ hms 60 60)))
        hms (- hms (* hour 60 60))
        minute (int (Math/floor (/ hms 60)))
        second (- hms (* minute 60))
        j (+ j 32044)
        g (quot j 146097)
        dg (mod j 146097)
        c (quot (* (+ (quot dg 36524) 1) 3) 4)
        dc (- dg (* c 36524))
        b (quot dc 1461)
        db (mod dc 1461)
        a (quot (* (+ (quot db 365) 1) 3) 4)
        da (- db (* a 365))
        y (+ (* g 400) (* c 100) (* b 4) a)
        m (- (quot (+ (* da 5) 308) 153) 2)
        d (+ da (- (quot (* (+ m 4) 153) 5)) 122)
        year (int (+ y (- 4800) (quot (+ m 2) 12)))
        month (int (+ (mod (+ m 2) 12) 1))
        day (int (+ d 1))]
    (list year month day hour minute second)))

(println (julian 2012 10 17 10 20 0))
(println (gregorian (julian 2012 10 17 10 20 0)))
