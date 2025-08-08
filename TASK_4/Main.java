package TASK_4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CLI for the Notes App.
 * Features:
 *  - Add note (append)
 *  - View notes
 *  - Delete note by index
 *  - Clear all notes
 *  - Export (overwrite) — save all from interactive input (optional)
 */
public class Main {
    private static final String FILENAME = "notes.txt";

    public static void main(String[] args) {
        NotesManager manager = new NotesManager(FILENAME);
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Notes file path: " + manager.getNotesFilePath());

        do {
            printMenu();
            while (!sc.hasNextInt()) {
                System.out.print("Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter note text: ");
                    String text = sc.nextLine().trim();
                    if (text.isEmpty()) {
                        System.out.println("Empty note ignored.");
                    } else {
                        manager.addNote(new Note(text));
                    }
                    break;

                case 2:
                    ArrayList<Note> notes = manager.readAllNotes();
                    if (notes.isEmpty()) {
                        System.out.println("No notes found.");
                    } else {
                        System.out.println("--- Your Notes ---");
                        int i = 1;
                        for (Note n : notes) {
                            System.out.println(i++ + ". " + n.getText());
                        }
                    }
                    break;

                case 3:
                    ArrayList<Note> listForDelete = manager.readAllNotes();
                    if (listForDelete.isEmpty()) {
                        System.out.println("No notes to delete.");
                        break;
                    }
                    System.out.println("Enter note number to delete:");
                    int delIndex;
                    while (!sc.hasNextInt()) {
                        System.out.print("Enter a number: ");
                        sc.next();
                    }
                    delIndex = sc.nextInt();
                    sc.nextLine();
                    boolean deleted = manager.deleteNoteAtIndex(delIndex);
                    System.out.println(deleted ? "Note deleted." : "Invalid index.");
                    break;

                case 4:
                    System.out.print("Are you sure you want to clear all notes? (y/n): ");
                    String confirm = sc.nextLine().trim().toLowerCase();
                    if (confirm.equals("y") || confirm.equals("yes")) {
                        manager.clearAllNotes();
                    } else {
                        System.out.println("Clear cancelled.");
                    }
                    break;

                case 5:
                    // Optional: interactive overwrite example
                    System.out.println("Enter notes line by line. Enter a single '.' on a line to finish.");
                    ArrayList<Note> newNotes = new ArrayList<>();
                    while (true) {
                        String line = sc.nextLine();
                        if (line.equals(".")) break;
                        if (!line.trim().isEmpty()) newNotes.add(new Note(line.trim()));
                    }
                    manager.overwriteNotes(newNotes);
                    break;

                case 6:
                    System.out.println("Exiting. Bye.");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Notes App ---");
        System.out.println("1. Add Note (append)");
        System.out.println("2. View Notes");
        System.out.println("3. Delete Note by Number");
        System.out.println("4. Clear All Notes");
        System.out.println("5. Overwrite Notes (interactive)");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }
}
