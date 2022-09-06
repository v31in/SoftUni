package L05WhileLoop;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        double sum = 0;
        while (!inputLine.equals("NoMoreMoney")) {
            double amount = Double.parseDouble(inputLine);
            if (amount < 0) {
                System.out.println("Invalid operation!");
                break;
            }

            sum += amount;
            System.out.printf("Increase: %.2f%n", amount);
            inputLine = scanner.nextLine();
        }

        System.out.printf("Total: %.2f%n", sum);

    }
}
