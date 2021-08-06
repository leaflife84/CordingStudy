package Binary;
/**
 * 정수 K, M과 N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 배열의 모든 요소가 M보다 크지는 않습니다.
 * 이 배열을 연속 원소의 K 블럭으로 분할해야 합니다. 블록 크기는 0에서 N 사이의 정수입니다. 배열의 모든 요소는 특정 블록에 속해야 합니다.
 * X에서 Y까지의 블록 합은 A[X] + A[X +1] + ...입니다. + A[Y]. 빈 블록의 합은 0입니다.
 * 큰 금액은 모든 블록의 최대 합계입니다.
 * 예를 들어, 다음과 같이 정수 K = 3, M = 5 및 배열 A가 주어집니다.
 *
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 * 예를 들어 배열을 다음과 같은 블록으로 나눌 수 있습니다.
 *
 * [2, 1, 5, 1, 2, 2, 2,2], [], 15의 큰 합계;
 * [2], [1, 5, 1,2], [2,2]의 큰 합계 9;
 * [2, 1, 5], [], [1, 2,2]의 큰 합이 8인 경우,
 * [2,1], [5,1], [2, 2,2]의 큰 합이 6입니다.
 * 목표는 큰 금액을 최소화하는 것입니다. 위의 예에서 6은 최소의 큰 금액입니다.
 *
 * 함수 쓰기:
 *
 * 클래스 솔루션 { public int 솔루션(int K, int M, int [] A); }
 * 정수 K, M 및 N개의 정수로 구성된 비어 있지 않은 배열 A가 주어진 경우 최소 대합이 반환됩니다.
 * 예를 들어, K = 3, M = 5 및 배열 A가 주어지면 다음과 같습니다.
 *
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 * 위에서 설명한 대로 함수는 6을 반환해야 합니다.
 *
 *  - 이진탐색문제로 예상되는 값을 중간값으로 하여 줄여나가는 형태로 찾아가는 문제 최소값, 최대값을 정해서 mid 값을 줄여나가는 방법
 * */
public class MinMaxDivision {

    public static void main(String[] args){
        MinMaxDivision mx = new MinMaxDivision();
        int A[] = {2, 1, 5, 1, 2, 2, 2};
        System.out.println(mx.solution(3,5,A));
    }

    public int solution(int K, int M, int[] A) {
        int max = 0;
        int min = 0;
        int result = 0;
        for(int i = 0; i < A.length; i++){
            max+=A[i]; //합계에서 나올 수 있는 가장 큰 수
            min = Math.max(min,A[i]); //합계에서 나올 수 있는 가장 작은 수
        }
        int mid = (min + max) / 2;
        while(min <= max){
            if(solve(mid,K,A)){
                result = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }
        return result;
    }

    public boolean solve(int value, int K, int[] A){
        int sum = 0;
        for(int i = 0; i < A.length; i++){ //2 1 5 1 2 2 2 : 7
            if(sum + A[i] > value){
                K--;
                sum = A[i];
                if(K <= 0){
                    return false;
                }
            }else{
                sum += A[i];
            }
        }
        if(K >= 0){
            return true;
        }else{
            return false;
        }
    }

}
