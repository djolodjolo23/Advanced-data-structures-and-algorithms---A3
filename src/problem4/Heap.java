package problem4;
public class Heap<AnyType extends Comparable<AnyType>> {


    public void doHeapSort(AnyType[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            AnyType temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }


    private void heapify(AnyType[] array, int n, int parentIndex) {
        int largest = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        if (leftChild < n && array[leftChild].compareTo(array[largest]) > 0) {
            largest = leftChild;
        }
        if (rightChild < n && array[rightChild].compareTo(array[largest]) > 0) {
            largest = rightChild;
        }
        if (largest != parentIndex) {
            AnyType temp = array[parentIndex];
            array[parentIndex] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }

}
