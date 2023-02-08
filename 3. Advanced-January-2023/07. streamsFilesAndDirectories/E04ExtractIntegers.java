package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class E04ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {

        String basePath = "C:\\Users\\ludic\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\04_output.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));
//        PrintStream writer = System.out;

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }

            reader.next();
        }
    }
}