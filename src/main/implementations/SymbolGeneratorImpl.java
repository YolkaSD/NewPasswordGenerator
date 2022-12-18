package main.implementations;
import main.interfaces.SymbolGenerator;

public class SymbolGeneratorImpl implements SymbolGenerator {
    private static final String CHAR_ALL_CASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //NUMBERS is that Rudiment? See implementation generateRandomNumber()
    private static final String NUMBERS = "0123456789";
    private static final String CHAR_SPECIAL = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    @Override
    public char generateRandomLetter() {
        return getRandomChar(CHAR_ALL_CASE);
    }

    @Override
    public char generateRandomNumber() {
        return Character.forDigit((int) (Math.random() * 10), 10);
    }

    @Override
    public char generateRandomSymbol() {
        return getRandomChar(CHAR_SPECIAL);
    }

    private char getRandomChar(String original){
        return original.charAt((int) (Math.random() * original.length()));
    }
}
