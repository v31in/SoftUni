package L03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String weekDay = scanner.nextLine();

        if (hour >=10 && hour <=18){
            if (weekDay.equals("Monday") ||
                weekDay.equals("Tuesday") ||
                weekDay.equals("Wednesday") ||
                weekDay.equals("Thursday") ||
                weekDay.equals("Friday")||
                weekDay.equals("Saturday")) {
                    System.out.println("open");
            } else if (weekDay.equals("Sunday")) {
                System.out.println("closed");
            }
        } else { System.out.println("closed");

        }
    }
}
