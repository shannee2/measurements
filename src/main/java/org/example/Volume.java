package org.example;

public class Volume {
    private final double value;
    private Unit unit;

    public Volume(double value, Unit unit) {
        if(value <=0){
            throw new IllegalArgumentException("Value cannot be less than or equal to 0");
        }
        this.value = value;
        this.unit =unit;
    }




}
