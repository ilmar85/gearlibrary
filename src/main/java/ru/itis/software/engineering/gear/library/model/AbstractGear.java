package ru.itis.software.engineering.gear.library.model;

import ru.itis.software.engineering.gear.library.Module;

public abstract class AbstractGear {
    /**
     * диаметр шестерни в мм
     */
    Float diameter;
    /**
     * ширина шестерни в мм
     */
    Float width;
    /**
     * количество зубьев шестерни
     */
    Long gearTeeth;
    /**
     * выбранный модуль зубьев шестерни
     */
    Module gearModule;

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Long getGearTeeth() {
        return gearTeeth;
    }

    public void setGearTeeth(Long gearTeeth) {
        this.gearTeeth = gearTeeth;
    }

    public Module getGearModule() {
        return gearModule;
    }

    public void setGearModule(Module gearModule) {
        this.gearModule = gearModule;
    }
}
