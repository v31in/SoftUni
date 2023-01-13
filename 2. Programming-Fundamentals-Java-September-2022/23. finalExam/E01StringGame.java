package finalExam;

import java.util.Scanner;

public class E01StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String myString = scanner.nextLine(); // "//Th1s 1s my str1ng!//"

        String command = scanner.nextLine();

        while (!command.equals("Done")) {

            if (command.contains("Change")) {
                // 1. "Change {char} {charNew}"
                // "Change 1 i" -> {"Change" "1" "i"}
                String charOld = command.split("\\s+")[1];      // "1"
                String charNew = command.split("\\s+")[2];  // "i"

                if (myString.contains(charOld)) {
                    myString = myString.replace(charOld, charNew);
                }
                System.out.println(myString);

            } else if (command.contains("Includes")) {
                // 2. "Includes {substring}"
                //  "Includes string"
                String substring = command.split("\\s+")[1];

                if (myString.contains(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (command.contains("End")) {
                // 3. "End {substring}"
                // "End my"
                String substring = command.split("\\s+")[1]; // "my"
                int lenght = myString.length() - substring.length();
                if (myString.substring(lenght).equals(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (command.contains("Uppercase")) {
                // 4. "Uppercase"
                myString = myString.toUpperCase();
                System.out.println(myString);

            } else if (command.contains("FindIndex")) {
                // 5. "FindIndex {char}"
                // "FindIndex I"
                String findIndex = command.split("\\s+")[1]; // "I"

                if (myString.contains(findIndex)) {
                    int print = myString.indexOf(findIndex);
                    System.out.println(print);
                }
            } else if (command.contains("Cut")) {
                // 6. "Cut {startIndex} {count}"
                // "Cut 5 5"
                // {//Th1s 1s my str1ng!//}
                int startIndex = Integer.parseInt(command.split("\\s+")[1]); // 5
                int count = Integer.parseInt(command.split("\\s+")[2]);      // 5

                int endIndex = startIndex + count;

                System.out.println(myString.substring(startIndex, endIndex));
            }


            command = scanner.nextLine();
        }

    }
}
