package problem1;

import java.util.Arrays;

public class QuadraticProbingHashTable <AnyType> {

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }


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
        currentSize++;
    }

    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
        }
    }

    protected static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType e) {
            this(e, true);
        }
        public HashEntry(AnyType e, boolean i) {
            element = e; isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 19;

    protected HashEntry<AnyType>[] array;
    protected int currentSize;

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


    private int myHash(AnyType x) {
        int hashcode = x.hashCode();
        int hashValue = hashcode % array.length;
        if (hashValue < 0) {
            hashValue += array.length;
        }
        return hashValue;
    }


    private int nextPrime(int n) {
        boolean isPrime = false;
        int nextPrime = n;
        while (!isPrime) {
            isPrime = true;
            nextPrime++;
            for (int i = 2; i <= n/2; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return nextPrime;
    }

}
