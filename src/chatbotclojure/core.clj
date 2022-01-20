(ns chatbotclojure.core
  (:gen-class))

;; -- ALL THE LIBRARIES --


;; -- District/park Librairies --
(def Parks #{"Kampa" "Vysehrad" "Rajska-Zahrada" "Dobeska" "Kinskeho-Zahrada" "Letna"})
(def Kampa #{"Bike" "bike" "WC" "wc" "Sports" "sports" "Run" "run" "Playground" "playground" "parking" "Parking"})
(def VysehradPark #{"Playground" "playground" "WC" "wc" "Bike" "bike"})
(def RajskáZahrada #{"Wc" "wc" "Bike" "bike" "ski" "Ski" "Playground" "playground" "dog" "Dog" "parking" "Parking"})
(def Dobeška #{"Wc" "wc" "Bike" "bike" "Skate" "skate" "playground" "Playground"})
(def Kinskeho-Zahrada #{"Wc" "wc" "Playground" "playground" "parking" "Parking"})
(def Letná #{"Wc" "wc" "Bike" "bike" "Sports" "sport" "Running" "running" "dog" "Dog" "Playground" "playground" "restaurant" "Restaurant"})


;; -- Positive/Negative/Exit line Librairies --
(def Positive #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negative #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})
(def Exitline #{"exit" "Exit" "Quit" "quit" "End" "end" "bye" "Bye"})


;; -- Pokemon in parks Librairies --
(def KampaP #{"Pikachu" "pikachu" "Charmender" "charmender" "Bulbasaur" "bulbasaur"})
(def VysehradParkP #{"Squirtle" "squirtle"})
(def RajskáZahradaP #{"Charmander" "charmender" "Bulbasaur" "bulbasaur"})
(def DobeškaP #{"Pikachu" "pikachu" "Squirtle" "squirtle"})
(def Kinskeho-ZahradaP #{"Pikachu" "pikachu" "Charmender" "charmender"})
(def LetnáP #{"Bulbasaur" "bulbasaur" "Squirtle" "squirtle"})

;; -- Pokemon color in parks Librairies --
(def KampaC #{"Yellow" "yellow" "Orange" "orange" "Green" "green"})
(def VysehradParkC #{"Blue" "blue"})
(def RajskáZahradaC #{"Orange" "orange" "Green" "green"})
(def DobeškaC #{"Yellow" "yellow" "Blue" "blue"})
(def Kinskeho-ZahradaC {"Yellow" "yellow" "Orange" "orange"})
(def LetnáC #{"Green" "green" "Blue" "blue"})



;; -- Pokemon Color --
(def PikachuC #{"yellow" "Yellow"})
(def CharmenderC #{"Orange" "orange"})
(def BulbasaurC #{"Green" "green"})
(def SquirtleC #{"Blue" "blue"})


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
(defn pikachuElem [c]
  (newline)
  (println "What was the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? pikachuE Element) [(println "Yes, there is a" c "" Element "type Pokemon")
                                    (println "Congratulations, you found a Pikachu !")]
      :else [(println "There is no" c "and" Element "Pokemon in this park") (pikachuElem c)])))

(defn squirtleElem [c]
  (newline)
  (println "What was the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? squirtleE Element) [(println "Yes, there is a" c "" Element "type Pokemon")
                                     (println "Congratulations, you found a Squirtle !")]
      :else [(println "There is no" c "and" Element "Pokemon in this park") (squirtleElem c)])))

(defn charmenderElem [c]
  (newline)
  (println "What was the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? charmenderE Element) [(println "Yes, there is a" c "" Element "type Pokemon")
                                     (println "Congratulations, you found a Charmender !")]
      :else [(println "There is no" c "and" Element "Pokemon in this park") (charmenderElem c)])))


(defn bulbasaurElem [c]
  (newline)
  (println "What was the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? bulbasaurE Element) [(println "Yes, there is a" c "" Element "type Pokemon")
                                     (println "Congratulations, you found a Bulbasaur !")]
      :else [(println "There is no" c "and" Element "Pokemon in this park") (bulbasaurElem c)])))



;; -- Function for Pokemon location per park --
(defn pokemonKamp []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? KampaC c) [(println "Yes, there is some" c "Pokemon in Kampa")
                            (cond
                              (contains? PikachuC c) [(pikachuElem c)]
                              (contains? CharmenderC c) [(charmenderElem c)]
                              (contains? BulbasaurC c) [(bulbasaurElem c)])]
      (contains? Exitline c) (exit-f)
      :else [(println "There is no" c "Pokemon in Kampa") (println "What was the colour of the Pokemon again ? [Enter a color]") (pokemonKamp)])))

(defn pokemonVyse []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? VysehradParkC c) [(println "Yes, there is some" c "Pokemon in Vysehrad")
                            (cond
                              (contains? SquirtleC c) (squirtleElem c))]
      (contains? Exitline c) (exit-f)
      :else [(println "There is no" c "Pokemon in Vysehrad") (println "What was the colour of the Pokemon again ? [Enter a color]") (pokemonVyse)])))

(defn pokemonRajs []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? RajskáZahradaC c) [(println "Yes, there is some" c "Pokemon in RajskáZahrada")
                            (cond
                              (contains? BulbasaurC c) (squirtleElem c)
                              (contains? CharmenderC c) (charmenderElem c))]
      (contains? Exitline c) (exit-f)
      :else [(println "There is no" c "Pokemon in Rajská Zahrada") (println "What was the colour of the Pokemon again ? [Enter a color]") (pokemonRajs)])))

(defn pokemonDobe []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? DobeškaC c) [(println "Yes, there is some" c "Pokemon in Dobeška")
                            (cond
                              (contains? PikachuC c) (pikachuElem c)
                              (contains? SquirtleC c) (squirtleElem c))]
      (contains? Exitline c) (exit-f)
      :else [(println "There is no" c "Pokemon in Dobeška") (println "What was the colour of the Pokemon again ? [Enter a color]") (pokemonDobe)])))

(defn pokemonKins []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? Kinskeho-ZahradaC c) [(println "Yes, there is some" c "Pokemon in Kinskeho-Zahrada")
                            (cond
                              (contains? PikachuC c) (pikachuElem c)
                              (contains? CharmenderC c) (charmenderElem c))]
      (contains? Exitline c) (exit-f)
      :else [(println "There is no" c "Pokemon in Kinskeho-Zahrada") (println "What was the colour of the Pokemon again ? [Enter a color]") (pokemonKins)])))

(defn pokemonLetn []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? LetnáC c) [(println "Yes, there is some" c "Pokemon in Letná")
                            (cond
                              (contains? SquirtleC c) (squirtleElem c)
                              (contains? BulbasaurC c) (bulbasaurElem c))]
      (contains? Exitline c) (exit-f)
      :else [(println "There is no" c "Pokemon in Letná") (println "What was the colour of the Pokemon again ? [Enter a color]") (pokemonLetn)])))


