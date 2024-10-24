public class OmeuComando implements comando {
    private int vol;
    private boolean isOn;
    private boolean isRinging;

    public OmeuComando() {
        vol = 50;
        isOn = false;
        isRinging = false;
    }

    @Override
    public void on() {
        if (isOn) {
            System.out.println("Your TV is already On");
        } else {
            isOn = true;
            System.out.println("Turning on the TV");
        }
    }

    @Override
    public void off() {
        if (isOn) {
            isOn = false;
            System.out.println("Turning off your TV");
        } else {
            System.out.println("Your TV is already Off");
        }
    }

    @Override
    public void openMenu() {
        if (isOn) {
            System.out.println("Volume: " + vol);
            System.out.println("Is on: " + isOn);
            System.out.println("Is Live: " + isRinging);
        } else {
            System.out.println("Please turn on the TV first to access the menu.");
        }
    }

    @Override
    public void setVolumeUp() {
        if (isOn) {
            vol++;
            System.out.println("Volume: " + vol);
        } else {
            System.out.println("Please turn on the TV first to adjust the volume.");
        }
    }

    @Override
    public void setVolumeDown() {
        if (isOn) {
            vol--;
            System.out.println("Volume: " + vol);
        } else {
            System.out.println("Please turn on the TV first to adjust the volume.");
        }
    }

    @Override
    public void play() {
        if (isOn) {
            System.out.println("TV is playing");
        } else {
            System.out.println("Please turn on the TV first to play.");
        }
    }

    @Override
    public void stop() {
        if (isOn) {
            System.out.println("PAUSE");
        } else {
            System.out.println("Please turn on the TV first to stop.");
        }
    }

    public int getVol() {
        return vol;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isRinging() {
        return isRinging;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setRinging(boolean ringing) {
        isRinging = ringing;
    }
}
