package problem3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        Integer[] array = {2, 8, 5, 3, 9, 4};
        InsertSort.doInsertSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }
}
