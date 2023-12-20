package DesignPatterns.Command;
/*
 * 
 Problema: Sistema de Controle Remoto Inteligente

Você está desenvolvendo um sistema de controle remoto inteligente para uma casa conectada. 
Este sistema permite que os usuários controlem vários dispositivos eletrônicos em sua casa, como luzes, televisão, eletrodomésticos, etc. 
Cada dispositivo é representado por um objeto que possui métodos como ligar(), desligar(), aumentarVolume(), diminuirVolume(), etc.

A equipe de desenvolvimento solicitou que você implemente um sistema de controle remoto que permita aos usuários programar e executar sequências de comandos.
Por exemplo, um usuário pode querer criar uma sequência para "Assistir TV" que envolve ligar a TV, ajustar o volume e ligar o decoder.

Utilize o padrão Command para criar uma solução flexível e extensível para este problema.

Requisitos:

1. Implemente interfaces como Command, ConcreteCommand, Invoker e Receiver.
2. Crie classes específicas de comando para cada ação possível em um dispositivo (ligar, desligar, aumentar volume, diminuir volume, etc.).
3. O invocador (controle remoto) deve ser capaz de armazenar e executar sequências de comandos.
4 .Lembre-se de fornecer um exemplo de como o sistema seria utilizado para criar e executar uma sequência de comandos, como "Assistir TV".

 */

import DesignPatterns.Command.Commands.DownVolumeCommand;
import DesignPatterns.Command.Commands.IncreaseVolumeCommand;
import DesignPatterns.Command.Commands.TurnOnCommand;
public class Application {

    public static void main(String[] args) {

        TV tv = new TV();

        TurnOnCommand turnOnTV = new TurnOnCommand(tv);
        IncreaseVolumeCommand  increaseVolumeCommand = new IncreaseVolumeCommand(tv, 10);
        DownVolumeCommand downVolumeCommand = new DownVolumeCommand(tv, -1);

        ControlCommad  controlCommad = new ControlCommad();
        controlCommad.addCommand(turnOnTV);
        controlCommad.addCommand(increaseVolumeCommand);
        controlCommad.addCommand(downVolumeCommand);

        controlCommad.executeCommand();
    }

}
