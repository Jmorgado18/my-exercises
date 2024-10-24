public class TV {
private String brand;
private int size;
private boolean isOn;
private int channel;

public TV(){
    this.brand=brand;
    this.size=size;
    this.isOn=isOn;
    this.channel=channel;
}

    public boolean isOn() {
        return isOn;
    }

    private void turningOn(){
isOn=true;
}
private void turningOff(){
    isOn=false;
}
private int getChannel(){

return channel;
}

    public String getBrand() {
        return brand;
    }

    public String setBrand(String brand) {
        this.brand = brand;
        return brand;
    }

    public int setSize(int size) {
        this.size = size;
        return size;
    }

    public boolean setOn(boolean on) {
        isOn = on;
        return isOn;
    }

    public int setChannel(int channel) {
        this.channel = channel;
        return channel;
    }
public void status(){
    System.out.println("A tv tem as seguintes caracteristicas" + this.isOn + " " + this.brand);

}

}
