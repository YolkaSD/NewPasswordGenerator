package main.implementations;

import CUI.ConsoleUserInterface;
import main.interfaces.PasswordGenerator;
import main.interfaces.SymbolGenerator;

import java.util.Arrays;

public class PasswordGeneratorImpl implements PasswordGenerator {
    private final SymbolGenerator symbolGenerator;
    private final ConsoleUserInterface consoleUserInterface;
    public PasswordGeneratorImpl(SymbolGenerator symbolGenerator, ConsoleUserInterface consoleUserInterface){
        this.symbolGenerator = symbolGenerator;
        this.consoleUserInterface = consoleUserInterface;
    }
    @Override
    public String generatePassword(int length, StringBuilder userConfig){
        String[] arrUserConfig = userConfig.toString().split(" ");
        StringBuilder userSpecSymbol = new StringBuilder(arrUserConfig[1]);
        StringBuilder basePass = new StringBuilder();
        int randomCount;
        while (basePass.length() < length){
            if (String.valueOf(arrUserConfig[0]).contains("1")) {
                basePass.append(symbolGenerator.generateRandomDigit());
                if (basePass.length() == length) continue;
            }
            if (String.valueOf(arrUserConfig[0]).contains("2")) {
                basePass.append(symbolGenerator.generateRandomUpperCase());
                if (basePass.length() == length) continue;
            }
            if (String.valueOf(arrUserConfig[0]).contains("3")) {
                basePass.append(symbolGenerator.generateRandomLowerCase());
                if (basePass.length() == length) continue;
            }
            if (String.valueOf(arrUserConfig[0]).contains("4")) {
                basePass.append(symbolGenerator.generateRandomSymbol());
                if (basePass.length() == length) continue;
            }
            if (String.valueOf(arrUserConfig[0]).contains("5")) {
                randomCount = (int) (Math.random() * userSpecSymbol.length());
                basePass.append(userSpecSymbol.charAt(randomCount));
            }
        }

        System.out.println(basePass);

        StringBuilder password = new StringBuilder();
        while (basePass.length() > 0) {
            randomCount = (int) (Math.random() * basePass.length());
            password.append(basePass.charAt(randomCount));
            basePass.deleteCharAt(randomCount);
        }

        return password.toString();

/*        StringBuilder passBuilder = new StringBuilder().append(symbolGenerator.generateRandomDigit())
                .append(symbolGenerator.generateRandomSymbol())
                .append(symbolGenerator.generateRandomLetter());

        char[] chars = new char[3];
        int randomCount;
        for (int i = 0; i < length - 3; i++) {
            chars[0] = symbolGenerator.generateRandomLetter();
            chars[1] = symbolGenerator.generateRandomSymbol();
            chars[2] = symbolGenerator.generateRandomDigit();

            randomCount = (int) (Math.random() * 3);
            passBuilder.append(chars[randomCount]);
        }
        return passBuilder.toString();*/
    }
}
