# Travel Itinerary Assistant – Java Console App

## Application Overview

Travel Itinerary Assistant is a Java console application that helps users plan and manage their travel trips. It allows users to:

- Add trips with destination and date ranges
- Add notes and accommodations to each trip
- Set and track budget per trip
- View all trip details in an organized format
- Persist data using file serialization
- Interact through a user-friendly command-line interface

This project was built to demonstrate object-oriented design, clean code, exception handling, data persistence, and test-driven development.

---

## Technologies & Design Patterns Used

| **Technology / Pattern** | **Purpose / Justification**                                                         |
| ------------------------ | ----------------------------------------------------------------------------------- |
| Java SE                  | Core programming language for building the application                              |
| Packages                 | Clean separation of concerns (`domain`, `data`, `util`, `exception`, `app`, `test`) |
| Encapsulation            | Each class controls its own internal data (e.g., `Trip`, `Budget`)                  |
| Composition              | `Trip` contains `Budget`, `List<Accommodation>`, `List<Note>`                       |
| Serialization (I/O)      | Used in `TripDataManager` to save/load trips to/from a text file (`trips.txt`)      |
| Custom Exception         | `InvalidInputException` used to demonstrate exception handling                      |
| JUnit 5                  | Unit testing of core domain logic (`TripTest.java`)                                 |

---

## Setup & Execution

### 1. Prerequisites

- Java JDK 17+
- [JUnit 5 Standalone Console JAR](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar)

### 2. Compile All Java Files

# PowerShell

$files = Get-ChildItem -Recurse -Filter \*.java | ForEach-Object { $\_.FullName }
javac -cp ".;junit-platform-console-standalone-1.10.0.jar" -d out $files

### 3. Run the app

java -cp out app.App

### 4. Run the Test

Run the Test:
java -jar junit-platform-console-standalone-1.10.0.jar -cp out --scan-classpath

## UML Diagrams

Class Diagram

Trip
├── destination : String
├── startDate : String
├── endDate : String
├── notes : List<Note>
├── accommodations : List<Accommodation>
├── budget : Budget
├── addNote()
├── addAccommodation()
└── toString()

Note
├── content : String
├── createdAt : String
└── toString()

Accommodation
├── name : String
├── address : String
├── cost : double
└── toString()

Budget
├── limit : double
├── spent : double
├── setLimit()
├── addSpent()
└── getRemaining()

TripDataManager
├── saveTrips()
└── loadTrips()

App (main)
└── Console UI & logic

InputHelper
└── getString(), getInt(), getDouble()

Architectural Diagram

+------------------+
| app.App | ← Main entry point
+------------------+
|
v
+------------------+ +--------------------+
| TripDataManager | <--> | File I/O |
+------------------+ +--------------------+
|
v
+------------------+ +--------------------+
| Trip |<----->| Note, Budget, |
| | | Accommodation |
+------------------+ +--------------------+

+------------------+
| InputHelper |
| (console input) |
+------------------+

---

### 4. Known limitations

- No date validation logic (invalid formats not caught)
- Trip duplication allowed
- Notes and accommodations cannot be edited or deleted once added
- Budget limits are not enforced (user can overspend

### 5. Future improvements

- Validate date formats with regex or LocalDate
- Add option to delete/edit trips, notes, and accommodations
- Refactor to MVC pattern for clearer separation
- Introduce sorting/filtering of trips
- Export trips to PDF/CSV
- Migrate to GUI (JavaFX or Swing)
