package org.aditya.calculator.utils;

import java.util.ArrayList;

public class Conversion {
    private UnitValue unitValue1;
    private UnitValue unitValue2;

    public Conversion(UnitValue unitValue1, UnitValue unitValue2) {
        this.unitValue1 = unitValue1;
        this.unitValue2 = unitValue2;
    }

    public UnitValue convert(UnitValue initialUnitValue) {
        double multiplier;
        Unit newUnit;

        if (initialUnitValue.getUnit().equals(unitValue1.getUnit())) {
            multiplier = unitValue2.getValue() / unitValue1.getValue();
            newUnit = unitValue2.getUnit();
        } else if (initialUnitValue.getUnit().equals(unitValue2.getUnit())) {
            multiplier = unitValue1.getValue() / unitValue2.getValue();
            newUnit = unitValue1.getUnit();
        } else {
            return null;
        }

        return new UnitValue(initialUnitValue.getValue() * multiplier, newUnit);
    }

    ArrayList<UnitValue> getUnitValues() {
        ArrayList<UnitValue> units = new ArrayList<>();
        units.add(unitValue1);
        units.add(unitValue2);
        return units;
    }

    public boolean contains(Unit unit) {
        return unitValue1.getUnit().equals(unit) || unitValue2.getUnit().equals(unit);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Conversion)) {
            return false;
        }

        Conversion otherConversion = (Conversion) otherObject;

        return otherConversion.getUnitValues().contains(unitValue1) && otherConversion.getUnitValues().contains(unitValue2);
    }

    Conversion moveUnitToBottom(Unit unit) {
        if (!contains(unit)) {
            return null;
        }

        if (unitValue1.getUnit().equals(unit)) {
            return new Conversion(unitValue2, unitValue1);
        } else {
            return new Conversion(unitValue1, unitValue2);
        }
    }
}
