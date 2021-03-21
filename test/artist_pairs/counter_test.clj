(ns artist-pairs.counter-test
  (:require [clojure.test :refer [deftest is]]
            [artist-pairs.counter :as sut]))

(deftest count-pairs-for-artist-correctly-adds-new-pairs
  (let [expected {"Black Byrd,Claude Debussy" 1
                  "Black Byrd,The Beatles"    1}]
    (->> ["Claude Debussy" "The Beatles"]
         (sut/count-pairs-for-artist {} "Black Byrd")
         (= expected)
         is)))

(deftest count-pairs-for-artist-correctly-increments-pair-count
  (let [counts {"Black Byrd,Claude Debussy" 1}
        expected {"Black Byrd,Claude Debussy" 2
                  "Black Byrd,The Beatles"    1}]
    (->> ["Claude Debussy" "The Beatles"]
         (sut/count-pairs-for-artist counts "Black Byrd")
         (= expected)
         is)))

(deftest count-pairs-in-line-returns-correctly-adds-new-pairs
  (let [expected {"Black Byrd,Claude Debussy"   1
                  "Black Byrd,The Beatles"      1
                  "Claude Debussy,The Beatles"  1}]
    (->> "Black Byrd,Claude Debussy,The Beatles"
         (sut/count-pairs-in-line {})
         (= expected)
         is)))

(deftest count-pairs-in-line-returns-correctly-increments-pair-count
  (let [counts {"Black Byrd,Claude Debussy"   1
                "Black Byrd,The Beatles"      2
                "Claude Debussy,The Beatles"  3}
        expected {"Black Byrd,Claude Debussy"   2
                  "Black Byrd,The Beatles"      3
                  "Claude Debussy,The Beatles"  4}]
    (->> "Black Byrd,Claude Debussy,The Beatles"
         (sut/count-pairs-in-line counts)
         (= expected)
         is)))
