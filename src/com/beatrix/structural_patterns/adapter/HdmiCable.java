package com.beatrix.structural_patterns.adapter;

/**
 * @author Beatrice V.
 * @created 22.10.2020 - 17:08
 * @project CreationalPatterns
 */
public class HdmiCable {
    private String plug;

    public HdmiCable() { }

    public HdmiCable(String plug) {
        this.plug = plug;
    }

    public String getPlug() {
        return plug;
    }
}
