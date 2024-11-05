package io.codeforall.fanstastic;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {
    public static void main(String[] args) {

        Prompt prompt =new Prompt(System.in, System.out);

        StringInputScanner askName = new StringInputScanner();
        askName.setMessage("Digite o seu nome \n");
        String name = prompt.getUserInput(askName);


        PasswordInputScanner askPassword = new PasswordInputScanner();
        askPassword.setMessage(("Digite uma password \n"));
        String password = prompt.getUserInput(askPassword);

        System.out.println(name);
        System.out.println(password);
    }
}
