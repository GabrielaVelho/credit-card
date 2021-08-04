(ns credit-card.core)

(def client {:name        "Gabriela Velho"
             :document    "123.456.789-00"
             :email       "gabriela@anyemail.com"
             :credit-card {:number         123456789
                           :cvv            000
                           :expirationDate "10/29"
                           :limit          5000
                           :purchases      [{:date     "10/11/2020"
                                             :price    100
                                             :merchant "Burguer King"
                                             :category "Food"
                                             }
                                            {:date     "11/12/2020"
                                             :price    150
                                             :merchant "Adidas"
                                             :category "Clothing"
                                             }
                                            {:date     "04/01/2021"
                                             :price    200
                                             :merchant "Dell"
                                             :category "Eletronic"
                                             }
                                            {:date     "18/02/2021"
                                             :price    200
                                             :merchant "Jeronimo"
                                             :category "Food"
                                             }
                                            {:date     "15/05/2021"
                                             :price    500
                                             :merchant "iPlace"
                                             :category "Eletronic"
                                             }]
                           }
             })

(def purchases (:purchases (:credit-card client)))

(println "Purchases vector:" purchases)

; Map (key: category, value: purchases = all purchases of this category)
(defn total-by-category [[category purchases]]
  (->> purchases
       (map :price)
       (reduce +)))

(defn group-by-category-and-get-total [purchases]
  (->> purchases
       (group-by :category)
       (map total-by-category)))

(println "- Total by category:")
(get-category purchases)
(println (group-by-category-and-get-total purchases))

(defn get-by-merchant [purchases merchant-to-find]
  (->> purchases
       (filter (fn [purchase] (= merchant-to-find (:merchant purchase))))
       (println)))

(println "- Get by merchant:")
(get-by-merchant purchases "iPlace")



