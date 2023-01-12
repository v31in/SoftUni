package P01FirstStepsInCodingExercise;

import java.util.Scanner;

public class L07FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int vegetarianMenu = Integer.parseInt(scanner.nextLine());

        double priceForChicken = chickenMenu * 10.35;
        double priceForFish = fishMenu * 12.40;
        double priceForVegan = vegetarianMenu * 8.15;

        double priceAllMenus = priceForChicken + priceForVegan + priceForFish;

        double priceDesert = priceAllMenus * 0.20;

        double totalPrice = priceAllMenus + priceDesert + 2.5;

        System.out.println(totalPrice);

    }
}