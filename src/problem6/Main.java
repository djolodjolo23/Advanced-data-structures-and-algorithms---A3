package problem6;

public class Main {

    public static void main(String[] args) {

        Integer[] array = {5, 20, 3, 6, 11, 23, 19, 18};
        System.out.println("Before sorting: ");
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        MergeSortIterative.doMergeSort(array);
        System.out.println("After sorting: ");
        for (Integer i : array) {
            System.out.print(i + " ");
        }

        Integer[] array2 = {5, 20, 3, 6, 11, 23, 19, 18};

        System.out.println();
        System.out.println("Before sorting: ");
        for (Integer i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
        MergeSortRecursive.doMergeSort(array2);
        System.out.println("After sorting: ");
        for (Integer i : array2) {
            System.out.print(i + " ");
        }
    }
}
