public class Driver {


    public static void main(String[] args) {

        Person person1 = new Person("John",33);
        Car car1 = new Car("Toyota", 50);

        System.out.println(person1.getName()+ " is driving a " + car1.getModel());
    }
}
