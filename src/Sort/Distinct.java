package Sort;

import java.util.HashSet;

/**
 *
 * 즉, N개의 정수로 구성된 배열 A가 주어진 경우 배열 A의 고유 값 수를 반환합니다.
 *
 * 예를 들어, 6개의 요소로 구성된 주어진 배열 A는 다음과 같습니다.
 *
 * A[0] = 2 A[1] = 1 A[2] = 1
 * A[3] = 2 A[4] = 3 A[5] = 1
 * 어레이 A에 표시되는 3개의 고유 값, 즉 1, 2, 3이 있기 때문에 함수는 3을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성합니다.
 *
 * N은 [0] 범위 내의 정수입니다.100,000];
 * 배열 A의 각 요소는 [-1,000,000,000-1,000,000] 범위의 정수입니다.
 *
 * */
public class Distinct {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
        }
        return set.size();
    }
}
