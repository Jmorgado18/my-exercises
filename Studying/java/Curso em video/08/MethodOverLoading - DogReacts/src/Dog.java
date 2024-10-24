public class Dog {
    private String name;
    private String quote;
    private String Timeday;
    private boolean isOwner;
    private int age;
    private double height;

    public Dog(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }




    public void react(String quote){
        this.quote=quote;
        if (quote.equals("goodboy")){
            System.out.println("sou amigavel");
        } else if (quote.equals("badboy")) {
            System.out.println("AUUUFFFF");
        }


    }
    public void react(boolean isOwner){
        this.isOwner=isOwner;
        if (isOwner) {
            System.out.println("sou amigavel");
        }else{
            System.out.println("AUUUUUFFFF");
        }
    }
    public void react(int age){
        this.age=age    ;
        if (age<8){
            System.out.println("Sou amigavel");
            return;
        }
        System.out.println("AUUUFFFF");
    }
    public void react(double height){
        this.height=height;
        if (height>20){
            System.out.println("AUUUFFFF");
            return;
        }
        System.out.println("Sou amigavel");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
