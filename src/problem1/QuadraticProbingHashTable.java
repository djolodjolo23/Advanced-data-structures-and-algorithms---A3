package problem1;

import java.util.Arrays;

public class QuadraticProbingHashTable <AnyType> {


    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty() {
        currentSize = 0;
        Arrays.fill(array, null);
    }

    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            return;
        }
        array[currentPos] = new HashEntry<>(x, true);

        if (++currentSize > array.length / 2) {
            rehash();
        }
    }

    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
        }
    }

    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType e) {
            this(e, true);
        }
        public HashEntry(AnyType e, boolean i) {
            element = e; isActive = i;
        }
    }

    private HashEntry<AnyType>[] array;
    private int currentSize;

    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }
    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myHash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }
    private void rehash() {
        HashEntry<AnyType> [] oldArray = array;
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        for (HashEntry<AnyType> anyTypeHashEntry : oldArray) {
            if (anyTypeHashEntry != null && anyTypeHashEntry.isActive) {
                insert(anyTypeHashEntry.element);
            }
        }
    }

    private int myHash(AnyType x) {
        int hashcode = x.hashCode();
        int mod = hashcode % 2;
        return 0; // testing for collisions
    }

    private static int nextPrime(int n) {
        if (n <= 2) {
            return 2;
        }

        int nextPrime = n;
        boolean found = false;

        while (!found) {
            nextPrime++;
            if (isPrime(nextPrime)) {
                found = true;
            }
        }

        return nextPrime;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }
}
