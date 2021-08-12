package Programmers.level3;

import java.util.Arrays;
import java.util.Scanner;

public class SkillCheck1 {
    public static void main(String[] args) {
        SkillCheck1 s = new SkillCheck1();
        System.out.println(s.solution(2,9));
        System.out.println(s.solution(2,1));
        System.out.println(s.solution(2,7));
    }

    public int[] solution(int n, int s) {
        int result = s/n;
        int div = s%n;
        int[] answer = new int[n];
        if(result == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        for(int i = 0; i < n; i++){
            if(div != 0){
                answer[i] = result+1;
                div--;
            }else{
                answer[i] = result;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
