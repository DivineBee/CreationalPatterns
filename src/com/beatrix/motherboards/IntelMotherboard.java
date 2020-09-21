package com.beatrix.motherboards;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:19
 * @project CreationalPatterns
 */
public class IntelMotherboard implements Motherboard {
    @Override
    public void signal() {
        System.out.println("Motherboard is working.");
    }

    @Override
    public void checkSocket() {
        System.out.println("Intel socket 1151.");
    }
}
