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

    public Long getGearRatio(Long gearTeeth1, Long gearTeeth2) {
        return gearTeeth1 / gearTeeth2;
    }

    /**
     * Метод возвращает расстояние между центрами шесте
     * @param gearTeeth1
     * @param gearTeeth2
     * @param teethAngle
     * @param module
     * @return
     */
    public Double getGearCenterDistance(Long gearTeeth1, Long gearTeeth2, Float teethAngle, Module module) {
        return (0.5 * (module.getValue() * ((gearTeeth1 + gearTeeth2) / (2 * Math.cos(teethAngle)))));
    }

    /**
     * метод возвращает делительный диаметр шестерни
     *
     * @param gearTeeth
     * @param teethAngle
     * @param module
     * @return
     */

    public Double getGearDividingDiameter(Long gearTeeth, Float teethAngle, Module module) {
        return (module.getValue() * gearTeeth) / Math.cos(teethAngle);
    }

    /**
     * метод возвращает диаметр вершин зубьев шестерни
     * @param gearTeeth
     * @param teethAngle
     * @param module
     * @param x1
     * @param deltaY
     * @return
     */
    public Double getGearToothTopDiameter(Long gearTeeth, Float teethAngle, Module module, Long x1, Double deltaY) {
        return getGearDividingDiameter(gearTeeth, teethAngle, module) + (2 * (1 + x1 + deltaY) * module.getValue());
    }

    /**
     * метод возвращает диаметры впадин зубьев шестерни
     * @param gearTeeth
     * @param teethAngle
     * @param module
     * @param x1
     * @param deltaY
     * @return
     */
    public Double getGearToothBottomDiameter(Long gearTeeth, Float teethAngle, Module module, Long x1, Double deltaY) {
        return getGearDividingDiameter(gearTeeth, teethAngle, module) - (2 * (1 + x1 + deltaY) * module.getValue());
    }
}
