public class Animal {
    Tipo tipo;
    String nome;
    int idade;
    String foodtype;
    String brandname;
    boolean adotar =false;
    public static int nrdonos;

    public void adotar(){
        adotar=true;
    }
    public Tipo getTipo(){
        return tipo;
    }
    public void setTipo(Tipo tipo){
        this.tipo=tipo;
    }
    public String food(String foodtype , String brandname){
        this.foodtype=foodtype;
        this.brandname=brandname;
        return foodtype + brandname;
    }
    public String food(String foodtype){
        this.foodtype=foodtype;
        return foodtype;
    }
}
