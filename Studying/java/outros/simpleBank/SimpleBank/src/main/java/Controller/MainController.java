package Controller;

import View.MainView;
import com.sun.tools.javac.Main;

public class MainController {
    
    MainView mainview = new MainView();

    public void init() {

    mainview.showMenu();
    }
}
