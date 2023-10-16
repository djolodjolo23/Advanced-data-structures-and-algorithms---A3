package problem2;

import problem1.QuadraticProbingHashTable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        QuadraticProbingHashTable<Car> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        List<List<QuadraticProbingHashTable.Stats<Car>>> allStats = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 12; j++) {
                quadraticProbingHashTable.insert(new Car());
            }
            allStats.add(quadraticProbingHashTable.getStats());
            quadraticProbingHashTable = new QuadraticProbingHashTable<>();
        }

        System.out.println();
    }
}
