(ns chatbotclojure.core
  (:gen-class))

;; -- ALL THE LIBRARIES --


;; -- District/park Librairies --
(def District #{:a "1" :b "2" :c "3" :d "4" :e "5" :f "6"})
(def Parks {:a "Bertramka" :b "Frantiskanska-Zahrada" :c "Obora-Hvezda"
            :d "Kampa" :e "Kinskeho-Zahrada" :f "Kamovka"})
(def Bertramka #{"Bike" "bike" "WC" "wc" "Sports" "sports" "Run" "run" "Playground" "playground" "parking" "Parking"})
(def Frantiskanska-Zahrada #{"Playground" "playground" "WC" "wc" "Bike" "bike"})
(def Obora-Hvezda #{"Wc" "wc" "Bike" "bike" "ski" "Ski" "Playground" "playground" "dog" "Dog" "parking" "Parking"})
(def Kampa #{"Wc" "wc" "Bike" "bike" "Skate" "skate" "playground" "Playground"})
(def Kinskeho-Zahrada #{"Wc" "wc" "Playground" "playground" "parking" "Parking"})
(def Klamovka #{"Wc" "wc" "Bike" "bike" "Sports" "sport" "Running" "running" "dog" "Dog" "Playground" "playground" "restaurant" "Restaurant"})


;; -- Positive/Negative/Exit line Librairies --
(def Positive #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negative #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})
(def Exitline #{"exit" "Exit" "Quit" "quit" "End" "end" "bye" "Bye"})


;; -- Pokemon in parks Librairies --
(def BertramkaP #{"Pikachu" "pikachu" "Charmender" "charmender" "Bulbasaur" "bulbasaur"})
(def Frantiskanska-ZahradaP #{"Squirtle" "squirtle"})
(def Obora-HvezdaP #{"Charmander" "charmender" "Bulbasaur" "bulbasaur"})
(def KampaP #{"Pikachu" "pikachu" "Squirtle" "squirtle"})
(def Kinskeho-ZahradaP #{"Pikachu" "pikachu" "Charmender" "charmender"})
(def KlamovkaP #{"Bulbasaur" "bulbasaur" "Squirtle" "squirtle"})


;; -- Pokemon Color --
(def PikachuC #{"yellow" "Yellow" "Electric" "electric"})
(def CharmenderC #{"Orange" "orange" "Fire" "fire"})
(def BulbasaurC #{"Green" "green" "Grass" "grass"})
(def SquirtleC #{"Blue" "blue" "Water" "water"})


;; -- Pokemon Element Type --
(def pikachuE #{"Electric" "electric"})
(def charmenderE #{"Fire" "fire"})
(def bulbasaurE #{"Grass" "grass"})
(def squirtleE #{"Water" "water"})

;; -- END OF THE LIBRARIES --


;; -- ALL THE FUNCTIONS --


;; -- Error function --
(defn err-f []
  (println "I didn't understand that, sorry"))


;; -- Exit function --
(defn exit-f []
  (newline)
  (println "Do you want to end the research ?")
  (Thread/sleep 1000)
  (let [z (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Positive z) (println "Thank you, have a good day !"))))


;; -- Function for Pokemon elements --
(defn pikachuElem []
  (newline)
  (println "Did you see the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? pikachuE Element) [(println "Yes, Pikachu is a" Element "type Pokemon.")
                                    (println "Congratulations, you found a Pikachu !")]
      (contains? Negative Element) [(println "Too bad, i can't tell if you found a Pikachu or not.")(pikachuElem)]
      :else [(err-f) (pikachuElem)])))

(defn squirtleElem []
  (newline)
  (println "Did you see the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? squirtleE Element) [(println "Yes, Squirtle is a" Element "type Pokemon.")
                                    (println "Congratulations, you found a Squirtle !")]
      (contains? Negative Element) [(println "Too bad, i can't tell if you found a Squirtle or not.") (squirtleElem)]
      :else [(err-f) (squirtleElem)])))

(defn charmenderElem []
  (newline)
  (println "Did you see the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? charmenderE Element) [(println "Yes, Charmender is a" Element "type Pokemon.")
                                    (println "Congratulations, you found a Charmender !")]
      (contains? Negative Element) [(println "Too bad, i can't tell if you found a Charmender or not.") (charmenderElem)]
      :else [(err-f) (charmenderElem)])))

(defn bulbasaurElem []
  (newline)
  (println "Did you see the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? bulbasaurE Element) [(println "Yes, Bulbasaur is a" Element "type Pokemon.")
                                    (println "Congratulations, you successfully found a Bulbasaur !")]
      (contains? Negative Element) [(println "Too bad, i can't tell if you found a Bulbasaur or not.") (bulbasaurElem)]
      :else [(err-f) (bulbasaurElem)])))


;; -- Function for Pokemon color checking --
(defn pikachuColor []
  (let [color (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? PikachuC color) [(println "Yes, the color of Pikachu is" color ".") (pikachuElem)]
      (contains? Exitline color) (exit-f)
      :else [(println "Pikachu isn't" color "! You certainly saw a different Pokemon.") (println "What was the Pokemon color again ?") (pikachuColor)])))

(defn squirtleColor []
  (let [color (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? SquirtleC color) [(println "Yes, the color of Squirtle is" color ".") (squirtleElem)]
      (contains? Exitline color) (exit-f)
      :else [(println "Squirtle isn't" color "! You certainly saw a different Pokemon.") (println "What was the Pokemon color again ?") (squirtleColor)])))

(defn charmenderColor []
  (let [color (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? CharmenderC color) [(println "Yes, the color of Charmender is" color ".") (charmenderElem)]
      (contains? Exitline color) (exit-f)
      :else [(println "Charmender isn't" color "! You certainly saw a different Pokemon.") (println "What was the Pokemon color again ?") (charmenderColor)])))

(defn bulbasaurColor []
  (let [color (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? BulbasaurC color) [(println "Yes, the color of Bulbasaur is" color ".") (bulbasaurElem)]
      (contains? Exitline color) (exit-f)
      :else [(println "Bulbasaur isn't" color "! You certainly saw a different Pokemon.") (println "What was the Pokemon color again ?") (bulbasaurColor)])))


;; -- Function for the Pokemon color sorting --
(defn whatPokemonColor [c]
  (newline)
  (println "What was the color of the Pokemon ?")
  (cond
    (= c "Pikachu") (pikachuColor)
    (= c "pikachu") (pikachuColor)
    (= c "Squirtle") (squirtleColor)
    (= c "squirtle") (squirtleColor)
    (= c "Charmender") (charmenderColor)
    (= c "charmender") (charmenderColor)
    (= c "Bulbasaur") (bulbasaurColor)
    (= c "bulbasaur") (bulbasaurColor)))


;; -- Function for Pokemon location per park --
(defn pokemonBert []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? BertramkaP c) [(println "Yes, there is some" c "in Bertramka") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This pokemon cannot be in Bertramka") (println "What is the name of the Pokemon again ?") (pokemonBert)])))

(defn pokemonFran []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Frantiskanska-ZahradaP  c) [(println "Yes, there is some" c "in Frantiskanska-Zahrada") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This pokemon cannot be in Frantiskanska-Zahrada") (println "What is the name of the Pokemon again ?") (pokemonFran)])))

(defn pokemonObor []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Obora-HvezdaP c) [(println "Yes, there is some" c "in Obora-Hvezda") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This pokemon cannot be in Obora-Hvezda") (println "What is the name of the Pokemon again ?") (pokemonObor)])))

(defn pokemonKamp []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? KampaP c) [(println "Yes, there is some" c "in Kampa") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This pokemon cannot be in Kampa") (println "What is the name of the Pokemon again ?") (pokemonKamp)])))

(defn pokemonKins []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Kinskeho-ZahradaP c) [(println "Yes, there is some" c "in Kinskeho-Zahrada") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This pokemon cannot be in Kinskeho-Zahrada") (println "What is the name of the Pokemon again?") (pokemonKins)])))

(defn pokemonKlam []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? KlamovkaP c) [(println "Yes, there is some" c "in Klamovka") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This Pokemon cannot be in Klamovka") (println "What is the name of the Pokemon again?") (pokemonKlam)])))


;; -- Sorting Pokemon per park function --
(defn whatPokemon [y]
  (newline)
  (println "What is the name of the Pokemon ?")
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
  (println "Did you see some kind of Pokemon ? [Y/N]")
  (Thread/sleep 1000)
  (let [a (read-line)]
    (cond
      (contains? Positive a) (whatPokemon y)
      (contains? Negative a) (exit-f))))


;; -- Activities function per park --
(defn activitiesBertramka [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Bertramka b) [(println "Yes there is a" b "area in this park."
                                        "Anything else ? [activities/N]") (activitiesBertramka y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesBertramka y)])))

(defn activitiesFrantiskanska-Zahrada [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Frantiskanska-Zahrada b) [(println "Yes there is a" b "area in this park."
                                                    "Anything else ? [activities/N]") (activitiesFrantiskanska-Zahrada y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesFrantiskanska-Zahrada y)])))

(defn activitiesObora-Hvezda [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Obora-Hvezda b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ? [activities/N]") (activitiesObora-Hvezda y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesObora-Hvezda y)])))

(defn activitiesKampa [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Kampa b) [(println "Yes there is a" b "area in this park."
                                    "Anything else ? [activities/N]") (activitiesKampa y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesKampa y)])))

(defn activitiesKinskeho-Zahrada [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Kinskeho-Zahrada b) [(println "Yes there is a" b "area in this park."
                                               "Anything else ? [activities/N]") (activitiesKinskeho-Zahrada y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesKinskeho-Zahrada y)])))

(defn activitiesKlamovka [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Klamovka b) [(println "Yes there is a" b "area in this park."
                                       "Anything else ? [activities/N]") (activitiesKlamovka y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesKlamovka y)])))


;; -- Sorting activities per park --
(defn sortingActivities [y]
  (cond
    (= y "1") (activitiesBertramka y)
    (= y "2") (activitiesFrantiskanska-Zahrada y)
    (= y "3") (activitiesObora-Hvezda y)
    (= y "4") (activitiesKampa y)
    (= y "5") (activitiesKinskeho-Zahrada y)
    (= y "6") (activitiesKlamovka y)))


;; -- Activities / Pokemon choose function
(defn activities [y]
  (newline) (Thread/sleep 1000)
  [(println "Are you looking for specific activities or -") (println"- are you looking for Pokemon ? [Activities/Pokemon]")]
  (let  [a (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (= a "Activities") [(println "OK so what are you looking for in this park ?") (sortingActivities y)]
      (contains? Exitline a) (exit-f)
      (= a "Pokemon") (pokemonSight y))))


;; -- Allows to do a loop --
(defn numer []
  (newline)
  (println "In which number of District do you live ?"))


;; -- Sorting district per park function --
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

