package com.beatrix.structural_patterns.bridge;

import com.beatrix.ConsoleColors;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:22
 * @project CreationalPatterns
 */
public class RGB implements PeripheralsType {

    @Override
    public String getType() {
        return "RGB";
    }

    @Override
    public void work() {
        System.out.println("The " + ConsoleColors.RED + "R" + ConsoleColors.GREEN+
                "G" + ConsoleColors.CYAN + "B " + ConsoleColors.RESET + ConsoleColors.YELLOW_BRIGHT  +
                "is lightning up...<3" + ConsoleColors.RESET);
    }
}
