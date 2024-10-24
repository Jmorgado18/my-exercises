public class PlayGround {
    public static void main(String[] args) {
        // Criar uma pessoa
        Pessoa pessoa = new Pessoa("João", 25, SEX.MALE);

        // Criar um gafanhoto (usuário) baseado na pessoa
        Gafanhoto gafanhoto = new Gafanhoto(pessoa);

        // Criar um vídeo
        Video video1 = new Video("Aula de Java", 5, 100, 50, false);

        // Mostrar detalhes iniciais do vídeo
        System.out.println("Nome do vídeo: " + video1.getVideoName());
        System.out.println("Avaliação do vídeo: " + video1.getAvaliation());
        System.out.println("Total de visualizações: " + video1.getViews());
        System.out.println("Total de likes: " + video1.getLikes());
        System.out.println("O vídeo está tocando? " + video1.isPlaying());

        // Tentar assistir ao vídeo antes de login
        gafanhoto.watchvideo();  // Output esperado: "Login First"

        // Fazer login e assistir ao vídeo
        gafanhoto.setLoggedIn(true);
        gafanhoto.watchvideo();  // Agora deve incrementar o total de vídeos assistidos

        // Dar like no vídeo
        gafanhoto.likeVideo(video1);  // Agora deve incrementar o número de likes no vídeo

        // Iniciar a reprodução do vídeo
        video1.play();
        System.out.println("O vídeo está tocando? " + video1.isPlaying());

        // Pausar o vídeo
        video1.pause();
        System.out.println("O vídeo está tocando? " + video1.isPlaying());

        // Fazer logout e tentar assistir a outro vídeo
        gafanhoto.setLoggedIn(false);
        gafanhoto.watchvideo();  // Output esperado: "Login First"

        // Exibir as estatísticas finais
        System.out.println("Total de vídeos assistidos pelo gafanhoto: " + gafanhoto.getTotVideosWatched());
        System.out.println("Total de likes no vídeo: " + video1.getLikes());

        Visualizacao visualizacao = new Visualizacao(gafanhoto, video1);
        System.out.println("Visualizações do vídeo: " + video1.getViews());
    }



}
