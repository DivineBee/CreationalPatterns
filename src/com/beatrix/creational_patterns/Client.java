package com.beatrix.creational_patterns;

import com.beatrix.creational_patterns.factories.PCFactory;
import com.beatrix.creational_patterns.factories.PCGamingFactory;
import com.beatrix.creational_patterns.factories.PCOfficeFactory;
import com.beatrix.creational_patterns.ram.RamDDR3;
import com.beatrix.creational_patterns.ram.RamDDR4;

import java.util.Scanner;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:28
 * @project CreationalPatterns
 */
public class Client {
    public static void main(String[] args) {
        PC.getPC();
        try {
            PC.buildPC();
        } catch(NullPointerException e){
            System.err.println("You don't have a PC we can build.");
        }
    }
}
