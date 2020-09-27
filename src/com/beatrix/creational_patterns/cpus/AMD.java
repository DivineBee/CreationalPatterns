package com.beatrix.creational_patterns.cpus;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:48
 * @project CreationalPatterns
 */
public class AMD implements CPU {

    @Override
    public void runProcesses() {
        System.out.println("AMD cpu is up and running.");
    }
}
