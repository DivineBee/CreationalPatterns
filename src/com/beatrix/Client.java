package com.beatrix;

import com.beatrix.ConsoleColors;
import com.beatrix.behavioral_patterns.command.KeyboardLoader;
import com.beatrix.behavioral_patterns.mediator.Mediator;
import com.beatrix.creational_patterns.PC;
import com.beatrix.creational_patterns.factories.PCFactory;
import com.beatrix.creational_patterns.factories.PCGamingFactory;
import com.beatrix.creational_patterns.factories.PCOfficeFactory;
import com.beatrix.creational_patterns.gpus.GPU;
import com.beatrix.creational_patterns.ram.RamDDR3;
import com.beatrix.creational_patterns.ram.RamDDR4;
import com.beatrix.structural_patterns.adapter.HdmiCable;
import com.beatrix.structural_patterns.adapter.Monitor;
import com.beatrix.structural_patterns.adapter.VgaAdapter;
import com.beatrix.structural_patterns.adapter.VgaCable;
import com.beatrix.structural_patterns.bridge.*;
import com.beatrix.structural_patterns.proxy.CachedVideoMemory;

import java.util.Scanner;

/**
 * @author Beatrice V.
 * @created 20.09.2020 - 18:28
 * @project CreationalPatterns
 */
public class Client {
    public static void main(String[] args) {
        Peripherals mouse = new Mouse(new RGB());
        Keyboard keyboard = new Keyboard(new Standard());

        HdmiCable hdmiCable = new HdmiCable("hdmi");
        Monitor monitor = new Monitor("hdmi");

        VgaCable vgaCable = new VgaCable("vga");
        VgaAdapter vgaAdapter = new VgaAdapter(vgaCable);

        GPU image = new CachedVideoMemory("Guns Akimbo");

        PC.getPC();
        try {
            PC.buildPC();
        } catch(NullPointerException e){
            System.err.println("You don't have a PC we can build.");
        }

        mouse.connect();
        keyboard.connect();

        if(monitor.connectViaHdmi(hdmiCable)){
            System.out.println("Hdmi connected!");
        }

        if(monitor.connectViaHdmi(vgaAdapter)){
            System.out.println("VGA cable connected via adapter to hdmi socket from monitor.");
        }

        //proxy
        image.render();
        System.out.println("");
        image.render();

        //mediator
        System.out.println("Now PC Control which uses Mediator design based architecture.");
        Scanner scan = new Scanner(System.in);

        // Object initialization block
        Mediator mediator = new Mediator();
        PC inOperationPC;
        PC pc1 = new PC(mediator, "Gaming Nedd");
        PC pc2 = new PC(mediator, "Office Lorely");
        PC pc3 = new PC(Mediator.PCStatus.MALFUNCTION, mediator, "Gaming Nicole");

        // User input block
        String repeatRunFlag = "yes";
        while (!repeatRunFlag.equalsIgnoreCase("no")) {
            System.out.println("Which pc do you want to check? ");
            System.out.println("press 1 for Ned's");
            System.out.println("press 2 for Lorely's");
            System.out.println("press 3 for Nicole's");

            int choice = scan.nextInt();
            if (choice == 1) {
                inOperationPC = pc1;
            } else if (choice == 2) {
                inOperationPC = pc2;
            } else {
                inOperationPC = pc3;
            }
            System.out.println("What do you want to do with the pc? " + inOperationPC.name);
            System.out.println("Press 1 to check parts ");
            System.out.println("Press 2 to repair ");

            int type = scan.nextInt();
            try {
                switch (type) {
                    case 1:
                        inOperationPC.checkParts();
                        break;
                    case 2:
                        inOperationPC.repair();
                        break;

                }
            } catch (Exception e1) {
                System.out.println("# Access denied #");
            }
            System.out.println("Press No to Exit and any other character to Continue pc operations  ... ");
            try {
                repeatRunFlag = scan.next();
            } catch (Exception e) {
                repeatRunFlag = "no";
            }
        }

        //command
        scan = new Scanner(System.in);
        int flag = 1;
        KeyboardLoader loader = new KeyboardLoader(keyboard);
        loader.load();
        while (flag == 1) {
            System.out.println("This is the Client Main Command Pattern with keyboard Example ");
            System.out.println("Loading the keyboard with appropriate commands and mapping them to keys ... ");
            System.out.println(ConsoleColors.GREEN_BOLD +"Please press the any command between 1 to 14 for operation\n" +
                    "1.        LightON\n" +
                    "2.        lightOff\n" +
                    "3.        fanOff\n" +
                    "4.        FanLOW\n" +
                    "5.        FanMEDIUM\n" +
                    "6.        FanHIGH\n" +
                    "7.        BoostON\n" +
                    "8.        BoostOFF\n" +
                    "9.        UndoCommandMacro\n" +
                    "10.       MasterOffcommand\n" +
                    "11.       musicOFF\n" +
                    "12.       MusicON\n" +
                    "13.       MusicVolumeUP\n" +
                    "14.       MusicVolumeDown\n"+ConsoleColors.RESET);

            int keyboardButtonNumber = scan.nextInt();
            keyboard.buttonPress(keyboardButtonNumber);

            System.out.println("\nDo you want to Re-run this program - Press 1 for yes and 0 or other digits to EXIT ");
            try {
                flag = scan.nextInt();
            } catch (Exception e) {
                flag = 0;
            }
        }
    }
}
