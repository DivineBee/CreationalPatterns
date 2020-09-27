package com.beatrix.creational_patterns.ram;

/**
 * @author Beatrice V.
 * @created 21.09.2020 - 11:44
 * @project CreationalPatterns
 */
public class RamDDR4 extends RamComponent {
    public String cellType;

    public RamDDR4() {
    }

    public RamDDR4(RamDDR4 target) {
        super(target);
        if (target != null) {
            this.cellType = target.cellType;
        }
    }

    @Override
    public RamComponent clone() {
        return new RamDDR4(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RamDDR4 ramDDR3 = (RamDDR4) o;
        return cellType.equals(ramDDR3.cellType);
    }

    @Override
    public String toString() {
        return "RamDDR4 " +
                "cellType='" + cellType + '\'' +
                ", capacity=" + capacity +
                ", name='" + name + '\'' +
                ", frequency=" + frequency;
    }
}
