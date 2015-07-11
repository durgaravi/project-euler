;; Problem 21

(ns project_euler.p21-amicable-nos
  (:require [clojure.math.combinatorics :refer [combinations]])
)

(defn get-divisors [n]
  (filter (fn [x] (zero? (mod n x))) (range 1 n))
)

(defn is-amicable? [[x y]]
  (and (= (reduce + (get-divisors x)) y) (= (reduce + (get-divisors y)) x))
)

(defn not-prime? [x]
  (not= '(1) (get-divisors x))
)

(let [nos (filter not-prime? (range 220 10000))]
    (reduce + (flatten (filter is-amicable? (combinations nos 2))))
  )
