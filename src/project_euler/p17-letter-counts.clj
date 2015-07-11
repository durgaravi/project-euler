;; Problem 17

(ns project_euler.p17-letter-counts
  )

(def num-dict {1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten"
               11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen" 20 "twenty"
               30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety" 100 "hundred" 1000 "onethousand"})

(defn get-two-digit-name
  [digits n]
  (if (contains? num-dict n) (get num-dict n)
    (let [first-word (get num-dict (read-string (str (nth digits 0) "0")))
            second-word (get num-dict (read-string (nth digits 1)))]
       (str first-word second-word)
        ))
 )

(defn get-three-digit-name
  [digits n]
  (let [first-word (str (get num-dict (read-string (str (nth digits 0)))) "hundred")
            last-two-digits (drop 1 digits)
            mid-word (if (= ["0" "0"] last-two-digits) "" "and")
            rest-word (get-two-digit-name last-two-digits (Integer/parseInt (clojure.string/join "" last-two-digits)))]
        (str first-word mid-word rest-word)
       )
 )
(defn get-string
  [n]
  (let [digits (map str (vec (str n)))
        numdigits (count digits)]
    (if (not= numdigits 3)
      (get-two-digit-name digits n)
      (get-three-digit-name digits n)

      )

    )
 )


(defn get-counts
  [n]
  (count (get-string n))
  )

(apply + (map get-counts (range 1 1001)))

