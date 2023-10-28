package problem1;

import helpers.CSVExporter;
import helpers.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {



        QuadraticProbingHashTable<String> quadraticProbingHashTable = new QuadraticProbingHashTable<>();

        quadraticProbingHashTable.insert("a");
        quadraticProbingHashTable.insert("b");
        quadraticProbingHashTable.insert("c");

        System.out.println(quadraticProbingHashTable.contains("a"));

        quadraticProbingHashTable.remove("a");

        System.out.println(quadraticProbingHashTable.contains("a"));



        // bottom part is commented out since I used it data analysis.
        /**



        CSVExporter<Integer> csvExporter = new CSVExporter<>();
        Statistics<String> statistics = new Statistics<>();
        List<List<QuadraticProbingHashTable.Stats<String>>> hashTableOccurrences = new ArrayList<>();
        List<Integer> collisionsAt = new ArrayList<>();


        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10; j++) {
                quadraticProbingHashTable.insert(statistics.generateRandomString());
            }
            hashTableOccurrences.add(quadraticProbingHashTable.getStats());
            collisionsAt.add(quadraticProbingHashTable.getFirstCollisionOccurrenceAt());
            quadraticProbingHashTable = new QuadraticProbingHashTable<>();
        }

        //collisionsAt.removeIf(element -> element == 0);


        int noCollisions = 0;
        for (int i = 0; i < collisionsAt.size(); i++) {
            if (collisionsAt.get(i) == 0) {
                noCollisions++;
                collisionsAt.set(i, 11); // in case there is no collision
            }
        }

        System.out.println("Runs without a collision: " + noCollisions);

        Map<Integer, Integer> countedPositions = statistics.getOccurrencesString(hashTableOccurrences);
        List<Integer> values = new ArrayList<>(countedPositions.values());

        System.out.println("Average first collision: " + statistics.findAverageDouble(collisionsAt));
        csvExporter.exportDataToCSV(values, "src/problem1/problem1_tablemapping0-23.csv");


        System.out.println();
        */
    }
}
