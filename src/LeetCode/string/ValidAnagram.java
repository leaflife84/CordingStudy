package LeetCode.string;

import java.util.HashMap;
import java.util.Set;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        String s = "abc";
        String t = "cba";
        System.out.println(v.isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        if(map1.size() != map2.size()){
            return false;
        }
        for(Character c : map1.keySet()){
            if(map2.get(c) == null){
                return false;
            }else{
                if(!map1.get(c).equals(map2.get(c))){
                    return false;
                }
            }
        }
        return true;
    }
}
