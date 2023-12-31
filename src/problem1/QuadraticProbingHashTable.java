package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * QuadraticProbingHashTable class implements a hash table with quadratic probing to resolve collisions.
 * Note that a big portion of the code is taken from the book examples.
 * @param <AnyType> generic type of the hash table.
 */
public class QuadraticProbingHashTable <AnyType> {

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }


    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
        stats = new ArrayList<>();
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

    /**
     * The inner class Stats is used to store the statistics of the hash table.
     * @param <AnyType> generic type of the hash table.
     */
    public static class Stats<AnyType> {
        private AnyType element;

        private int firstPos;

        private int finalPos;
        private int probeCount;

        private Stats(AnyType e, int flp, int p) {
            element = e;
            firstPos = flp;
            probeCount = p;
        }

        private void incrementProbe() {
            probeCount++;
        }

        private void setFinalPos(int finalPos) {
            this.finalPos = finalPos;
        }

        public int getFirstPos() {
            return firstPos;
        }

        public int getProbeCount() {
            return probeCount;
        }

    }

    private static final int DEFAULT_TABLE_SIZE = 23;

    protected HashEntry<AnyType>[] array;

    public List<Stats<AnyType>> stats;

    public int firstCollisionOccurrenceAt;
    protected int currentSize;

    private boolean collisionOccurred = false;

    public int getFirstCollisionOccurrenceAt() {
        return firstCollisionOccurrenceAt;
    }

    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }


    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myHash(x);
        Stats<AnyType> current = new Stats<>(x, currentPos, 0);
        stats.add(current);
        while (true) {
            try {
                while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
                    if (!collisionOccurred) {
                        int counter = 0;
                        for (HashEntry<AnyType> entry : array) {
                            if (entry != null) {
                                counter++;
                            }
                        }
                        firstCollisionOccurrenceAt = counter;
                        collisionOccurred = true;
                    }
                    currentPos += offset;
                    offset += 2;
                    current.incrementProbe();
                    if (currentPos >= array.length) {
                        currentPos -= array.length;
                    }
                }
                current.setFinalPos(currentPos);
                return currentPos;
            } catch (ArrayIndexOutOfBoundsException e) {
                            // sometimes, but very rarely (1 in 500 runs on average), the program crashes with ArrayIndexOutOfBoundsException, when offset is too big
                offset = 2; // reseting offset to 2 to avoid that, since I did not want to use rehash() method
                            // to increase the size of the array. It's more clear for analysis without rehash.
                currentPos = myHash(x);
            }
        }
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

    public List<Stats<AnyType>> getStats() {
        return stats;
    }


}
