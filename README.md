# DN5-JavaFSE-Solutions

Solutions for Cognizant's **Digital Nurture 5.0 – Deep Skilling Program**  
Track: Java Full Stack Engineer (FSE)

---

## About

This repository contains my hands-on exercise submissions for the DN 5.0 Deep Skilling program.  
The program covers 16 modules over 7 weeks including Design Patterns, DSA, Spring Boot, Microservices, React, and more.

- **University:** Lovely Professional University  
- **Program:** B.Tech Computer Science and Engineering (2023–2027)  
- **GitHub:** [dev-sharma-ui](https://github.com/dev-sharma-ui)

---

## Repository Structure

```
DN5-JavaFSE-Solutions/
│
├── Week1_Engineering_Concepts/
│   ├── Design_Patterns/
│   │   ├── SingletonPatternExample/
│   │   └── FactoryMethodPatternExample/
│   └── DSA/
│       ├── EcommercePlatformSearch/
│       └── FinancialForecasting/
│
├── Week2_Programming_Languages/
├── Week3_Products_Frameworks/
├── Week4_Spring_REST/
├── Week5_Microservices/
├── Week6_React/
└── Week7_Platforms_GenAI/
```

---

## Week 1 – Engineering Concepts

### Module 1: Design Patterns and Principles

#### Exercise 1 – Singleton Pattern
**Scenario:** Ensure a logging utility class has only one instance throughout the application lifecycle.

| File | Description |
|------|-------------|
| `Logger.java` | Singleton class with private constructor and static getInstance() method |
| `SingletonTest.java` | Verifies only one instance is created across multiple calls |

**Key concept:** The constructor is private so no external class can call `new Logger()`. The static `getInstance()` method returns the same object every time.

---

#### Exercise 2 – Factory Method Pattern
**Scenario:** A document management system that creates different types of documents (Word, PDF, Excel) using the Factory Method pattern.

| File | Description |
|------|-------------|
| `Document.java` | Interface defining open, save, close methods |
| `WordDocument.java` | Concrete implementation for Word |
| `PdfDocument.java` | Concrete implementation for PDF |
| `ExcelDocument.java` | Concrete implementation for Excel |
| `DocumentFactory.java` | Abstract factory with createDocument() method |
| `WordDocumentFactory.java` | Returns a WordDocument |
| `PdfDocumentFactory.java` | Returns a PdfDocument |
| `ExcelDocumentFactory.java` | Returns an ExcelDocument |
| `FactoryMethodTest.java` | Tests creation of all three document types |

**Key concept:** The client code works with the `Document` interface and never calls `new` on a concrete class directly. Adding a new document type only requires a new factory — existing code stays untouched.

---

### Module 2: Data Structures and Algorithms

#### Exercise 2 – E-commerce Platform Search
**Scenario:** Implement and compare linear search and binary search for a product catalogue.

| File | Description |
|------|-------------|
| `Product.java` | Product class with productId, productName, category |
| `ProductSearch.java` | Linear search O(n) and binary search O(log n) implementations |
| `ProductSearchTest.java` | Tests both algorithms, including not-found cases |

**Linear Search** – scans every element one by one. Works on unsorted arrays. Time complexity O(n).  
**Binary Search** – repeatedly halves the search range. Requires a sorted array. Time complexity O(log n).  

For a large product catalogue, binary search is significantly faster once the data is sorted.

---

#### Exercise 7 – Financial Forecasting
**Scenario:** Predict future investment values based on present value and a growth rate using recursion.

| File | Description |
|------|-------------|
| `FinancialForecaster.java` | Recursive and memoized recursive implementations |
| `FinancialForecastingTest.java` | Tests forecasting for multiple years and growth rates |

**Recursive formula:**
```
futureValue(value, rate, 0) = value
futureValue(value, rate, n) = futureValue(value, rate, n-1) * (1 + rate)
```

The memoized version caches results for each period so they are not recalculated on repeated queries.

---

## How to Run

Each exercise is a standalone Java project with no external dependencies.

```bash
# Compile
javac -d out src/com/ecommerce/search/*.java

# Run
java -cp out com.ecommerce.search.ProductSearchTest
```

Recommended IDE: **IntelliJ IDEA** or **Eclipse**  
Java version: **Java 17+**

---

## Progress Tracker

| Week | Module | Status |
|------|--------|--------|
| Week 1 | Design Patterns and Principles | ✅ Done |
| Week 1 | Data Structures and Algorithms | ✅ Done |
| Week 2 | PL/SQL Programming | 🔄 In Progress |
| Week 2 | TDD and Logging Framework | ⏳ Pending |
| Week 3 | Spring Core and Maven | ⏳ Pending |
| Week 3 | Spring Data JPA with Hibernate | ⏳ Pending |
| Week 4 | Spring REST using Spring Boot 3 | ⏳ Pending |
| Week 5 | Microservices with Spring Cloud | ⏳ Pending |
| Week 6 | React | ⏳ Pending |
| Week 7 | Git, DevOps, Docker, Cloud, GenAI | ⏳ Pending |

---

## License

This repository is for educational purposes as part of the Cognizant DN 5.0 program.
