public class Person {
    private String name;
    private Bank bank;

    public Person(String name, Bank bank) {
        this.name = name;
        this.bank = bank; // Guardar a referência do banco
    }

    public String getName() {
        return name;
    }

    public void showStatus() {
        bank.showStatus();
    }
    public void levantar(int quantia){
        bank.levantar(quantia);
    }

    public void deposita(int quantia){
        bank.depositar(quantia );
    }
    public void fecharconta(){
        bank.fecharConta();
    }
}
