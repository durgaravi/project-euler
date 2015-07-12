;; Problem 4

(ns project_euler.p4-palindrome-pdt
  )

(defn is-palindrome?
  [n]
  (let [number-string (str n)
        halflen (/ (count number-string) 2) ]
    (= (subs number-string 0 (Math/floor halflen))
       (clojure.string/reverse (subs number-string (Math/ceil halflen))))
  )
)

(let [palindromes (for [x (range 100 1000) y (range 100 1000)
                        :when (is-palindrome? (* x y))] (* x y))]
  (apply max palindromes)
  )

