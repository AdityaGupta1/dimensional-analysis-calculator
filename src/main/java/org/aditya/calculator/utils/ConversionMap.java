package org.aditya.calculator.utils;

import java.util.ArrayList;

public class ConversionMap {
    private ArrayList<Conversion> conversions;

    public ConversionMap(ArrayList<Conversion> conversions) {
        this.conversions = conversions;
    }

    public FullConversionMap convert(UnitValue initialUnitValue) {
        UnitValue finalUnitValue = initialUnitValue;
        ArrayList<Conversion> orderedConversionMap = new ArrayList<>();

        while (orderedConversionMap.size() < conversions.size()) {
            for (Conversion conversion : conversions) {
                ArrayList<Unit> units = new ArrayList<>();
                units.add(conversion.getUnitValues().get(0).getUnit());
                units.add(conversion.getUnitValues().get(1).getUnit());

                if (units.contains(finalUnitValue.getUnit())) {
                    orderedConversionMap.add(conversion);
                    finalUnitValue = conversion.convert(finalUnitValue);
                }
            }
        }

        return new FullConversionMap(initialUnitValue, new ConversionMap(orderedConversionMap), finalUnitValue);
    }

    public ArrayList<Conversion> getConversions() {
        return conversions;
    }
}
