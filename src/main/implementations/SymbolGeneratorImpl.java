package main.implementations;
import main.interfaces.SymbolGenerator;

public class SymbolGeneratorImpl implements SymbolGenerator {
    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String ALL_CHARS = CHAR_UPPERCASE + CHAR_LOWERCASE;
    //NUMBERS is that Rudiment? See implementation generateRandomNumber()
    private static final String NUMBERS = "0123456789";
    private static final String CHAR_SPECIAL = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private int length, index;


   /* Also note that methods generateRandomLetter and generateRandomSymbol have the same implementation */

    @Override
    public char generateRandomLetter() {
        length = ALL_CHARS.length();
        index = Character.forDigit((int) (Math.random() * length), 10);
        return ALL_CHARS.charAt(index);
    }

    @Override
    public char generateRandomNumber() {
        return Character.forDigit((int) (Math.random() * 10), 10);
    }

    @Override
    public char generateRandomSymbol() {
        length = CHAR_SPECIAL.length();
        index = Character.forDigit((int) (Math.random() * length), 10);
        return ALL_CHARS.charAt(index);
    }
}
