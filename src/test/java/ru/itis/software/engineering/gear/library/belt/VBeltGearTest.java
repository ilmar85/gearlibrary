package ru.itis.software.engineering.gear.library.belt;

import org.junit.Before;
import org.junit.Test;
import ru.itis.software.engineering.gear.library.belt.model.DrivenPulley;
import ru.itis.software.engineering.gear.library.belt.model.DrivingPulley;

import static org.junit.Assert.*;

public class VBeltGearTest {

    VBeltGear vBeltGear;
    DrivingPulley drivingPulley;
    DrivenPulley drivenPulley;

    @Before
    public void init() {
        vBeltGear = new VBeltGear();
        vBeltGear.setRatio(2.0);
        vBeltGear.setSlipRatio(0);

        drivingPulley = new DrivingPulley();
        drivingPulley.setDiameter(1000);

        drivenPulley = new DrivenPulley();
        drivenPulley.setDiameter(2000);
    }

    @Test
    public void calculateDrivenPulleyDiameter() {
        double diameter = vBeltGear.calculateDrivenPulleyDiameter(
                drivingPulley.getDiameter(),
                vBeltGear.getRatio(),
                vBeltGear.getSlipRatio());

        assertEquals(drivenPulley.getDiameter(), diameter, 0.0);
    }

    @Test
    public void calculateRatio() {
        double ratio = vBeltGear.calculateRatio(
                drivingPulley.getDiameter(),
                drivenPulley.getDiameter(),
                vBeltGear.getSlipRatio());

        assertEquals(vBeltGear.getRatio(), ratio, 0.0);
    }

    @Test
    public void calculatePulleyWidth() {
        double pulleyWidth = vBeltGear.calculatePulleyWidth(1, 5.00, 5.00);
        assertEquals(10.0, pulleyWidth, 0.0);
    }
}