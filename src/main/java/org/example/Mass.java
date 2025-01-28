package org.example;

public class Mass implements Measurement <MassUnit>{
    private final double value;
    private final MassUnit massUnit;

    public Mass(double value, MassUnit massUnit) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value cannot be less than or equal to 0");
        }
        this.value = value;
        this.massUnit = massUnit;
    }

    public Measurement convertTo(MassUnit massUnit) {
        double valueInMilligram = this.toMilligram();
        return switch (massUnit) {
            case MILLIGRAM -> new Mass(valueInMilligram, MassUnit.MILLIGRAM);
            case CENTIGRAM -> new Mass(valueInMilligram / 10, MassUnit.CENTIGRAM);
            case DECIGRAM -> new Mass(valueInMilligram / 100, MassUnit.DECIGRAM);
            case GRAM -> new Mass(valueInMilligram / 1000, MassUnit.GRAM);
            case DECAGRAM -> new Mass(valueInMilligram / 10000, MassUnit.DECAGRAM);
            case KILOGRAM -> new Mass(valueInMilligram / 1000000, MassUnit.KILOGRAM);
            default -> throw new IllegalStateException("Unexpected value: " + massUnit);
        };
    }

    private double toMilligram() {
        return switch (this.massUnit) {
            case MILLIGRAM -> this.value;
            case CENTIGRAM -> this.value * 10;
            case DECIGRAM -> this.value * 100;
            case GRAM -> this.value * 1000;
            case DECAGRAM -> this.value * 10000;
            case KILOGRAM -> this.value * 1000000;
            default -> throw new IllegalStateException("Unexpected value: " + this.massUnit);
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mass mass = (Mass) obj;
        return Double.compare(mass.value, value) == 0 && massUnit == mass.massUnit;
    }
}