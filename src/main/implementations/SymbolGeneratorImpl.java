package main.implementations;
import main.interfaces.SymbolGenerator;

public class SymbolGeneratorImpl implements SymbolGenerator {
    private static final String CHAR_ALL_CASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CHAR_UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CHAR_LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String CHAR_SPECIAL = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    @Override
    public char generateRandomLetter() {
        return getRandomChar(CHAR_ALL_CASE);
    }

    @Override
    public char generateRandomDigit() {
        return getRandomChar(DIGITS);
    }

    @Override
    public char generateRandomSymbol() {
        return getRandomChar(CHAR_SPECIAL);
    }

    @Override
    public char generateRandomUpperCase() {
        return getRandomChar(CHAR_UPPER_CASE);
    }

    @Override
    public char generateRandomLowerCase() {
        return getRandomChar(CHAR_LOWER_CASE);
    }

    public char getRandomChar(String original){
        return original.charAt((int) (Math.random() * original.length()));
    }
}
