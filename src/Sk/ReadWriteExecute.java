package Sk;

import java.util.HashMap;

public class ReadWriteExecute {
    public static int symbolicToOctal(String permString) {
        if(permString.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('r',4);
        map.put('w',2);
        map.put('x',1);
        map.put('-',0);
        StringBuilder str = new StringBuilder();
        int result = 0;
        for(int i = 0; i < permString.length(); i++){
            result += map.get(permString.charAt(i));
            if((i+1)%3 == 0){
                str.append(result);
                result = 0;
            }
        }
        return Integer.parseInt(str.toString());

    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(ReadWriteExecute.symbolicToOctal(""));
    }
}
