import java.util.*;

public class Demo {
    public static void main(String[] args) {
        // Create a HashMap<Integer, String>
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(3, "Three");
        hashMap.put(2, "Two");
        hashMap.put(4, "Four");

        // Convert HashMap entries to a List
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(hashMap.entrySet());
        System.out.println("EntryList: " + entryList);
        // Sort the List based on values
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> entry1, Map.Entry<Integer, String> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });

        // Create a new LinkedHashMap to store the sorted entries
        LinkedHashMap<Integer, String> sortedHashMap = new LinkedHashMap<>();

        // Populate the sorted LinkedHashMap
        for (Map.Entry<Integer, String> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted HashMap
        System.out.println("Original HashMap: " + hashMap);
        System.out.println("Sorted HashMap: " + sortedHashMap);
        System.out.println('z' - 'a');


        int k = 235;
        String str = String.valueOf(k);
        int start = -1;
        int temp = Integer.parseInt(String.valueOf(str.charAt(0)));
        while(k!= 0){
            start = k / 10;
        }

        System.out.println("start: " + start);
        System.out.println(temp);
    }
}
