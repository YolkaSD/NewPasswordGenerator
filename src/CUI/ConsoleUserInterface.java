package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    public StringBuilder start(){
        StringBuilder userArguments = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String configMsg = "1 - number\n" +
                "2 - symbol\n" +
                "3 - special symbol\n" +
                "input: ";

        System.out.format("Plz, enter the required password components in the format:\n%s", configMsg);
        boolean isCorrectInput = false;
        while (!isCorrectInput)
        {
            String input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("(?!.*(\\d).*\\1)^[123]{1,3}$")) {
                userArguments.append(input);
                isCorrectInput = true;
            } else {
                System.out.format("Plz, Please enter a components as required \n%s", configMsg);
            }
        }
        return userArguments;
    }
}

