package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phonesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            String[] commandsLine = inputLine.split(" - ");
            String command = commandsLine[0];

            switch (command) {
                case "Add":
                    String addPhone = commandsLine[1];
                    if (!phonesList.contains(addPhone)) {
                        phonesList.add(addPhone);
                    }
                    break;
                case "Remove":
                    String removePhone = commandsLine[1];
                    if (phonesList.contains(removePhone)) {
                        phonesList.remove(removePhone);
                    }
                    break;
                case "Bonus phone":
                    String[] bonusPhone = commandsLine[1].split(":");
                    String oldPhone = bonusPhone[0];
                    String newPhone = bonusPhone[1];
                    if (phonesList.contains(oldPhone)) {
                        int index = phonesList.indexOf(oldPhone);
                        phonesList.add(index + 1, newPhone);
                    }
                    break;
                case "Last":
                    String lastPhone = commandsLine[1];
                    if (phonesList.contains(lastPhone)) {
                        String thisPhone = lastPhone;
                        phonesList.remove(lastPhone);
                        phonesList.add(thisPhone);
                    }
                    break;
            }

            inputLine = scanner.nextLine();
        }

        System.out.println(String.join(", ", phonesList));
    }
}
