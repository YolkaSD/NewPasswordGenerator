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

        int randomCount;
        for (int i = 3; i < length; i++) {
            randomCount = (int) (Math.random() * 3);
            switch (randomCount) {
                case 1:
                    passBuilder.append(symbolGenerator.generateRandomLetter());
                    break;
                case 2:
                    passBuilder.append(symbolGenerator.generateRandomNumber());
                    break;
                default:
                    passBuilder.append(symbolGenerator.generateRandomSymbol());
                    break;
            }
        }
        return passBuilder.toString();
    }
}
