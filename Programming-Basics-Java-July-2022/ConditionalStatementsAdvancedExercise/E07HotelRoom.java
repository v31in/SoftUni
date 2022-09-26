package P03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();        //На първия ред е месецът – May, June, July, August, September или October
        int nightsCount = Integer.parseInt(scanner.nextLine());        //На втория ред е броят на нощувките – цяло число в интервала [0 ... 200]

        double studioPrice = 0;
        double appPrice = 0;

        if (month.equals("May") || (month.equals("October"))) {
            studioPrice = 50 * nightsCount;
            appPrice = 65 * nightsCount;
            if (nightsCount>7 && nightsCount<=14) {
                studioPrice = studioPrice * 0.95;
            } else if (nightsCount>14) {
                studioPrice = studioPrice * 0.70;
                appPrice = appPrice * 0.90;
            }
        } else if (month.equals("June") || (month.equals("September"))) {
            studioPrice = 75.20 * nightsCount;
            appPrice = 68.70 * nightsCount;
            if (nightsCount > 14) {
                studioPrice = studioPrice * 0.80;
                appPrice = appPrice * 0.90;
            }
        } else if (month.equals("July") || (month.equals("August"))) {
            studioPrice = 76 * nightsCount;
            appPrice = 77 * nightsCount;
            if (nightsCount > 14) {
                appPrice = appPrice * 0.90;
            }
        }

        System.out.printf("Apartment: %.2f lv.%n",appPrice);
        System.out.printf("Studio: %.2f lv.",studioPrice);

    }
}
