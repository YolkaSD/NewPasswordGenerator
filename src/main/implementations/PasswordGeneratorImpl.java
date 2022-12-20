package main.implementations;

import main.interfaces.PasswordGenerator;
import main.interfaces.SymbolGenerator;

public class PasswordGeneratorImpl implements PasswordGenerator {
    private final static int MIN_LENGTH = 4;
    private final static int MAX_LENGTH = 99;
    SymbolGenerator symbolGenerator;
    public PasswordGeneratorImpl(SymbolGenerator symbolGenerator){
        this.symbolGenerator = symbolGenerator;
    }
    @Override
    public String generatePassword(int length){
        if(length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new RuntimeException("Incorrect password length");
        }
        StringBuilder passBuilder = new StringBuilder().append(symbolGenerator.generateRandomNumber())
                .append(symbolGenerator.generateRandomSymbol())
                .append(symbolGenerator.generateRandomLetter());

        char[] chars = new char[3];
        int randomCount;
        for (int i = 0; i < length - 3; i++) {
            chars[0] = symbolGenerator.generateRandomLetter();
            chars[1] = symbolGenerator.generateRandomSymbol();
            chars[2] = symbolGenerator.generateRandomNumber();

            randomCount = (int) (Math.random() * 3);
            passBuilder.append(chars[randomCount]);
        }
        return passBuilder.toString();
    }
}
