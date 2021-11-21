## Park Chatbot in Clojure

### Introduction

The Prague Municipality decided to promote the many natural landscapes in Prague (as Stromovka or Prokopske udoli). As they want to open the opportunity for new perspectives on tourist guides, they ask people to join a competition.

Our team of hobby devs are joining the competition, and we want to present a chatbot solution that would seamlessly allow the user to communicate about his walk in the Prague nature.

The current chatbot will follow the idea of the classical ELIZA system.

### Usage

The chatbot is written in Clojure, a functional programming language running on Java Virtual Machine. Depending on your operating system different steps are necessary to install the required components:

Java Development Kit (JDK) version 11 or newer.

Leiningen

A Command Line Interface (CLI)

### Main

Here is the main function which begin the chatbot.

```

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


