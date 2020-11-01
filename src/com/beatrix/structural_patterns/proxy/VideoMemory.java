package com.beatrix.structural_patterns.proxy;

import com.beatrix.ConsoleColors;
import com.beatrix.creational_patterns.gpus.GPU;

/**
 * @author Beatrice V.
 * @created 22.10.2020 - 18:39
 * @project CreationalPatterns
 */
public class VideoMemory implements GPU {
    private final String data;

    public VideoMemory(String data) {
        this.data = data;
        display(data);
    }

    public void display(String currentData){
        System.out.println(ConsoleColors.PURPLE_BACKGROUND + "Retrieving " + currentData +" from video memory."+ ConsoleColors.RESET);
    }

    @Override
    public void render() {
        System.out.println("Rendering data " + data);
    }
}
