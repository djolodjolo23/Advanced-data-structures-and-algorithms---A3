package problem3;

public class InsertSort {

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
