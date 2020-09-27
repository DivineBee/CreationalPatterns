package com.beatrix.creational_patterns.gpus;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:48
 * @project CreationalPatterns
 */
public class DedicatedGPU implements GPU{

    @Override
    public void render() {
        System.out.println("Rendering from dedicated graphic card.");
    }
}
