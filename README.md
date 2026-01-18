# Library Management System in Java
A simple console-based Library Management System implemented in Java demonstrating basic Object-Oriented Programming (OOP) concepts such as inheritance, polymorphism, abstraction, encapsulation and custom exceptions.

---

## Features
- Add / remove books
- List all books
- Add / remove members (Student/Teacher)
- List all members
- Borrow books with stock and borrow limit checks
- Return borrowed books
- Prevent duplicate borrowing of the same book
  
---

## Skills Demonstrated
- ### Object-Oriented Programming (OOP)
  - Inheritance (Student and Teacher extend Member)
  - Polymorphism (different borrow limits based on the member type)
  - Abstraction (abstract Member class and HasBorrowLimit interface)
  - Encapsulation (private fields + getters)
- ### Collections
  - HashMap for storing books and members
  - ArrayList for tracking borrowed books
- ### Custom Exceptions
  - BookNotFoundException and MemberNotFoundException
  - BorrowLimitExceededException
  - OutOfStockException
  - BookNotBorrowedException and BookAlreadyBorrowedException
- ### Console-based UI
  - Menu-driven interaction using `Scanner`
 
---

## How to Run
1. Navigate to the project folder:
```bash
cd LibraryManagementSystem
```
2. Compile the Java files:
```bash
javac src/*.java
```
3. Run the program:
```bash
java -cp src Main
```
