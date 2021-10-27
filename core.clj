(ns chatbotclojure.core
  (:gen-class))

;; ALL THE LIBRARIES
;; All the trying libraries

(def District #{"1" "2" "3" "4" "5" "6"})
(def Parks #{:1 "Jardin Royal" :2 "Riegrovy sady" :3 "Rajská Zahrada" :4 "Central Park Pankrác" :5 "Sacré Coeur Park" :6 "Hvězda"})
(def Hobbies #{"Bike" "Playfield" "Street Workout"})
(def Positif #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negatif #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})



;; ALL THE FUNCTIONS
(defn err-f []
  (println "I didn't understand that, can you rephrase please ? "))

(defn  numer-f []
  (println "In which number of District do you live ?")
  (let [y (read-line)]
    (cond
      (contains? District y) (println "Ok so there is a few places I can recommend you in District number" y)
      (contains? District y) (:y Parks))))



(defn -main []
  (println "Good morning to you ! What's your name ?")
  (let [x (read-line)]
    (println "Hello" x "!")
    (println "My purpose is to present you Prague and his surroundings")
    (println "In which number of District do you live ?"))
  (let [y (read-line)]
    (cond
      (contains? District y) (numer-f)
      :else (str (err-f) (numer-f)))))
