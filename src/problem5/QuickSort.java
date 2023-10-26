package problem5;

import problem3.InsertSort;

public class QuickSort {

    public static <AnyType extends Comparable<? super AnyType>> void doQuickSort(AnyType[] a, int depth) {
        quicksort(a, 0, a.length - 1, depth);
    }

    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right, int depth) {
        if (left < right && depth > 0) {
            int pivotIndex = getPivotIndex(a, left, right);
            AnyType pivot = a[pivotIndex];
            swapReferences(a, pivotIndex, right);
            int sliceIndex = slice(a, left, right, pivot);
            quicksort(a, left, sliceIndex - 1, --depth);
            quicksort(a, sliceIndex + 1, right, --depth);
        } else if (depth <= 0) {
            InsertSort.doInsertSort(a, left, right);
        }
    }


    private static <AnyType extends Comparable<? super AnyType>> int getPivotIndex(AnyType[] a, int left, int right) {
        int middle = (left + right) / 2;
        AnyType leftVal = a[left];
        AnyType rightVal = a[right];
        AnyType middleVal = a[middle];
        if ((leftVal.compareTo(middleVal) <= 0 && middleVal.compareTo(rightVal) <= 0) ||
                (rightVal.compareTo(middleVal) <= 0 && middleVal.compareTo(leftVal) <= 0)) {
            return middle;
        } else if ((leftVal.compareTo(rightVal) <= 0 && rightVal.compareTo(middleVal) <= 0) ||
                (middleVal.compareTo(rightVal) <= 0 && rightVal.compareTo(leftVal) <= 0)) {
            return right;
        } else {
            return left;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> int slice(AnyType[] a, int left, int right, AnyType pivot) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                if (i != j) {
                    swapReferences(a, i, j);
                }
                i++;
            }
        }
        swapReferences(a, i, right);
        return i;
    }

    private static <AnyType> void swapReferences(AnyType[] a, int i, int j) {
        AnyType temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
