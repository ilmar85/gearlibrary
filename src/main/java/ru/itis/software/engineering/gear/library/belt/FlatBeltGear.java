package ru.itis.software.engineering.gear.library.belt;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчёт плоскоременной передачи
 */
public class FlatBeltGear extends AbstractBeltGear {

    /**
     * Расчёт диаметра ведущего шкива (малого)
     * Полученный диаметр округляют до ближайшего стандартного значения ГОСТ 23831-79
     *
     * @param drivingShaftPower           - мощность на ведущем валу, кВт
     * @param drivingShaftAngularVelocity - угловая скорость ведущего вала, рад/с
     * @return диаметра ведущего шкива, мм.
     *
     */
    public double calculateDrivingPulleyDiameter(double drivingShaftPower, double drivingShaftAngularVelocity) {
        double drivingShaft = drivingShaftPower/drivingShaftAngularVelocity;
        double result = 550 * Math.cbrt(drivingShaft);

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double calculateDrivenPulleyDiameter(double drivingPulleyDiameter, double ratio, double slipRatio) {
        double result = ratio * drivingPulleyDiameter * (1 - slipRatio);

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double calculateRatio(double drivingPulleyDiameter, double drivenPulleyDiameter, double slipRatio) {
        double result = drivenPulleyDiameter / drivingPulleyDiameter * (1 - slipRatio);

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Расчёт коэффициента скольжения
     *
     * @param rotationSpeedIdling - частота вращения на холостом ходу, мин(-1)
     * @param rotationSpeedLoad   - частота вращения под нагрузкой, мин(-1)
     * @return коэффициент скольжения
     */
    public double calculateSlipRatio(double rotationSpeedIdling, double rotationSpeedLoad) {
        double result = (rotationSpeedLoad - rotationSpeedIdling) / rotationSpeedIdling;

        return new BigDecimal(result).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }



}
