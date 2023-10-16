package problem4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] array = {10, 20, 15, 12, 40, 25, 18};

        Heap<Integer> heap = new Heap<>();

        heap.doHeapSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
