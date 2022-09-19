import java.util.Scanner;

public class CoffeeMachine_3_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int numberDrinks = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double totalPrice = 0;

        switch (drink) {
            case "Espresso":
                if (sugar.equals("Without")) {
                    price = 0.90 * 0.65;
                } else if (sugar.equals("Normal")) {
                    price = 1.00;
                } else if (sugar.equals("Extra")) {
                    price = 1.20;
                }
                if (numberDrinks>=5) {
                    price = price * 0.75;
                }
                break;
            case "Cappuccino":
                if (sugar.equals("Without")) {
                    price = 1.00 * 0.65;
                } else if (sugar.equals("Normal")) {
                    price = 1.20;
                } else if (sugar.equals("Extra")) {
                    price = 1.60;
                }
                break;
            case "Tea":
                if (sugar.equals("Without")) {
                    price = 0.50 * 0.65;
                } else if (sugar.equals("Normal")) {
                    price = 0.60;
                } else if (sugar.equals("Extra")) {
                    price = 0.70;
                }
                break;
        }
            totalPrice = price * numberDrinks;

        if (totalPrice > 15) {
            totalPrice = totalPrice * 0.8;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", numberDrinks,drink, totalPrice);
    }
}
