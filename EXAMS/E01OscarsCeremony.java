package ExamPreparation;

import java.util.Scanner;

public class E01OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());

        double statuesPrice = rent * 0.7;
        double cateringPrice = statuesPrice * 0.85;
        double soundPrice = cateringPrice / 2;

        double totalPrice = statuesPrice + cateringPrice + soundPrice + rent;

        System.out.printf("%.2f", totalPrice);
    }
}
