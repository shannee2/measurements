package org.example;

public class Volume {
    private final double value;
    private final Unit unit;

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

    public Unit getUnit() {
        return this.unit;
    }

    public Volume convertTo(Unit unit) {
        double valueInMillilitre = this.toMillilitre();
        return switch (unit) {
            case MILLILITRE -> new Volume(valueInMillilitre, Unit.MILLILITRE);
            case CENTILITRE -> new Volume(valueInMillilitre / 10, Unit.CENTILITRE);
            case DECILITRE -> new Volume(valueInMillilitre / 100, Unit.DECILITRE);
            case LITRE -> new Volume(valueInMillilitre / 1000, Unit.LITRE);
            case DECALITRE -> new Volume(valueInMillilitre / 10000, Unit.DECALITRE);
            case KILOLITRE -> new Volume(valueInMillilitre / 1000000, Unit.KILOLITRE);
            default -> throw new IllegalStateException("Unexpected value: " + unit);
        };
    }

    private double toMillilitre() {
        return switch (this.unit) {
            case MILLILITRE -> this.value;
            case CENTILITRE -> this.value * 10;
            case DECILITRE -> this.value * 100;
            case LITRE -> this.value * 1000;
            case DECALITRE -> this.value * 10000;
            case KILOLITRE -> this.value * 1000000;
            default -> throw new IllegalStateException("Unexpected value: " + this.unit);
        };
    }
}
