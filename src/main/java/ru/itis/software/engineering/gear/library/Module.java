package ru.itis.software.engineering.gear.library;


public enum Module {
    MODULE0_05(0.05),
    MODULE0_06(0.06),
    MODULE0_08(0.08),
    MODULE0_1(0.1),
    MODULE0_12(0.12),
    MODULE0_15(0.15),
    MODULE0_2(0.2),
    MODULE0_25(0.25),
    MODULE0_3(0.3),
    MODULE0_4(0.4),
    MODULE0_5(0.5),
    MODULE0_6(0.6),
    MODULE0_8(0.8),
    MODULE1(1.0),
    MODULE1_25(1.25),
    MODULE1_5(1.5),
    MODULE2(2.0),
    MODULE2_5(2.5),
    MODULE3(3.0),
    MODULE4(4.0),
    MODULE5(5.0),
    MODULE6(6.0),
    MODULE8(8.0),
    MODULE10(10.0),
    MODULE12(12.0),
    MODULE16(16.0),
    MODULE25(25.0),
    MODULE32(32.0),
    MODULE40(40.0),
    MODULE50(50.0),
    MODULE60(60.0),
    MODULE80(80.0),
    MODULE100(100.0);

    Double value;

    public Double getValue() {
        return value;
    }

    Module(Double i) {
        this.value = i;
    }
}
