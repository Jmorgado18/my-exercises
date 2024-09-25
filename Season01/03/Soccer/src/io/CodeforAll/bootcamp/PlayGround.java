package io.CodeforAll.bootcamp;

public class PlayGround {
    public static void main(String[] args) {

        Soccer team1= new Soccer();
        team1.cidade="Porto";
        team1.nome="FCP";
        team1.pontos=0;
        team1.setExpenses(5000);
        int teamExpenses = team1.getExpenses();

        Soccer team2= new Soccer();
        team2.cidade="Lisboa";
        team2.nome="SLB";
        team2.pontos=0;
        team2.setExpenses(100000);
        int teamExpenses2 = team2.getExpenses();
        team1.win();
        team2.draw();
        System.out.println("A equipa " + team1.nome + " tem " + team1.pontos + " pontos");
        System.out.println("A equipa " + team2.nome + " tem " + team2.pontos + " pontos");
        System.out.println(team1.nome + " " + teamExpenses);
        System.out.println(team2.nome + " " + teamExpenses2);

        int titulos = team1.addtitles(37, 3);
        titulos = team1.addtitles(titulos, 2);
        team1.nroftitles = titulos;

          System.out.println(team1.nome + " " + team1.nroftitles);

          int titulos2= team2.addtitles(3);
          team2.nroftitles=titulos2;

        System.out.println(team2.nome + " tem " + team2.nroftitles + " títulos.");

        int[] novosTitulos = {2, 3, 4}; // Adicionando múltiplos títulos
        team1.nroftitles = team1.addtitles(novosTitulos);
        System.out.println(team1.nome + " agora tem " + team1.nroftitles + " títulos.");

        team2.addtitles("Campeonato Nacional", 5); // Adiciona 5 títulos e exibe mensagem
        System.out.println(team2.nome + " agora tem " + team2.nroftitles + " títulos.");
    }
}
