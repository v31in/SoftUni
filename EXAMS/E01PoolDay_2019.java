import java.util.Scanner;

public class PoolDay_1_2019 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        double taxEntrance = Double.parseDouble(scanner.nextLine());
        double priceOneShezlong = Double.parseDouble(scanner.nextLine());
        double priceOneUmbrella = Double.parseDouble(scanner.nextLine());

        double allTax = peopleCount * taxEntrance;
        double allPriceShezlongs = (Math.ceil(peopleCount * 0.75)) * priceOneShezlong;
        double allPriceUmbrella = (Math.ceil(peopleCount * 0.50)) * priceOneUmbrella;

        double totalPrice = allTax + allPriceShezlongs + allPriceUmbrella;
        System.out.printf("%.2f lv.", totalPrice);
    }
}
