;; Problem 10

(ns project_euler.p10-summation-prime
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn not-multiple?
  [n d]
  (or (= d n) (not= 0 (mod n d)))
  )

(defn sieve-of-eratosthenes
  [n]
  (let [initial (range 2 (+ n 1)) sqrt (expt n 0.5)]
    (loop [d 2 acc initial]
      (if (> d sqrt) acc
        (recur (+ d 1) (filter (fn [x] (not-multiple? x d)) acc))))
    )
  )

(apply + (sieve-of-eratosthenes 2000000))

