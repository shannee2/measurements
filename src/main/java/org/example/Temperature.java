package org.example;

public class Temperature extends Measurement<TemperatureUnit> {

    public Temperature(double value, TemperatureUnit unit) {
        super(value, unit);
    }

    public Temperature increaseTemperature(Temperature temperature) {
        Measurement<TemperatureUnit> convertedTemperature = temperature.convertTo(this.unit);
        return new Temperature(this.value + convertedTemperature.value, this.unit);
    }

    @Override
    public Temperature convertTo(TemperatureUnit toUnit) {
        double convertedValue = switch (this.unit) {
            case CELSIUS -> switch (toUnit) {
                case CELSIUS -> this.value;
                case FAHRENHEIT -> (this.value * 9/5) + 32;
                case KELVIN -> this.value + 273.15;
            };
            case FAHRENHEIT -> switch (toUnit) {
                case CELSIUS -> (this.value - 32) * 5/9;
                case FAHRENHEIT -> this.value;
                case KELVIN -> (this.value - 32) * 5/9 + 273.15;
            };
            case KELVIN -> switch (toUnit) {
                case CELSIUS -> this.value - 273.15;
                case FAHRENHEIT -> (this.value - 273.15) * 9/5 + 32;
                case KELVIN -> this.value;
            };
        };

        return new Temperature(convertedValue, toUnit);
    }
}

