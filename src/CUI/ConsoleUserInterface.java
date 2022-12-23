package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    private final static int MIN_LENGTH = 4;
    private final static int MAX_LENGTH = 99;
    private String userConfig;
    private int userLength;
    private final Scanner scanner = new Scanner(System.in);
    public void start(){
        setUserLength();
        setUserConfig();
        scanner.close();
    }
    public String getUserConfig() {
        return userConfig;
    }
    public int getUserLength() {
        return userLength;
    }
    private void setUserConfig(){
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
                System.exit(-1);
            } else {
                System.out.format("Plz, Please enter a components as required \n%s", configMsg);
            }
        }
        userConfig = firstInput + specInput;
    }
    private void setUserLength(){
        String configMsg =
                "Please enter password length from 4 to 99\n" +
                "0 - EXIT\n" +
                "Input: ";
        System.out.println(configMsg);
        boolean isInputCorrect = false;
        while (!isInputCorrect){
            String input = scanner.nextLine();
            if (input.matches("^\\d{1,2}$") && Integer.parseInt(input) > 3) {
                userLength = Integer.parseInt(input);
                isInputCorrect = true;
            } else if (input.equals("0")) {
                System.exit(-1);
            } else {
                System.out.print(configMsg);
            }
        }

    }
}

