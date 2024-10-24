public class Caneta {
    public String brand;
    public int Carga;
    public boolean tampada;

    public Caneta(String brand, int Carga){
        this.brand=brand;
        this.Carga=Carga;
        tampar();
    }

    public void tampar(){
        tampada=true;
    }


}
