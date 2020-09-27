package com.beatrix.creational_patterns.factories;

import com.beatrix.creational_patterns.cpus.CPU;
import com.beatrix.creational_patterns.cpus.Intel;
import com.beatrix.creational_patterns.gpus.GPU;
import com.beatrix.creational_patterns.gpus.IntegratedGPU;
import com.beatrix.creational_patterns.motherboards.IntelMotherboard;
import com.beatrix.creational_patterns.motherboards.Motherboard;


/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:51
 * @project CreationalPatterns
 */
public class PCOfficeFactory implements PCFactory {
    @Override
    public Motherboard addMotherboard() {
        return new IntelMotherboard();
    }

    @Override
    public GPU addGPU() {
        return new IntegratedGPU();
    }

    @Override
    public CPU addCPU() { return new Intel(); }
}
