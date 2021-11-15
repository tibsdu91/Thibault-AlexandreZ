(ns chatbotclojure.core
  (:gen-class))

;; ALL THE LIBRARIES
;; Adding some hobbies

(def Hobbies #{"Bike" "Playfield" "Street Workout" "Workout" "WC" "Dog" "Run" "Skate"})

(def District #{:a "1" :b "2" :c "3" :d "4" :e "5" :f "6"})
(def Parks {:a "Jardin Royal" :b "Riegrovy sady" :c "Rajská Zahrada"
            :d "Central Park Pankrác" :e "Sacré Coeur Park" :f "Hvězda"})

(def Positif #{"yeah" "Y" "yes" "OK" "y" "ok" "Yes" "Yeah"})
(def Negatif #{"n" "nope" "not" "Nope" "Not" "N" "no" "No"})

(def Exitline #{"exit" "Exit" "Quit" "quit" "End" "end" "bye" "Bye"})


;; ALL THE FUNCTIONS
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
      (contains? Positif z) (println "Thank you, have a good day !"))))



;; new function activities-f
(defn activities-f []
  (let [t (read-line)]
    (cond
      (contains? Hobbies t) ())))





;;; réussi a être utilisé et a continuer 
(defn activities []
  (newline)(Thread/sleep 1000)
  (println "Are you looking for specific things in this park ?")
  (let  [y (read-line)]
    (cond
      (contains? Positif y) (println "OK so what are you looking for in this park ?" (str (activities-f)))
      (contains? Exitline y) (exit-f)
      (contains? Negatif y) (exit-f))))





;;A Implementer en plus simple
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
    (= y "3") (println "For instance, this one is near your position :" (:c Parks))
    )
  (activities))




;; Reussit a afficher parc spécifique et a continuer sur activities 
(defn numer-f []
  (numer)
  (let [y (read-line)]
    (cond
      (newline) (Thread/sleep 1000)
      (contains? District y) [(println "Ok so there is a few parks I can recommand you in District number" y "!")
                              (numer-2 y)]
      (contains? Exitline y) (exit-f)
      :else (str (err-f) (numer-f)))))










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





