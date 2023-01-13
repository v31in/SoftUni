package exam1;

import java.util.Scanner;

public class E05Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int countDays = 1;
        boolean isFailed = false;
        int totalMeters = 0;
        int goal = 3484;
        boolean golaReached = false;

        while (!input.equals("END")) {

            if (input.equals("Yes")) {
                countDays++;
            }
            if (countDays > 5) {
                isFailed = true;
                break;
            }

            int metersClimed = Integer.parseInt(scanner.nextLine());

            totalMeters = totalMeters + metersClimed;

            if (totalMeters >= goal) {
                golaReached = true;
                break;
            }

            input = scanner.nextLine();
        }
        if (isFailed) {
            System.out.println("Failed!");
            System.out.printf("%d", totalMeters + 5364);
        } else if (golaReached) {
            System.out.printf("Goal reached for %d days!", countDays);

        } else {
            System.out.println("Failed!");
            System.out.printf("%d", totalMeters + 5364);
        }

    }
}
