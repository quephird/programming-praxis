(ns two-word-games.two-word-games)

(def vowels "aeiou")

(defn vowel? [c]
  (contains? (set vowels) c))

(defn contains-exactly-five-vowels? [w]
  (= vowels (apply str (filter vowel? (seq w))))
  )

(defn letters-in-ascending-order? [w]
  (and
    (> (count (seq w)) 5)
    (= w (apply str (sort (seq w)))))
  )

(defn find-words [filename predicate]
  (with-open [rdr (clojure.java.io/reader filename)]
    (let [lines (line-seq rdr)]
      (doall (filter predicate lines)))
    )
  )

(println (find-words "single.txt" contains-exactly-five-vowels?))
(println (find-words "single.txt" letters-in-ascending-order?))
