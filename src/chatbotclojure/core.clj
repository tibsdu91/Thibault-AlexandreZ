(ns chatbotclojure.core
  (:gen-class))

;; -- ALL THE LIBRARIES --



(def District #{:a "1" :b "2" :c "3" :d "4" :e "5" :f "6"})
(def Parks {:a "Bertramka" :b "Frantiskanska-Zahrada" :c "Obora-Hvezda"
            :d "Kampa" :e "Kinskeho-Zahrada" :f "Kamovka"})

(def Bertramka #{"Bike" "bike" "WC" "wc" "Sports" "sports" "Run" "run" "Playground" "playground" "parking" "Parking" "Pikachu" "pikachu" "Charmander" "charmander" "Bulbasaur" "bulbasaur"})
(def Frantiskanska-Zahrada #{"Playground" "playground" "WC" "wc" "Bike" "bike" "Squirtle" "squirtle"})
(def Obora-Hvezda #{"Wc" "wc" "Bike" "bike" "ski" "Ski" "Playground" "playground" "dog" "Dog" "parking" "Parking" "Charmander" "charmender" "Bulbasaur" "bulbasaur"})
(def Kampa #{"Wc" "wc" "Bike" "bike" "Skate" "skate" "playground" "Playground" "Pikachu" "pikachu" "Squirtle" "squirtle"})
(def Kinskeho-Zahrada #{"Wc" "wc" "Playground" "playground" "parking" "Parking" "Pikachu" "pikachu" "Charmander" "charmender"})
(def Klamovka #{"Wc" "wc" "Bike" "bike" "Sports" "sport" "Running" "running" "dog" "Dog" "Playground" "playground" "restaurant" "Restaurant" "Bulbasaur" "bulbasaur" "Squirtle" "squirtle"})

(def Positive #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negative #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})

(def Exitline #{"exit" "Exit" "Quit" "quit" "End" "end" "bye" "Bye"})


;Pokemon Library
(def Pikachu #{"yellow" "Yellow" "Electric" "electric"})
(def Charmander #{"Orange" "orange" "Fire" "fire"})
(def Bulbasaur #{"Green" "green" "Grass" "grass"})
(def Squirtle #{"Blue" "blue" "Water" "water"})


;; -- END OF THE LIBRAIRY --




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
      (contains? Positive z) (println "Thank you, have a good day !"))))


;; -- ONE FUNCTION PER PARK --

(defn pokemonBert []
  (let [c (read-line)]
    (newline)(Thread/sleep 1000)
    (cond
      (contains? Bertramka c) (println "Yes, there is some " c "in Bertramka")
      (contains? Exitline c) (exit-f)
      :else (println "This pokemon cannot be in Bertramka"))))

(defn pokemonFran []
  (let [c (read-line)]
    (newline)(Thread/sleep 1000)
    (cond
      (contains? Bertramka c) (println "Yes, there is some " c "in Frantiskanska-Zahrada")
      (contains? Exitline c) (exit-f)
      :else (println "This pokemon cannot be in Frantiskanska-Zahrada"))))

(defn pokemonObor []
  (let [c (read-line)]
    (newline)(Thread/sleep 1000)
    (cond
      (contains? Bertramka c) (println "Yes, there is some " c "in Obora-Hvezda")
      (contains? Exitline c) (exit-f)
      :else (println "This pokemon cannot be in Obora-Hvezda"))))

(defn pokemonKamp []
  (let [c (read-line)]
    (newline)(Thread/sleep 1000)
    (cond
      (contains? Bertramka c) (println "Yes, there is some " c "in Kampa")
      (contains? Exitline c) (exit-f)
      :else (println "This pokemon cannot be in Kampa"))))

(defn pokemonKins []
  (let [c (read-line)]
    (newline)(Thread/sleep 1000)
    (cond
      (contains? Bertramka c) (println "Yes, there is some " c "in Kinskeho-Zahrada")
      (contains? Exitline c) (exit-f)
      :else (println "This pokemon cannot be in Kinskeho-Zahrada"))))

(defn pokemonKlam []
  (let [c (read-line)]
    (newline)(Thread/sleep 1000)
    (cond
      (contains? Bertramka c) (println "Yes, there is some " c "in Klamovka")
      (contains? Exitline c) (exit-f)
      :else (println "This pokemon cannot be in Klamovka"))))


(defn whatPokemon [y]
  (newline)
  (println "What was the of name the Pokemon ?")
  (Thread/sleep 1000)
  (cond
    (= y "1") (pokemonBert)
    (= y "2") (pokemonFran)
    (= y "3") (pokemonObor)
    (= y "4") (pokemonKamp)
    (= y "5") (pokemonKins)
    (= y "6") (pokemonKlam)))



(defn pokemonSight [y]
  (newline)
  (println "Did you see some kind of Pokemon ?")
  (let [a (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Positive a) (whatPokemon y)
      (contains? Negative a) (exit-f))))





(defn activitiesBertramka [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Bertramka b) [(println "Yes there is a" b "area in this park."
                                        "Anything else ?") (activitiesBertramka y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesBertramka y)])))

(defn activitiesFrantiskanska-Zahrada [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Frantiskanska-Zahrada b) [(println "Yes there is a" b "area in this park."
                                                    "Anything else ?") (activitiesFrantiskanska-Zahrada y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (exit-f)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesFrantiskanska-Zahrada y)])))

(defn activitiesObora-Hvezda [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Obora-Hvezda b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ?") (activitiesObora-Hvezda y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesObora-Hvezda y)])))

(defn activitiesKampa [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Kampa b) [(println "Yes there is a" b "area in this park."
                                    "Anything else ?") (activitiesKampa y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesKampa y)])))

(defn activitiesKinskeho-Zahrada [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Kinskeho-Zahrada b) [(println "Yes there is a" b "area in this park."
                                               "Anything else ?") (activitiesKinskeho-Zahrada y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesKinskeho-Zahrada y)])))

(defn activitiesKlamovka [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Klamovka b) [(println "Yes there is a" b "area in this park."
                                       "Anything else ?") (activitiesKlamovka y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ?") (activitiesKlamovka y)])))





;;;Launch the activity search and lead to the right park
(defn activities [y]
  (newline) (Thread/sleep 1000)
  (println "Are you looking for specific activities to do in this park ? [Y/N]")
  (let  [a (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Positive a) (println "OK so what are you looking for in this park ?")
      (contains? Exitline a) (exit-f)
      (contains? Negative a) (pokemonSight y)))
  (cond
    (= y "1") (activitiesBertramka y)
    (= y "2") (activitiesFrantiskanska-Zahrada y)
    (= y "3") (activitiesObora-Hvezda y)
    (= y "4") (activitiesKampa y)
    (= y "5") (activitiesKinskeho-Zahrada y)
    (= y "6") (activitiesKlamovka y)))

;; -- END OF THE FUNCTION PER PARK --


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


