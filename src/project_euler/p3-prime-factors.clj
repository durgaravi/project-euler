;; Problem 3

(ns project_euler.p3-prime-factors
  )

(defn get-reduced-number
  [n d]
  (loop [number n]
    (if (not= 0 (mod number d))  number
      (recur (/ number d)))
  ))

(defn get-largest-prime
  [n]
  (loop [number n div 2]
    (let [res (get-reduced-number number div)]
    (if (= 1 res) div
      (recur res (inc div)))))
 )

(get-largest-prime 600851475143)
