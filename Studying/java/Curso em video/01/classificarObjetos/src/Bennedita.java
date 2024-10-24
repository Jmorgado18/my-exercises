public class Bennedita {
    private boolean isSheSleeping;
    private boolean isShefed;

    public boolean sleep(){
        if (isSheSleeping=false){
            isSheSleeping=true;
        }else{
            isSheSleeping=false;
        }
        return isSheSleeping;
    }
    public boolean fed(){
        if(isShefed=false){
            System.out.println("Feeding the baby");
            isShefed=true;

        }

        return isShefed;
    }

    public boolean isSheSleeping() {
        return isSheSleeping;
    }

    public boolean isShefed() {
        return isShefed;
    }

    public void setSheSleeping(boolean sheSleeping) {
        isSheSleeping = sheSleeping;
    }

    public void setShefed(boolean shefed) {
        isShefed = shefed;
    }
}
