;; Problem 2
(ns project_euler.p2-even-fibonacci
  )


(defn generate-fibonacci-series
  [n]
(loop [x 1 y 2 fib-series [1 2]]
  (let [sum (+ x y)]
  (if (>= sum (- n 1)) fib-series
    (recur y sum (conj fib-series sum)))
 )
 ))

(apply + (filter even? (generate-fibonacci-series 4000000)))
