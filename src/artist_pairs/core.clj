(ns artist-pairs.core
  (:require [artist-pairs.counter :refer [count-pairs]]
            [artist-pairs.csv-writer :refer [write-pairs]]))

(defn -main [input-path output-path]
  (->> input-path
       count-pairs
       (filter (fn [[pair appearances]] (> appearances 49)))
       (write-pairs output-path)))
