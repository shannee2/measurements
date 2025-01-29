package org.example;

import java.util.Objects;

public class Measurement<U extends Unit> {
    protected final double value;
    protected final U unit;

    public Measurement(double value, U unit) {
        if (value <= 0 && !(unit instanceof TemperatureUnit)) {
            throw new IllegalArgumentException("Value must be positive");
        }
        if (unit ==TemperatureUnit.KELVIN && value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.value = value;
        this.unit = unit;
    }

    public Measurement<U> add(Measurement<U> measurement, U toUnit) {
        Measurement<U> convertedMeasurement = measurement.convertTo(this.unit);
        Measurement<U> sum = new Measurement<>(convertedMeasurement.value + this.value, this.unit);
        return sum.convertTo(toUnit);
    }

    public Measurement<U> convertTo(U toUnit) {
        return new Measurement<>(value * this.unit.getConversionFactor() / toUnit.getConversionFactor(), toUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Measurement<?> that = (Measurement<?>) obj;
        return Double.compare(that.value, value) == 0 && unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}