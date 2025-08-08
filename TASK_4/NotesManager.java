package TASK_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles reading/writing notes to a text file (notes.txt).
 * Uses FileWriter (append/overwrite) and BufferedReader/FileReader for reading.
 */
public class NotesManager {
    private final File notesFile;

    public NotesManager(String filename) {
        this.notesFile = new File(filename);
        try {
            // ensure file exists
            if (!notesFile.exists()) {
                notesFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error initializing notes file: " + e.getMessage());
        }
    }

    /**
     * Append a single note as a new line.
     */
    public void addNote(Note note) {
        // append mode = true
        try (FileWriter fw = new FileWriter(notesFile, true)) {
            fw.write(note.getText().replaceAll("\\r?\\n", " ") + System.lineSeparator());
            // flush happens on close in try-with-resources
            System.out.println("Note added successfully.");
        } catch (IOException e) {
            System.out.println("Failed to add note: " + e.getMessage());
        }
    }

    /**
     * Read all notes and return as a list.
     */
    public ArrayList<Note> readAllNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(notesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    notes.add(new Note(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read notes: " + e.getMessage());
        }
        return notes;
    }

    /**
     * Overwrite file with provided notes list.
     * Use carefully (this replaces file contents).
     */
    public void overwriteNotes(ArrayList<Note> notes) {
        try (FileWriter fw = new FileWriter(notesFile, false)) { // overwrite mode
            for (Note n : notes) {
                fw.write(n.getText().replaceAll("\\r?\\n", " ") + System.lineSeparator());
            }
            System.out.println("Notes saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save notes: " + e.getMessage());
        }
    }

    /**
     * Delete a note at 1-based index. Returns true if deleted.
     */
    public boolean deleteNoteAtIndex(int index) {
        ArrayList<Note> notes = readAllNotes();
        if (index < 1 || index > notes.size()) {
            return false;
        }
        notes.remove(index - 1);
        overwriteNotes(notes);
        return true;
    }

    /**
     * Clear all notes (truncate file).
     */
    public void clearAllNotes() {
        try (FileWriter fw = new FileWriter(notesFile, false)) {
            // writing nothing truncates the file
            System.out.println("All notes cleared.");
        } catch (IOException e) {
            System.out.println("Failed to clear notes: " + e.getMessage());
        }
    }

    /**
     * Return the absolute path of the notes file (useful for user info).
     */
    public String getNotesFilePath() {
        try {
            return notesFile.getCanonicalPath();
        } catch (IOException e) {
            return notesFile.getAbsolutePath();
        }
    }
}
