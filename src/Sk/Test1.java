package Sk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Test1 {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int number : numbers){
            map.put(number,map.getOrDefault(number,0)+1);
        }
        for(Integer i : map.keySet()){
            if(map.get(i) == 1){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}
