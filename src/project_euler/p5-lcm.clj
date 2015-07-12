;; Problem 5

(ns project_euler.p5-lcm
  )

(defn get-divisors [n]
  (filter (fn [x] (zero? (mod n x))) (range 1 n))
  )

(defn is-prime? [x]
  (= '(1) (get-divisors x))
  )

(defn is-evenly-divisible?
  [n divisors]
  (not (reduce (fn [a b] (and a b)) (map (fn [d] (= 0 (mod n d))) divisors)))
  )

(defn get-lcm
  [list-of-nums]
  (+ 1 (last (for [n (drop (apply max list-of-nums) (range))
                   :while (is-evenly-divisible? n list-of-nums)] n)))
  )

(let [prime-pdts (filter is-prime? (range 2 20))
      other-nos [20 18 16]]
  (get-lcm (conj other-nos (apply * prime-pdts)))
  )



