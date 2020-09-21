package com.beatrix.factories;

import com.beatrix.cpus.AMD;
import com.beatrix.cpus.CPU;
import com.beatrix.gpus.DedicatedGPU;
import com.beatrix.gpus.GPU;
import com.beatrix.motherboards.AMDMotherboard;
import com.beatrix.motherboards.Motherboard;

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
