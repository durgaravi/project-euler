;; Problem 7

(ns project_euler.p7-prime-100001
  )

(defn get-divisors [n]
  (filter (fn [x] (zero? (mod n x))) (range 1 n))
)

(defn is-prime? [x]
  (= '(1) (get-divisors x))
)

(defn get-next-prime
  [n]
  (loop [nextn (+ n 1)]
    (if (is-prime? nextn) nextn
      (recur (inc nextn))))
  )

(defn get-ith-prime
  [i]
  (loop [index 1 n 2]
    (if (= index i) n
      (recur (inc index) (get-next-prime n))))
  )

(get-ith-prime 10001)
