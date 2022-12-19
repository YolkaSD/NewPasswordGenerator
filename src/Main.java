import main.implementations.PasswordGeneratorImpl;
import main.implementations.SymbolGeneratorImpl;
import main.interfaces.PasswordGenerator;
import main.interfaces.SymbolGenerator;

public class Main {
    public static void main(String[] args) {

        SymbolGenerator sg = new SymbolGeneratorImpl();

        PasswordGenerator generator = new PasswordGeneratorImpl(sg);

        /*
        failed .*\d.*] and *[a-zA-Z].*]
        */
        try {
            String password = generator.generatePassword(15);
            if (password.length() != 15) throw new AssertionError();
            if (!password.matches(".*\\d.*]")) throw new AssertionError();
            if (!password.matches(".*[a-zA-Z].*]")) throw new AssertionError();
            if (!password.matches(".*[&^%$#@!()_+].*")) throw new AssertionError();
            System.out.println("Test1 passed");
        } catch (AssertionError e) {
            System.out.println("Test1 failed");
        }

        try {
            String password = generator.generatePassword(2);
            System.out.println("Test2 failed");
        } catch (Exception e) {
            System.out.println("Test2 passed");
        }

        try {
            String password = generator.generatePassword(150);
            System.out.println("Test3 failed");
        } catch (Exception e) {
            System.out.println("Test3 passed");
        }
    }
}