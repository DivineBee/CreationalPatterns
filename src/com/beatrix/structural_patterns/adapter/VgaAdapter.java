package com.beatrix.structural_patterns.adapter;

/**
 * @author Beatrice V.
 * @created 22.10.2020 - 17:24
 * @project CreationalPatterns
 */
public class VgaAdapter extends HdmiCable{
    private VgaCable vgaCable;

    public VgaAdapter(VgaCable vgaCable){
        this.vgaCable = vgaCable;
    }

    public String insertAdapter(){
        return "Vga adapter inserted to monitor.";
    }
}
