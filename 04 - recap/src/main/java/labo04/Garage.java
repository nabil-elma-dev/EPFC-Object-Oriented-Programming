package main.java.labo04;

public class Garage {
    private int numberOfCars;
    private Car[] garage;

    public Garage(int capacity) {
        this.garage = new Car[capacity];
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
        if (!this.isEmpty()) {
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

    public void sort() {
        for (int posCurrent = 0; posCurrent < numberOfCars; ++posCurrent) {
            int posMin = posMinFrom(posCurrent);
            swapCars(posCurrent, posMin);
        }
    }

    private void swapCars(int posCurrent, int posMin) {
        Car carOccupyingPosMin = this.garage[posMin];
        this.garage[posMin] = this.garage[posCurrent];
        this.garage[posCurrent] = carOccupyingPosMin;
    }

    private int posMinFrom(int start) {
        int posMin = start;
        for (int currentPos = start + 1; currentPos < this.numberOfCars; ++currentPos) {
            if (this.garage[currentPos].compareTo(this.garage[posMin]) < 0) {
                posMin = currentPos;
            }
        }
        return posMin;
    }
}
