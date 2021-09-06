package Naver;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        int[] A = {1,2,3,4,5};
        int K = 4;
        System.out.println(t.solution(A,K));
    }
    public int solution(int[] A, int K) {
        Arrays.sort(A);
        int result = Integer.MAX_VALUE;
        if (K >= A.length - 1){ //삭제될 수보다 전체가 작거나 같은경우 0
            return 0;
        }
        result = Math.min(result, A[A.length-1-K]-A[0]); //왼쪽 삭제
        result = Math.min(result, A[A.length-1]-A[K]); //오른쪽 삭제
        return result;
    }
}
