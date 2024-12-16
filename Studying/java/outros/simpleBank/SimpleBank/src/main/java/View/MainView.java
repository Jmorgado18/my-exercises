package View;


import Controller.MenuController;
import Controller.RegisterController;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MainView {
    Prompt prompt = new Prompt(System.in, System.out);
    String options[]={"Login","Register"};
    MenuController menuController = new MenuController();
    RegisterController registerController = new RegisterController();


    public void showMenu() {

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Choose an option");
        int option = prompt.getUserInput(scanner);

        if (option == 1) {
            menuController.showMenu();
        }else if (option == 2) {
            registerController.register();
        }

    }

}
