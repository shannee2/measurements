package org.example;

public class Volume {
    private final double value;
    private Unit unit;

    public Volume(double value, Unit unit) {
        if(value <=0){
            throw new IllegalArgumentException("Value cannot be less than or equal to 0");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return this.value;
    }

    public double convertTo(Unit unit) {
        double valueInMillilitre = this.toMillilitre();
        switch (unit) {
            case MILLILITRE:
                return valueInMillilitre;
            case CENTILITRE:
                return valueInMillilitre / 10;
            case DECILITRE:
                return valueInMillilitre / 100;
            case LITRE:
                return valueInMillilitre / 1000;
            case DECALITRE:
                return valueInMillilitre / 10000;
            case KILOLITRE:
                return valueInMillilitre / 1000000;
            default:
                throw new IllegalStateException("Unexpected value: " + unit);
        }
    }

    private double toMillilitre() {
        switch (this.unit) {
            case MILLILITRE:
                return this.value;
            case CENTILITRE:
                return this.value * 10;
            case DECILITRE:
                return this.value * 100;
            case LITRE:
                return this.value * 1000;
            case DECALITRE:
                return this.value * 10000;
            case KILOLITRE:
                return this.value * 1000000;
            default:
                throw new IllegalStateException("Unexpected value: " + this.unit);
        }
    }
}
