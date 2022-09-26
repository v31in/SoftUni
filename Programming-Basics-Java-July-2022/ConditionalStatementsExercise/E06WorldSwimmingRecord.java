package P02ConditionalStatementsExercise;

import java.util.Scanner;

public class E06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeForMeter = Double.parseDouble(scanner.nextLine());

        double targetTime = distance * timeForMeter;
        double resistence = Math.floor(distance/15);
        double resistenceInSeconds = resistence * 12.5;
        double allTime = targetTime + resistenceInSeconds;
        if (record > allTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", allTime);
        } else {
           System.out.printf("No, he failed! He was %.2f seconds slower.", Math.abs(record-allTime));

        }
    }
}
