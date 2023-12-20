package DesignPatterns.Command.Commands;

import DesignPatterns.Command.Command;
import DesignPatterns.Command.Receiver;

// ConcreteCommand para ligar a TV
public class DownVolumeCommand implements Command {
    private Receiver receiver;
    private int volume;

    public DownVolumeCommand(Receiver receiver, int volume) {
        this.receiver = receiver;
        this.volume = volume;
    }

    @Override
    public void execute() {

        if (volume < 0) {
            throw new UnsupportedOperationException("O valor do volume não pode ser negativo.");
        }
        receiver.downVolume(volume);

    }

    @Override
    public void rollback() {
        receiver.downVolume(0);
    }
}