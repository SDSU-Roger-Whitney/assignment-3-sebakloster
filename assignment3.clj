

(def item1 {:name "Green Tea Ice Cream" :price 2.5 :quantity 2})
(def item2 {:name "Lemon Ice Cream" :price 1.5 :quantity 3})
(def item3 {:name "Banana Ice Cream" :price 2.5 :quantity 1})
(def item4 {:name "Chocolate Ice Cream" :price 2.5 :quantity 1})

(def bill [item1 item2 item3 item4])

; Problem 1

(defn subtotal [x]
  (* (get x :price) (get x :quantity)))

(defn bill-total [bills]
  (reduce + (map subtotal bills)))

(bill-total bill)

; Problem 2 

(def items [{:name "New Almond Ice Cream" :price 10 :quantity 1}, {:name "Green Tea Ice Cream" :price 2.5 :quantity 1}, {:name "Banana Ice Cream" :price 10 :quantity 1}])

(defn increment-item-quantity [item]
  (assoc item :quantity (+ (get item :quantity) 1)))

(defn add-items [bill items]
  (reduce (fn [bill item]
            (if (some #(= (get % :name) (get item :name)) bill)
              (map (fn [bill-item]
                     (if (= (get bill-item :name) (get item :name))
                       (increment-item-quantity bill-item)
                       bill-item))
                   bill)
              (conj bill item)))
          bill
          items))

(add-items bill items)


; Problem 3

(defn divisors [n]
  (conj (filter (comp zero? (partial rem n)) (range 1 n)) n))

(divisors 12)


;Problem 4

(defn abundant [n]
  (-(- (reduce + (divisors n)) n ) n))

(abundant 12)

;Problem 5

(defn abundant? [n]
  (if (<= (abundant n) 0) false true))

(filter abundant? (range 300))

;Problem 6

(defn pattern-count [text pattern]
  (count (re-seq  (re-pattern pattern) text)))


(pattern-count "abaabaaba" "aba")