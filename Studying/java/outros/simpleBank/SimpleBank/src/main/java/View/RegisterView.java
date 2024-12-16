package View;


import Controller.SaveCustomer;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;



public class RegisterView {

    Prompt prompt = new Prompt(System.in, System.out);
    SaveCustomer saveCustomer = new SaveCustomer();

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;

    public void showRegisterMenu() {


        System.out.println("Please insert your FirstName:");
        StringInputScanner question1 = new StringInputScanner();
        firstName= prompt.getUserInput(question1);

        System.out.println("Pease insert your LastName:");
        StringInputScanner question3 = new StringInputScanner();
        lastName = prompt.getUserInput(question3);

        System.out.println("Pease insert your Email:");
        StringInputScanner question4 = new StringInputScanner();
        email = prompt.getUserInput(question4);

        System.out.println("Pease insert your PhoneNumber:");
        StringInputScanner question5 = new StringInputScanner();
        phoneNumber = prompt.getUserInput(question5);

        System.out.println("Pease insert your Password:");
        StringInputScanner question2 = new StringInputScanner();
        password = prompt.getUserInput(question2);

        saveCustomer.saveCustomerData(this);


    }



    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
