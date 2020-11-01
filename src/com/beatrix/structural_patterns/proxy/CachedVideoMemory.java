package com.beatrix.structural_patterns.proxy;

import com.beatrix.creational_patterns.gpus.GPU;
/**
 * @author Beatrice V.
 * @created 22.10.2020 - 19:04
 * @project CreationalPatterns
 */
//Proxy class
public class CachedVideoMemory implements GPU {
    private VideoMemory videoMemory;
    private final String data;

    public CachedVideoMemory(String data) {
        this.data = data;
    }

    @Override
    public void render() {
        if(videoMemory == null){
            videoMemory = new VideoMemory(data);
        }
        videoMemory.render();
    }
}
