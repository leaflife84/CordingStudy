package kakao.mobility;

public class test2 {
    public static void main(String[] args) {
            test2 t = new test2();
            int[] T = {0,0,1,2};
            int[] A = {1,2};
            System.out.println(t.solution(T,A));
    }
    private int[] visit;
    public int solution(int[] T, int[] A) {
        visit = new int[T.length];
        int total = 0;
        for(int i = 0; i < A.length; i++){
            int node = A[i];
            int result = 0;
            while(true){
                if(node == 0){
                    if(visit[node] == 0){
                        result++;
                        visit[node] = 1;
                        break;
                    }else{
                        break;
                    }
                }else{
                    if(visit[node] == 0) {
                        result++;
                        visit[node] = 1;
                        node = T[node];
                    }else{
                        break;
                    }

                }
            }
            total += result;
        }
        return total;
    }
}
