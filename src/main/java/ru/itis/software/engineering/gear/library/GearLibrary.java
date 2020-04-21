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

    public Double getGearRatio(Long gearTeeth1, Long gearTeeth2) {
        return (double) gearTeeth1 / (double) gearTeeth2;
    }


    /**
     * Метод возвращает расстояние между центрами шесте
     * @param gearTeeth1
     * @param gearTeeth2
     * @param teethAngle
     * @param module
     * @return
     */
    public Double getGearCenterDistance(Long gearTeeth1, Long gearTeeth2, Double teethAngle, Module module) {
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

    public Double getGearDividingDiameter(Long gearTeeth, Double teethAngle, Module module) {
        return (module.getValue() * gearTeeth) / Math.cos(teethAngle);
    }

    /**
     * метод возвращает диаметр вершин зубьев шестерни
     * @param gearTeeth
     * @param teethAngle
     * @param module
     * @param x1 коэфициент смещения колеса
     * @param deltaY
     * @return
     */
    public Double getGearToothTopDiameter(Long gearTeeth, Double teethAngle, Module module, Double x1, Double deltaY) {
        return getGearDividingDiameter(gearTeeth, teethAngle, module) + (2 * (1 + x1 + deltaY) * module.getValue());
    }
    public Double getGearToothTopDiameter(Long gearTeeth,Long gearTeeth2, Double teethAngle, Module module, Double x1 ){
        Double deltaY = getDeltaY(gearTeeth,gearTeeth2,teethAngle,module);
        return getGearToothTopDiameter(gearTeeth,  teethAngle,  module, x1, deltaY);
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
    public Double getGearToothBottomDiameter(Long gearTeeth, Double teethAngle, Module module, Long x1, Double deltaY) {
        return getGearDividingDiameter(gearTeeth, teethAngle, module) - (2 * (1 + x1 + deltaY) * module.getValue());
    }


    public Double getDeltaY(Long gearTeeth1,Long gearTeeth2, Double teethAngle, Module module){
        return getXe()-getY(gearTeeth1,gearTeeth2,teethAngle,module);

    }

    private Double getY(Long teeth1,Long teeth2, Double teethAngle,Module module) {
        return (getGearCenterDistance(teeth1,teeth2,teethAngle,module)
                -getDividingCenterDistance(teeth1,teeth2,teethAngle,module))/module.getValue();
    }

    private Double getDividingCenterDistance(Long teeth1,Long teeth2, Double teethAngle,Module module) {
        return ((teeth1+teeth2)*module.getValue())/2*(Math.cos(teethAngle));
    }

    private Double getXe() {
        return 0.0;
    }
}
