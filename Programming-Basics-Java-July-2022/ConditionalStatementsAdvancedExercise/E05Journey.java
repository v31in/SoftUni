package P03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budjet = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        double spendMoney = 0;
        String destination = "";
        String typeOfPlace = "";
        if (budjet <= 100) {
            switch (season) {
                case "summer":
                    spendMoney = budjet * 0.30;
                    destination = "Bulgaria";
                    break;
                case "winter":
                    spendMoney = budjet * 0.70;
                    destination = "Bulgaria";
                    break;
            }
        } else if (budjet > 100 && budjet <= 1000) {
            switch (season) {
                case "summer":
                    spendMoney = budjet * 0.40;
                    destination = "Balkans";
                    break;
                case "winter":
                    spendMoney = budjet * 0.80;
                    destination = "Balkans";
                    break;
            }
        } else if (budjet > 1000) {
            switch (season) {
                case "summer":
                case "winter":
                    spendMoney = budjet * 0.90;
                    destination = "Europe";
                    break;
            }
        }
        System.out.printf("Somewhere in %s%n", destination);

        if (season.equals("summer")) {
            typeOfPlace = "Camp";

        } else if (season.equals("winter")){
            typeOfPlace = "Hotel";
        }
        if (destination.equals("Europe")) {
            typeOfPlace = "Hotel";

        }
        System.out.printf("%s - %.2f",typeOfPlace, spendMoney);
    }
}
