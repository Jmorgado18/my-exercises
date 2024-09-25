package io.CodeforAll.bootcamp;

public class Soccer {
    public String nome;
    public String cidade;
    public int pontos;
    private int expenses;
    public int nroftitles;

    public void win() {
        this.pontos += 3;
    }

    public void draw(){
        this.pontos=+1;
    }

public int addtitles(int nr1, int nr2){
return nr1 + nr2;
}
public int addtitles (int n1){

        return this.nroftitles +n1;

}
public int addtitles( int[] novostitulos){
        int total =0;
        for (int titulo : novostitulos){
            total += titulo;
        }
        return this.nroftitles+ total;
}
    public void addtitles(String nomeTitulo, int quantidade) {
        this.nroftitles += quantidade;
        System.out.println("Adicionados " + quantidade + " títulos do tipo: " + nomeTitulo);
    }
    public int getExpenses() {
        return this.expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }
}
