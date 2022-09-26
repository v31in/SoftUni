package P03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFlowers = scanner.nextLine();  //Вид цветя - текст с възможности - "Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        int numberOfFlowers = Integer.parseInt(scanner.nextLine());    //Брой цветя - цяло число в интервала [10…1000]
        int budjet = Integer.parseInt(scanner.nextLine());    //Бюджет - цяло число в интервала [50…2500]

        double price = 0;

        switch (typeOfFlowers) {
            case "Roses":
                price = numberOfFlowers *5;
                if (numberOfFlowers>80) {
                    price = price - (price * 0.10);
                }
                break;
            case "Dahlias":
                price = numberOfFlowers *3.80;
                if (numberOfFlowers>90) {
                    price = price - (price * 0.15);
                }
                break;
            case "Tulips":
                price = numberOfFlowers *2.80;
                if (numberOfFlowers>80) {
                    price = price - (price * 0.15);
                }
                break;
            case "Narcissus":
                price = numberOfFlowers *3;
                if (numberOfFlowers<120) {
                    price = price + (price * 0.15);
                }
                break;
            case "Gladiolus":
                price = numberOfFlowers *2.50;
                if (numberOfFlowers<80) {
                    price = price + (price * 0.20);
                }
                break;
        }
        if (budjet>=price) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, typeOfFlowers, budjet-price);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", price-budjet);
        }
    }
}
