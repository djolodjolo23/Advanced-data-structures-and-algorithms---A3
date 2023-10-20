package problem2;

import helpers.CSVExporter;
import helpers.Statistics;
import problem1.QuadraticProbingHashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        QuadraticProbingHashTable<Car> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        List<List<QuadraticProbingHashTable.Stats<Car>>> hashTableOccurrences = new ArrayList<>();

        List<Integer> collisionsAt = new ArrayList<>();

        CSVExporter<Integer> csvExporter = new CSVExporter<>();


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

        int noCollisions = 0;

        for (int i = 0; i < collisionsAt.size(); i++) {
            if (collisionsAt.get(i) == 0) {
                noCollisions++;
                collisionsAt.set(i, 11);
            }
        }

        System.out.println("Runs without a collision: " + noCollisions);

        Map<Integer, Integer> countedPositions = statistics.getOccurrences(hashTableOccurrences);
        List<Integer> values = new ArrayList<>(countedPositions.values());

        csvExporter.exportDataToCSV(values, "src/problem2/problem2_tablemapping0-23.csv");

        System.out.println("Average first collision: " + statistics.findAverageDouble(collisionsAt));


        System.out.println();
    }
}
