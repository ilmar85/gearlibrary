package ru.itis.software.engineering.gear.library.belt;

/**
 * Расчёт клиноременной передачи
 */
public class VBeltGear extends AbstractBeltGear {

    /**
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param drivenPulleyDiameter  - диаметр ведомого шкива, мм
     * @param slipRatio             - коэффициент скольжения не учитывается
     */
    @Override
    public double calculateRatio(double drivingPulleyDiameter, double drivenPulleyDiameter, double slipRatio) {
        return drivenPulleyDiameter / drivingPulleyDiameter;
    }

    /**
     * @param drivingPulleyDiameter - диаметр ведущего шкива, мм
     * @param ratio                 - передаточное число
     * @param slipRatio             - коэффициент скольжения не учитывается
     * @return
     */
    @Override
    public double calculateDrivenPulleyDiameter(double drivingPulleyDiameter, double ratio, double slipRatio) {
        return ratio * drivingPulleyDiameter;
    }
}
