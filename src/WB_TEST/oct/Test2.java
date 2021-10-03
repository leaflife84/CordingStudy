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
        for (int i = 2; i < answer.length; i++) {
            int insertData = i+1; //3
            cal *= 2;
            cal = cal%(answer.length-count);
            for (int j = 0; j < list.size(); j++) {
                if(j != list.size()-1 && index > list.get(j)) continue;
                else {
                    int t = 0;
                    if(cal >= list.size()) {
                        t = list.size() - j;
                        if(index > list.get(j)){
                            t = 1;
                        }
                        index = list.get((cal - t)%list.size());
                        list.remove((cal - t)%list.size());
                        break;
                    }else{
                        index = list.get((j+cal)%list.size());
                        list.remove((j+cal)%list.size());
                        break;
                    }
                }
            }
            answer[index] = insertData;
        }

        return answer;
    }
}
