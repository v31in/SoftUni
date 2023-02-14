package streamsFilesAndDirectoriesExercises;

import java.io.File;

public class E08GetFolderSize {
    public static void main(String[] args) {

        String pathFolder = "C:\\Users\\ludic\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathFolder);

        File[] allFilesInFolder = folder.listFiles(); //масив с всички файлове в папката

        int folderSize = 0; //размер на папката
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }

        System.out.println("Folder size: " + folderSize);
    }
}
