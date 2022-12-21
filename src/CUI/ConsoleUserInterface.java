package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    public char[] start(){
        char[] userArguments = new char[3];
        //String[] arguments Make it a class field?
        String[] arguments = {"numbers", "symbols", "special symbols"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password options");
        int index = 0;
        while (index < 3) {
            System.out.format("Will the password contain %s?:\n1 - Yes\n0 - No\n2 - Exit\nInput: ", arguments[index]);
                String input = scanner.nextLine();
                if (input.equals("0") || input.equals("1")) {
                    userArguments[index] = Character.forDigit(Integer.parseInt(input), 10);
                } else if (input.equals("2")) {
                    System.exit(-1);
                } else {
                    System.out.print("Incorrect input :( ");
                    index--;
                }
            index++;
        }
        scanner.close();
        return userArguments;
    }
}

