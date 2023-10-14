package problem2;

import problem1.QuadraticProbingHashTable;

public class Main {
    public static void main(String[] args) {

        QuadraticProbingHashTable<Car> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        Car car1= new Car("MRH166", 1999, "red", "bmw");
        Car car2= new Car("MRH167", 1999, "red", "bmw");

        Car car3= new Car("MRH168", 1999, "red", "bmw");
        Car car4= new Car("MRH169", 1999, "red", "bmw");
        Car car5= new Car("MRH170", 1999, "red", "bmw");
        Car car6= new Car("MRH171", 1999, "red", "bmw");
        Car car7= new Car("MRH172", 1999, "red", "bmw");
        Car car8= new Car("MRH173", 1999, "red", "bmw");
        Car car9= new Car("MRH174", 1999, "red", "bmw");
        Car car10= new Car("MRH175", 1999, "red", "bmw");
        Car car11= new Car("MRH176", 1999, "red", "bmw");
        Car car12= new Car("MRH177", 1999, "red", "bmw");




        quadraticProbingHashTable.insert(car1);
        quadraticProbingHashTable.insert(car2);
        quadraticProbingHashTable.insert(car3);
        quadraticProbingHashTable.insert(car4);
        quadraticProbingHashTable.insert(car5);
        quadraticProbingHashTable.insert(car6);
        quadraticProbingHashTable.insert(car7);
        quadraticProbingHashTable.insert(car8);
        quadraticProbingHashTable.insert(car9);
        quadraticProbingHashTable.insert(car10);
        quadraticProbingHashTable.insert(car11);
        quadraticProbingHashTable.insert(car12);




        System.out.println(car1.hashCode());

    }
}
