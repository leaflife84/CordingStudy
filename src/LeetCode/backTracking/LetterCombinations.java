package LeetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    String alpha[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        List<String> list = l.letterCombinations("23");
        System.out.println(list.stream().toList());

    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(result, 0, digits);
        return result;

    }
    public void dfs(List<String> result, int index, String digits){

    }
}
