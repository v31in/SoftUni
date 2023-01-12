package exam1;

import java.util.Scanner;

public class E01Excursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfPeople = Integer.parseInt(scanner.nextLine()); //1. Броят на хората в групата – цяло число в интервала [0 … 50]
        int nights = Integer.parseInt(scanner.nextLine()); //2. Броят на нощувките – цяло число в интервала [0 … 2000]
        int transportCards = Integer.parseInt(scanner.nextLine()); //3. Броят на картите за транспорт – цяло число в интервала [0… 2000]
        int museumTickets = Integer.parseInt(scanner.nextLine()); //4. Броят на билетите за музеи – цяло число в интервала [0 … 2000]

        int totalnightsPrice = nights * 20;
        double totalCardsPrice = transportCards * 1.60;
        double totalMuseumTicketsPrice = museumTickets * 6;

        double total = (totalnightsPrice + totalCardsPrice + totalMuseumTicketsPrice) * numberOfPeople * 1.25;

        //System.out.println(totalnightsPrice);
        //System.out.println(totalCardsPrice);
        //System.out.println(totalMuseumTicketsPrice);
        System.out.printf("%.2f", total);

    }
}
