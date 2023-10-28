package problem2;

import java.util.Objects;
import java.util.Random;

/**
 * Car class represents a car with a license plate number, year, colour, make and transmission.
 */
public class Car {

    private final String licensePlateNumber;
    private final int year;
    private final String colour;

    private final String make;

    private final char transmission;

    private final Random random = new Random();


    public Car(String licensePlateNumber, int year, String colour, String make, char transmission) {
        this.licensePlateNumber = licensePlateNumber;
        this.year = year;
        this.colour = colour;
        this.make = make;
        this.transmission = transmission;
    }

    /**
     * Random car
     */
    public Car() {
        this.licensePlateNumber = generateLicensePlate();
        this.year = generateYear();
        this.colour = generateColour();
        this.make = generateMake();
        this.transmission = generateTransmission();
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
        int result = 17;
        result += customHash(licensePlateNumber);
        result += customHash(year);
        result += customHash(colour);
        result += customHash(make);
        result *= 31;
        if (transmission == 'A') {
            result += 41;
        } else {
            result += 79;
        }
        return result;
    }



    private int customHash(Object object) {
        int hashVal = 0;
        String str = object.toString();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 1) {
                int charVal = str.charAt(i);
                hashVal += charVal;
            }
        }
        return hashVal;
    }


    private char generateTransmission() {
        return random.nextBoolean() ? 'A' : 'M';
    }

    private String generateLicensePlate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (random.nextInt(26) + 'A'));
        }
        for (int i = 0; i < 3; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private int generateYear() {
        return random.nextInt(2023 - 1970) + 1970;
    }


    private String generateColour() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return String.format("#%02x%02x%02x", red, green, blue);
    }


    private String generateMake() {
        String[] makes = {"BMW", "Mercedes", "Audi", "Volkswagen", "Porsche", "Opel", "Ford",
                "Fiat", "Renault", "Peugeot", "Citroen", "Toyota", "Honda", "Mazda", "Nissan",
                "Subaru", "Mitsubishi", "Suzuki", "Hyundai", "Kia", "Volvo", "Saab", "Jaguar",
                "Lexus", "Jeep", "Land Rover", "Tesla", "Ferrari", "Lamborghini", "Maserati", "Alfa Romeo",
                "Aston Martin", "Bentley", "Bugatti", "Chevrolet", "Chrysler", "Dodge", "Hummer", "Pontiac",
                "Cadillac", "Lincoln", "Acura"};
        return makes[random.nextInt(makes.length)];
    }

}
