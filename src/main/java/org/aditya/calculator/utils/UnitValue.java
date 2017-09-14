package org.aditya.calculator.utils;

public class UnitValue {
    private double value;
    private Unit unit;

    public UnitValue(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof UnitValue)) {
            return false;
        }

        UnitValue otherUnitMeasure = (UnitValue) otherObject;

        return otherUnitMeasure.getValue() == this.getValue() && otherUnitMeasure.getUnit().equals(this.getUnit());
    }
}
