package Helpers;

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


}
