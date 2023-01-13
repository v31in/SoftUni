package L05WhileLoop;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        boolean isExcluded = false;
        int year = 1;
        int poorGradesCount = 0;
        double sumAllGrades = 0;
        while (year <= 12) {
            if (poorGradesCount > 1) {
                isExcluded = true;
                break;
            }

            double grade = Double.parseDouble(scanner.nextLine());

            if (grade < 4) {
                poorGradesCount++;
                continue;
            }

            sumAllGrades += grade;

            year++;
        }

        if (isExcluded) {
            System.out.printf("%s has been excluded at %d grade%n", name, year);
        } else {
            double avgGrade = sumAllGrades / 12;
            System.out.printf("%s graduated. Average grade: %.2f%n", name, avgGrade);
        }

    }
}
