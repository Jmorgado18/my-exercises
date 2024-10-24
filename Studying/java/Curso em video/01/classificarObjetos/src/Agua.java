public class Agua {
    private int qtd;
    private String brand;

    public Agua(String brand){
        this.qtd=100;
        this.brand=brand;
    }
    public void encher(){
        qtd=100;
    }
    public void beber(){
        qtd=qtd-10;
    }

    public int getQtd() {
        return qtd;
    }

    public String getBrand() {
        return brand;
    }
}
