public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(111, 100, "poupança", "João"); // Passando o dono
        Person person1 = new Person("João", bank);
        person1.showStatus();

        Bank bank2 = new Bank(1112,0,"corrente","jose");
        Person person2 =new Person("José", bank2);
        person2.showStatus();

        person1.levantar(99999999);
        person1.levantar(10);

        person2.deposita(0);
        person2.deposita(300);

        person2.fecharconta();
    }
}
