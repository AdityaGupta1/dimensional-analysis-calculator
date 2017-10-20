package org.aditya.calculator;

import org.aditya.calculator.utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static ArrayList<Conversion> lengthConversions = new ArrayList<>();
    private static ArrayList<Conversion> massConversions = new ArrayList<>();
    private static ArrayList<Conversion> pressureConversions = new ArrayList<>();
    private static ArrayList<Conversion> volumeConversions = new ArrayList<>();

    private static HashMap<String, UnitType> unitTypes = new HashMap<>();
    private static HashMap<UnitType, ArrayList<Conversion>> conversionLists = new HashMap<>();

    private static ArrayList<Unit> unitsWithPrefixes = new ArrayList<>();
    private static HashMap<String, Double> prefixes = new HashMap<>();

    private static void addMetricConversions() {
        unitsWithPrefixes.add(new Unit("m", UnitType.LENGTH));
        unitsWithPrefixes.add(new Unit("g", UnitType.MASS));
        unitsWithPrefixes.add(new Unit("L", UnitType.VOLUME));
        unitsWithPrefixes.add(new Unit("Pa", UnitType.PRESSURE));

        prefixes.put("Y", 1E24);
        prefixes.put("Z", 1E21);
        prefixes.put("E", 1E18);
        prefixes.put("P", 1E15);
        prefixes.put("T", 1E12);
        prefixes.put("G", 1E9);
        prefixes.put("M", 1E6);
        prefixes.put("k", 1E3);
        prefixes.put("d", 1E-1);
        prefixes.put("c", 1E-2);
        prefixes.put("m", 1E-3);
        prefixes.put("µ", 1E-6);
        prefixes.put("n", 1E-9);
        prefixes.put("p", 1E-12);
        prefixes.put("f", 1E-15);
        prefixes.put("a", 1E-18);
        prefixes.put("z", 1E-21);
        prefixes.put("y", 1E-24);

        for (Unit unit : unitsWithPrefixes) {
            for (String prefix : prefixes.keySet()) {
                String newUnitString = prefix + unit.getUnitString();
                UnitType type = unit.getUnitType();
                conversionLists.get(type).add(new Conversion(
                        new UnitValue(prefixes.get(prefix), unit),
                        new UnitValue(1, new Unit(newUnitString, type))));
                unitTypes.put(newUnitString, type);
            }
        }
    }

    private static void addConversions() {
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("km", UnitType.LENGTH)),
                new UnitValue(0.62137, new Unit("mi", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("mi", UnitType.LENGTH)),
                new UnitValue(5280, new Unit("ft", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("m", UnitType.LENGTH)),
                new UnitValue(1.0936, new Unit("yd", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("in", UnitType.LENGTH)),
                new UnitValue(2.54, new Unit("cm", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("km", UnitType.LENGTH)),
                new UnitValue(0.62137, new Unit("mi", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("Å", UnitType.LENGTH)),
                new UnitValue(Math.pow(10, -10), new Unit("m", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(1, new Unit("yd", UnitType.LENGTH)),
                new UnitValue(3, new Unit("ft", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(12, new Unit("in", UnitType.LENGTH)),
                new UnitValue(1, new Unit("ft", UnitType.LENGTH))));
        lengthConversions.add(new Conversion(
                new UnitValue(6, new Unit("ft", UnitType.LENGTH)),
                new UnitValue(1, new Unit("fathom", UnitType.LENGTH))));

        massConversions.add(new Conversion(
                new UnitValue(1, new Unit("kg", UnitType.MASS)),
                new UnitValue(2.2046, new Unit("lb", UnitType.MASS))));
        massConversions.add(new Conversion(
                new UnitValue(1, new Unit("lb", UnitType.MASS)),
                new UnitValue(453.59, new Unit("g", UnitType.MASS))));
        massConversions.add(new Conversion(
                new UnitValue(1, new Unit("lb", UnitType.MASS)),
                new UnitValue(16, new Unit("oz", UnitType.MASS))));
        massConversions.add(new Conversion(
                new UnitValue(1, new Unit("amu", UnitType.MASS)),
                new UnitValue(1.660538782 * Math.pow(10, -24), new Unit("g", UnitType.MASS))));

        pressureConversions.add(new Conversion(
                new UnitValue(1, new Unit("atm", UnitType.PRESSURE)),
                new UnitValue(1.01325 * Math.pow(10, 5), new Unit("Pa", UnitType.PRESSURE))));
        pressureConversions.add(new Conversion(
                new UnitValue(1, new Unit("atm", UnitType.PRESSURE)),
                new UnitValue(760, new Unit("torr", UnitType.PRESSURE))));
        pressureConversions.add(new Conversion(
                new UnitValue(1, new Unit("atm", UnitType.PRESSURE)),
                new UnitValue(14.70, new Unit("psi", UnitType.PRESSURE))));
        pressureConversions.add(new Conversion(
                new UnitValue(1, new Unit("bar", UnitType.PRESSURE)),
                new UnitValue(Math.pow(10, 5), new Unit("Pa", UnitType.PRESSURE))));
        pressureConversions.add(new Conversion(
                new UnitValue(1, new Unit("torr", UnitType.PRESSURE)),
                new UnitValue(1, new Unit("mmHg", UnitType.PRESSURE))));

        volumeConversions.add(new Conversion(
                new UnitValue(1, new Unit("L", UnitType.VOLUME)),
                new UnitValue(1.0567, new Unit("qt", UnitType.VOLUME))));
        volumeConversions.add(new Conversion(
                new UnitValue(1, new Unit("gal", UnitType.VOLUME)),
                new UnitValue(4, new Unit("qt", UnitType.VOLUME))));
        volumeConversions.add(new Conversion(
                new UnitValue(1, new Unit("gal", UnitType.VOLUME)),
                new UnitValue(3.7854, new Unit("L", UnitType.VOLUME))));
        volumeConversions.add(new Conversion(
                new UnitValue(2, new Unit("cup", UnitType.VOLUME)),
                new UnitValue(1, new Unit("pt", UnitType.VOLUME))));
        volumeConversions.add(new Conversion(
                new UnitValue(2, new Unit("pt", UnitType.VOLUME)),
                new UnitValue(1, new Unit("qt", UnitType.VOLUME))));
        volumeConversions.add(new Conversion(
                new UnitValue(1, new Unit("cup", UnitType.VOLUME)),
                new UnitValue(8, new Unit("fl oz", UnitType.VOLUME))));

        unitTypes.put("km", UnitType.LENGTH);
        unitTypes.put("mi", UnitType.LENGTH);
        unitTypes.put("ft", UnitType.LENGTH);
        unitTypes.put("m", UnitType.LENGTH);
        unitTypes.put("yd", UnitType.LENGTH);
        unitTypes.put("in", UnitType.LENGTH);
        unitTypes.put("cm", UnitType.LENGTH);
        unitTypes.put("Å", UnitType.LENGTH);
        unitTypes.put("fathom", UnitType.LENGTH);
        unitTypes.put("kg", UnitType.MASS);
        unitTypes.put("lb", UnitType.MASS);
        unitTypes.put("g", UnitType.MASS);
        unitTypes.put("oz", UnitType.MASS);
        unitTypes.put("amu", UnitType.MASS);
        unitTypes.put("atm", UnitType.PRESSURE);
        unitTypes.put("Pa", UnitType.PRESSURE);
        unitTypes.put("torr", UnitType.PRESSURE);
        unitTypes.put("psi", UnitType.PRESSURE);
        unitTypes.put("bar", UnitType.PRESSURE);
        unitTypes.put("mmHg", UnitType.PRESSURE);
        unitTypes.put("L", UnitType.VOLUME);
        unitTypes.put("qt", UnitType.VOLUME);
        unitTypes.put("gal", UnitType.VOLUME);
        unitTypes.put("cup", UnitType.VOLUME);
        unitTypes.put("pt", UnitType.VOLUME);
        unitTypes.put("fl oz", UnitType.VOLUME);

        conversionLists.put(UnitType.LENGTH, lengthConversions);
        conversionLists.put(UnitType.MASS, massConversions);
        conversionLists.put(UnitType.PRESSURE, pressureConversions);
        conversionLists.put(UnitType.VOLUME, volumeConversions);

        addMetricConversions();
    }

    public static void main(String[] args) {
        addConversions();

        Scanner scanner = new Scanner(System.in);

        // starting value
        System.out.println("Enter the initial value in the format <amount> <unit>:");
        String startString = scanner.nextLine();

        String[] startUnitStringArray = startString.split(" ");

        if (startUnitStringArray.length < 2) {
            System.err.println("Your starting value must be in the format <amount> <unit>!");
            return;
        }
        Double amount;
        try {
            amount = Double.parseDouble(startUnitStringArray[0]);
        } catch (NumberFormatException e) {
            System.err.println("You have entered an invalid amount for the starting value!");
            return;
        }
        String startUnitString = "";

        for (int i = 1; i < startUnitStringArray.length; i++) {
            startUnitString += startUnitStringArray[i];
            if (i != startUnitStringArray.length - 1) {
                startUnitString += " ";
            }
        }

        Set<String> units = unitTypes.keySet();
        if (!units.contains(startUnitString)) {
            System.err.println("Your starting unit is invalid / not supported!");
            return;
        }

        // desired unit
        System.out.println("Enter the desired unit:");
        String endUnitString = scanner.nextLine();

        if (!units.contains(endUnitString)) {
            System.err.println("Your desired unit is invalid / not supported / of the wrong type!");
            return;
        }

        // create starting UnitValue and ending unit
        UnitValue start = new UnitValue(amount, new Unit(startUnitString, unitTypes.get(startUnitString)));
        Unit end = new Unit(endUnitString, unitTypes.get(endUnitString));

        FullConversionMap conversionMap = convert(start, end);
        System.out.println();
        System.out.println(conversionMap.createDimensionalAnalysis());
    }

    private static FullConversionMap convert(UnitValue start, Unit end) {
        ArrayList<FullConversionMap> conversionMaps = new ArrayList<>();
        conversionMaps.add(new FullConversionMap(start, new ConversionMap(new ArrayList<>()), start));

        while (!hasUnit(conversionMaps, end)) {
            ArrayList<FullConversionMap> newConversionMaps = new ArrayList<>();

            for (FullConversionMap conversionMap : conversionMaps) {
                Unit finalUnit = conversionMap.getFinalUnitValue().getUnit();

                for (Conversion conversion : conversionLists.get(finalUnit.getUnitType())) {
                    if (conversionMap.getMap().getConversions().contains(conversion)) {
                        continue;
                    }

                    if (!conversion.contains(finalUnit)) {
                        continue;
                    }

                    newConversionMaps.add(new FullConversionMap(conversionMap.getInitialUnitValue(), conversionMap.getMap().addConversion(conversion), conversion.convert(conversionMap.getFinalUnitValue())));
                }
            }

            conversionMaps = newConversionMaps;
        }

        for (FullConversionMap conversionMap : conversionMaps) {
            if (conversionMap.getFinalUnitValue().getUnit().equals(end)) {
                return conversionMap;
            }
        }

        return null;
    }

    private static boolean hasUnit(ArrayList<FullConversionMap> conversionMaps, Unit unit) {
        ArrayList<Unit> units = new ArrayList<>();

        for (FullConversionMap conversionMap : conversionMaps) {
            units.add(conversionMap.getFinalUnitValue().getUnit());
        }

        return units.contains(unit);
    }
}
