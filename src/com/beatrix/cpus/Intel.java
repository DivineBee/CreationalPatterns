package com.beatrix.cpus;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:45
 * @project CreationalPatterns
 */
public class Intel implements CPU {
    @Override
    public void runProcesses() {
        System.out.println("Intel cpu is up and running.");
    }
}
