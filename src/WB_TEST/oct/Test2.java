package WB_TEST.oct;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.solution(3);
    }

    public int[] solution(int n){
        int[] answer = new int[n*(3*(n-1))+1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            list.add(i);
        }
        int count = 2;
        answer[0] = 1;
        answer[2] = 2;
        int index = 2;
        list.remove(0);
        list.remove(1);
        int cal = 1;
        int currentIndex = 1;
        for (int i = 2; i < answer.length; i++) {
            int insertData = i+1; //3
            cal *= 2;
            cal = cal%(answer.length-1);
            int listIndex = (currentIndex+cal)%list.size();
            index = list.get(listIndex);
            currentIndex = (currentIndex+cal)%list.size();
            list.remove(listIndex);
            answer[index] = insertData;
        }
        //1,6,2,7,5,3,4 // 1,12,2,11..
        return answer;
    }
}
