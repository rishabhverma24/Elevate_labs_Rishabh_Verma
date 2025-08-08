package TASK_3;


import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void issueBook(String userId, String bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already issued!");
            return;
        }
        book.setAvailable(false);
        System.out.println("Book issued successfully to " + user.getName() + "!");
    }

    public void returnBook(String bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (book.isAvailable()) {
            System.out.println("Book is already available!");
            return;
        }
        book.setAvailable(true);
        System.out.println("Book returned successfully!");
    }

    private Book findBook(String bookId) {
        for (Book b : books) {
            if (b.getBookId().equalsIgnoreCase(bookId)) {
                return b;
            }
        }
        return null;
    }

    private User findUser(String userId) {
        for (User u : users) {
            if (u.getUserId().equalsIgnoreCase(userId)) {
                return u;
            }
        }
        return null;
    }
}
