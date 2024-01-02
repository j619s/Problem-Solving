package recursion;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(powerSet(s));

    }

    static ArrayList<String> powerSet(String s){
        ArrayList<String> res = new ArrayList<>();
        findPowerSet(s, res, "", 0);
        return res;
    }

    static void findPowerSet(String s, ArrayList<String> result, String output, int index){
        if(index == s.length()){
            result.add(output);
            return;
        }

        findPowerSet(s, result, output + s.charAt(index), index + 1);
        findPowerSet(s, result, output, index + 1);
    }

}
