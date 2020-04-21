package ru.itis.software.engineering.gear.library;

import org.junit.Test;
import ru.itis.software.engineering.gear.library.GearLibrary;

import static org.junit.Assert.assertEquals;
import static ru.itis.software.engineering.gear.library.GearLibrary.GEAR_LIBRARY;

public class GearLibraryTest {
    @Test
    public void Test(){
        assertEquals(GEAR_LIBRARY.getGearRatio(5L,2L), (Double)2.5);
    }
}
