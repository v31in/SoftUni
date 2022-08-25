package P03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budjet = Integer.parseInt(scanner.nextLine()); //Бюджет на групата – цяло число в интервала [1…8000]
        String season = scanner.nextLine(); //Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"
        int fishermanCount = Integer.parseInt(scanner.nextLine()); //Брой рибари – цяло число в интервала [4…18]

        double rentPrice = 0;

        switch (season){
            case "Spring":
                rentPrice = 3000;
                if (fishermanCount <= 6) {
                    rentPrice = rentPrice - (rentPrice * 0.10);
                } else if (fishermanCount > 7 && fishermanCount <=11) {
                    rentPrice = rentPrice - (rentPrice * 0.15);
                } else if (fishermanCount >= 12) {
                    rentPrice = rentPrice - (rentPrice * 0.25);
                }
                if (fishermanCount % 2 == 0) {
                    rentPrice = rentPrice - (rentPrice * 0.05);
                }
                break;
            case "Summer":
                rentPrice = 4200;
                if (fishermanCount <= 6) {
                    rentPrice = rentPrice - (rentPrice * 0.10);
                } else if (fishermanCount > 7 && fishermanCount <=11) {
                    rentPrice = rentPrice - (rentPrice * 0.15);
                } else if (fishermanCount >= 12) {
                    rentPrice = rentPrice - (rentPrice * 0.25);
                }
                if (fishermanCount % 2 == 0) {
                    rentPrice = rentPrice - (rentPrice * 0.05);
                }
                break;
            case  "Autumn":
                rentPrice = 4200;
                if (fishermanCount <= 6) {
                    rentPrice = rentPrice - (rentPrice * 0.10);
                } else if (fishermanCount > 7 && fishermanCount <=11) {
                    rentPrice = rentPrice - (rentPrice * 0.15);
                } else if (fishermanCount >= 12) {
                    rentPrice = rentPrice - (rentPrice * 0.25);
                }
                break;
            case "Winter":
                rentPrice = 2600;
                if (fishermanCount <= 6) {
                    rentPrice = rentPrice - (rentPrice * 0.10);
                } else if (fishermanCount > 7 && fishermanCount <=11) {
                    rentPrice = rentPrice - (rentPrice * 0.15);
                } else if (fishermanCount >= 12) {
                    rentPrice = rentPrice - (rentPrice * 0.25);
                }
                if (fishermanCount % 2 == 0) {
                    rentPrice = rentPrice - (rentPrice * 0.05);
                }
                break;
        }
        double diff = Math.abs(budjet-rentPrice);
        if (budjet>= rentPrice) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }

    }
}
