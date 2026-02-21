# AI_PROMPTS_A3.md

## Conversation 1

### User Prompt

I'm working with java and I currently have a file that is an I want to make it more Object oretiant

### Assistant Response (Summary)

The assistant explained how to make a Java file more object-oriented by:

* Introducing encapsulation (grouping data and behavior together)
* Reducing excessive use of static methods
* Creating proper domain classes
* Following the Single Responsibility Principle
* Moving logic out of main and into separate classes

The assistant provided:

* An example of procedural vs object-oriented code
* A Person class example
* A checklist for refactoring into OOP
* Suggestions such as using interfaces and service layers

---

## Conversation 2

### User Prompt

ETLPipeline Here is an example of my code

(Full ETLPipeline.java file was provided by the user.)

### Assistant Response (Refactor to OOP)

The assistant refactored the design into a more object-oriented structure by introducing:

1. Product Class (Domain Model)

   * Encapsulated product fields (id, name, price, category)
   * Moved transformation logic into the object
   * Added methods like transform(), getPriceRange(), and toCsvRow()

2. ETLService Class (Service Layer)

   * Responsible for processing the file
   * Handles parsing, transformation, and writing output
   * Separates file logic from domain logic

3. ETLPipeline Class (Entry Point Only)

   * Contains only the main method
   * Instantiates ETLService
   * Delegates execution

The assistant emphasized:

* Separation of concerns
* Removing unnecessary static methods
* Improved testability
* Clear architecture (Domain → Service → Entry)

---

