package com.beatrix.factories;

import com.beatrix.cpus.CPU;
import com.beatrix.cpus.Intel;
import com.beatrix.gpus.GPU;
import com.beatrix.gpus.IntegratedGPU;
import com.beatrix.motherboards.IntelMotherboard;
import com.beatrix.motherboards.Motherboard;


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
