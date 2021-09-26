package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum1 {
    private List<List<Integer>> list = new ArrayList<>();
    private int[] numList;
    public static void main(String[] args) {
        combinationSum1 c = new combinationSum1();
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> res = c.combinationSum(candidates, target);
        System.out.println(res.stream().toList());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        numList = new int[candidates.length];
        numList = candidates;
        Arrays.sort(numList);
        dfs(new ArrayList<>(), target, 0, 0);
        return list;
    }

    public void dfs(ArrayList<Integer> select, int target, int sum, int index){
        if(sum == target){
            list.add((List<Integer>) select.clone());
            return;
        }else if(sum > target){
            return;
        }

        for (int i = index; i < numList.length; i++) {
            select.add(numList[i]);
            sum += numList[i];
            dfs(select, target, sum, i);
            select.remove(select.size()-1);
            sum -= numList[i];
        }

    }
}
