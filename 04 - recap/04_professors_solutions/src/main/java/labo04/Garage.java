package labo04;

public class Garage {
    private Car[] array;

    //nombre de voitures actuellement dans le garage (remplissage utile du tableau)
    private int numberOfCars;

    public Garage() {
        this(3);
    }

    public Garage(int capacity) {
        array = new Car[capacity];
        numberOfCars = 0;
    }

    public int numberOfCars() {
        return this.numberOfCars;
    }

    public boolean isEmpty() {
        return this.numberOfCars == 0;
    }

    public boolean isFull() {
        return this.numberOfCars == this.array.length;
    }

    public boolean add(Car c) {
        if (!this.isFull()) {
            this.array[numberOfCars++] = c;
            return true;
        }
        return false;
    }

    public boolean removeLastCar() {
        if (!isEmpty()) {
            --this.numberOfCars;
            this.array[this.numberOfCars] = null;
            /* pour que le garbage collector puisse
               libérer la mémoire associée à cet objet au besoin */
            return true;
        }
        return false;
    }

    //privé car ça concerne l'implémentation interne de ranger()
    //et donc cette opération ne doit pas être disponible
    //de façon publique
    private int posMinFrom(int start) {
        int posMin = start;
        for (int i = start + 1; i < this.numberOfCars; ++i)
            if (this.array[i].compareTo(this.array[posMin]) < 0)
                posMin = i;
        return posMin;
    }

    //privé car ça concerne l'implémentation interne de ranger()
    //et donc cette opération ne doit pas être disponible
    //de façon publique
    private void swapCars(int i, int j) {
        Car temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    //tri par sélection
    public void sort() {
        for (int i = 0; i < this.numberOfCars; ++i) {
            int posMin = posMinFrom(i);
            swapCars(i, posMin);
        }
    }

    public boolean contains(Car v) {
        for (int i = 0; i < this.numberOfCars; ++i)
            if (array[i].equals(v))
                return true;
        return false;
    }

    public Car getCar(int pos) {
        if (pos > 0 && pos <= this.numberOfCars)
            return array[pos - 1];
        return null;
    }

    @Override
    public String toString() {
        String res = "Garage : \n";
        for (int i = 0; i < this.numberOfCars; ++i)
            res += "  " + (i + 1) + ") " + array[i] + "\n";
        return res;
    }

    //pas demandé dans l'énoncé
    @Override
    public boolean equals(Object o) {
        if (o instanceof Garage) {
            Garage g = (Garage) o;
            if (g.numberOfCars == this.numberOfCars) {
                for (int i = 0; i < this.numberOfCars; ++i)
                    if (!g.getCar(i).equals(this.getCar(i)))
                        return false;
                return true;
            } else
                return false;
        }
        return false;
    }
}
