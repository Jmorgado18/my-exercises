public class Visualizacao {
    private Gafanhoto gafanhoto;
    private Video video;

    public Visualizacao(Gafanhoto gafanhoto, Video video) {
        this.gafanhoto = gafanhoto;
        this.video = video;
        gafanhoto.setTotVideosWatched(gafanhoto.getTotVideosWatched()+1);
        video.setViews(video.getViews()+1);
    }

}
