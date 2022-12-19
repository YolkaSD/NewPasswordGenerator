package main.implementations;

import main.interfaces.PasswordGenerator;
import main.interfaces.SymbolGenerator;

public class PasswordGeneratorImpl implements PasswordGenerator {
    final static int MIN_LENGTH = 4;
    final static int MAX_LENGTH = 99;
    SymbolGenerator symbolGenerator;
    public PasswordGeneratorImpl(SymbolGenerator symbolGenerator){
        this.symbolGenerator = symbolGenerator;
    }
    @Override
    public String generatePassword(int length) throws RuntimeException{
        if(length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new RuntimeException("Incorrect password length");
        }
        int count = 0;
        StringBuilder passBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            switch (count) {
               case 0 -> {
                   passBuilder.append(symbolGenerator.generateRandomSymbol());
                   count++;
               }
               case 1 -> {
                   passBuilder.append(symbolGenerator.generateRandomNumber());
                   count++;
               }
               case 2 -> {
                   passBuilder.append(symbolGenerator.generateRandomLetter());
                   count -= count;
               }
            }
        }
        return String.valueOf(passBuilder);
    }
}
