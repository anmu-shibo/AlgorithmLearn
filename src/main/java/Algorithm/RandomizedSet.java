package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    ArrayList nums = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }
        int deleteIndex = map.get(val);
        int lastVal = (int) nums.get(nums.size() - 1);
        map.put(lastVal, deleteIndex);
        nums.set(deleteIndex, lastVal);
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return (int) nums.get(randomIndex);
    }
}
