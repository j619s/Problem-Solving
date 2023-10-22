import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 comb = new CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = comb.combinationSum2(candidates, 8);
        System.out.println(res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combSum2(0, target, candidates, result, new ArrayList<>());
        return result;
    }


    public void combSum2(int index, int target, int[] candidates, List<List<Integer>> result, List<Integer> list){

        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }

            if(candidates[i] > target) break;

            list.add(candidates[i]);
            combSum2(i + 1, target - candidates[i], candidates, result, list);
            list.remove(list.size() - 1);
        }
    }
}
