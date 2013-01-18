(ns csv-to-html
  (:use [clojure.string])
  (:import (java.io BufferedReader FileReader))
  )

(defn load-file [csv-file]
  (with-open [fr (FileReader. "data.csv")
              br (BufferedReader. fr)]
    (->> br
      line-seq
      doall
      )
    )
  )

(defn to-tds [line]
  (let [cells (split line #",")]
    (interleave
      (repeat (count cells) "<td>")
      cells
      (repeat (count cells) "</td>"))
    )
  )

(defn to-trs [line]
  (list "<tr>" line "</tr>")
  )

(defn to-table [lines]
  (list "<table>" lines "</table>")
  )

(defn to-html [csv-file]
  (let [data (load-file csv-file)]
    (->> data
      (map to-tds)
      (map to-trs)
      to-table
      flatten
      (apply str)
      )
    )
  )

(println (to-html "data.csv"))

