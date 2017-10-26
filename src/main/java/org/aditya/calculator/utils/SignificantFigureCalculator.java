package org.aditya.calculator.utils;

public class SignificantFigureCalculator {
    public int calculateSignificantFigures(String number) {
        boolean hasDecimalPoint = false;

        if (number.contains(".")) {
            hasDecimalPoint = true;
            number = number.replace(".", "");
        }

        while (number.charAt(0) == '0') {
            number = number.substring(1);
        }

        if (hasDecimalPoint) {
            return number.length();
        }

        while (number.charAt(number.length() - 1) == '0') {
            number = number.substring(0, number.length() - 1);
        }

        return number.length();
    }
}
