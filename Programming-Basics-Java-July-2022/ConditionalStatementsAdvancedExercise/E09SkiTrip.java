package P03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stay = Integer.parseInt(scanner.nextLine());
        //Първи ред - дни за престой - цяло число в интервала [0...365]
        String roomType = scanner.nextLine();
        //Втори ред - вид помещение - "room for one person", "apartment" или "president apartment"
        String rating =  scanner.nextLine();
        //Трети ред - оценка - "positive"  или "negative"

        double room = 18;
        double app = 25;
        double presidentApp = 35;
        int nightsStay = stay - 1;

        double price = 0;

        switch (roomType) {
            case "room for one person":
                price = room * nightsStay;
                break;
            case "apartment":
                if (stay<10) {
                    price = app * nightsStay * 0.70;
                } else if (stay >=10 && stay <=15) {
                    price = app * nightsStay * 0.65;
                } else if (stay > 15) {
                    price = app * nightsStay * 0.50;
                }
                break;
            case "president apartment":
                if (stay<10) {
                    price = presidentApp * nightsStay * 0.90;
                } else if (stay >=10 && nightsStay <=15) {
                    price = presidentApp * nightsStay * 0.85;
                } else if (stay > 15) {
                    price = presidentApp * nightsStay * 0.80;
                }
                break;
        }

        if (rating.equals("positive")) {
            price = price * 1.25;
        } else if (rating.equals("negative")) {
            price = price * 0.90;
        }
        System.out.printf("%.2f", price);
    }
}
