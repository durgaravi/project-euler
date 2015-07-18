;; Problem 25

(ns project_euler.p25-fibonacci-1000
  )


(defn get-fibonacci-index
  [numdigits]
  (loop [x 1 y 1 n 1]
    (let [sum (unchecked-add x y)]
      (if (= numdigits (count (str x))) n
        (recur (biginteger y) sum (inc n)))
      )
    ))

(get-fibonacci-index 1000)
