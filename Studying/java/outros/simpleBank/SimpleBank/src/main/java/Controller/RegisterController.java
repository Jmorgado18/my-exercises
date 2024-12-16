package Controller;

import View.RegisterView;

public class RegisterController {
    RegisterView registerView = new RegisterView();

    public void register() {
registerView.showRegisterMenu();
    }
}
