package Controller;

import View.LoginView;

public class MenuController {
    LoginView loginView = new LoginView();

    public void showMenu() {
        loginView.showLoginMenu();

    }


}
