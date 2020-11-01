package com.beatrix.structural_patterns.adapter;

/**
 * @author Beatrice V.
 * @created 22.10.2020 - 17:12
 * @project CreationalPatterns
 */
public class Monitor {
    private String requiredPlug;

    public Monitor() { }

    public Monitor(String requiredPlug) {
        this.requiredPlug = requiredPlug;
    }

    public String getSocket(){
        return requiredPlug;
    }

    public boolean connectViaHdmi(HdmiCable hdmiCable){
        boolean result;
        result = (this.requiredPlug.equalsIgnoreCase("HDMI"));
        return result;
    }
}
