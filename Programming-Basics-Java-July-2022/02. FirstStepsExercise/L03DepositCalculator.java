package P01FirstStepsInCodingExercise;

import java.util.Scanner;

public class L03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double deposit = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double sum = deposit + months * ((deposit * percent / 100) / 12) ;

        System.out.println(sum);

    }
}
