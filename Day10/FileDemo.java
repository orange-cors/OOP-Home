package Day10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) {
        try {
            // 1. Create File object
            File file = new File("testfile.txt");

            // 2. Check if file exists
            System.out.println("File exists? " + file.exists());

            // 3. Create file if not exists
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }

            // 4. File information
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Is file? " + file.isFile());
            System.out.println("Is directory? " + file.isDirectory());

            // 5. Write to file
            FileWriter writer = new FileWriter(file);
            writer.write("Hello World!\n");
            writer.write("This is the second line.");
            writer.close();
            System.out.println("Data written to file.");

            // 6. Read file content
            System.out.println("\nFile content:");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();

            // 7. Work with directory
            File folder = new File("MyFolder");
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("\nFolder created: " + folder.getName());
            }

            // 8. List files in current directory
            System.out.println("\nFiles in current directory:");
            File currentDir = new File(".");
            File[] list = currentDir.listFiles();
            for (File f : list) {
                System.out.println("- " + f.getName());
            }

            // 9. Delete file (optional)
            // file.delete();
            // System.out.println("File deleted.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

