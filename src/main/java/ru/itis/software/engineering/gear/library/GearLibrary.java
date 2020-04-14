package ru.itis.software.engineering.gear.library;

/**
 * библиотека расчета зубчатых передач
 */
public enum GearLibrary {
    GEAR_LIBRARY;

    /***
     *
     * @param gearTeeth1
     * @param gearTeeth2
     * @return
     */

    public Long getGearRatio(Long gearTeeth1, Long gearTeeth2){
        return gearTeeth1/gearTeeth2;
    }

    public Double getGearCenterDistance(Long gearTeeth1, Long gearTeeth2, Float teethAngle, Module module){
        return (0.5*(module.getValue()*((gearTeeth1+gearTeeth2)/(2*Math.cos(teethAngle)))));
    }

}
