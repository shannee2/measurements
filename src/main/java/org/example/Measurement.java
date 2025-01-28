package org.example;

import java.util.Objects;

public class Measurement implements IMeasurement {
    private final double value;
    private final Unit unit;

    public Measurement(double value, Unit unit) {
        if(value <= 0) {
            throw new IllegalArgumentException("Value should be positive");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public IMeasurement convertTo(Unit unit) {
        if(unit.getClass() != this.unit.getClass()) {
            throw new IllegalArgumentException("Cannot convert between different types of units");
        }
        return new Measurement(value * this.unit.getConversionFactor() / unit.getConversionFactor(), unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Measurement that = (Measurement) obj;
        return Double.compare(that.value, value) == 0 && unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
