package Controller;

import View.RegisterView;

public class SaveCustomer {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phonenumber;



  public void saveCustomerData(RegisterView registerView) {

      this.firstName = registerView.getFirstName();
      this.lastName = registerView.getLastName();
      this.email = registerView.getEmail();
      this.password = registerView.getPassword();
      this.phonenumber = registerView.getPhoneNumber();
      showDetails();
  }


    public void showDetails() {

        System.out.println("this is the first name " + firstName);
        System.out.println("this is the last name " + lastName);
        System.out.println("this is the email " + email);
        System.out.println("this is the password " + password);
        System.out.println("this is the phonenumber " + phonenumber);
    }
}
