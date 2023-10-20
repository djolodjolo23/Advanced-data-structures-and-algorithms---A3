package problem5;

import problem3.InsertSort;

public class QuickSort {

    public static <AnyType extends Comparable<? super AnyType>> void doQuickSort(AnyType[] a, int depth) { // int depth
        quicksort(a, 0, a.length - 1, depth);
    }

    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int low, int high, int depth) { // int depth
        if (low < high && depth > 0) { // depth>0
            int pivotIndex = getPivotIndex(a, low, high);
            AnyType pivot = a[pivotIndex];
            swapReferences(a, pivotIndex, high);
            int sliceIndex = slice(a, low, high, pivot);
            quicksort(a, low, sliceIndex - 1, --depth); // --depth
            quicksort(a, sliceIndex + 1, high, --depth); // -depth
        } else {
            InsertSort.doInsertSort(a, low, high);
        }
    }


    private static <AnyType extends Comparable<? super AnyType>> int getPivotIndex(AnyType[] a, int low, int high) {
        int middle = (low + high) / 2;
        AnyType lowVal = a[low];
        AnyType highVal = a[high];
        AnyType middleVal = a[middle];
        if ((lowVal.compareTo(middleVal) <= 0 && middleVal.compareTo(highVal) <= 0) ||
                (highVal.compareTo(middleVal) <= 0 && middleVal.compareTo(lowVal) <= 0)) {
            return middle;
        } else if ((lowVal.compareTo(highVal) <= 0 && highVal.compareTo(middleVal) <= 0) ||
                (middleVal.compareTo(highVal) <= 0 && highVal.compareTo(lowVal) <= 0)) {
            return high;
        } else {
            return low;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> int slice(AnyType[] a, int low, int high, AnyType pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                if (i != j) {
                    swapReferences(a, i, j);
                }
                i++;
            }
        }
        swapReferences(a, i, high);
        return i;
    }

    private static <AnyType> void swapReferences(AnyType[] a, int i, int j) {
        AnyType temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
