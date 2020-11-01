package com.beatrix.structural_patterns.bridge;

import com.beatrix.creational_patterns.gpus.GPU;
import com.beatrix.structural_patterns.adapter.HdmiCable;
import com.beatrix.structural_patterns.adapter.Monitor;
import com.beatrix.structural_patterns.adapter.VgaAdapter;
import com.beatrix.structural_patterns.adapter.VgaCable;
import com.beatrix.structural_patterns.proxy.CachedVideoMemory;

/**
 * @author Beatrice V.
 * @created 21.10.2020 - 20:28
 * @project CreationalPatterns
 */
public class mAIN {
    public static void main(String[] args) {
        Peripherals mouse = new Mouse(new RGB());
        mouse.connect();

        Peripherals keyboard = new Keyboard(new Standard());
        keyboard.connect();

        HdmiCable hdmiCable = new HdmiCable("hdmi");
        Monitor monitor = new Monitor("hdmi");
        if(monitor.connectViaHdmi(hdmiCable)){
            System.out.println("Hdmi connected!");
        }

        VgaCable vgaCable = new VgaCable("vga");
        VgaAdapter vgaAdapter = new VgaAdapter(vgaCable);
        if(monitor.connectViaHdmi(vgaAdapter)){
            System.out.println("VGA cable connected via adapter to hdmi socket from monitor.");
        }

        //proxy
        GPU image = new CachedVideoMemory("Guns Akimbo");
        image.render();
        System.out.println("");
        image.render();
    }
}
