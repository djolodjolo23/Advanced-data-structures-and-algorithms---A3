package problem2;

import Helpers.Statistics;
import problem1.QuadraticProbingHashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        QuadraticProbingHashTable<Car> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        List<List<QuadraticProbingHashTable.Stats<Car>>> hashTableOccurrences = new ArrayList<>();

        List<Integer> collisionsAt = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                quadraticProbingHashTable.insert(new Car());
            }
            hashTableOccurrences.add(quadraticProbingHashTable.getStats());
            collisionsAt.add(quadraticProbingHashTable.getFirstCollisionOccurrenceAt());
            quadraticProbingHashTable = new QuadraticProbingHashTable<>();
        }

        Statistics<QuadraticProbingHashTable.Stats<Car>> statistics = new Statistics<>();

        //collisionsAt.removeIf(element -> element == 0);

        Map<Integer, Integer> countedPositions = statistics.getOccurrences(hashTableOccurrences);
        double avgColision = statistics.findAverage(collisionsAt);


        System.out.println();
    }
}
