package org.aditya.calculator.utils;

import java.util.ArrayList;

public class ConversionMap {
    private ArrayList<Conversion> conversions;

    public ConversionMap(ArrayList<Conversion> conversions) {
        this.conversions = conversions;
    }

    public ArrayList<Conversion> getConversions() {
        return conversions;
    }

    public ConversionMap addConversion(Conversion conversion) {
        ArrayList<Conversion> conversions = (ArrayList<Conversion>) this.conversions.clone();
        conversions.add(conversion);
        return new ConversionMap(conversions);
    }
}
