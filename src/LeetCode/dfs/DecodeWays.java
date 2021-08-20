package LeetCode.dfs;

import java.util.*;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "0";
        int result = d.numDecodings(s);
        System.out.println(result);

    }

    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public int numDecodings(String s) {
        return dfs(0,s);
    }

    public int dfs(int i, String s){
        int count = 0;
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.length() == 1){
            if(isValid(s,1)){
                return 1;
            }else{
                return 0;
            }
        }else if(s.length() == 0){
            return 1;
        }


        if(isValid(s,1)){
            String oneCode = s.substring(1);
            count += dfs(1, oneCode);
        }

        if(isValid(s,2)){
            String twoCode = s.substring(2);
            count += dfs(1,twoCode);
        }

        map.put(s,count);

        return count;
    }

    public boolean isValid(String s, int i){
        if(i > s.length()){
            return false;
        }
        s = s.substring(0,i);
        if(s.isEmpty()){
            return true;
        }
        if(s.charAt(0) == '0'){
            return false;
        }else return Integer.parseInt(s) <= 26;

    }
}
