package org.example;

public class Main {
    public static void main(String[] args) {
        VolumeUnit litre = VolumeUnit.LITRE;
        VolumeUnit ml = VolumeUnit.MILLILITRE;
        MassUnit mg = MassUnit.MILLIGRAM;
        MassUnit g = MassUnit.GRAM;
        System.out.println(litre.getDeclaringClass()+" "+mg.getDeclaringClass());

        if(litre.getDeclaringClass().equals(g.getDeclaringClass())){
            System.out.println("Both are equal");
        }else{
            System.out.println("Both are not equal");
        }
        System.out.println(litre.getDeclaringClass()+" "+ml.getDeclaringClass());
    }
}
