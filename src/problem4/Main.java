package problem4;

public class Main {
    public static void main(String[] args) {

        Integer[] array = {10, 20, 15, 12, 40, 25, 18};

        Heap<Integer> heap = new Heap<>();

        heap.doHeapSort(array);

    }
}
