package regularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> furnitureNames = new ArrayList<>(); //имената на мебелите
        double totalSum = 0 ; //общо изхарчена сума за всички въведени мебели

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex); //шаблон

        String input = scanner.nextLine();
        while(!input.equals("Purchase")) {
            //input = ">>Sofa<<312.23!3"
            Matcher matcher = pattern.matcher(input);
            //matcher = ">>(?<furniture>Sofa)<<(?<price>312.23)!(?<quantity>3)"

            //true -> input отговарят на шаблона
            //false -> input не отговаря на шаблона
            if (matcher.find()) {
                String furnitureName = matcher.group("furniture"); //"Sofa"
                double price = Double.parseDouble(matcher.group("price")); //"312.23" -> parse -> 312.23
                int quantity = Integer.parseInt(matcher.group("quantity")); //"3" -> parse -> 3

                furnitureNames.add(furnitureName);
                double currentFurniturePrice = price * quantity; //платено за текущата мебел
                totalSum += currentFurniturePrice;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furnitureNames.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
