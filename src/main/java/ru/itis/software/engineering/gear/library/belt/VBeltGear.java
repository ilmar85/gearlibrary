package ru.itis.software.engineering.gear.library.belt;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчёт клиноременной передачи
 */
public class VBeltGear extends AbstractBeltGear {

    /**
     * Расчёт диаметра ведомого шкива, мм
     *
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param ratio                 - передаточное число
     * @param slipRatio             - коэффициент скольжения не учитывается
     * @return диаметр ведомого шкива, мм
     */
    @Override
    public double calculateDrivenPulleyDiameter(double drivingPulleyDiameter, double ratio, double slipRatio) {
        double result = ratio * drivingPulleyDiameter;

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Расчёт передаточного числа
     *
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param drivenPulleyDiameter  - диаметр ведомого шкива, мм
     * @param slipRatio             - коэффициент скольжения не учитывается
     */
    @Override
    public double calculateRatio(double drivingPulleyDiameter, double drivenPulleyDiameter, double slipRatio) {
        double result = drivenPulleyDiameter / drivingPulleyDiameter;

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Расчёт ширины шкива
     *
     * @param beltCount             - количество ремней в передаче
     * @param distanceGrooves       - расстояние между осями клиновых канавок, мм
     * @param distanceGroovesPulley - расстояние между осью крайней канавки и ближайшим торцом шкива, мм
     * @return ширина шкива, мм
     */
    public double calculatePulleyWidth(int beltCount, double distanceGrooves, double distanceGroovesPulley) {
        double firstTemp = (beltCount - 1) * distanceGrooves;
        double secondTemp = 2 * distanceGroovesPulley;
        double result = firstTemp + secondTemp;

        return new BigDecimal(result).setScale(0, RoundingMode.HALF_UP).doubleValue();
    }
}
