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
    public String generatePassword(int length) throws RuntimeException{
        if(length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new RuntimeException("Incorrect password length");
        }
        StringBuilder passBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            passBuilder.append(symbolGenerator.generateRandomSymbol())
                    .append(symbolGenerator.generateRandomLetter())
                    .append(symbolGenerator.generateRandomNumber());
        }
        passBuilder.delete(length, length * 3);
        return passBuilder.toString();
    }
}
