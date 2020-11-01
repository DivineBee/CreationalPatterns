package com.beatrix.structural_patterns.adapter;

/**
 * @author Beatrice V.
 * @created 22.10.2020 - 17:23
 * @project CreationalPatterns
 */
public class VgaCable {
    private String plug;

    public VgaCable(String plug) {
        this.plug = plug;
    }

    public String getPlug() {
        return plug;
    }
}
