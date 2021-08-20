package Sort;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {
        Hindex h = new Hindex();
        int[] citations = {12, 11, 10, 9, 8, 1};
        System.out.println(h.solution(citations));
    }
    //[0,1,3,5,6]
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            int h_index = citations.length-i; //최대값 5
            if(citations[i] >= h_index) {
                answer = h_index;
                break;
            }
        }

        return answer;
    }


}
