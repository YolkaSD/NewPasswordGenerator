package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    private final static int MIN_LENGTH = 4;
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
        System.out.format("Plz, enter the required password components in the format:\n%s", configMsg);
        String firstInput;
        boolean isCorrectInput = false;
        while (!isCorrectInput)
        {
            firstInput = scanner.nextLine();
            if (firstInput.matches("(?!.*(\\d).*\\1)^[1234]{1,4}$")) {
                userConfig = firstInput + " " + "null";
                isCorrectInput = true;
            } else if (firstInput.matches("(?!.*(\\d).*\\1)^[1235]{1,4}$")) {
                userConfig = firstInput;
                setUserSpecialChar();
                isCorrectInput = true;
            } else if (firstInput.equals("0")){
                System.exit(-1);
            } else {
                System.out.format("Plz, Please enter a components as required \n%s", configMsg);
            }
        }
    }
    private void setUserLength(){
        String configMsg =
                "Please enter password length from 4 to 99\n" +
                "0 - EXIT\n" +
                "Input: ";
        System.out.print(configMsg);
        boolean isInputCorrect = false;
        while (!isInputCorrect){
            String input = scanner.nextLine();
            if (input.matches("^\\d{1,2}$") && Integer.parseInt(input) >= MIN_LENGTH) {
                userLength = Integer.parseInt(input);
                isInputCorrect = true;
            } else if (input.equals("0")) {
                System.exit(-1);
            } else {
                System.out.print(configMsg);
            }
        }

    }
    private void setUserSpecialChar(){
        String configSpecMsg =
                "enter several special symbol from the !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n" +
                "0 - EXIT\n" +
                "input: ";
        System.out.print(configSpecMsg);
        boolean isInputCorrect = false;
        while (!isInputCorrect){
            String input = scanner.nextLine();
            if (!input.isEmpty() && input.matches("^[!\"#$%&'()*+,-.\\/:;<=>?@\\[\\\\\\]^_`{|}~]*$")) {
                userConfig = userConfig + " " + input;
                isInputCorrect = true;
            }else if(input.equals("0")) {
                System.exit(-1);
            } else {
                System.out.println("Plz, Please enter !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
            }
        }
    }
}

