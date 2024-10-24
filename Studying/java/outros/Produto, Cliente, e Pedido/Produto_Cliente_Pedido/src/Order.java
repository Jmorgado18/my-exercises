public class Order {
    public static void main(String[] args) {

        Customer customer1= new Customer("João","Rua do crl");
        Product product1= new Product("batata" , 10);
        Product product2= new Product("aaa" , 40);
        Product product3= new Product("ss" , 50);
        Product product4= new Product("dd" , 1);
        double totalbill;


            totalbill=
            product2.getPrice()+product1.getPrice()+product3.getPrice()+product4.getPrice();

        System.out.println("O " +customer1.getName() + " gastou " + totalbill);

    }
}
