import java.util.Scanner;

public class NameGame_6_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int points = 0;
        String winningName = "";

        while (!name.equals("Stop")) {
            int n = name.length();
            int currentPoints = 0;

            for (int i = 0; i <= n-1 ; i++) {
                int number = Integer.parseInt(scanner.nextLine());

                if (number == name.charAt(i)){
                    currentPoints = currentPoints + 10;
                } else {
                    currentPoints = currentPoints + 2;
                }

            }
            if (currentPoints >= points){
                points = currentPoints;
                winningName = name;

            }

            name = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winningName, points);
    }
}
