package DesignPatterns.Command;

public class TV implements Receiver {

    @Override
    public void turnOn() {
        System.out.println("Tv ligada");
    }

    @Override
    public void turnOff() {
        System.out.println("Tv desligada");

    }

    @Override
    public void upVolume(int volume) {
        System.out.println("Volume aumentado para " + volume);
    }

    @Override
    public void downVolume(int volume) {
        System.out.println("Volume abaixado para " + volume);

    }

}
