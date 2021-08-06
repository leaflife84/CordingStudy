package DFSandBFS;

public class 더하기빼기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int result = s.solution(numbers,target);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            //더하기
            answer += dfs(0, numbers, target, 1, 0);
            //빼기
            answer += dfs(0, numbers, target, -1, 0);
            return answer;
        }
        public int dfs(int i, int[] numbers, int target, int chk, int sum) {
            if(i == numbers.length) {
                return 0;
            }
            sum += numbers[i]*chk;
            if(sum == target && i == numbers.length-1) {
                return 1;
            }else {
                int result = 0;
                result += dfs(i+1, numbers, target, 1, sum);
                result += dfs(i+1, numbers, target, -1, sum);
                return result;
            }
        }
    }



}
