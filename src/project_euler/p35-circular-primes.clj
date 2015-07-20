;; Problem 35

(ns project_euler.p35-circular-primes
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

(defn is-prime? [x primeset]
  (contains? primeset x)
  )

(defn rotations [coll]
  (map (fn [ch] (Integer/parseInt (apply str ch)))
       (take (count coll) (partition (count coll) 1 (cycle coll))))
  )

(defn is-circular-prime?
  [n primeset]
  (reduce (fn [a b] (and a b))
          (map (fn [x] (is-prime? x primeset)) (rotations (str n))))
  )

(let [primeset (set (sieve-of-eratosthenes 1000000))]
  (count (filter (fn [x] (is-circular-prime? x primeset)) primeset))
  )





