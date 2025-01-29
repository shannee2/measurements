package org.example;

public enum TemperatureUnit implements Unit {
    CELSIUS(1),
    FAHRENHEIT(1),
    KELVIN(1);

    private final double conversionFactor;

    TemperatureUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }
}

