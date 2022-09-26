import java.util.Scanner;

public class PCGameShop_5_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countHeartstone = 0;
        int countFornite = 0;
        int countOverwatch = 0;
        int countOthers = 0;

        for (int i = 1; i <= n ; i++) {
            String name = scanner.nextLine();

            if (name.equals("Hearthstone")) {
                countHeartstone++;
            } else if (name.equals("Fornite")) {
                countFornite++;
            } else if (name.equals("Overwatch")) {
                countOverwatch++;
            } else {
                countOthers++;
            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", (countHeartstone * 1.0/n) * 100);
        System.out.printf("Fornite - %.2f%%%n", (countFornite * 1.0/n) * 100);
        System.out.printf("Overwatch - %.2f%%%n", (countOverwatch * 1.0/n) * 100);
        System.out.printf("Others - %.2f%%%n", (countOthers * 1.0/n) * 100);

    }
}
