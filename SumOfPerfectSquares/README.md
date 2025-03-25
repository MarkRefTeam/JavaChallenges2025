# SumOfPerfectSquares

A small Java console application that lets the user enter numbers and calculates the sum of perfect squares up to that number. Includes input validation, scoring system, duplicate input detection, and a few fun easter eggs!

## ✨ Features

- ✅ Validates user input based on specific rules
- ✅ Calculates sum of perfect squares up to `n`
- ✅ Prevents repeated entries (anti-cheat mechanism)
- ✅ Scoring system based on user input
- ✅ Special hidden messages for numbers like 42, 69, 7, and 13 (Easter eggs 😄)

## 🚀 Getting Started

### Requirements

- Java 23+
- Maven 3.6+

### Build & Run

Clone the repository and run the project using Maven:

```bash
git clone https://github.com/<your-username>/SumOfPerfectSquares.git
cd SumOfPerfectSquares
mvn compile
mvn exec:java -Dexec.mainClass="org.example.App"

SumOfPerfectSquares/
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── org.example
│   │           ├── App.java
│   │           └── PerfectSquareCalculator.java
│   └── test
│       └── java
│           └── org.example
│               └── AppTest.java



