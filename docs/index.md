## Park Chatbot in Clojure

### Introduction

The Prague Municipality decided to promote the many natural landscapes in Prague (as Stromovka or Prokopske udoli). As they want to open the opportunity for new perspectives on tourist guides, they ask people to join a competition.

Our team of hobby devs are joining the competition, and we want to present a chatbot solution that would seamlessly allow the user to communicate about his walk in the Prague nature.

The current chatbot will follow the idea of the classical ELIZA system.

### Running the programm

The chatbot is written in Clojure, a functional programming language running on Java Virtual Machine. Depending on your operating system different steps are necessary to install the required components:

1. Java Development Kit (JDK) version 11 or newer.

2. Leiningen

3. A Command Line Interface (CLI)

### Usage

In order to start the chatbot, here is the command line to enter :

```sh

git clone https://github.com/tibsdu91/Thibault-AlexandreZ.git  #Clone the github repository, request your Gituhub credentials.
cd /chatbotclojure  #Browse the project folder.
lein run  #Run the chatbot and start interaction. Type :done at anytime to quit the app.

```
### Main function

Here is the main function which begin the chatbot.

```Clojure

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

```Clojure

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


### Authors

Thibault Masse & Alexandre Zouaki

