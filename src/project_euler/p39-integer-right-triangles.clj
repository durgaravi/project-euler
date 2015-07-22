;; Problem 39

(ns project_euler.p39-integer-right-triangles
  )

(defn is-right-triangle?
  [a b c]
  (= (+ (Math/pow a 2) (Math/pow b 2)) (Math/pow c 2))
  )

(defn merge-perimeters
  [m1 m2]
  (merge-with concat m1 m2)
  )

(let [right-triangles (for [a (range 1 997)
                            b (range (+ a 1) 998)
                            c (range (+ b 1) 999)
                            :when (and (< c (+ a b)) (is-right-triangle? a b c)
                                       (<= (+ a b c) 1000))] [a b c])
      perimeters (map (fn [abc] {(apply + abc) [abc]}) right-triangles)
      perimeter-map (reduce merge-perimeters perimeters)
      perimeter-counts (into {} (map (fn [[k v]] [k (count v)]) perimeter-map))
      ]
  (key (apply max-key val perimeter-counts))
  )
