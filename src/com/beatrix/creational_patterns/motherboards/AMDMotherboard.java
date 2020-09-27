package com.beatrix.creational_patterns.motherboards;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:21
 * @project CreationalPatterns
 */
public class AMDMotherboard implements Motherboard {
    @Override
    public void signal() {
        System.out.println("Motherboard is working.");
    }

    @Override
    public void checkSocket() { System.out.println("AMD AM4 socket."); }
}
