package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionaryGFG {
    /*
    * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

Examples :

Input:  n = 5, k = 4, dict = {"baa","abcd","abca","cab","cad"}
Output: 1
Explanation: Here order of characters is 'b', 'd', 'a', 'c' Note that words are sorted and in the given language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input: n = 3, k = 3, dict = {"caa","aaa","aab"}
Output: 1
Explanation: Here order of characters is 'c', 'a', 'b' Note that words are sorted and in the given language "caa" comes before "aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.

    * */

    public static void main(String[] args) {

    }

    public String findOrder(String[] dict, int n, int k){

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < dict.length - 1; i++){
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.max(word1.length(), word2.length());

            for(int j = 0; j < len; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(i) - 'a').add(word2.charAt(i) - 'a');
                    break;
                }
            }
        }

        List<Integer> topSort = topologicalSort(adj, k);
        StringBuilder res = new StringBuilder();
        for(int x : topSort){
            res.append((char)(x + (int)'a'));
        }

        return res.toString();
    }

    public static List<Integer> topologicalSort(List<List<Integer>> adj, int k){

        int[] indegree = new int[k];

        for(int i = 0; i < k; i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < k; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topologicalOrder = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            topologicalOrder.add(u);
            count++;
            for(int v : adj.get(u)){
                if(--indegree[v] == 0){
                    q.add(v);
                }
            }
        }

        if(count == k) return topologicalOrder;

        return new ArrayList<>();
    }


}
