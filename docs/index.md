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


### Authors

Thibault Masse & Alexandre Zouaki & Nicolas Felis

