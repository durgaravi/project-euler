;; Problem 49

(ns project_euler.p49-prime-permutations
  )

(defn get-divisors [n]
  (filter (fn [x] (zero? (mod n x))) (range 1 n))
  )

(defn is-prime? [x]
  (= '(1) (get-divisors x))
  )

(defn is-permutation?
  [a b]
  (= (set (str a)) (set (str b)))
  )

(apply str
       (first (let [primes (filter is-prime? (range 1000 9999))]
         (for [a primes b primes c primes
               :when (and (< a b) (< b c)
                          (= (- b a) (- c b))
                          (not= a 1487)
                          (is-permutation? a b) (is-permutation? b c))]
           [a b c])
         )))


