package problem4;

public class HeapSort {


    public static<AnyType extends Comparable<? super AnyType>> void doHeapSort(AnyType[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            percolateDown(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            AnyType temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            percolateDown(array, i, 0);
        }
    }



    private static<AnyType extends Comparable<? super AnyType>>void percolateDown(AnyType[] array, int arrayLength, int parentIndex) {
        int largest = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        if (leftChild < arrayLength && array[leftChild].compareTo(array[largest]) > 0) {
            largest = leftChild;
        }
        if (rightChild < arrayLength && array[rightChild].compareTo(array[largest]) > 0) {
            largest = rightChild;
        }
        if (largest != parentIndex) {
            AnyType temp = array[parentIndex];
            array[parentIndex] = array[largest];
            array[largest] = temp;
            percolateDown(array, arrayLength, largest);
        }
    }

}
