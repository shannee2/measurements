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
        double valueInCelsius = switch (this.unit) {
            case CELSIUS -> this.value;
            case FAHRENHEIT -> (this.value - 32) * 5 / 9;
            case KELVIN -> this.value - 273.15;
        };

        double convertedValue = switch (toUnit) {
            case CELSIUS -> valueInCelsius;
            case FAHRENHEIT -> (valueInCelsius * 9 / 5) + 32;
            case KELVIN -> valueInCelsius + 273.15;
        };

        return new Temperature(convertedValue, toUnit);
    }
}

