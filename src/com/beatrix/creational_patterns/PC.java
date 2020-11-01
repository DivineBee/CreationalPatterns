package com.beatrix.creational_patterns;

import com.beatrix.creational_patterns.cpus.CPU;
import com.beatrix.creational_patterns.factories.PCFactory;
import com.beatrix.creational_patterns.factories.PCGamingFactory;
import com.beatrix.creational_patterns.factories.PCOfficeFactory;
import com.beatrix.creational_patterns.gpus.GPU;
import com.beatrix.creational_patterns.motherboards.Motherboard;
import com.beatrix.creational_patterns.ram.RamDDR3;
import com.beatrix.creational_patterns.ram.RamDDR4;
import com.beatrix.structural_patterns.bridge.*;

import java.util.Scanner;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 21:47
 * @project CreationalPatterns
 */
public class PC {
    private static Motherboard motherboard;
    private static GPU gpu;
    private static CPU cpu;

    public PC(PCFactory pcFactory) {
        motherboard = pcFactory.addMotherboard();
        gpu = pcFactory.addGPU();
        cpu = pcFactory.addCPU();
    }

    public static void buildPC(){
        motherboard.signal();
        motherboard.checkSocket();
        gpu.render();
        cpu.runProcesses();
    }

    public static PC getPC(){
        PC pc = null;
        PCFactory pcFactory;

        Scanner response = new Scanner(System.in);
        System.out.println("Enter PC type:");
        String pcType = response.nextLine();

        if(pcType.equalsIgnoreCase("Gaming")){
            pcFactory = new PCGamingFactory();
            pc = new PC(pcFactory);

            RamDDR4 ddr4 = new RamDDR4();
            ddr4.capacity = 16;
            ddr4.frequency = 3100;
            ddr4.name = "Kingston";
            ddr4.cellType= "ddr4";

            Scanner gamingResponse = new Scanner(System.in);
            System.out.println("Do you want another ram? yes/no");
            String extraRam = gamingResponse.nextLine();

            if(extraRam.equals("yes")){
                RamDDR4 secondDdr4 = (RamDDR4) ddr4.clone();
                System.out.println("Added second identical ram for compatibility\n" +
                        "Ram1 - " + ddr4.toString() + "\nRam2 - " + secondDdr4.toString());
            } else {
                System.out.println("Your gaming build is ready.");
            }

        } else if (pcType.equalsIgnoreCase("Office")){
            pcFactory = new PCOfficeFactory();
            pc = new PC(pcFactory);

            RamDDR3 ddr3 = new RamDDR3();
            ddr3.capacity = 4;
            ddr3.frequency = 2300;
            ddr3.name = "Corsair";
            ddr3.cellType= "ddr3";

            Scanner gamingResponse = new Scanner(System.in);
            System.out.println("Do you want another ram? yes/no");
            String extraRam = gamingResponse.nextLine();

            if(extraRam.equals("yes")){
                RamDDR3 secondDdr3 = (RamDDR3) ddr3.clone();
                System.out.println("Added second identical ram for compatibility\n" +
                        "Ram1 - " + ddr3.toString() + "\nRam2 - " + secondDdr3.toString());
            } else {
                System.out.println("Your gaming build is ready.");
            }

        } else {
            System.out.println("Can't build such PC.");
        }
        return pc;
    }
}
