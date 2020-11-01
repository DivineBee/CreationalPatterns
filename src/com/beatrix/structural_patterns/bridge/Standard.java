package com.beatrix.structural_patterns.bridge;

import com.beatrix.ConsoleColors;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:38
 * @project CreationalPatterns
 */
public class Standard implements PeripheralsType {
    @Override
    public String getType() {
        return "Standard";
    }

    @Override
    public void work() {
        System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT + "Standard device is turning on and ready!"+ ConsoleColors.RESET);
    }
}
