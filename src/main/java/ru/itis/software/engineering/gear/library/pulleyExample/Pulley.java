package ru.itis.software.engineering.gear.library.pulleyExample;

import ru.itis.software.engineering.gear.library.belt.model.AbstractPulley;

public class Pulley extends AbstractPulley {
    public Pulley(double diameter, double width, double shaftPower, double shaftAngularVelocity, double rotationSpeed) {
        super(diameter, width, shaftPower, shaftAngularVelocity, rotationSpeed);
    }
}
