package com.beatrix.factories;

import com.beatrix.cpus.CPU;
import com.beatrix.gpus.GPU;
import com.beatrix.motherboards.Motherboard;

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
