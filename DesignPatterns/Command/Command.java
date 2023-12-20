package DesignPatterns.Command;

public interface Command {
    void execute();
    void rollback();
}