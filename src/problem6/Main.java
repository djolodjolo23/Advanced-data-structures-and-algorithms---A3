package problem6;

import helpers.CSVExporter;
import helpers.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Integer[] array = {5, 20, 3, 6};
        System.out.println("Before sorting: ");
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        MergeSortIterative.doMergeSort(array);
        System.out.println("After sorting: ");
        for (Integer i : array) {
            System.out.print(i + " ");
        }

        Integer[] array2 = {5, 20, 3, 6};

        System.out.println();
        System.out.println("Before sorting: ");
        for (Integer i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
        MergeSortRecursive.doMergeSort(array2);
        System.out.println("After sorting: ");
        for (Integer i : array2) {
            System.out.print(i + " ");
        }

        /**

        Random random = new Random();


        Timer timer = new Timer();
        CSVExporter<Long> csvExporter = new CSVExporter<>();

        List<List<Long>> mergeSortIterativeAllTimes = new ArrayList<>();
        List<List<Long>> mergeSortRecursiveAllTimes = new ArrayList<>();



        for (int k = 0; k < 100; k++) {
            List<Long> insertSortTimes= new ArrayList<>();
            List<Long> heapSortTimes = new ArrayList<>();
            for (int i = 0; i <= 100000; i += 1000) {
                Integer[] array = new Integer[i];
                for (int j = 0; j < array.length; j++) {
                    array[j] = random.nextInt(500000);
                } // first run is on empty array to warm up the JVM, ignore this run in the csv stats
                final Integer[] arrayCopy = Arrays.copyOf(array, array.length);
                insertSortTimes.add(timer.timeItNanoTime(() -> MergeSortIterative.doMergeSort(arrayCopy)));
                heapSortTimes.add(timer.timeItNanoTime(() -> MergeSortRecursive.doMergeSort(Arrays.copyOf(array, array.length))));
            }
            mergeSortIterativeAllTimes.add(insertSortTimes);
            mergeSortRecursiveAllTimes.add(heapSortTimes);
        }

        List<Long> mergeSortIterativeTimes = timer.findAverageRunningTimeLong(mergeSortIterativeAllTimes);
        List<Long> mergeSortRecursiveTimes = timer.findAverageRunningTimeLong(mergeSortRecursiveAllTimes);

        csvExporter.exportDataToCSV(mergeSortIterativeTimes, "mergeSortIterativeTimes.csv");
        csvExporter.exportDataToCSV(mergeSortRecursiveTimes, "mergeSortRecursiveTimes.csv");

         */
    }
}
