package View;

import Controller.OptionController;

import javax.swing.*;

public class OptionVIew {

    private int option;
OptionController optionController = new OptionController();

    public void saveOption(int option) {
        this.option = option;
        optionController.saveOption(option);
        handleOption();
    }

public void handleOption() {


    switch (option) {
        case 1:
            //Deposit
            break;
        case 2:
            //Withdraw
            break;
        case 3:
            //Balance
            break;
        case 4:
            //Exit
            break;
        case 5:
            //Transfer
            break;
        case 6:
            //Loan
            break;
    }


}

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}