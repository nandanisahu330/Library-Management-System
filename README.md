# Library-Management-System
# -Library-Management-System
A simple Java-based Library Management System demonstrating Object-Oriented Programming (OOP) principles such as encapsulation, abstraction, and association. The system allows managing books, users, and book borrowing/returning operations.

## Features
- **Book Management**: Add books with title, author, and ISBN.
- **User Management**: Register users with a unique ID and name.
- **Book Issuing**: Borrow books to registered users with a 14-day due date.
- **Book Returning**: Return borrowed books to the library.
- **Overdue Tracking**: Identify books past their due date.

## Project Structure
The project consists of three main classes:
- `Book`: Represents a book with attributes like title, author, ISBN, availability, current borrower, and due date.
- `User`: Represents a user with attributes like user ID, name, and a list of borrowed books.
- `Library`: Manages collections of books and users, and handles operations like issuing and returning books.

## OOP Concepts Demonstrated
- **Encapsulation**: Private fields with public getters/setters to control access.
- **Abstraction**: High-level methods in the `Library` class hide implementation details.
- **Association**: Relationships between `Book` and `User` (e.g., a user borrows books, a book has a borrower).
- **Modularity**: Each class has a single responsibility, improving maintainability.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with command-line compilation tools

## Setup
1. Clone or download the repository.
2. Ensure JDK is installed and configured (`java -version` to verify).
3. Place the Java source file (`Library.java`) in a project directory.

## Usage
1. Compile the program:
   ```bash
   javac Library.java
