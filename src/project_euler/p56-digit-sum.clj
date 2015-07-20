;; Problem 56

(ns project_euler.p56-digit-sum
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn get-digit-sum
  [n]
  (apply + (map (fn [ch] (read-string (str ch))) (str n)))
 )

(apply max (for [a (range 1 100) b (range 1 100)]
  (get-digit-sum (expt a b))
 ))


