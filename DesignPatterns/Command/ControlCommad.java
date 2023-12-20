package DesignPatterns.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ControlCommad {

    private List<Command> commands;

    public ControlCommad() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void executeCommand() {
        commands.forEach(command -> {
            try {

                command.execute();

            } catch (Exception e) {
                System.out.println(
                        "Tivemos um problema ao processar os comandos. Será feito um rollback da operação.");
                System.out.println("O problema foi causado por: " + e.getMessage());
                System.out.println("A TV foi restaurada ao seu valor original.");
                rollback();

            }
        });

    }

    public void rollback() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).rollback();
        }
    }
}
