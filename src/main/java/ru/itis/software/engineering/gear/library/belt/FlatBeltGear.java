package ru.itis.software.engineering.gear.library.belt;

/**
 * Расчёт плоскоременной передачи
 */
public class FlatBeltGear extends AbstractBeltGear {

    /**
     * Расчёт диаметра ведущего шкива (малого)
     * Полученный диаметр округляют до ближайшего стандартного значения ГОСТ 23831-79
     * @param drivingShaftPower           - мощность на ведущем валу, кВт
     * @param drivingShaftAngularVelocity - угловая скорость ведущего вала, рад/с
     * @return диаметра ведущего шкива, мм.
     *
     */
    public double calculateDrivingPulleyDiameter(double drivingShaftPower, double drivingShaftAngularVelocity) {
        double drivingShaft = drivingShaftPower/drivingShaftAngularVelocity;
        return 0.055 * Math.cbrt(drivingShaft);
    }

    @Override
    public double calculateDrivenPulleyDiameter(double drivingPulleyDiameter, double ratio, double slipRatio) {
        return ratio * drivingPulleyDiameter * (1 - slipRatio);
    }

//Скорости ременных передач

    @Override
    public double calculateRatio(double drivingPulleyDiameter, double drivenPulleyDiameter, double slipRatio) {
        return drivenPulleyDiameter / drivingPulleyDiameter * (1 - slipRatio);
    }

    /**
     * Расчёт коэффициента скольжения
     * @param rotationSpeedIdling - частота вращения на холостом ходу, мин(-1)
     * @param rotationSpeedLoad   - частота вращения под нагрузкой, мин(-1)
     * @return коэффициент скольжения
     */
    public double calculateSlipRatio(double rotationSpeedIdling, double rotationSpeedLoad) {
        return (rotationSpeedIdling - rotationSpeedLoad) / rotationSpeedIdling;
    }

    /**
     * Расчёт окружной скорости на шкивах
     * @param pulleyDiameter - диаметр шкива, мм
     * @param rotationSpeed  - частота вращения, мин(-1)
     * @return окружная скорость, м/с
     */
    public double peripheralSpeed(double pulleyDiameter, double rotationSpeed) {
        return (Math.PI * pulleyDiameter * rotationSpeed) / 60000;
    }



}
