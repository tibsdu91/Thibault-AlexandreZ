(ns chatbotclojure.core
  (:gen-class))

;; -- ALL THE LIBRARIES --



(def District #{:a "1" :b "2" :c "3" :d "4" :e "5" :f "6"})
(def Parks {:a "Bertramka" :b "Frantiskanska-Zahrada" :c "Obora-Hvezda"
            :d "Kampa" :e "Kinskeho-Zahrada" :f "Kamovka"})

(def Bertramka #{"Bike" "bike" "WC" "wc" "Sports" "sports" "Run" "run" "Playground" "playground" "parking" "Parking"})
(def Frantiskanska-Zahrada #{"Playground" "playground" "WC" "wc" "Bike" "bike"})
(def Obora-Hvezda #{"Wc" "wc" "Bike" "bike" "ski" "Ski" "Playground" "playground" "dog" "Dog" "parking" "Parking"})
(def Kampa #{"Wc" "wc" "Bike" "bike" "Skate" "skate" "playground" "Playground"})
(def Kinskeho-Zahrada #{"Wc" "wc" "Playground" "playground" "parking" "Parking"})
(def Klamovka #{"Wc" "wc" "Bike" "bike" "Sports" "sport" "Running" "running" "dog" "Dog" "Playground" "playground" "restaurant" "Restaurant"})

(def Positif #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negatif #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})

(def Exitline #{"exit" "Exit" "Quit" "quit" "End" "end" "bye" "Bye"})


;; -- ALL THE FUNCTIONS --
(defn err-f []
  (println "I didn't understand that, sorry"))



;;fonction exit , implementer negatif z
(defn exit-f []
  (newline)
  (println "Do you want to end the research ?")
  (Thread/sleep 1000)
  (let [z (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Positif z) (println "Thank you, have a good day !")
      )))


;;; -- One Function activities per park -- 

(defn activitiesBertramka []
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Bertramka b) [(println "Yes there is a" b "area in this park."
                                        "Anything else ?") (activitiesBertramka)]
      (contains? Exitline b) (exit-f)
      (contains? Negatif b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesBertramka)])))

(defn activitiesFrantiskanska-Zahrada []
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Frantiskanska-Zahrada b) [(println "Yes there is a" b "area in this park."
                                                    "Anything else ?") (activitiesFrantiskanska-Zahrada)]
      (contains? Exitline b) (exit-f)
      (contains? Negatif b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesFrantiskanska-Zahrada)])))

(defn activitiesObora-Hvezda []
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Obora-Hvezda b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ?") (activitiesObora-Hvezda)]
      (contains? Exitline b) (exit-f)
      (contains? Negatif b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesObora-Hvezda)])))

(defn activitiesKampa []
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Kampa b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ?") (activitiesKampa)]
      (contains? Exitline b) (exit-f)
      (contains? Negatif b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesKampa)])))

(defn activitiesKinskeho-Zahrada []
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Kinskeho-Zahrada b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ?") (activitiesKinskeho-Zahrada)]
      (contains? Exitline b) (exit-f)
      (contains? Negatif b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesKinskeho-Zahrada)])))

(defn activitiesKlamovka []
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Klamovka b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ?") (activitiesKlamovka)]
      (contains? Exitline b) (exit-f)
      (contains? Negatif b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesKlamovka)])))





;;;Launch the activity search and lead to the right park
(defn activities [y]
  (newline) (Thread/sleep 1000)
  (println "Are you looking for specific activities to do in this park ? [Y/N]")
  (let  [a (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Positif a) (println "OK so what are you looking for in this park ?")
      (contains? Exitline a) (exit-f)
      (contains? Negatif a) (exit-f)))
  (cond
    (= y "1") (activitiesBertramka)
    (= y "2") (activitiesFrantiskanska-Zahrada)
    (= y "3") (activitiesObora-Hvezda)
    (= y "4") (activitiesKampa)
    (= y "5") (activitiesKinskeho-Zahrada)
    (= y "6") (activitiesKlamovka)))

;;;-- End of the function activities per park --


;;Allows to do a loop 
(defn numer []
  (newline)
  (println "In which number of District do you live ?"))


;;numer-2 is called in numer-f & keeping the y variable
(defn numer-2 [y]
  (cond
    (newline) (Thread/sleep 1000)
    (= y "4") (println "For instance, this one is near your position :" (:d Parks))
    (= y "5") (println "For instance, this one is near your position :" (:e Parks))
    (= y "6") (println "For instance, this one is near your position :" (:f Parks))
    (= y "1") (println "For instance, this one is near your position :" (:a Parks))
    (= y "2") (println "For instance, this one is near your position :" (:b Parks))
    (= y "3") (println "For instance, this one is near your position :" (:c Parks)))
  (activities y))




(defn numer-f []
  (numer)
  (let [y (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? District y) [(println "Ok so there is a few parks I can recommand you in District number" y "!")
                              (numer-2 y)]
      (contains? Exitline y) (exit-f)
      :else (str (err-f) (numer-f)))))


;;; -- Main function that starts the bot --
(defn -main []
  (newline)
  (println "Good morning to you ! What's your name ?")
  (Thread/sleep 1000)
  (let [x (read-line)]
    (newline)
    (println "Hello" x "!")
    (Thread/sleep 1000)
    (newline)
    (println "My purpose is to present you Prague and his surroundings")
    (numer-f)))





