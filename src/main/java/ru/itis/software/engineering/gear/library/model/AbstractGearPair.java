package ru.itis.software.engineering.gear.library.model;

import ru.itis.software.engineering.gear.library.GearLibrary;

public abstract class AbstractGearPair {

    /**
     * Абстрактные модели шестерен
     */
    AbstractGear abstractGear1;
    AbstractGear abstractGear2;
    /**
     * расстояние между центральным
     */
    Float centerDistance;

    public AbstractGear getAbstractGear1() {
        return abstractGear1;
    }

    public void setAbstractGear1(AbstractGear abstractGear1) {
        this.abstractGear1 = abstractGear1;
    }

    public AbstractGear getAbstractGear2() {
        return abstractGear2;
    }

    public void setAbstractGear2(AbstractGear abstractGear2) {
        this.abstractGear2 = abstractGear2;
    }

    public Float getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(Float centerDistance) {
        this.centerDistance = centerDistance;
    }
    public Double calculateRatio(){
        return GearLibrary.GEAR_LIBRARY.getGearRatio(abstractGear1.gearTeeth,abstractGear2.gearTeeth);
    }
}
