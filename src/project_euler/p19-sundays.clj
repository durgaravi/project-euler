;; Problem 19

(ns project_euler.p19-sundays
  )

(def date-fmt (java.text.SimpleDateFormat. "yyyy-MM-dd"))

(defn is-leap?
  [year]
  (and (= 0 (mod year 4)) (not= 0 (mod year 400)))
  )

(defn is-sunday?
  [datestr]
  (let [date (str (.parse date-fmt datestr))]
    (= "Sun" (subs date 0 3)))
  )

(defn generate-date-strings
  [start-yr end-yr]
  (let [years (range start-yr end-yr)
        months (range 12)]
    (for [y years
          m months
          d ["01"]]
      (str y "-" (format "%02d" m) "-" d))
    )
  )


(count (filter is-sunday? (generate-date-strings 1901 2001)))
