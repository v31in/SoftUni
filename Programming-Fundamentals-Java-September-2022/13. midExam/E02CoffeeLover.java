package midExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> startingList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {

            String inputLine = scanner.nextLine();
            String[] commandsLine = inputLine.split(" ");
            String command = commandsLine[0];

            switch (command) {
                case "Include":
                    String includeItem = commandsLine[1];
                    startingList.add(commandsLine[1]);
                    break;
                case "Remove":
                    String removeItems = commandsLine[1];
                    int number = Integer.parseInt(commandsLine[2]);
                    if (removeItems.contains("first")) {
                        //
                        for (int j = 0; j < number; j++) {
                            startingList.remove(0);
                            }
                    } else if (removeItems.contains("last")) {
                        for (int j = number; j > 0; j--) {
                            startingList.remove(startingList.size() - 1);
                        }
                    }
                    break;
                case "Prefer":
                    int preferCoffeeIndex1 = Integer.parseInt(commandsLine[1]);
                    int preferCoffeeIndex2 = Integer.parseInt(commandsLine[2]);

                    if (startingList.size() - 1 >= preferCoffeeIndex1 && startingList.size() - 1 >= preferCoffeeIndex2) {
                        String firstElement = startingList.get(preferCoffeeIndex1);
                        String secondElement = startingList.get(preferCoffeeIndex2);
                        startingList.set(preferCoffeeIndex1, secondElement);
                        startingList.set(preferCoffeeIndex2, firstElement);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(startingList);
                    break;

            }

        }
        System.out.println("Coffees:");
        System.out.println(String.join(" ", startingList));
    }
}