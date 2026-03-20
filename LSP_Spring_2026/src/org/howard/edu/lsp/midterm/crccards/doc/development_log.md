# Development Log

- **Java Documentation (Oracle):**  
  https://docs.oracle.com/javase/8/docs/api/  
  Used for understanding `HashMap`, `List`, and `ArrayList` behavior.

- **Lecture Notes:**  
  Used to review CRC cards and object-oriented design principles.

- **ChatGPT:**  
  During this assignment, I started by writing my own initial implementations of the `Task` and `TaskManager` classes based on the CRC cards. I set up the fields, constructors, and basic getters and setters. However, I ran into a few issues:  
  1. When implementing `setStatus()` in `Task`, I initially forgot to handle invalid status values correctly, which caused some test cases in the `Driver` to fail.  
  2. In `TaskManager`, I tried using a `List<Task>` to store tasks, but I realized it didn’t easily prevent duplicate `taskId`s or allow efficient lookup by ID.  

  To resolve these problems, I carefully researched Java’s Collections Framework and experimented with a `HashMap<String, Task>` to store tasks. I then used ChatGPT as a debugging and guidance tool to validate my approach. ChatGPT helped me:  

  - Confirm that using a `HashMap` would prevent duplicate task IDs and allow efficient task lookup.  
  - Refine my `setStatus()` method so invalid statuses would be set to `"UNKNOWN"`.  
  - Make sure that `getTasksByStatus()` correctly filtered tasks by their current status.  

  After following these suggestions and combining them with my own code, I tested the program with the provided `Driver` class. All features worked correctly, including:

  - Displaying only `OPEN` tasks  
  - Detecting duplicate task IDs  
  - Handling invalid status values  
  - Finding tasks by ID  
