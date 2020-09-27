package com.beatrix.creational_patterns.ram;
/**
 * @author Beatrice V.
 * @created 21.09.2020 - 11:36
 * @project CreationalPatterns
 */
public abstract class RamComponent {
    public int capacity;
    public String name;
    public int frequency;

    public RamComponent() { }

    public RamComponent(RamComponent component) {
        if (component != null) {
            this.capacity = component.capacity;
            this.name = component.name;
            this.frequency = component.frequency;
        }
    }

    public abstract RamComponent clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RamComponent that = (RamComponent) o;
        return capacity == that.capacity &&
                name == that.name &&
                frequency == that.frequency;
    }
}
