public class Pen {
    private String modelo;
    private String cor;
    private boolean tampa;
    private void status(){

        System.out.println("O modelo da canela é " + this.modelo);
        System.out.println(("A cor da caneta é " + this.cor));
    }
    public void showStatus(){
        status();
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    private void draw(){
        if(tampa==true){
            System.out.println("Erro, tirar a tampa primeiro");
        }else{
            System.out.println("A desenhar");
        }
    }
    public void tampar(){
        tampa=true;
    }
    public void destampar() {
        tampa=false;
    }

    public void showDraw(){
        draw();
    }

}
