package problem5;

import helpers.CSVExporter;
import helpers.Statistics;
import helpers.Timer;
import problem3.InsertSort;
import problem4.HeapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // generate array of 100 random numbers from 1 to 1000
        Random random = new Random();

        Statistics<Integer> statistics = new Statistics<>();


        Integer [] array = new Integer[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        int recommendedDepth = statistics.getRecommendedDepth(array);

        QuickSort.doQuickSort(array, recommendedDepth);



        /**
        Timer timer = new Timer();
        CSVExporter<Long> csvExporter = new CSVExporter<>();

        List<List<Long>> insertSortAllTimes = new ArrayList<>();
        List<List<Long>> heapSortAllTimes = new ArrayList<>();
        List<List<Long>> quickSortAllTimes = new ArrayList<>();



        for (int k = 0; k < 10; k++) {
            List<Long> insertSortTimes= new ArrayList<>();
            List<Long> heapSortTimes = new ArrayList<>();
            List<Long> quickSortTimes = new ArrayList<>();
            for (int i = 0; i <= 5000; i += 5) {
                Integer[] array = new Integer[i];
                for (int j = 0; j < array.length; j++) {
                    array[j] = random.nextInt(500000);
                } // first run is on empty array to warm up the JVM, ignore this run in the csv stats
                final Integer[] arrayCopy = Arrays.copyOf(array, array.length);
                insertSortTimes.add(timer.timeItNanoTime(() -> InsertSort.doInsertSort(arrayCopy, 0, arrayCopy.length - 1)));
                heapSortTimes.add(timer.timeItNanoTime(() -> HeapSort.doHeapSort(Arrays.copyOf(array, array.length))));
                quickSortTimes.add(timer.timeItNanoTime(() -> QuickSort.doQuickSort(Arrays.copyOf(array, array.length))));
            }
            insertSortAllTimes.add(insertSortTimes);
            heapSortAllTimes.add(heapSortTimes);
            quickSortAllTimes.add(quickSortTimes);
        }

        List<Long> averageInsertSortTimes = timer.findAverageRunningTimeLong(insertSortAllTimes);
        List<Long> averageHeapSortTimes = timer.findAverageRunningTimeLong(heapSortAllTimes);
        List<Long> averageQuickSortTimes = timer.findAverageRunningTimeLong(quickSortAllTimes);

        csvExporter.exportDataToCSV(averageInsertSortTimes, "insertSortTimes.csv");
        csvExporter.exportDataToCSV(averageHeapSortTimes, "heapSortTimes.csv");
        csvExporter.exportDataToCSV(averageQuickSortTimes, "quickSortTimes.csv");

         */
    }
}
