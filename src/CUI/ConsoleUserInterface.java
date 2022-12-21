package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    public int[] start(){
        int[] userArguments = new int[3];
        //String[] arguments Make it a class field?
        String[] arguments = {"numbers", "symbols", "special symbols"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password options");
        int index = 0;
        while (index < 3) {
            System.out.format("Will the password contain %s?:\n1 - Yes\n0 - No\n2 - Exit\nInput: ", arguments[index]);
            int input;
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == 0 || input == 1) {
                    userArguments[index] = input;
                } else if (input == 2) {
                    System.exit(-1);
                } else {
                    System.out.print("Incorrect input :( ");
                    index--;
                }
            } else {
                System.out.println("Please restart program and enter the correct number");
                System.exit(-2);
            }
            index++;
        }
        return userArguments;
    }
}

