## Pokemon Chatbot in Clojure

### Introduction

The city of Prague likes our chatbot application and it got implemented. Nevertheless, after a few
months of usage, the city would like us to enhance it with more interactive features, namely, they
would like to provide the users with the possibility to identify Pokemon in the
parks. They ask our team to choose a domain and demonstrate on it how this enhanced feature
would work and thus allow A/B testing with the users to see how they like it.

### Running the programm

The chatbot is written in Clojure, a functional programming language running on Java Virtual Machine. Depending on your operating system different steps are necessary to install the required components:

1. Java Development Kit (JDK) version 11 or newer.

2. Leiningen

3. A Command Line Interface (CLI)

### Usage

In order to start the chatbot, here is the command line to enter :

```shell

git clone https://github.com/tibsdu91/Thibault-AlexandreZ.git  #Clone the github repository, request your Gituhub credentials.
cd /chatbotclojure  #Browse the project folder.
lein run  #Run the chatbot and start interaction. Type :done at anytime to quit the app.

```
### Pokemon Library

In order to give information about pokemon that are in the parks, we had to create 4 types of libraries :

  1. A library containing the list of Pokemon per park
  2. A library containg the list of Pokemon color per park
  3. A library containing the Pokemon's color
  4. A library containing the Pokemon's element type

```clojure
(def KampaP #{"Pikachu" "pikachu" "Charmender" "charmender" "Bulbasaur" "bulbasaur"})
(def VysehradParkP #{"Squirtle" "squirtle"})

(def KampaC #{"Yellow" "yellow" "Orange" "orange" "Green" "green"})
(def VysehradParkC #{"Blue" "blue"})

(def PikachuC #{"yellow" "Yellow"})
(def CharmenderC #{"Orange" "orange"})

(def pikachuE #{"Electric" "electric"})
(def charmenderE #{"Fire" "fire"})
```

### Main function

Here is the main function which begin the chatbot.

```clojure
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
```

### Pokemon/Activities choice

In this function, we ask the user if he wants to launch the activities part or the Pokemon part of the chatbot 

```clojure
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
```


### Change of Park

These two function work together. By creating them, we tried to propose a change in the park chosen by the user. Unfortunately, the question feel a bit "soon" in the process.
One enhancement is to propose this at the end of a search to create a loop for an easy restart for the user

```clojure
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
``` 
### Pokemon Park Sorting 

This function, as well as asking the color of a pokemon that the user saw, it process the previously entered park and access to the according function

```clojure
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
``` 

### Pokemon Color Cheking

Once inside the right function, thanks to the previous one, the user is ask to enter a color. If the color matches the according library, the user accesses the next function.

```clojure
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
```

### Pokemon Elements Checking

This function matches the element type of the Pokemon, and keeps in memory the color previously entered to print out the mix of the two elements, proving the "filtering" Pokemon's search

```clojure 
(defn pikachuElem [c]
  (newline)
  (println "What was the Pokemon Element type ?")
  (let [Element (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? pikachuE Element) [(println "Yes, there is a" c "" Element "type Pokemon")
                                    (println "Congratulations, you found a Pikachu !")]
      :else [(println "There is no" c "and" Element "Pokemon in this park") (pikachuElem c)])))
```


### Authors

Thibault Masse - Alexandre Zouaki - Nicolas Felis

