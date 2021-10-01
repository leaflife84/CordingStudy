package LeetCode.dp;

import java.util.HashSet;

public class LongestRepeatingCharacters {
    public static void main(String[] args) {
        LongestRepeatingCharacters l = new LongestRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("dvcvfb"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while(i < s.length()){
            if(set.contains(s.charAt(i))){
                max = Math.max(max,set.size());
                set.remove(s.charAt(j));
                j++;
            }else{
                set.add(s.charAt(i));
                i++;
            }
            max = Math.max(max,set.size());
        }
        return max;
    }
}
