package P01FirstStepsInCodingExercise;

import java.util.Scanner;

public class L04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pages = Integer.parseInt(scanner.nextLine());
        int pagesHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int completedBook = pages / pagesHour ;

        int hoursPerDay = completedBook / days ;

        System.out.println(hoursPerDay);

    }
}
