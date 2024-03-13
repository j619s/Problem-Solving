package LeetcodeDailyJanuary2024;

import java.util.*;

//    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
//    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
//    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
//
//You must implement the functions of the class such that each function works in average O(1) time complexity.
//
public class InsertDeleteGetRandomO1 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public InsertDeleteGetRandomO1(){
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int pos = map.get(val);
            int lastElement = list.get(list.size() - 1);

            list.set(pos, lastElement);
            map.put(lastElement, pos);

            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }
        return false;
    }

    public int getRandom() {
        int randIndex = random.nextInt(list.size());
        return list.get(randIndex);
    }


}
