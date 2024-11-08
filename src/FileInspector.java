import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File chosen: " + selectedFile.getName());
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }
                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
            }
        }
    }
}
