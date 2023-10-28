package problem3;

public class InsertSort {

    /**
     * Insert sort algorithm that uses the supposed inner insertion sort algorithm directly, since I wanted to use it in QuickSort.
     * Therefore, I removed the outer algorithm and just used the inner one.
     * @param array the array to be sorted.
     * @param low the lower bound of the array.
     * @param high the upper bound of the array.
     * @param <AnyType> the type of the array.
     */
    public static<AnyType extends Comparable<? super AnyType>> void doInsertSort(AnyType[] array, int low, int high){
        for (int i = low; i < high; i++) {
            for (int j = i + 1; j > 0; j--) {
                int result = array[j].compareTo(array[j-1]);
                if (result < 0) {
                    AnyType temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
}
