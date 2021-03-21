(ns artist-pairs.counter
  (:require [clojure.java.io :refer [reader]]
            [clojure.string :refer [split]]))

(defn count-pairs-for-artist [counts artist later-artists]
  (reduce (fn [counts later-artist]
            (let [pair (str artist "," later-artist)]
              (if (contains? counts pair)
                (update counts pair inc)
                (assoc counts pair 1))))
          counts
          later-artists))

(defn count-pairs-in-line [counts line]
  (let [artists (-> line (split #",") sort vec)]
    (reduce-kv (fn [counts index artist]
                 (count-pairs-for-artist counts
                                         artist
                                         (subvec artists (inc index))))
               counts
               artists)))

(defn count-pairs [path]
  (with-open [contents (reader path)]
    (->> contents
         line-seq
         (reduce count-pairs-in-line {}))))
