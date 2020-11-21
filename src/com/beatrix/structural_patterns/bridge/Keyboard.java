package com.beatrix.structural_patterns.bridge;

import com.beatrix.behavioral_patterns.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:46
 * @project CreationalPatterns
 */
public class Keyboard extends Peripherals{

    List<Command> specialKeys = new ArrayList<Command>(15);
    Command lastCommand;
    List<Command> commandMacro = new ArrayList<Command>(3);

    public Keyboard(PeripheralsType peripheralsType) {
        super(peripheralsType);
    }

    public Keyboard() {
    }

    @Override
    public void connect() {
        System.out.println("Your keyboard is connected!");
        peripheralsType.work();
    }

    public List<Command> getCommandMacro() {
        return commandMacro;
    }

    public Command getLastCommand() {
        return lastCommand;
    }

    public void setLastCommand(Command lastCommand) {
        this.lastCommand = lastCommand;
    }

    public void setCommandOnSpecialKey( int i,Command cmd) {
        specialKeys.add(i, cmd);
    }

    public void buttonPress(int keyNumber){
        Command command = specialKeys.get(keyNumber);
        command.execute();
        setLastCommand(command);
        commandMacro.add(command);
    }
}
