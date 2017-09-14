package org.aditya.calculator.utils;

public class Unit {
    public String unitString;
    public UnitType type;

    public Unit(String unitString, UnitType type) {
        this.unitString = unitString;
        this.type = type;
    }

    public String getUnitString() {
        return unitString;
    }

    public UnitType getUnitType() {
        return type;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Unit)) {
            return false;
        }

        Unit otherUnit = (Unit) otherObject;

        return otherUnit.getUnitString().equals(unitString) && otherUnit.getUnitType().equals(type);
    }

    @Override
    public String toString() {
        return unitString;
    }
}
