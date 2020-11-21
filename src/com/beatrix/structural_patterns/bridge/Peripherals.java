package com.beatrix.structural_patterns.bridge;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:44
 * @project CreationalPatterns
 */
public abstract class Peripherals {
    protected PeripheralsType peripheralsType;

    public Peripherals(PeripheralsType peripheralsType) {
        this.peripheralsType = peripheralsType;
    }

    public Peripherals() {

    }

    abstract public void connect();
}
