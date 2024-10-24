public class Video implements AccoesVideo{
    private String VideoName;
    private int avaliation;
    private int views;
    private int likes;
    private boolean isPlaying;

    public Video(String videoName, int avaliation, int views, int likes, boolean isPlaying) {
        VideoName = videoName;
        this.avaliation = avaliation;
        this.views = views;
        this.likes = likes;
        this.isPlaying = isPlaying;
    }

    @Override
    public void play() {
        this.isPlaying=true;
    }

    @Override
    public void pause() {
        this.isPlaying=false;
    }

    @Override
    public void like() {
        this.likes++;
    }

    public String getVideoName() {
        return VideoName;
    }

    public void setVideoName(String videoName) {
        VideoName = videoName;
    }

    public int getAvaliation() {
        return avaliation;
    }

    public void setAvaliation(int avaliation) {
        this.avaliation = avaliation;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
