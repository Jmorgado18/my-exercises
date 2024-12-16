package View;

import Controller.MainMenuController;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class LoginView {
Prompt prompt = new Prompt(System.in, System.out);
MainMenuController mainMenuController = new MainMenuController();

    public void showLoginMenu() {

        System.out.println("Please insert your Customer Number:");
        StringInputScanner question1 = new StringInputScanner();
        String customerNumber = prompt.getUserInput(question1);

        System.out.println("Pease insert your Password:");
        PasswordInputScanner question2 = new PasswordInputScanner();
        String password = prompt.getUserInput(question2);


        //FALTA VERIFICAR SE O CUSTOMER EXISTE - CRIAR UM SERVICE QUE LIGA AO DAO


        mainMenuController.showMenu();




    }
}
