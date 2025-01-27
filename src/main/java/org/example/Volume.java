package org.example;

public class Volume {
    private final double litreValue;
    private Unit unit;

    public Volume(double value, Unit unit) {
        if(value <=0){
            throw new IllegalArgumentException("Value cannot be less than or equal to 0");
        }
//        Conversion
        this.litreValue = value;
        this.unit =unit;
    }




}
