package problem6;

import java.util.Arrays;

public class MergeSortIterative{

    public static <AnyType extends Comparable<? super AnyType>> void doMergeSort(AnyType[] array) {
        int length = array.length;
        AnyType[] temp = Arrays.copyOf(array, length);
        Arrays.fill(temp, null);
        for (int i = 1; i < length; i *= 2) {
            for (int j = 0; j < length - i; j += 2 * i) {
                int low = j;
                int mid = j + i;
                int high = Math.min(j + 2 * i - 1, length - 1);
                merge(array, temp, low, mid, high);
            }
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] array, AnyType[] temp, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int k = low;
        while (i < mid && j <= high) {
            if (array[i].compareTo(array[j]) <= 0) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        if (high + 1 - low >= 0) System.arraycopy(temp, low, array, low, high + 1 - low);
    }

}
