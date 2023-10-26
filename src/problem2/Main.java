package problem2;

import helpers.CSVExporter;
import helpers.Statistics;
import problem1.QuadraticProbingHashTable;

import java.util.ArrayList;
import java.util.HashMap;
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
        Map<Integer, Integer> probeCountMap = new HashMap<>();

        /*
        for (List<QuadraticProbingHashTable.Stats<Car>> stats : hashTableOccurrences) {
            for (QuadraticProbingHashTable.Stats<Car> stat : stats) {
                if (stat.getProbeCount() > 0) {
                    // print index from the hash table and the number of probes
                    System.out.println("Car Index :" + stats.indexOf(stat));
                    System.out.println("Probes: " + stat.getProbeCount());
                }
            }
            System.out.println();
        }

         */

        List<Integer> allProbes = new ArrayList<>();


        for (List<QuadraticProbingHashTable.Stats<Car>> stats : hashTableOccurrences) {
            for (QuadraticProbingHashTable.Stats<Car> stat : stats) {
                if (stat.getProbeCount() > 0) {
                    int carIndex = stats.indexOf(stat);
                    int probes = stat.getProbeCount();
                    allProbes.add(probes);
                    if (probeCountMap.containsKey(carIndex)) {
                        int currentProbeCount = probeCountMap.get(carIndex);
                        probeCountMap.put(carIndex, currentProbeCount + probes);
                    } else {
                        probeCountMap.put(carIndex, probes);
                    }
                }
            }
        }


        // Ensure the list is not empty
        if (allProbes.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : allProbes) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        int average = sum / allProbes.size();

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Average: " + average);



        for (Map.Entry<Integer, Integer> entry : probeCountMap.entrySet()) {
            int carIndex = entry.getKey();
            int probes = entry.getValue();
            System.out.println("Car Index: " + carIndex);
            System.out.println("Probes: " + probes);
        }



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
