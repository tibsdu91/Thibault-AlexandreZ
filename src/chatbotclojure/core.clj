(ns chatbotclojure.core
  (:gen-class))

;; ALL THE LIBRARIES
;; All the trying libraries
(def Hobbies #{"Bike" "Playfield" "Street Workout"})

(def District #{:a "1" :b "2" :c "3" :d "4" :e "5" :f "6"})
(def Parks {:a "Jardin Royal" :b "Riegrovy sady" :c "Rajská Zahrada"
            :d "Central Park Pankrác" :e "Sacré Coeur Park" :f "Hvězda"})

(def Positif #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negatif #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})

(def Exitline #{"exit" "Exit" "Quit" "quit" "End" "end" "bye" "Bye"})


;; ALL THE FUNCTIONS
(defn err-f []
  (println "I didn't understand that, sorry"))



;;Fonction Exit à continuer/implémenter
(defn exit-f []
  (println "Do you want to end the research ?")
  (let [z (read-line)]
    (cond
      (contains? Positif z)(println "Thank you, have a good day !"))))




;;A Implementer en plus simple
(defn numer []
  (println "In which number of District do you live ?"))






;; Reussit a afficher parc spécifique pour numero de district
(defn numer-f []
  (numer)
  (let [y (read-line)]
    (cond
      (contains? District y) (println "Ok so there is a few parks I can recommand you in District number" y "!")

      :else (str (err-f) (numer-f)))
    (cond
      (= y "4") (println "For instance, this one is near your position :" (:d Parks))
      (= y "5") (println "For instance, this one is near your position :" (:e Parks))
      (= y "6") (println "For instance, this one is near your position :" (:f Parks))
      (= y "1") (println "For instance, this one is near your position :" (:a Parks))
      (= y "2") (println "For instance, this one is near your position :" (:b Parks))
      (= y "3") (println "For instance, this one is near your position :" (:c Parks))
      )
    ))



;;; a utiliser quand on aura reussi a appeler le parc 
(defn activities []
  (println "Are you looking for specific things in this park ?")
  (let  [y (read-line)]
    (cond
      (contains? Positif y) (println "OK so ok what are you looking for in this park")
      (contains? Negatif y) (exit-f))))




(defn -main []
  (println "Good morning to you ! What's your name ?")
  (let [x (read-line)]
    (println "Hello" x "!")
    (println "My purpose is to present you Prague and his surroundings")
    (numer-f)))


