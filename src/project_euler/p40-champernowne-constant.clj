;; Problem 40

(ns project_euler.p40-champernowne-constant
  )

(defn get-irrational
  [max-len]
 (loop [n 1 acc "1"]
   (if (<= max-len (count acc)) acc
     (let [nxt (inc n)]
     (recur nxt (str acc nxt)))))
 )


(let [number-string (get-irrational 1000000)
      indices (map (fn [x] (- (Math/pow 10 x) 1)) (range 7))
      numbers (map (fn [n] (read-string (str (nth number-string n)))) indices)]
  (apply * numbers)
  )



