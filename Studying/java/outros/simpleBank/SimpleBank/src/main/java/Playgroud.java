import Controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Playgroud {
  //  public static MainController mainController;
    public static void main(String[] args) {

     //   ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       MainController mainController  = new MainController();

        mainController.init();

    }
}
