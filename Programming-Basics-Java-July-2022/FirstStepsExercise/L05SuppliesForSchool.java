package P01FirstStepsInCodingExercise;

import java.util.Scanner;

public class L05SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int litersPrep = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());

        double priceBeforeDiscount = pens * 5.8 + markers * 7.2 + litersPrep *1.2 ;

        double finalPrice = priceBeforeDiscount - (priceBeforeDiscount * percentDiscount / 100);
        System.out.printf("%.2f", finalPrice);

    }
}
