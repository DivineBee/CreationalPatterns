package com.beatrix.behavioral_patterns.command;

/**
 * @author Beatrice V.
 * @created 21.11.2020 - 17:53
 * @project CreationalPatterns
 */
import com.beatrix.structural_patterns.bridge.Keyboard;

import java.util.Arrays;
import java.util.List;

public interface Command {
    public void execute();
    public void undo();

}


class MasterOffcommand implements Command{
    List<Command> commandMacro;
    public MasterOffcommand(Command... commands){
        commandMacro = Arrays.asList(commands);
    }

    @Override
    public void execute() {
        for(Command cmd:   commandMacro ){
            System.out.println("putting off  "+ cmd.getClass().getSimpleName() );
            cmd.execute();
        }

    }

    @Override
    public void undo() {
    }
}

class UndocommandMacro implements Command{
    Keyboard Keyboard;

    public UndocommandMacro(Keyboard Command){
        this.Keyboard = Command;
    }

    @Override
    public void execute() {
        for(Command cmd:   Keyboard.getCommandMacro() ){
            System.out.println("Undoing "+ cmd.getClass().getSimpleName() );
            cmd.undo();
        }
    }

    @Override
    public void undo() {
        for(Command cmd:   Keyboard.getCommandMacro() )
            cmd.undo();
    }
}

class Undocommand implements Command{
    Command Lastcommand;
    Keyboard Keyboard;

    public Undocommand(Keyboard Command){
        this.Keyboard = Command;
    }

    @Override
    public void execute() {
        System.out.println(Keyboard.getLastCommand());
        Keyboard.getLastCommand().undo();
    }

    @Override
    public void undo() {
        Keyboard.getLastCommand().undo();
    }
}


class LightON implements Command{
    Light light;
    public LightON(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnON();
    }

    @Override
    public void undo() {
        light.turnOFF();
    }
}

class LightOFF implements Command{
    Light light;
    public LightOFF(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOFF();
    }

    @Override
    public void undo() {
        light.turnON();
    }
}

class FanOFF implements Command{
    Fan device;
    public FanOFF(Fan device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnOFF();
    }

    @Override
    public void undo() {
        device.turnHIGH();
    }
}

class FanLOW implements Command{
    Fan device;
    public FanLOW(Fan device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnLOW();
    }

    @Override
    public void undo() {
        device.turnHIGH();
    }
}

class FanMEDIUM implements Command{
    Fan device;
    public FanMEDIUM(Fan device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnMED();
    }

    @Override
    public void undo() {
        device.turnHIGH();
    }
}

class FanHIGH implements Command{
    Fan device;
    public FanHIGH(Fan device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnHIGH();
    }

    @Override
    public void undo() {
        device.turnOFF();
    }
}


class BoostON implements Command{
    BoostMode device;
    public BoostON(BoostMode device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnON();
    }

    @Override
    public void undo() {
        device.turnOFF();
    }
}

class BoostOFF implements Command{
    BoostMode device;
    public BoostOFF(BoostMode device){
        this.device = device;
    }
    @Override
    public void execute() {
        device.turnOFF();
    }

    @Override
    public void undo() {
        device.turnON();
    }
}
