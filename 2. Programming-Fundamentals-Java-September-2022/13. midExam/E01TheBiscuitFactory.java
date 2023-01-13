package midExam;

import java.util.Scanner;

public class E01TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numBiscuitsPerDayPerWorker = Integer.parseInt(scanner.nextLine());
        int countWorkers = Integer.parseInt(scanner.nextLine());
        long numBiscuitsPer30DaysRivalCompany = Long.parseLong(scanner.nextLine());

        double numBiscuitsPerDay = 0;
        double numBiscuits = 0;
        for (int day = 1; day <= 30 ; day++) {

            if (day % 3 == 0) {
                numBiscuitsPerDay = Math.floor((numBiscuitsPerDayPerWorker * countWorkers) * 0.75);
                numBiscuits += numBiscuitsPerDay;
            } else {
                numBiscuitsPerDay = Math.floor(numBiscuitsPerDayPerWorker * countWorkers);
                numBiscuits += numBiscuitsPerDay;
            }
        }
        //17160 – 16000 = 1160 - difference between your and the other factory production
        //1160/16000 * 100 = 7.25% more biscuits.
        double percent = Math.abs((numBiscuits - numBiscuitsPer30DaysRivalCompany) / numBiscuitsPer30DaysRivalCompany * 100);

        if (numBiscuits > numBiscuitsPer30DaysRivalCompany) {
            System.out.printf("You have produced %.0f biscuits for the past month.%n", numBiscuits);
            System.out.printf("You produce %.2f percent more biscuits.", percent);
        } else {
            System.out.printf("You have produced %.0f biscuits for the past month.%n", numBiscuits);
            System.out.printf("You produce %.2f percent less biscuits.", percent);
        }


    }
}
