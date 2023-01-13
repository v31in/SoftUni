package textProcessingExercise;

import java.util.Scanner;

public class E03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        //"C:\Internal\training-internal\Template.pptx".split("\") -> ["C:", "Internal", "training-internal", "Template.pptx"]
        String [] pathParts = path.split("\\\\"); //["C:", "Internal", "training-internal", "Template.pptx"]
        String fullFileName = pathParts[pathParts.length - 1]; // "Template.pptx"

        // "Template.pptx".split(".") -> ["Template", "pptx"]
        String fileName = fullFileName.split("\\.")[0]; // "Template.pptx".split(".") -> ["Template", "pptx"]
        String extension = fullFileName.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}