package main.implementations;

import main.interfaces.SymbolGenerator;

public class SymbolGeneratorImpl implements SymbolGenerator {
    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String ALL_CHARS = CHAR_UPPERCASE + CHAR_LOWERCASE;
    private static final String NUMBERS = "0123456789";
    private static final String CHAR_SPECIAL = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";


    @Override
    public char generateRandomLetter() {

        return 0;
    }

    @Override
    public char generateRandomNumber() {
        return 0;
    }

    @Override
    public char generateRandomSymbol() {
        return 0;
    }
}
