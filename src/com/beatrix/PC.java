package com.beatrix;

import com.beatrix.cpus.CPU;
import com.beatrix.factories.PCFactory;
import com.beatrix.gpus.GPU;
import com.beatrix.motherboards.Motherboard;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 21:47
 * @project CreationalPatterns
 */
public class PC {
    private Motherboard motherboard;
    private GPU gpu;
    private CPU cpu;

    public PC(PCFactory pcFactory) {
        motherboard = pcFactory.addMotherboard();
        gpu = pcFactory.addGPU();
        cpu = pcFactory.addCPU();
    }

    public void buildPC(){
        motherboard.signal();
        motherboard.checkSocket();
        gpu.render();
        cpu.runProcesses();
    }
}
