;; Problem 22

(ns project_euler.p22-name-scores
  )

(def letter-score {"A" 1 "B" 2 "C" 3 "D" 4 "E" 5 "F" 6 "G" 7
                   "H" 8 "I" 9 "J" 10 "K" 11 "L" 12 "M" 13 "N" 14
                   "O" 15 "P" 16 "Q" 17 "R" 18 "S" 19 "T" 20 "U" 21
                   "V" 22 "W" 23 "X" 24 "Y" 25 "Z" 26})

(defn read-names
  [filename]
  (-> filename
      slurp
      (clojure.string/replace "\"" "")
      (clojure.string/split #",")
      sort)
  )

(defn get-name-score
  [nm index]
  (* (apply + (map (fn [ch] (get letter-score (str ch))) nm)) index)
  )

(let [names (read-names "resources/p022_names.txt")]
  (apply + (map get-name-score names (range 1 (+ (count names) 1))))
  )

