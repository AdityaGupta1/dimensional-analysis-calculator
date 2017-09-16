package org.aditya.calculator.utils;

public class FullConversionMap {
    private UnitValue initialUnitValue;
    private ConversionMap map;
    private UnitValue finalUnitValue;

    public FullConversionMap(UnitValue initialUnitValue, ConversionMap map, UnitValue finalUnitValue) {
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


    private String line1 = "";
    private String line2 = "";
    private String line3 = "";
    public String createDimensionalAnalysis() {
        line1 = initialUnitValue.toString();

        line2 = "";
        for (int i = 0; i < line1.length(); i++) {
            line2 += "-";
        }

        line3 = "";
        for (int i = 0; i < line1.length(); i++) {
            line3 += " ";
        }

        Unit previousTopUnit = initialUnitValue.getUnit();

        for (Conversion conversion : map.getConversions()) {
            addVerticalLine();

            // assumes conversion map is in order
            conversion = conversion.moveUnitToBottom(previousTopUnit);
            String topValue = conversion.getUnitValues().get(0).toString();
            String bottomValue = conversion.getUnitValues().get(1).toString();

            previousTopUnit = conversion.getUnitValues().get(0).getUnit();

            int length;
            if (topValue.length() >= bottomValue.length()) {
                length = topValue.length();
                bottomValue = createCenteredString(bottomValue, length - bottomValue.length());
            } else {
                length = bottomValue.length();
                topValue = createCenteredString(topValue, length - topValue.length());
            }

            line1 += topValue;
            line3 += bottomValue;
            for (int i = 0; i < length; i++) {
                line2 += "-";
            }
        }

        line2 += " = " + finalUnitValue;

        return line1 + "\n" + line2 + "\n" + line3;
    }

    private String createCenteredString(String string, int spaces) {
        boolean side = true;

        for (int i = 0; i < spaces; i++) {
            side = !side;
            if (side) {
                string = " " + string;
            } else {
                string = string + " ";
            }
        }

        return string;
    }

    private void addVerticalLine() {
        line1 += " | ";
        line2 += " + ";
        line3 += " | ";
    }
}
