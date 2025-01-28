package org.example;

public enum MassUnit implements Unit {
    MILLIGRAM(1),
    CENTIGRAM(10),
    DECIGRAM(100),
    GRAM(1000),
    DECAGRAM(10000),
    KILOGRAM(1000000);

    private final double conversionFactor;

    MassUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }
}