package ru.itis.software.engineering.gear.library.belt.model;

public class Belt {

    /**
     * Длина ремня
     */
    private double length;

    public Belt() {
    }

    public Belt(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
