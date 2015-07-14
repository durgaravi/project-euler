;; Problem 6

(ns project_euler.p6-sum-square
 )

(defn get-sum-of-squares
  [n]
  (apply + (map (fn [x] (Math/pow x 2)) (range 1 n)))
 )

(defn get-square-of-sums
  [n]
  (Math/pow (apply + (range 1 n)) 2)
 )

(long (- (get-square-of-sums 101) (get-sum-of-squares 101)))
