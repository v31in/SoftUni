package P04ForLoop;

import java.util.Scanner;

public class E03Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200){
                p1 = p1 + 1;
            } else if (number >=200 && number <400) {
                p2 = p2 + 1;
            } else if (number >=400 && number < 600) {
                p3 = p3 + 1;
            } else if (number >= 600 && number < 800 ) {
                p4 = p4 + 1;
            } else if (number >=800) {
                p5 = p5 + 1;
            }
        }
        double percent1 = p1 *1.0 / n *100;
        double percent2 = p2 *1.0 / n *100;
        double percent3 = p3 *1.0 / n *100;
        double percent4 = p4 *1.0 / n *100;
        double percent5 = p5 *1.0 / n *100;

        System.out.printf("%.2f%%%n", percent1);
        System.out.printf("%.2f%%%n", percent2);
        System.out.printf("%.2f%%%n", percent3);
        System.out.printf("%.2f%%%n", percent4);
        System.out.printf("%.2f%%%n", percent5);

    }
}
