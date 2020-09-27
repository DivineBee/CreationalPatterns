package com.beatrix.creational_patterns.factories;

import com.beatrix.creational_patterns.cpus.AMD;
import com.beatrix.creational_patterns.cpus.CPU;
import com.beatrix.creational_patterns.gpus.DedicatedGPU;
import com.beatrix.creational_patterns.gpus.GPU;
import com.beatrix.creational_patterns.motherboards.AMDMotherboard;
import com.beatrix.creational_patterns.motherboards.Motherboard;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:53
 * @project CreationalPatterns
 */
public class PCGamingFactory implements PCFactory {
    @Override
    public Motherboard addMotherboard() { return new AMDMotherboard(); }

    @Override
    public GPU addGPU() { return new DedicatedGPU(); }

    @Override
    public CPU addCPU() { return new AMD(); }
}
