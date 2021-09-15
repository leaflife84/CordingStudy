package kakao.mobility;

public class test3 {
    public static void main(String[] args) {
        int[] A = {3,-7,3,-7,3,-8,3};
        test3 t = new test3();
        System.out.println(t.solution(A));
    }

    public int solution(int[] A) {
        int evenCheck = 0;
        int oddCheck = 0;
        int maxCount = 0;
        int evenCount = 0;
        int oddCount = 0;
        int totalCount = 0;
        boolean isEvenEnd = false;
        boolean isOddEnd = false;
        for(int i = 0; i < A.length; i+=2){
            int even = A[i];
            if(i > 0 && evenCheck != even){
                totalCount += evenCount;
                evenCheck = even;
                evenCount = 1;
                isEvenEnd = true;
            }else{
                evenCheck = even;
                evenCount++;
            }
            if(i+1 < A.length) {
                int odd =A[i+1];
                if ( i > 1 && oddCheck != odd) {
                    totalCount += oddCount;
                    oddCheck = odd;
                    oddCount = 1;
                    isOddEnd = true;
                } else {
                    oddCheck = odd;
                    oddCount++;
                }
            }else{
                isOddEnd = true;
            }
            if(isEvenEnd || isOddEnd){
                if(!isEvenEnd){
                    totalCount += evenCount;
                }
                if(!isOddEnd){
                    totalCount += oddCount;
                }
                maxCount = Math.max(maxCount,totalCount);
                totalCount = 0;
                isEvenEnd = false;
                isOddEnd = false;
            }
        }
        return Math.max(maxCount,oddCount+evenCount);
    }
}
