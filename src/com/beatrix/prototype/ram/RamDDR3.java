package com.beatrix.prototype.ram;

/**
 * @author Beatrice V.
 * @created 21.09.2020 - 11:44
 * @project CreationalPatterns
 */
public class RamDDR3 extends RamComponent {
    public String cellType;

    public RamDDR3() {
    }

    public RamDDR3(RamDDR3 target) {
        super(target);
        if (target != null) {
            this.cellType = target.cellType;
        }
    }

    @Override
    public RamComponent clone() {
        return new RamDDR3(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RamDDR3 ramDDR3 = (RamDDR3) o;
        return cellType.equals(ramDDR3.cellType);
    }

    @Override
    public String toString() {
        return "RamDDR3 " +
                "cellType='" + cellType + '\'' +
                ", capacity=" + capacity +
                ", name='" + name + '\'' +
                ", frequency=" + frequency;
    }
}
