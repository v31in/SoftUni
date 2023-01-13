package P01FirstStepsInCodingExercise;

import java.util.Scanner;

public class L08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tax = Double.parseDouble(scanner.nextLine());

        double sneakersPrice = tax - (tax * 0.40);

        double uniformPrice = sneakersPrice - (sneakersPrice * 0.20);

        double ballPrice = uniformPrice / 4;

        double accessories = ballPrice / 5;

        double totalPrice = tax + sneakersPrice + uniformPrice + ballPrice + accessories;

        System.out.println(totalPrice);

    }
}