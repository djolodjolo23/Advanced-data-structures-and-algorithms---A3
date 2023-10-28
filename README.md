The src package contains sub-packages for each problem. In each sub-package there is a main class with a main method inside, where the code can be compiled and executed.

Helpers package contains several helper classes for exporting the data, printing, timing and performing calculations.

- Problem 1
  -   The QuadraticProbingHashTable object is created inside the Main class, where it can be tested with different operations. Note that rehash() method is not implemented, so the table size is fixed.

- Problem 2
  -   Similarly to problem 1, the QuadraticProbingHashTable object can be tested in a Main class with different operations. Car class contains several attributes combined into a single string, which is then used as a key for the hash table. It is possible to manually insert the Car data, or create all the attributes randomly by simply creating a new Car() object.

- Problem 3
  - Main method contains an array that can be sorted by calling a static method doInsertSort() from the InsertSort class and passing the array as a parameter. 

- Problem 4

    - Main method contains an array that can be sorted by calling a static method doHeapSort() from the HeapSort class and passing the array as a parameter.
- Problem 5
    - Main method contains an array that can be sorted by calling a static method doQuickSort() from the QuickSort class and passing the array as a parameter.
- Problem 6
  -   Main method contains an array that can be sorted by calling a static method doMergeSort() from the MergeSortIterative or MergeSortRecursive class and passing the array as a parameter.

- Problem 7 can be ignored as I haven't had enough time for the analysis.


- Subpackages within the problem packages can be ignored as these were done for statistical analysis and are not used in the main classes.