package com.beatrix.structural_patterns.proxy;

/**
 * @author Beatrice V.
 * @created 22.10.2020 - 20:47
 * @project CreationalPatterns
 */
public class Data {
    public int id;
    public int address;
    public int size;
    public String name;

    public Data(int id, int address, int size, String name) {
        this.id = id;
        this.address = address;
        this.size = size;
        this.name = name;
    }
}
