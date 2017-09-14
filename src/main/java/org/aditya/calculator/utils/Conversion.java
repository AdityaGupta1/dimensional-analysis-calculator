package org.aditya.calculator.utils;

import java.util.ArrayList;

public class Conversion {
    private UnitValue unit1;
    private UnitValue unit2;

    public Conversion(UnitValue unit1, UnitValue unit2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    public UnitValue convert(UnitValue initialUnitValue) {
        double multiplier;
        Unit newUnit;

        if (initialUnitValue.getUnit().equals(unit1.getUnit())) {
            multiplier = unit2.getValue() / unit1.getValue();
            newUnit = unit2.getUnit();
        } else if (initialUnitValue.getUnit().equals(unit2.getUnit())) {
            multiplier = unit1.getValue() / unit2.getValue();
            newUnit = unit1.getUnit();
        } else {
            return null;
        }

        return new UnitValue(initialUnitValue.getValue() * multiplier, newUnit);
    }

    public ArrayList<UnitValue> getUnitValues() {
        ArrayList<UnitValue> units = new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        return units;
    }

    /*
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Conversion)) {
            return false;
        }

        Conversion otherConversion = (Conversion) otherObject;

        return otherConversion.getUnitValues().contains(unit1) && otherConversion.getUnitValues().contains(unit2);
    }
    */
}
