package org.aditya.calculator.utils;

public class FullConversionMap {
    private UnitValue initialUnitValue;
    private ConversionMap map;
    private UnitValue finalUnitValue;

    FullConversionMap(UnitValue initialUnitValue, ConversionMap map, UnitValue finalUnitValue) {
        this.initialUnitValue = initialUnitValue;
        this.map = map;
        this.finalUnitValue = finalUnitValue;
    }

    public UnitValue getInitialUnitValue() {
        return initialUnitValue;
    }

    public ConversionMap getMap() {
        return map;
    }

    public UnitValue getFinalUnitValue() {
        return finalUnitValue;
    }
}
