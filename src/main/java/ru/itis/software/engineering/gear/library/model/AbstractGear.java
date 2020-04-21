package ru.itis.software.engineering.gear.library.model;

import ru.itis.software.engineering.gear.library.GearLibrary;
import ru.itis.software.engineering.gear.library.Module;
import ru.itis.software.engineering.gear.library.gearExample.Gear;

/**
 * абстрактная шестерня в вакууме
 */
public abstract class AbstractGear {

    /***
     * Здесь мы можем создать экземпляр класса
     * Который автоматически рассчитает максимальный диаметр заготовки под шестерню
     * @param gearTeeth1 количество зубьев в шестерне 1
     * @param gearTeeth2 количество зубьев в шестерне 2
     * @param width ширина шестерни
     * @param gearModule модуль
     * @param teethAngle угол зуба
     * @param x смещение между шестернями
     */
    public AbstractGear(Long gearTeeth1 , Long gearTeeth2,Float width, Module gearModule, Double teethAngle, Double x) {
        this.width = width;
        this.gearTeeth = gearTeeth2;
        this.gearModule = gearModule;
        this.teethAngle = teethAngle;
        this.x = x;
        this.diameter= GearLibrary.GEAR_LIBRARY.getGearToothTopDiameter(gearTeeth1,gearTeeth2,teethAngle,gearModule,x);
        this.deltaY= GearLibrary.GEAR_LIBRARY.getDeltaY(gearTeeth1,gearTeeth2,teethAngle,gearModule);
    }

    public AbstractGear(Double diameter, Float width, Long gearTeeth, Module gearModule, Double teethAngle, Double x,Double deltaY) {
        this.diameter = diameter;
        this.width = width;
        this.gearTeeth = gearTeeth;
        this.gearModule = gearModule;
        this.teethAngle = teethAngle;
        this.x = x;
        this.deltaY=deltaY;
    }


    /**
     * диаметр шестерни в мм
     */
    Double diameter;
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
    /**
     * угол наклона зуба шестерни
     */
    Double teethAngle;
    /**
     * коэфициент смещения зацепления колеса
     */
    Double x;
    /**
     * Коэффициент уравнительного смещения
     */
    Double deltaY;

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
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

    public Double getTeethAngle() {
        return teethAngle;
    }

    public void setTeethAngle(Double teethAngle) {
        this.teethAngle = teethAngle;
    }
}
