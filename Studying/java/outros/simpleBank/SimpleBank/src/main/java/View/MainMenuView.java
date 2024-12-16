package View;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MainMenuView {

    Prompt prompt = new Prompt(System.in, System.out);
    String options[]={"Depoit","Withdraw","Balance","Exit","Transfer","Loan"};

    OptionVIew optionView = new OptionVIew();
private int option;

   public void showMenu() {

       MenuInputScanner scanner = new MenuInputScanner(options);
       scanner.setMessage("Choose an option");
      option = prompt.getUserInput(scanner);

       if (option == 1) {
           System.out.println("Deposit");
       }else if (option == 2) {
           System.out.println("Withdraw");
       }else if (option == 3) {
           System.out.println("Balance");
       }else if (option == 4) {
           System.out.println("Exit");
       }else if (option == 5) {
           System.out.println("Transfer");
       }else if (option == 6) {
           System.out.println("Loan");
       }
       optionView.saveOption(option);


    }

    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