;; -- Sorting Pokemon per park function --
(defn whatPokemon [y]
  (newline)
  (println "What was the color of the Pokemon ? [Enter a color]")
  (Thread/sleep 1000)
  (cond
    (= y "Kampa") (pokemonKamp)
    (= y "Vysehrad") (pokemonVyse)
    (= y "Rajska-Zahrada") (pokemonRajs)
    (= y "Dobeska") (pokemonDobe)
    (= y "Kinskeho-Zahrada") (pokemonKins)
    (= y "Letna") (pokemonLetn)))


;; -- Allows to change park location --
(defn ListPark []
  (newline)
  (println "Here is a list of the recommended parks :")
  (Thread/sleep 1000)
  (newline)
  (println Parks)
  (Thread/sleep 1000)
  (println "Please enter exactly the name of the park where you want recommendations")
  (let [y (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Parks y) [(println "You have selected :" y)
                           (cond
                             (newline) (Thread/sleep 1000)
                             [(= y "Kampa")
                              (= y "Vysehrad")
                              (= y "Rajska-Zahrada")
                              (= y "Dobeaka")
                              (= y "Kinskeho-Zahrada")
                              (= y "Letna")] (whatPokemon y))]
      (contains? Exitline y) (exit-f)
      :else (str (err-f) (ListPark)))))


