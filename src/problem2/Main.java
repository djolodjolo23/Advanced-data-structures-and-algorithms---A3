package problem2;

import Helpers.Statistics;
import problem1.QuadraticProbingHashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        QuadraticProbingHashTable<Car> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        List<List<QuadraticProbingHashTable.Stats<Car>>> allStats = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 11; j++) {
                quadraticProbingHashTable.insert(new Car());
            }
            allStats.add(quadraticProbingHashTable.getStats());
            quadraticProbingHashTable = new QuadraticProbingHashTable<>();
        }

        Statistics<QuadraticProbingHashTable.Stats<Car>> statistics = new Statistics();

        Map<Integer, Integer> map = statistics.getOccurrences(allStats);


        System.out.println();
    }
}
