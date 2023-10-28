package problem7;

public class Main {

    public static void main(String[] args) {

        Integer [] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        ShellSort.doShellSort(array);

        for (Integer element : array) {
            System.out.println(element);
        }

    }
}
