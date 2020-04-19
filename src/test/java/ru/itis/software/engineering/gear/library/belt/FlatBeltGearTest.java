package ru.itis.software.engineering.gear.library.belt;

import org.junit.Before;
import org.junit.Test;
import ru.itis.software.engineering.gear.library.belt.model.DrivenPulley;
import ru.itis.software.engineering.gear.library.belt.model.DrivingPulley;


import static org.junit.Assert.*;

public class FlatBeltGearTest {

    FlatBeltGear flatBeltGear;
    DrivingPulley drivingPulley;
    DrivenPulley drivenPulley;

    @Before
    public void init() {
        flatBeltGear = new FlatBeltGear();
        flatBeltGear.setRatio(2.0);
        flatBeltGear.setSlipRatio(0.1);
        flatBeltGear.setRotationSpeedIdling(1800.0);
        flatBeltGear.setRotationSpeedLoad(2000.0);

        drivingPulley = new DrivingPulley();
        drivingPulley.setDiameter(1185.0);
        drivingPulley.setRotationSpeed(1000.0);
        drivingPulley.setShaftPower(1000);

        drivenPulley = new DrivenPulley();
        drivenPulley.setDiameter(2133.0);
        drivenPulley.setRotationSpeed(1000.0);
        drivenPulley.setShaftPower(900);
    }

    @Test
    public void calculateDrivingPulleyDiameter() {
        double diameter = flatBeltGear.calculateDrivingPulleyDiameter(drivingPulley.getShaftPower(), 100);

        assertEquals(1185.0, diameter, 0.0);

    }

    @Test
    public void calculateDrivenPulleyDiameter() {
        double diameter = flatBeltGear.calculateDrivenPulleyDiameter(
                drivingPulley.getDiameter(),
                flatBeltGear.getRatio(),
                flatBeltGear.getSlipRatio());

        assertEquals(drivenPulley.getDiameter(), diameter, 0.0);
    }

    @Test
    public void calculateRatio() {
        double ratio = flatBeltGear.calculateRatio(drivingPulley.getDiameter(), drivenPulley.getDiameter(), flatBeltGear.getSlipRatio());

        assertEquals(flatBeltGear.getRatio(), ratio, 0.0);
    }

    @Test
    public void calculateSlipRatio() {
        double slipRatio = flatBeltGear.calculateSlipRatio(
                flatBeltGear.getRotationSpeedIdling(),
                flatBeltGear.getRotationSpeedLoad());
        assertEquals(flatBeltGear.getSlipRatio(), slipRatio, 0.0);
    }

    @Test
    public void peripheralSpeed() {
        double peripheralSpeed = flatBeltGear.peripheralSpeed(drivingPulley.getDiameter(), drivingPulley.getRotationSpeed());
        assertEquals(62.0, peripheralSpeed, 0.0);
    }

    @Test
    public void calculateEfficiency() {
        double efficiency = flatBeltGear.calculateEfficiency(drivingPulley.getShaftPower(), drivenPulley.getShaftPower());
        assertEquals(0.9, efficiency, 0.0);
    }
}