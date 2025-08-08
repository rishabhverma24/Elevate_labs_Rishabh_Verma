# Student Record Management System (Java CLI)

A simple **Command-Line Interface (CLI)** program to manage student records using Java.  
Supports **CRUD operations**: Create, Read, Update, and Delete student details.

---

## 📂 Project Structure
```
TASK_2/
├── Main.java       # Main program logic with menu
├── Student.java    # Student class (model)
```

---

## 🛠 Features
- Add new students
- View all students
- Update existing student details
- Delete students by ID
- Uses `ArrayList` for dynamic storage
- Demonstrates **Encapsulation**, **Collections**, and **OOP** concepts in Java

---

## 🚀 How to Run

### **1. Clone the repository**
```bash
git clone <your_repo_url>
cd <repo_folder>
```

---

### **2. Compile the code**

#### If using the package `TASK_2`

From the **parent folder** (where the `TASK_2` folder is located):

```bash
javac TASK_2\Main.java TASK_2\Student.java
```

---

### **3. Run the program**
```bash
java TASK_2.Main
```

---

### **4. Menu Options**
Once the program starts, you’ll see:
```
--- Student Record Management System ---
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter choice:
```

---

## 📝 Example Usage
```
Enter choice: 1
Enter ID: 101
Enter Name: Alice
Enter Marks: 88.5
Student added successfully!

Enter choice: 2
ID: 101, Name: Alice, Marks: 88.5
```

---

## 📚 Concepts Used
* **Classes and Objects**
* **Encapsulation** (private fields + getters/setters)
* **ArrayList** for storing records
* **Loops & Conditional Statements**
* **Package structure in Java**

---

## 📌 Requirements
* Java JDK 8 or above
* Terminal/Command Prompt

---

## 💡 Notes
* If you remove the `package TASK_2;` line from both `.java` files,  
  you can compile and run directly from inside the folder:
```bash
cd TASK_2
javac Main.java Student.java
java Main
```
* Always compile before running to reflect changes.
