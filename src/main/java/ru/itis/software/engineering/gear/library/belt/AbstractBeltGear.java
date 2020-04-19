package ru.itis.software.engineering.gear.library.belt;


import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractBeltGear {

    private double ratio;
    private double slipRatio;
    private double centerDistance;
    private double rotationSpeedIdling;
    private double rotationSpeedLoad;

    /**
     * Расчёт передаточного числа
     *
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param drivenPulleyDiameter - диаметр ведомого шкива, мм
     * @param slipRatio - коэффициент скольжения
     * @return передаточное число
     */
    public abstract double calculateRatio(double drivingPulleyDiameter, double drivenPulleyDiameter, double slipRatio);

    /**
     * Расчёт диаметра ведомого шкива
     *
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param ratio                 - передаточное число
     * @param slipRatio             - коэффициент скольжения
     * @return диаметр ведомого шкива, мм
     */
    public abstract double calculateDrivenPulleyDiameter(double drivingPulleyDiameter, double ratio, double slipRatio);

    /**
     * Расчёт длины ремня (без учёта припуска на соединение концов)
     *
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param drivenPulleyDiameter  - диаметр ведомого шкива, мм
     * @param centerDistance        - межосевое расстояние (расстояние между геометрическими осями валов), мм
     * @return длина ремня, мм
     */
    public double calculateBeltLength(double drivingPulleyDiameter, double drivenPulleyDiameter, double centerDistance) {
        double firstTemp = 2 * centerDistance;
        double secondTemp = Math.PI/2 * (drivingPulleyDiameter + drivenPulleyDiameter);
        double thirdTemp = Math.pow(drivenPulleyDiameter - drivingPulleyDiameter, 2) / (4 * centerDistance);
        double result = firstTemp + secondTemp + thirdTemp;

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Расчёт межосевого расстояния (расстояние между геометрическими осями валов)
     *
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param drivenPulleyDiameter  - диаметр ведомого шкива, мм
     * @param beltLength            - длина ремня, мм
     * @return межосевое расстояние, мм
     */
    public double calculateCenterDistance(double drivingPulleyDiameter, double drivenPulleyDiameter, double beltLength) {
        double firstTemp = 2 * beltLength;
        double secondTemp = Math.PI * (drivenPulleyDiameter - drivingPulleyDiameter);
        double thirdTemp = Math.pow((2 * beltLength - secondTemp), 2);
        double fourthTemp =  8 * (Math.pow(drivenPulleyDiameter - drivingPulleyDiameter, 2));
        double fiveTemp = Math.sqrt(thirdTemp - fourthTemp);

        return (firstTemp - secondTemp + fiveTemp) / 8;
    }

    /**
     * Расчёт КПД ременной передачи
     *
     * @param drivingShaftPower - мощность на ведущем валу, кВт
     * @param drivenShaftPower  - мощность на ведомом валу, кВт
     * @return коэффициент полезного действия
     */
    public double calculateEfficiency(double drivingShaftPower, double drivenShaftPower) {
        double result = drivenShaftPower / drivingShaftPower;

        return new BigDecimal(result).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Расчёт окружной скорости на шкивах
     *
     * @param pulleyDiameter - диаметр шкива, мм
     * @param rotationSpeed  - частота вращения, мин(-1)
     * @return окружная скорость, м/с
     */
    public double peripheralSpeed(double pulleyDiameter, double rotationSpeed) {
        double result = (Math.PI * pulleyDiameter * rotationSpeed) / 60000;

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getSlipRatio() {
        return slipRatio;
    }

    public void setSlipRatio(double slipRatio) {
        this.slipRatio = slipRatio;
    }

    public double getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(double centerDistance) {
        this.centerDistance = centerDistance;
    }

    public double getRotationSpeedIdling() {
        return rotationSpeedIdling;
    }

    public void setRotationSpeedIdling(double rotationSpeedIdling) {
        this.rotationSpeedIdling = rotationSpeedIdling;
    }

    public double getRotationSpeedLoad() {
        return rotationSpeedLoad;
    }

    public void setRotationSpeedLoad(double rotationSpeedLoad) {
        this.rotationSpeedLoad = rotationSpeedLoad;
    }
}
