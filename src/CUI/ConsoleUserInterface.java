package CUI;

import java.util.Scanner;

public class ConsoleUserInterface {
    private final static int MIN_LENGTH = 4;
    private final StringBuilder userConfig = new StringBuilder();
    private int userLength;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUserInterface() {
    }

    public void start(){
        setUserLength();
        setUserConfig();
        scanner.close();
    }
    public StringBuilder getUserConfig() {
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
        String input;
        boolean isCorrectInput = false;
        while (!isCorrectInput)
        {
            input = scanner.nextLine();
            if (input.matches("(?!.*(\\d).*\\1)^[1234]{1,4}$")) {
                userConfig.append(input).append(" ").append("null");
                isCorrectInput = true;
            } else if (input.matches("(?!.*(\\d).*\\1)^[1235]{1,4}$")) {
                userConfig.append(input);
                setUserSpecialChar();
                isCorrectInput = true;
            } else if (input.equals("0")){
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
                userConfig.append(" ").append(input);;
                isInputCorrect = true;
            }else if(input.equals("0")) {
                System.exit(-1);
            } else {
                System.out.println("Plz, Please enter !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
            }
        }
    }
}

