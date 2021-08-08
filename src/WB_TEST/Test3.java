package WB_TEST;


//11011, 10100
public class Test3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        int[] A = {3,2,-2,5,-3};
        System.out.println(t.solution(A));


    }
    //3,2,-2,5,-3
    public int solution(int[] A) {
        int max = 0;
        int min = 0;
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] > 0) {
                max += A[i]; //합계에서 나올 수 있는 가장 큰 수
                min = Math.max(min, A[i]); //합계에서 나올 수 있는 가장 작은 수
            }
        }
        int mid = (min + max) / 2;
        while(min <= max){
            if(solve(mid,A)){
                result = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }
        return result;
    }

    public boolean solve(int value, int[] A){
        int check = 0;
        for(int i = 0; i < A.length; i++){ //3,2,-2,5,-3
            if(A[i] == value){
                check++;
            }
            if(A[i] == value*-1){
                check++;
            }
            if(check == 2){
                return true;
            }
        }
        return false;
    }
}


