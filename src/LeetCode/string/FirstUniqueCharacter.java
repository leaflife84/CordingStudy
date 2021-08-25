package LeetCode.string;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        FirstUniqueCharacter f = new FirstUniqueCharacter();
        String s = "aabb";
        System.out.println(f.firstUniqChar(s));
    }
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//            if(map.get(s.charAt(i)) == null){
//                map.put(s.charAt(i),1);
//            }else{
//                map.put(s.charAt(i),map.get(s.charAt(i))+1);
//            }
        }

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}
