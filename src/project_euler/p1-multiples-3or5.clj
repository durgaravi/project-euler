;; Problem 1
(ns project_euler.p1-multiples-3or5
  )

(defn is-multiple-3or5?
  [n]
  (or (= 0 (mod n 3)) (= 0 (mod n 5)))
 )

(apply + (filter is-multiple-3or5? (range 3 1000)))
