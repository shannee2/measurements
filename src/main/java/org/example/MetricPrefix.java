package org.example;

public class MetricPrefix {
    public static final MetricPrefix MILLI = new MetricPrefix(0.001);
    public static final MetricPrefix CENTI = new MetricPrefix(0.01);
    public static final MetricPrefix DECI = new MetricPrefix(0.1);
    public static final MetricPrefix DECA = new MetricPrefix(10);
    public static final MetricPrefix KILO = new MetricPrefix(1000);

    private final double factor;

    private MetricPrefix(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}