package streamsFilesAndDirectoriesExercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E05LineNumbers {
    public static void main(String[] args) throws IOException {
        //1. прочитам всички редове от файл inputLineNumbers.txt
        //2. обхождаме всеки ред -> записваме в нов файл с пореден номер отпред
        String path = "C:\\Users\\ludic\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("output_line_numbers.txt");
        int lineNumber = 1;
        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }

        writer.close(); //спирам да пиша във файла и файлът се затваря

    }
}