package problem3;

public class SortStuff<AnyType extends Comparable<AnyType>> {


    public void insertSort(AnyType[] array){
        for (int i = 0; i < array.length - 1; i++) {
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
