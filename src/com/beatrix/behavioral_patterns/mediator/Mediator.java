package com.beatrix.behavioral_patterns.mediator;

import com.beatrix.creational_patterns.PC;

/**
 * @author Beatrice V.
 * @created 21.11.2020 - 18:27
 * @project CreationalPatterns
 */
public class Mediator {
    PC buildedPC;

    public enum PCStatus {
        NOT_CHECKED, WORKING, MALFUNCTION, READY
    }

    public void checkParts(PC pc) {
        if (pc.status == PCStatus.WORKING) {
            buildedPC = pc;
            System.out.println("PC is working, ready to be sent to customer.");
        } else {
            pc.status = PCStatus.MALFUNCTION;
            buildedPC = pc;
            System.out.println("PC needs to be repaired, sending to master.");
        }
    }

    public void repair(PC pc) {
        checkParts(pc);
        if (pc.status.equals(PCStatus.MALFUNCTION)) {
            System.out.println("Your PC is being fixed...\nPLEASE STAND BY.");
            pc.status = PCStatus.READY;
        } else {
            System.out.println("Your pc is working, no need to repair.");
        }
    }
}
