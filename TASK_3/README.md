# 📚 Library Management System (Java CLI)

A simple **Command-Line Interface (CLI)** program to manage books and users using Java.  
Implements **OOP concepts** such as **Abstraction**, **Inheritance**, and **Polymorphism**.

---

## 📂 Project Structure
```
LibraryManagement/
├── Main.java       # Entry point with menu & flow control
├── Book.java       # Model class for book details
├── User.java       # Model class for user details
├── Library.java    # Manages books, users, issue & return operations
```

---

## 🛠 Features
- Add new books
- Register users
- View available books
- Issue books to users
- Return issued books
- Prevents double-issuing of the same book
- Demonstrates:
  - **Encapsulation** (private fields + getters/setters)
  - **Inheritance**
  - **Polymorphism**
  - **HAS-A** relationships

---

## 🚀 How to Run

### **1. Clone the repository**
```bash
git clone <your_repo_url>
cd <repo_folder>
```

---

### **2. Compile the code**
If using package `LibraryManagement`, compile from the parent folder:
```bash
javac LibraryManagement\Main.java LibraryManagement\Book.java LibraryManagement\User.java LibraryManagement\Library.java
```

---

### **3. Run the program**
```bash
java LibraryManagement.Main
```

---

### **4. Menu Options**
```
--- Library Management System ---
1. Add Book
2. Register User
3. View Available Books
4. Issue Book
5. Return Book
6. Exit
Enter choice:
```

---

## 📝 Example Usage
```
Enter choice: 1
Enter Book ID: B101
Enter Title: Java Basics
Enter Author: John Doe
Book added successfully!

Enter choice: 3
ID: B101 | Title: Java Basics | Author: John Doe | Available: Yes

Enter choice: 4
Enter User ID: U201
Enter Book ID: B101
Book issued successfully!
```

---

## 📚 Concepts Used
- **Classes and Objects**
- **Encapsulation**
- **Inheritance**
- **Polymorphism**
- **Abstraction**
- **HAS-A vs IS-A Relationships**
- **Method Overriding**
- **Constructor Chaining**
- **`super` keyword**

---

## 📌 Requirements
- Java JDK 8 or above
- Terminal/Command Prompt
- Any text editor or IDE (VS Code, IntelliJ, Eclipse, etc.)

---

## 💡 Notes
- If you remove the `package LibraryManagement;` line from `.java` files,  
  you can compile and run directly from inside the folder:
```bash
cd LibraryManagement
javac Main.java Book.java User.java Library.java
java Main
```
- Always compile before running to reflect changes.

---

## 🔄 Program Flow Diagram (ASCII)
```
+----------------------------+
|   Library Management App   |
+----------------------------+
            |
            v
   +--------------------+
   |  Display Main Menu |
   +--------------------+
            |
            v
+-------------------+      +---------------------+
| User Chooses:     | ---> |  Exit Program       |
| 1. Add Book       |      +---------------------+
| 2. Register User  |
| 3. View Books     |
| 4. Issue Book     |
| 5. Return Book    |
| 6. Exit           |
+-------------------+
            |
            v
   +----------------------+
   | Perform Operation    |
   +----------------------+
            |
            v
   +----------------------+
   | Return to Main Menu  |
   +----------------------+
```

---

## 📄 Task Reference
**Objective:** Develop a mini system to manage books and users.  
**Tools:** Java, VS Code, Terminal.  
**Key Concepts:** Abstraction, Inheritance, Polymorphism.

**Hints:**
1. Create classes: `Book`, `User`, `Library`.
2. Implement book issue and return features.

---
