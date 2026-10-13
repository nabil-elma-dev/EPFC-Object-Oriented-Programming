package labo04;

public class Car {
    private final String brand;
    private final String model;

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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car v = (Car) o;
            return (v.brand.equals(this.brand) && v.model.equals(this.model));
        }
        return false;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }

    public int compareTo(Car other) {
        return this.toString().compareTo(other.toString());
    }

}
