package ru.itis.software.engineering.gear.library;

import org.junit.Test;
import ru.itis.software.engineering.gear.library.GearLibrary;
import ru.itis.software.engineering.gear.library.gearExample.Gear;

import static org.junit.Assert.assertEquals;
import static ru.itis.software.engineering.gear.library.GearLibrary.GEAR_LIBRARY;

public class GearLibraryTest {
    @Test
    public void Test(){
        assertEquals(GEAR_LIBRARY.getGearRatio(5L,2L), (Double)2.5);
    }
    @Test
    public  void TestGear(){
        Gear gear = new Gear(50L, 50L, (float) 20.0, Module.MODULE3, 20.0, 0.0);
        assertEquals("высчитанный диаметр не совпадает!",(Double) 128.42461854401762,gear.getDiameter());
    }
}
