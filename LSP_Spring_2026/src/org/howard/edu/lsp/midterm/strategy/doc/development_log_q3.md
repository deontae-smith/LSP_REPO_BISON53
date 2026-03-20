# Research Documentation

## 1. Strategy Pattern in Java
- **Search:** "Java Strategy Pattern site:stackoverflow.com"  
- **How it helped:** Provided examples of implementing the Strategy Pattern in Java, showing how to separate different behaviors into their own classes and use a context class to apply them. This guided the refactoring of `PriceCalculator` to use `PricingStrategy` classes.  

## 2. Java Interfaces and Polymorphism
- **Search:** "Java interface tutorial oracle"  
- **How it helped:** Reviewed how to define and implement Java interfaces. Helped structure `PricingStrategy` as an interface and implement multiple pricing strategies

## 3. Open/Closed Principle (SOLID) in Java
- **Search:** "Open Closed Principle example Java"  
- **How it helped:** Reinforced why the original `PriceCalculator` design was not maintainable. Guided the use of the Strategy Pattern to make the system open for extension but closed for modification.  

## 4. Dynamic behavior with Strategy Pattern
- **Search:** "Java strategy pattern change behavior at runtime"  
- **How it helped:** Showed how to change strategies dynamically at runtime using a setter method. This inspired the `setPricingStrategy` method in the `PriceCalculator` class.  


## 5. Java Best Practices for Package Structure
- **Search:** "Java package naming conventions"  
- **How it helped:** Ensured all classes were placed in the correct package `org.howard.edu.lsp.midterm.strategy` and followed standard naming conventions.  