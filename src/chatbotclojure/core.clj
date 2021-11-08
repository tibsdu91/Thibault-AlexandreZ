(ns chatbotclojure.core
  (:gen-class))

;; ALL THE LIBRARIES
;; All the trying libraries
(def Hobbies #{"Bike" "Playfield" "Street Workout"})

(def District #{"1" "2" "3" "4" "5" "6"})
(def Parks #{:1 "Jardin Royal" :2 "Riegrovy sady" :3 "Rajská Zahrada" :4 "Central Park Pankrác" :5 "Sacré Coeur Park" :6 "Hvězda"})
(def Positif #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negatif #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})



;; ALL THE FUNCTIONS
(defn err-f []
  (println "I didn't understand that, sorry"))


(defn exit-f []
 (println "Thank you, have a good day !"))


(defn numer []
  (println "In which number of District do you live ?"))

(defn numer-f []
  (numer)
  (let [y (read-line)]
    (cond
      (contains? District y) (println "Ok so there is a few parks I can recommand you in District number" y "!" :y Parks)
      :else (str (err-f) (numer-f)))))


;;; a utiliser quand on aura reussi a appeler le parc 
(defn activities []
  (println "Are you looking for specific things in this park ?")
  (let  [y (read-line)]
    (cond
      (contains? Positif y) (println "OK so ok what are you looking for in the park")
      (contains? Negatif y) (exit-f))))



(defn -main []
  (println "Good morning to you ! What's your name ?")
  (let [x (read-line)]
    (println "Hello" x "!")
    (println "My purpose is to present you Prague and his surroundings")
    (numer-f)))


