package main.java.labo04;

public class Garage {
    private int numberOfCars;
    private Car[] garage;

    public Garage(int qty) {
        this.garage = new Car[qty];
        this.numberOfCars = 0;
    }

    public Garage() {
        this(3);
    }

    public int numberOfCars() {
        return this.numberOfCars;
    }

    public boolean isEmpty() {
        return this.numberOfCars == 0;
    }

    public boolean isFull() {
        return this.garage.length == this.numberOfCars;
    }

    public boolean removeLastCar() {
        if (!isEmpty()) {
            --this.numberOfCars;
            this.garage[this.numberOfCars] = null;
            return true;
        }
        return false;
    }

    public boolean add(Car newCar) {
        if (!isFull()) {
            this.garage[this.numberOfCars] = newCar;
            ++this.numberOfCars;
            return true;
        }
        return false;
    }

    public boolean contains(Car target) {
        int pos = 0;
        while (pos < this.numberOfCars && garage[pos] != target) {
            ++pos;
        }
        return pos < this.numberOfCars;
    }

    public Car getCar(int pos) {
        return (pos > 0 && pos <= this.numberOfCars) ?
                garage[pos - 1]
                : null;
    }

    @Override
    public String toString() {
        String carList = "Garage : \n ";
        for (int i = 0; i < numberOfCars - 1; ++i) {
            carList += " " + ((i+1) + ") " + garage[i] + "\n ");
        }
        carList += " " + ((numberOfCars) + ") " + garage[numberOfCars - 1] + "\n");
        return carList;
    }
}
