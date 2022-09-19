import java.util.Scanner;

public class FamilyTrip_2_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budjet = Double.parseDouble(scanner.nextLine()); // Бюджетът, с който разполагат
        int nights = Integer.parseInt(scanner.nextLine()); // Брой нощувки
        double priceForOneNight = Double.parseDouble(scanner.nextLine()); // Цена за нощувка
        int percentExtraExpences = Integer.parseInt(scanner.nextLine()); // Процент за допълнителни разходи

        double priceForAllStay = 0;

        if (nights > 7) {
            priceForAllStay = priceForOneNight * nights * 0.95;
        } else {
            priceForAllStay = priceForOneNight * nights;
        }

        double percentAll = percentExtraExpences * budjet / 100;

        double allExpences = priceForAllStay + percentAll;

        if (budjet >= allExpences) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", Math.abs(budjet-allExpences));
        } else {
            System.out.printf("%.2f leva needed.", Math.abs(budjet-allExpences));
        }
    }
}
