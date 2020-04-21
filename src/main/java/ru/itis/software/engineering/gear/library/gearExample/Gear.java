package ru.itis.software.engineering.gear.library.gearExample;

import ru.itis.software.engineering.gear.library.Module;
import ru.itis.software.engineering.gear.library.model.AbstractGear;

/**
 * Экземпляр класса шестерня
 */
public class Gear  extends AbstractGear {
    public Gear(Long gearTeeth1, Long gearTeeth2, Float width, Module gearModule, Double teethAngle, Double x) {
        super(gearTeeth1, gearTeeth2, width, gearModule, teethAngle, x);
    }
}
