package P01FirstStepsInCodingExercise;

import java.util.Scanner;

public class L06Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int tinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double nylonPrice = (nylon + 2) * 1.5;
        double paintPrice = (paint * 14.5) * 1.1;
        double tinnerPrice = tinner * 5.0;
        double bags = 0.4;

        double totalMaterialsPrice = nylonPrice + paintPrice + tinnerPrice + bags;
        double workerPrice = (totalMaterialsPrice * 0.30) * hours;
        double total = totalMaterialsPrice + workerPrice;

        System.out.println(total);


    }
}
