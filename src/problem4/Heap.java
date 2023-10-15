package problem4;

import java.util.ArrayList;
import java.util.List;

public class Heap<AnyType extends Comparable<AnyType>> {

    private static class HeapNode<AnyType> {

        private AnyType element;
        private HeapNode<AnyType> leftChild;
        private HeapNode<AnyType> rightChild;

        HeapNode(AnyType element) {
            this(element, null, null);
        }

        HeapNode(AnyType theElement, HeapNode<AnyType> left, HeapNode<AnyType> right) {
            element = theElement; leftChild = left; rightChild = right;
        }
    }

    private HeapNode<AnyType> root;

    private int theSize;

    public void doHeapSort(AnyType[] array) {
        heapifyTest(array);
    }

    private void heapify(AnyType[] array) {
        HeapNode<AnyType> parent = new HeapNode<>(array[0]);
        List<HeapNode<AnyType>> nodes = new ArrayList<>();
        nodes.add(parent);
        root = parent;
        if (array.length > 1) {
            for (int i = 1; i <= array.length; i++) {
                HeapNode<AnyType> current = nodes.get(i - 1);
                if (i * 2 <= array.length) {
                    current.leftChild = new HeapNode<>(array[(i * 2) - 1]);
                    nodes.add(current.leftChild);
                    if (i * 2 + 1 <= array.length) {
                        current.rightChild = new HeapNode<>(array[i * 2]);
                        nodes.add(current.rightChild);
                    }
                }
            }
        }
    }

    private void heapifyTest(AnyType[] array) {
        if (array == null || array.length <= 1) {
            return; // No need to heapify if there are 0 or 1 elements.
        }

        int n = array.length;

        // Start from the last non-leaf node (parent of the last element) and move up the array.
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(array, n, i);
        }

        // Now, the array is a max-heap.
    }

    private void heapifyDown(AnyType[] array, int n, int parentIndex) {
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
            // Swap the parent with the largest child.
            AnyType temp = array[parentIndex];
            array[parentIndex] = array[largest];
            array[largest] = temp;

            // Recursively heapify the affected subtree.
            heapifyDown(array, n, largest);
        }
    }

}
