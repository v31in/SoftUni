package exam1;

import java.util.Scanner;

public class E04ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // броя на моделите компютри
        double realSales = 0;
        double totalSales = 0;
        double totalRateing = 0;

        for (int i = 1; i <= n ; i++) {

            int input = Integer.parseInt(scanner.nextLine()); // възможните продажби и рейтинга

            double rateing = input * 1.0 % 10;

            int posibleSales = input / 10;

            if (rateing == 2) {
                realSales = 0;
            } else if (rateing == 3) {
                realSales = posibleSales * 0.5;
            } else if (rateing == 4) {
                realSales = posibleSales * 0.7;
            } else if (rateing == 5) {
                realSales = posibleSales * 0.85;
            } else if (rateing == 6) {
                realSales = posibleSales * 1.0;
            }
            totalSales = totalSales + realSales;
            totalRateing = totalRateing + rateing;
        }
        System.out.printf("%.2f%n", totalSales);
        System.out.printf("%.2f", totalRateing/n);

    }
}
