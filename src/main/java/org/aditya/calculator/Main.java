package org.aditya.calculator;

import org.aditya.calculator.utils.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UnitValue start = new UnitValue(20000, new Unit("m", UnitType.LENGTH));
        ArrayList<Conversion> conversions = new ArrayList<>();
        conversions.add(new Conversion(new UnitValue(1, new Unit("m", UnitType.LENGTH)),new UnitValue(100, new Unit("cm", UnitType.LENGTH))));
        conversions.add(new Conversion(new UnitValue(2.54, new Unit("cm", UnitType.LENGTH)),new UnitValue(1, new Unit("in", UnitType.LENGTH))));
        conversions.add(new Conversion(new UnitValue(12, new Unit("in", UnitType.LENGTH)),new UnitValue(1, new Unit("ft", UnitType.LENGTH))));
        conversions.add(new Conversion(new UnitValue(5280, new Unit("ft", UnitType.LENGTH)),new UnitValue(1, new Unit("mi", UnitType.LENGTH))));
        ConversionMap map = new ConversionMap(conversions);
        FullConversionMap fullMap = map.convert(start);
        System.out.println(fullMap.getFinalUnitValue());
    }
}
