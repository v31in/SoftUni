package conditionalStatements;

import java.util.Scanner;

public class P06SpeedInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double speed = Double.parseDouble(scanner.nextLine());

        String textResult = "";
        if (speed <= 10) {
            textResult = "slow";
        } else if (speed <= 50) {
            textResult = "average";
        } else if (speed <= 150) {
            textResult = "fast";
        } else if (speed <= 1000) {
            textResult = "ultra fast";
        } else {
            textResult = "extremely fast";
        }

        System.out.println(textResult);
    }
}