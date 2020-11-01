package com.beatrix.creational_patterns.gpus;

import com.beatrix.structural_patterns.proxy.Data;

import java.util.HashMap;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:45
 * @project CreationalPatterns
 */
public class IntegratedGPU implements GPU {
    @Override
    public void render() {
        System.out.println("Rendering from integrated graphic card.");
    }
}
