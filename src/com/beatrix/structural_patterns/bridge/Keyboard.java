package com.beatrix.structural_patterns.bridge;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:46
 * @project CreationalPatterns
 */
public class Keyboard extends Peripherals{

    public Keyboard(PeripheralsType peripheralsType) {
        super(peripheralsType);
    }

    @Override
    public void connect() {
        System.out.println("Your keyboard is connected!");
        peripheralsType.work();
    }
}
