;; Problem 48

(ns project_euler.p48-self-squares
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn get-self-square-sum
  [n]
  (apply + (map (fn [x] (expt x x)) (range 1 n)))
 )

(let [number-string (str (get-self-square-sum 1001))
      num-length (count number-string)]
  (subs number-string (- num-length 10)))
