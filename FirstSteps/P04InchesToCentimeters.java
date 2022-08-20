package L01firstSteps;

import java.util.Scanner;

public class P04InchesToCentimeters {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inch = Double.parseDouble(scanner.nextLine());

        double result = inch * 2.54;

        System.out.println(result);

    }

}
