import java.io.*;
import java.nio.file.*;

public class FileOperations {

    public static void main(String[] args) {
        
        String filePath = "C:\\Users\\raj76\\OneDrive\\Desktop\\JAVA\\example.txt";

        // Write content to the file (overwrite)
        writeFile(filePath,"File handling in Java refers to the process of creating, reading, writing, modifying, and deleting files through Java programs. It allows persistent storage of data — meaning the data remains even after the program ends..\n");

        // Read the file
        readFile(filePath);

        //Modify word
        modifyFile(filePath, "creating", "forming");
        System.out.println("Content After Modification: ");
        readFile(filePath);

        //Append another line
        appendToFile(filePath, "This is an appended line.\n File operations may cause errors (e.g., file not found), so Java requires handling exceptions like IOException using try-catch blocks.\n");

        //Final read to show updated content
        readFile(filePath);
    }

    // Write new content to the file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read and display file content
    public static void readFile(String filePath) {
        System.out.println("Reading file content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

   // Append content to the file
    public static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("Content appended successfully.\n");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

     // Replace oldWord with newWord in file content
    public static void modifyFile(String filePath, String oldWord, String newWord) {
        try {
            Path path = Paths.get(filePath);
            String content = new String(Files.readAllBytes(path));
            content = content.replaceAll(oldWord, newWord);
            Files.write(path, content.getBytes());
            System.out.println("File modified successfully.\n");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}
