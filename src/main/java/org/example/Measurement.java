package org.example;

public interface Measurement<T extends Enum<T>> {
    Measurement<T> convertTo(T unit);
}
