package org.example;

public enum VolumeUnit implements Unit{
    MILLILITRE(1),
    CENTILITRE(10),
    DECILITRE(100),
    LITRE(1000),
    DECALITRE(10000),
    KILOLITRE(1000000);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }
}
