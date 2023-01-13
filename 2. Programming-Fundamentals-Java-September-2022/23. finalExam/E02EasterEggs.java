package finalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        // @@@@green@*/10/@yel0w@*26*#red#####//8//@limon*@*23*@@@red#*/%^&/6/@gree_een@/notnumber/###purple@@@@@*$%^&*/5/

        String regexValidBarcode = "[@#]+(?<color>[a-z]{3,})[@#]+[^A-Za-z0-9]*\\/+(?<amount>[0-9]+)\\/+";

        Pattern pattern = Pattern.compile(regexValidBarcode);

        Matcher matcher = pattern.matcher(input);

        StringBuilder outputItems = new StringBuilder();

        while (matcher.find()) {
            // "You found 10 green eggs!"

            int number = Integer.parseInt(matcher.group("amount"));
            String color = matcher.group("color");

            outputItems.append(String.format("You found %d %s eggs!%n", number, color));


        }
        System.out.println(outputItems);

    }
}
