package exam1;

import java.util.Scanner;

public class E03FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberDancers = Integer.parseInt(scanner.nextLine()); // 1. Брой танцьори
        double points = Double.parseDouble(scanner.nextLine()); // 2. Брой точки
        String season = scanner.nextLine(); // 3. Сезон
        String place = scanner.nextLine(); // 4. Място

        double spechelenaSuma = 0;

        switch (place) {
            case "Bulgaria":
                spechelenaSuma = points * numberDancers;

                if (season.equals("summer")) {
                    spechelenaSuma = spechelenaSuma * 0.95;
                } else if (season.equals("winter")) {
                    spechelenaSuma = spechelenaSuma * 0.92;
                }
                break;
            case "Abroad":
                spechelenaSuma = points * numberDancers * 1.5;
                if (season.equals("summer")) {
                    spechelenaSuma = spechelenaSuma * 0.90;
                } else if (season.equals("winter")) {
                    spechelenaSuma = spechelenaSuma * 0.85;
                }
                break;
        }
        double charity = spechelenaSuma * 0.75;
        double sum = (spechelenaSuma - charity) / numberDancers;
        System.out.printf("Charity - %.2f%n", charity);
        System.out.printf("Money per dancer - %.2f%n", sum);
    }
}
