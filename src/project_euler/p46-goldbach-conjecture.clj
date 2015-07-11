;; Problem 46

(ns project_euler.p46-goldbach-conjecture
  )

(defn get-divisors [n]
  (filter (fn [x] (zero? (mod n x))) (range 1 n))
)

(defn is-prime? [x]
  (= '(1) (get-divisors x))
)


(defn get-num-list
 [n]
  (range 1 (Math/sqrt (/ n 2)))
 )


(defn check-conjecture
  [n]
  (let [num-list (get-num-list n)
        diff (map (fn [x] (- n (* 2 (Math/pow x 2)))) num-list)]
    (reduce (fn [x y] (or x y)) (map is-prime? diff))
    )
 )

(+ 2 (last (for [n (filter (fn [k] (not (is-prime? k)))
                (for [x (drop 34 (range)) :when (odd? x)] x))
      :while (check-conjecture n)] n)))

