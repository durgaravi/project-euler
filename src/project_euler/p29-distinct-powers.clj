;; Problem 29

(ns project_euler.p29-distinct-powers
  )

(count (set
        (for [a (range 2 101) b (range 2 101)]
          (Math/pow a b))))
