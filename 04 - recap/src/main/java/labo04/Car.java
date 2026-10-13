package main.java.labo04;

import java.util.Objects;

public class Car {
    private final String brand, model;

    public Car(String brand, String model) {
        if(brand == null || model == null)
            throw new RuntimeException("attributes cannot be null");
        this.brand = brand;
        this.model = model;

    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int compareTo(Car other) {
        return (this.brand + " " + this.model).compareToIgnoreCase(other.brand + " " + other.model);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car otherCar) {
            return this.compareTo(otherCar) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.model;
    }
}
