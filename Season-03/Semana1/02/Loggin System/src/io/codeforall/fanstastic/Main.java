package io.codeforall.fanstastic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Prompt prompt = new Prompt(System.in, System.out);
        String[] options = {"Login", "Register"};

        // Menu para o usuário escolher entre Login ou Registro
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Choose an option: ");
        int answerIndex = prompt.getUserInput(scanner);

        if (answerIndex == 1) { // Login
            login(prompt);
        } else { // Register
            register(prompt);
        }
    }

    private static void login(Prompt prompt) {
        System.out.println("Insert your credentials Below:");

        StringInputScanner askName = new StringInputScanner();
        askName.setMessage("Username: \n");
        String name = prompt.getUserInput(askName);

        PasswordInputScanner askPassword = new PasswordInputScanner();
        askPassword.setMessage("Password: \n");
        String password = prompt.getUserInput(askPassword);

        if (validateCredentials(name, password)) {
            System.out.println("Login Successful! Welcome " + name);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void register(Prompt prompt) {
        System.out.println("Create a new account:");

        StringInputScanner askName = new StringInputScanner();
        askName.setMessage("Username: \n");
        String username = prompt.getUserInput(askName);

        String password;
        while (true) {
            PasswordInputScanner askPassword = new PasswordInputScanner();
            askPassword.setMessage("Password (must be at least 8 characters, " +
                    "contain at least one uppercase letter, " +
                    "one lowercase letter, one digit, and one special character): \n");
            password = prompt.getUserInput(askPassword);

            // Validar a senha
            if (isPasswordValid(password)) {
                break; // Sair do loop se a senha for válida
            } else {
                System.out.println("Password does not meet the requirements. Please try again.");
            }
        }

        saveCredentials(username, password);
        System.out.println("Account created successfully!");
    }

    private static boolean isPasswordValid(String password) {
        // Definir os critérios de validação
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean hasMinLength = password.length() >= 8;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasMinLength && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    private static void saveCredentials(String username, String password) {
        String filePath = "passwords.txt";
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(username + ":" + password + "\n");
        } catch (IOException e) {
            System.out.println("Error saving credentials: " + e.getMessage());
        }
    }

    private static boolean validateCredentials(String username, String password) {
        String filePath = "passwords.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 2) {
                    String fileUsername = credentials[0];
                    String filePassword = credentials[1];
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading credentials file: " + e.getMessage());
        }
        return false;
    }
}
