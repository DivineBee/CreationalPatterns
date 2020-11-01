package com.beatrix.structural_patterns.bridge;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:49
 * @project CreationalPatterns
 */
public class Mouse extends Peripherals{
    public Mouse(PeripheralsType peripheralsType) {
        super(peripheralsType);
    }

    @Override
    public void connect() {
        System.out.println("Your mouse is connected!");
        peripheralsType.work();
    }
}
