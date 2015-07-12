;; Problem 9

(ns project_euler.p9-special-pythagorean-triplet.clj
  (:require [clojure.math.combinatorics :refer [selections]]))

(defn is-special-triplet?
  [[a b c]]
  (and (= (+ (Math/pow a 2) (Math/pow b 2)) (Math/pow c 2)) (= 1000 (+ a b c)))
 )

(first (for [[a b c] (filter is-special-triplet? (selections (range 1 1000) 3))
      :when (= 1000 (+ a b c))]
  (* a b c)))


