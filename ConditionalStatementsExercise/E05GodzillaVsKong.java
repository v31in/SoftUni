package P02ConditionalStatementsExercise;

import java.util.Scanner;

public class E05GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budjet = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double clothesPrice = Double.parseDouble(scanner.nextLine());

        double decor = budjet * 0.10;

        double allPriceClothes = clothesPrice * statists;

        if (statists > 150) {
            allPriceClothes = allPriceClothes - (allPriceClothes * 0.10);
        }

        double  totalSum = allPriceClothes + decor;

        if (totalSum > budjet) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalSum - budjet);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budjet - totalSum);

        }
    }
}
