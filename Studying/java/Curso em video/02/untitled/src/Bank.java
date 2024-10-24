public class Bank {
    private int nrConta;
    private String tipo;
    private String dono;
    private int saldo;
    private boolean status;

    public Bank(int nrConta, int saldo, String tipo, String dono) { // Adicione o dono no construtor
        this.nrConta = nrConta;
        this.saldo = saldo;
        this.tipo = tipo;
        this.dono = dono; // Inicializa o dono
        this.status = true;
    }

    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo; // Corrigido para atualizar o saldo da classe
    }

    public void showStatus() {
        System.out.println("Dono da conta: " + getDono()); // Adicionei o dono
        System.out.println("Número de conta: " + getNrConta());
        System.out.println("Saldo atual: " + getSaldo());
        System.out.println("Tipo de conta: " + getTipo());
        System.out.println("Status da conta: " + isStatus());
        System.out.println("--------------------------------");
    }

    public void levantar(int quantia) {
        if (quantia > saldo || quantia < 0) {
            System.out.println("Erro. Quantia indisponível ou valor inválido");
            return;
        }
        saldo = saldo - quantia;
        System.out.println("Levantou " + quantia + ". Saldo restante: " + saldo);
    }

    public void depositar(int quantia) {
        if (quantia <= 0) {
            System.out.println("Quantia inválida");
            return;
        }
        saldo += quantia; // Atualiza o saldo
        System.out.println("Depositou " + quantia + ". Saldo atual: " + saldo);
    }

    public void mensalidade() {
        setSaldo(saldo - 10);
    }

    public void fecharConta() {
        if (getSaldo() > 0) {
            System.out.println("ERRO ! Levante o saldo restante");
            return;
        }
        System.out.println("Conta fechada com sucesso");
        status = false;
    }
}
