package problem4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] array = {20, 30, 10, 5, 11};

        HeapSort.doHeapSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
