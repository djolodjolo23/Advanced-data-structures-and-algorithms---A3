package problem2;

import java.util.Objects;

public class Car {

    private final String licensePlateNumber;
    private final int year;
    private final String colour;

    private final String make;


    public Car(String licensePlateNumber, int year, String colour, String make) {
        this.licensePlateNumber = licensePlateNumber;
        this.year = year;
        this.colour = colour;
        this.make = make;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(licensePlateNumber, car.licensePlateNumber) && Objects.equals(colour, car.colour) && Objects.equals(make, car.make);
    }

    @Override
    public int hashCode() {
        int hashVal = 0;
        for (int i = 0; i < licensePlateNumber.length(); i++) {
            int thechar = licensePlateNumber.charAt(i);
            hashVal += thechar;
            hashVal = hashVal * thechar;
        }
        return hashVal;
    }
}
