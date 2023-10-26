package problem6;

import java.util.Arrays;

public class MergeSortIterative{

    public static <AnyType extends Comparable<? super AnyType>> void doMergeSort(AnyType[] array) {
        int length = array.length;
        AnyType[] temp = Arrays.copyOf(array, length);
        Arrays.fill(temp, null);
        for (int i = 1; i < length; i *= 2) { // sequence 1, 2, 4, 8, should double each time.
            for (int j = 0; j < length - i; j += 2 * i) { // sequence 0 2 4 8, then 0 4, then 0 8... += 2 * i (1*2, 2*2, 4*2)
                int left = j;
                int mid = j + i;
                int right = Math.min(j + 2 * i - 1, length - 1);
                merge(array, temp, left, mid, right);
            }
        }
    }

    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] array, AnyType[] temp, int left, int mid, int right) {
        int i = left; // first half start
        int j = mid; // sec half start
        int k = left; // temp pointer, starts at left
        while (i < mid && j <= right) {
            if (array[i].compareTo(array[j]) <= 0) {
                temp[k++] = array[i++];
            } else {
                 temp[k++] = array[j++];
            }
        }
        while (i < mid) { // copy remaining left
            temp[k++] = array[i++];
        }
        while (j <= right) { // copy remaining right
            temp[k++] = array[j++];
        }
        if (right + 1 - left >= 0) { // temp = array
            System.arraycopy(temp, left, array, left, right + 1 - left);
        }
    }

}
