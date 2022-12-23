package main.interfaces;

public interface PasswordGenerator {
    String generatePassword(int length, StringBuilder userConfig);
}
