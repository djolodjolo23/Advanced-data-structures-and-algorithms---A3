package helpers;

import problem1.QuadraticProbingHashTable;
import problem2.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics<AnyType> {


    /**
     * Returns the average number of probes for a given hash table.
     * @param listOfLists is the list of hash table occurrences.
     * @return the average number of probes for a given hash table.
     */
    public Map<Integer, Integer> getOccurrences(List<List<QuadraticProbingHashTable.Stats<AnyType>>> listOfLists) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<QuadraticProbingHashTable.Stats<AnyType>> list : listOfLists) {
            for (QuadraticProbingHashTable.Stats<AnyType> element : list) {
                int key = element.getFirstPos();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }

    /**
     * Recommended depth for quick sort algorithm, based on the size of the array.
     * @param array is the array to be sorted.
     * @return the recommended depth based on the array length.
     */
    public int getRecommendedDepth(AnyType[] array) {
        int depth = 0;
        int n = array.length;
        while (n / 2 > 20) {
            depth++;
            n = n / 2;
        }
        return ++depth;
    }

    /**
     * Generates a random string of length 10.
     * @return a random string of length 10.
     */
    public String generateRandomString() {
        String characters = "abcdefghijklmnopqrstuvwxyz.?|#!%$@^#*()/1234567890";
        StringBuilder sb = new StringBuilder();
        int length = 10;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


}