;; -- State and change of park --
(defn changePark [y]
  (newline)
  (println "The search of Pokemon is currently into :" y)
  (Thread/sleep 1000)
  (newline)
  (println "Do you want to search for a pokemon in this park" y)
  (println "or do you want to change park ? [Stay/Change]")
  (Thread/sleep 1000)
  (let [change (read-line)]
    (cond
    (= change "stay") [(println "You have selected : Stay") (whatPokemon y)]
    (= change "Stay") [(println "You have selected : Stay") (whatPokemon y)]
    (= change "change") [(println "You have selected : Change") (ListPark)]
    (= change "Change") [(println "You have selected : Change") (ListPark)])))


(defn pokemonSight [y]
  (newline)
  (println "Do you need help to identify some kind of Pokemon you saw? [Y/N]")
  (Thread/sleep 1000)
  (let [a (read-line)]
    (cond
      (contains? Positive a) (changePark y)
      (contains? Negative a) (exit-f))))


;; -- Activities function per park --
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

(defn activitiesVysehradPark [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? VysehradPark b) [(println "Yes there is a" b "area in this park."
                                           "Anything else ? [activities/N]") (activitiesVysehradPark y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesVysehradPark y)])))

(defn activitiesRajskáZahrada [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? RajskáZahrada b) [(println "Yes there is a" b "area in this park."
                                            "Anything else ? [activities/N]") (activitiesRajskáZahrada y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesRajskáZahrada y)])))

(defn activitiesDobeška [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Dobeška b) [(println "Yes there is a" b "area in this park."
                                      "Anything else ? [activities/N]") (activitiesDobeška y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesDobeška y)])))

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

(defn activitiesLetná [y]
  (let [b (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Letná b) [(println "Yes there is a" b "area in this park."
                                    "Anything else ? [activities/N]") (activitiesLetná y)]
      (contains? Exitline b) (exit-f)
      (contains? Negative b) (pokemonSight y)
      :else [(println "Sorry but there is no" b "area in this park."
                      "Anything else ? [activities/N]") (activitiesLetná y)])))


;; -- Sorting activities per park --
(defn sortingActivities [y]
  (cond
    (= y "Kampa") (activitiesKampa y)
    (= y "Vysehrad") (activitiesVysehradPark y)
    (= y "Rajska-Zahrada") (activitiesRajskáZahrada y)
    (= y "Dobeska") (activitiesDobeška y)
    (= y "Kinskeho-Zahrada") (activitiesKinskeho-Zahrada y)
    (= y "Letna") (activitiesLetná y)))


;; -- Activities / Pokemon choose function
(defn activities [y]
  (newline) (Thread/sleep 1000)
  [(println "Are you looking for specific activities or -") (println "- are you looking for Pokemon in this park ? [Activities/Pokemon]")]
  (let  [a (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (= a "Activities") [(println "OK so what are you looking for in this park ?") (sortingActivities y)]
      (= a "activities") [(println "OK so what are you looking for in this park ?") (sortingActivities y)]
      (contains? Exitline a) (exit-f)
      (= a "Pokemon") (pokemonSight y)
      (= a "pokemon") (pokemonSight y))))


;; -- Allows to do a loop --
(defn numer []
  (newline)
  (println "Here is a list of the recommended parks :")
  (Thread/sleep 1000)
  (newline)
  (println Parks)
  (Thread/sleep 1000)
  (println "Please enter exactly the name of the park where you want recommendations"))


;; -- Sorting district per park function --
(defn numer-2 [y]
  (cond
    (newline) (Thread/sleep 1000)
    (= y "Kampa") (activities y)
    (= y "Vysehrad") (activities y)
    (= y "Rajska-Zahrada") (activities y)
    (= y "Dobeska") (activities y)
    (= y "Kinskeho-Zahrada") (activities y)
    (= y "Letna") (activities y)))

(defn numer-f []
  (numer)
  (let [y (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? Parks y) [(println "You have selected :" y) (numer-2 y)]
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
    (println "My purpose is to present you Prague and his Pokemon")
    (numer-f)))

