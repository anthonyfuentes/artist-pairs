(ns artist-pairs.csv-writer
  (:require [clojure.java.io :refer [writer]]
            [clojure.data.csv :refer [write-csv]]))

(defn write-pairs [path pairs]
  (with-open [output (writer path)]
    (write-csv output pairs)))
