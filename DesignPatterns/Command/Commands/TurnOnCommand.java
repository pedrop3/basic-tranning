package DesignPatterns.Command.Commands;

import DesignPatterns.Command.Command;
import DesignPatterns.Command.Receiver;

// ConcreteCommand para ligar a TV
public class TurnOnCommand implements Command {
    private Receiver receiver;

    public TurnOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }

    @Override
    public void rollback() {
        receiver.turnOff();
    }
}