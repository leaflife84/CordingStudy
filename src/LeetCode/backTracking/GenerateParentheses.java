package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private int N;
    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> list = g.generateParenthesis(3);
        System.out.println(list.stream().toList());
    }

    public List<String> generateParenthesis(int n) {
        N = n;
        ArrayList<String> result = new ArrayList<>();
        dfs(result, "",0,0);
        return result;
    }

    public void dfs(ArrayList<String> result, String select, int left, int right){
        if(left == N && right == N){
            result.add(select);
            return;
        }
        if(left > N || right > N){
            return;
        }
        if(left < right){
            return;
        }
        dfs(result, select + "(", left+1, right);
        dfs(result, select + ")", left, right+1);
    }
}
