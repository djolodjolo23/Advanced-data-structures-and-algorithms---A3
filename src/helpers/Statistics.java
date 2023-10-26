package helpers;

import problem1.QuadraticProbingHashTable;
import problem2.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics<AnyType> {


    public Map<Integer, Integer> getOccurrences(List<List<QuadraticProbingHashTable.Stats<Car>>> listOfLists) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<QuadraticProbingHashTable.Stats<Car>> list : listOfLists) {
            for (QuadraticProbingHashTable.Stats<Car> element : list) {
                int key = element.getFirstPos();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }

    public Map<Integer, Integer> getOccurrencesString(List<List<QuadraticProbingHashTable.Stats<AnyType>>> listOfLists) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<QuadraticProbingHashTable.Stats<AnyType>> list : listOfLists) {
            for (QuadraticProbingHashTable.Stats<AnyType> element : list) {
                int key = element.getFirstPos();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }


    public int getRecommendedDepth(AnyType[] array) {
        int depth = 0;
        int n = array.length;
        while (n / 2 > 20) {
            depth++;
            n = n / 2;
        }
        return ++depth;
    }

    public double findAverageDouble(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        return (double) sum / list.size();
    }




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
