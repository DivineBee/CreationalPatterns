package com.beatrix.behavioral_patterns.command;

import com.beatrix.structural_patterns.bridge.Keyboard;

/**
 * @author Beatrice V.
 * @created 21.11.2020 - 17:59
 * @project CreationalPatterns
 */
public class KeyboardLoader {
    Keyboard Keyboard;

    public KeyboardLoader(Keyboard Keyboard) {
        this.Keyboard = Keyboard;
    }

    public void load() {
        // Create instance of 3rd party devices
        Light light = new Light();
        Fan fan = new Fan();
        BoostMode boost = new BoostMode();

//		Command cmd =  new LightON(light);
        Keyboard.setCommandOnSpecialKey(0,new Undocommand(Keyboard));
        Keyboard.setCommandOnSpecialKey(1,new LightON(light));
        LightOFF lightOff = new LightOFF(light);
        Keyboard.setCommandOnSpecialKey(2,lightOff);
        FanOFF fanOff = new FanOFF(fan);
        Keyboard.setCommandOnSpecialKey(3,fanOff);
        Keyboard.setCommandOnSpecialKey(4,new FanLOW(fan));
        Keyboard.setCommandOnSpecialKey(5,new FanMEDIUM(fan));
        Keyboard.setCommandOnSpecialKey(6,new FanHIGH(fan));
        Keyboard.setCommandOnSpecialKey(7,new BoostON(boost));
        BoostOFF BoostOFF = new BoostOFF(boost);
        Keyboard.setCommandOnSpecialKey(8,BoostOFF);
        Keyboard.setCommandOnSpecialKey(9,new UndocommandMacro(Keyboard));
        Keyboard.setCommandOnSpecialKey(10,new MasterOffcommand(lightOff,fanOff,BoostOFF));


    }
}


// There are several 3rd component or devices. They would ack as reciever of the command. Each command object would wrap them.
class Light {
    void turnON() {
        System.out.println("Turn ON Light");
    }

    void turnOFF() {
        System.out.println("Turn OFF Light");
    }
}

class Fan {

    public enum speed{
        OFF,LOW,MED,HIGH
    }
    speed fanSpeed;

    void turnOFF() {
        fanSpeed = speed.OFF;
        System.out.println("Turn OFF FAN");
    }
    void turnLOW() {
        fanSpeed = speed.LOW;
        System.out.println("Turn LOW FAN");
    }
    void turnMED() {
        fanSpeed = speed.MED;
        System.out.println("Turn MED FAN");
    }
    void turnHIGH() {
        fanSpeed = speed.HIGH;
        System.out.println("Turn HIGH FAN");
    }

}

class BoostMode {
    void turnON() {
        System.out.println("Turn ON Boost");
    }

    void turnOFF() {
        System.out.println("Turn OFF Boost");
    }
}

class MusicSystem {
    void turnON() {
        System.out.println("Turn ON Music System");
    }

    void turnOFF() {
        System.out.println("Turn OFF Music System");
    }
    void volumeUP() {
        System.out.println("Volume up Music System");
    }

    void volumeDOWN() {
        System.out.println("Volume down Music System");
    }
}
