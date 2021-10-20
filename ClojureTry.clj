;; ALL THE LIBRARIES

(def District #{"1" "2" "3" "4" "5" "6"})
(def Parks #{"Jardin Royal" "Riegrovy sady" "Rajská Zahrada" "Central Park Pankrác" "Sacré Coeur Park" "Hvězda"})
(def Hobbies #{"Bike" "Playfield" "Street Workout"})
(def Positif #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negatif #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})



;; ALL THE FUNCTIONS

(defn start []
  (println "Good morning to you ! What's your name ?")
  (let [x (read-line)]
    (println "Hello" x "!")
    (println "My purpose is to present you Prague and his surroundings")
    (println "In which number of District do you live" x "?"))
  (let [y (read-line)]
    (cond
      (contains? District y) (Numer)
      :else (Error))))



(defn Error []
  (println "I didn't understand that, can you rephrase please ? "))

(defn  Numer[]
  (let [y (read-line)]
    (cond 
      (contains? District y) (println "Ok so there is a few places I can recommend you in District number" y))))