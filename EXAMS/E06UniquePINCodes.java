package exam1;

import java.util.Scanner;

public class E06UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int counter = 0;

        for (int i = 2; i <= first; i +=2) {
            for (int j = 2; j <=second ; j++) {
                for (int k = 2; k <= third ; k +=2) {

                    if (j!=4 && j!=6 && j!=8 && j!=9)
                        System.out.printf("%d %d %d%n", i, j, k);

                }

            }

        }

    }
}
