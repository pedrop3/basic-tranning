package DesignPatterns.Command.Commands;

import DesignPatterns.Command.Command;
import DesignPatterns.Command.Receiver;

// ConcreteCommand para ligar a TV
public class IncreaseVolumeCommand implements Command {
    private Receiver receiver;
    private int volume;

    public IncreaseVolumeCommand(Receiver receiver,int volume) {
        this.receiver = receiver;
        this.volume = volume;
    }

    @Override
    public void execute() {
        receiver.upVolume(volume);
    }

    @Override
    public void rollback() {
        receiver.upVolume(0);
    }
}