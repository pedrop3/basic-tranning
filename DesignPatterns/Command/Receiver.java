package DesignPatterns.Command;

public interface Receiver {
  void turnOn();
  void turnOff();
  void upVolume(int volume);
  void downVolume(int volume);
}