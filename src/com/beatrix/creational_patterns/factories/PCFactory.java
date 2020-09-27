package com.beatrix.creational_patterns.factories;

import com.beatrix.creational_patterns.cpus.CPU;
import com.beatrix.creational_patterns.gpus.GPU;
import com.beatrix.creational_patterns.motherboards.Motherboard;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:50
 * @project CreationalPatterns
 */
public interface PCFactory {
    Motherboard addMotherboard();
    GPU addGPU();
    CPU addCPU();
}
