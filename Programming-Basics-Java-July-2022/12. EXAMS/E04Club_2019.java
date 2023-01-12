import java.util.Scanner;

public class Club_4_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededIncome = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        double totalPrice = 0;
        boolean target = false;

        while (!input.equals("Party!")) {
            String coctailName = input;
            int coctailCount = Integer.parseInt(scanner.nextLine());

            double coctailPrice = coctailCount * coctailName.length();
            if (coctailPrice % 2 != 0) {
                coctailPrice = coctailPrice * 0.75;
            }

            totalPrice = totalPrice + coctailPrice;

            if (totalPrice >= neededIncome) {
                target = true;
                break;
            }

            input = scanner.nextLine();
        }
            if (target) {
                System.out.println("Target acquired.");
                System.out.printf("Club income - %.2f leva.", totalPrice);
            } else {
                System.out.printf("We need %.2f leva more.%n", neededIncome-totalPrice);
                System.out.printf("Club income - %.2f leva.", totalPrice);

            }
    }
}
