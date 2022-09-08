package P05WhileLoopExercise;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyNeededForExcursion = Double.parseDouble(scanner.nextLine());
        double money = Double.parseDouble(scanner.nextLine());

        int spendCount = 0;
        boolean isFailed = false;
        int daysCount =0;

        while (money < moneyNeededForExcursion) {
            daysCount++;
            String command = scanner.nextLine();
            double moneySavedOrSpend = Double.parseDouble(scanner.nextLine());

            switch (command) {
                case "spend":
                    spendCount++;
                    money = money - moneySavedOrSpend;

                    if (money < 0) {
                        money = 0;
                    }


                    break;

                case "save":
                    spendCount=0;
                    money = money + moneySavedOrSpend;

                    break;
            }
            if (spendCount >= 5) {
                isFailed = true;
                break;
            }

        }
        if (isFailed) {
            System.out.println("You can't save the money.");
            System.out.println(daysCount);
        } else {
            System.out.printf("You saved the money for %d days.", daysCount);

        }
    }
}
