package TASK_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. View Available Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bId = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bId, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    String uId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    library.registerUser(new User(uId, name));
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    String issueUserId = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    String issueBookId = sc.nextLine();
                    library.issueBook(issueUserId, issueBookId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    String returnBookId = sc.nextLine();
                    library.returnBook(returnBookId);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
