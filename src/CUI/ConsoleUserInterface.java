package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    public String start(){
        Scanner scanner = new Scanner(System.in);
        String configMsg =
                "1 - digits (0-9)\n" +
                "2 - upper case (A-Z)\n" +
                "3 - lower case (a-z)\n" +
                "4 - special symbol !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n" +
                "5 - several special symbol from the !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n" +
                "0 - EXIT\n" +
                "input: ";
        String configSpecMsg =
                "enter several special symbol from the !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n" +
                "0 - EXIT\n" +
                "input: ";

        System.out.format("Plz, enter the required password components in the format:\n%s", configMsg);
        String firstInput = null;
        String specInput = null;
        boolean isCorrectInput = false;
        while (!isCorrectInput)
        {
            firstInput = scanner.nextLine();
            if (firstInput.matches("(?!.*(\\d).*\\1)^[1234]{1,4}$")) {
                isCorrectInput = true;
            } else if (firstInput.matches("(?!.*(\\d).*\\1)^[1235]{1,4}$")) {
                System.out.println("Selecting special characters in development");
                isCorrectInput = true;
                specInput = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n";
            } else if (firstInput.equals("0")){
                isCorrectInput = true;
            } else {
                System.out.format("Plz, Please enter a components as required \n%s", configMsg);
            }
        }
        return firstInput + ":" + specInput;
    }

}

