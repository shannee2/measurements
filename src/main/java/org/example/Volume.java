package org.example;

import java.util.Objects;

public class Volume implements Measurement <VolumeUnit> {
    private final double value;
    private final VolumeUnit volumeUnit;

    public Volume(double value, VolumeUnit volumeUnit) {
        if(value <=0){
            throw new IllegalArgumentException("Value cannot be less than or equal to 0");
        }
        this.value = value;
        this.volumeUnit = volumeUnit;
    }

    public Volume convertTo(VolumeUnit volumeUnit) {
        double valueInMillilitre = this.toMillilitre();
        return switch (volumeUnit) {
            case MILLILITRE -> new Volume(valueInMillilitre, VolumeUnit.MILLILITRE);
            case CENTILITRE -> new Volume(valueInMillilitre / 10, VolumeUnit.CENTILITRE);
            case DECILITRE -> new Volume(valueInMillilitre / 100, VolumeUnit.DECILITRE);
            case LITRE -> new Volume(valueInMillilitre / 1000, VolumeUnit.LITRE);
            case DECALITRE -> new Volume(valueInMillilitre / 10000, VolumeUnit.DECALITRE);
            case KILOLITRE -> new Volume(valueInMillilitre / 1000000, VolumeUnit.KILOLITRE);
            default -> throw new IllegalStateException("Unexpected value: " + volumeUnit);
        };
    }

    private double toMillilitre() {
        return switch (this.volumeUnit) {
            case MILLILITRE -> this.value;
            case CENTILITRE -> this.value * 10;
            case DECILITRE -> this.value * 100;
            case LITRE -> this.value * 1000;
            case DECALITRE -> this.value * 10000;
            case KILOLITRE -> this.value * 1000000;
            default -> throw new IllegalStateException("Unexpected value: " + this.volumeUnit);
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
        Volume volume = (Volume) obj;
        return Double.compare(volume.value, value) == 0 && volumeUnit == volume.volumeUnit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, volumeUnit);
    }
}
