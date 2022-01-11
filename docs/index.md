## Park Chatbot in Clojure

### Introduction

The city of Prague likes our chatbot application and it got implemented. Nevertheless, after a few
months of usage, the city would like us to enhance it with more interactive features, namely, they
would like to provide the users with the possibility to identify pokemon in the
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

### Activities function

In order to give information to the user about activities to do in the park, we had to create one function per park linking the different librairies and the user input. Here is an example of one function activities:

```clojure

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

```

### Pokemon Library

In order to give information about pokemon that are in the parks, we had to create libraries for each pokemon we can find in the parks. Here is the libraries we created :
```clojure

(def Pikachu #{"yellow" "Yellow" "Electric" "electric"})
(def Charmander #{"Orange" "orange" "Fire" "fire"})
(def Bulbasaur #{"Green" "green" "Grass" "grass"})
(def Squirtle #{"Blue" "blue" "Water" "water"})

```
### Sorting Pokemon 
In order to find the pokemons more easily, we had to create a code that sorting pokemons per park. Here is the codes we created:
```clojure

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
    
```
### Pokemon Location
To locate pokemon more easily, we have created functions that allow them to be found in parks. Here is an example of one function Pokemon Location:
```clojure

(defn pokemonBert []
  (let [c (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? BertramkaP c) [(println "Yes, there is some" c "in Bertramka") (whatPokemonColor c)]
      (contains? Exitline c) (exit-f)
      :else [(println "This pokemon cannot be in Bertramka") (println "What is the name of the Pokemon again ?") (pokemonBert)])))

``` 
### Pokemon Color Sorting 
To find the pokemon more easily we have created a function which allows them to be sorted by color. We also had to add parameters so that the chatbot recognizes the name of the pokemon regardless of the writing.Here is the codes we created:
```clojure

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
    
``` 

### Pokemon Color Cheking
To find the pokemon more easily, we have written a function that allows you to check the color of the pokemon.Here is an example of one function Pokemon Color Cheking:
```clojure

(defn pikachuColor []
  (let [color (read-line)]
    (newline) (Thread/sleep 1000)
    (cond
      (contains? PikachuC color) [(println "Yes, the color of Pikachu is" color ".") (pikachuElem)]
      (contains? Exitline color) (exit-f)
      :else [(println "Pikachu isn't" color "! You certainly saw a different Pokemon.") (println "What was the Pokemon color again ?") (pikachuColor)])))

```

### Pokemon Elements
To more easily identify the pokemon we have created a function which allows you to know which element is the pokemon. Here is an example of one function Pokemon Elements:
```clojure 
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
      
```


### Authors

Thibault Masse & Alexandre Zouaki & Nicolas Felis

