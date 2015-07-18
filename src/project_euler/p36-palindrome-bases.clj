;; Problem 36

(ns project_euler.p36-palindrome-bases
  )

(defn is-palindrome?
  [n base]
  (let [number-string (Integer/toString n base)
        halflen (/ (count number-string) 2) ]
    (= (subs number-string 0 (Math/floor halflen))
       (clojure.string/reverse (subs number-string (Math/ceil halflen))))
    )
  )

(apply +
       (filter (fn [n] (is-palindrome? n 2))
               (filter (fn [n] (is-palindrome? n 10))
                       (range 1000000))))
