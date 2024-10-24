public class Gafanhoto extends Pessoa{

    private boolean isLoggedIn;
    private int totVideosWatched;


    public Gafanhoto(Pessoa pessoa) {
        super(pessoa.getName(), pessoa.getAge(), pessoa.getSex());
    }

    private void Login(){
        this.isLoggedIn=true;
    }

    private void Logout(){
      this.isLoggedIn=false;

    }

    public void watchvideo(){
        if (isLoggedIn) {
            this.totVideosWatched++;
            return;
        }
        System.out.println("Login First");
    }

    public void likeVideo(Video video){
      if (isLoggedIn) {
        video.like();
        return;
      }
        System.out.println("Login First");
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getTotVideosWatched() {
        return totVideosWatched;
    }

    public void setTotVideosWatched(int totVideosWatched) {
        this.totVideosWatched = totVideosWatched;
    }
}


