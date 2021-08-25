package LeetCode.string;

public class SquareNumbers {
    public static void main(String[] args) {
        SquareNumbers s = new SquareNumbers();
        System.out.println(s.judgeSquareSum(999999999));
    }
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left<=right){
            int cur = left * left + right * right;
            if(cur < left){
                left++;
            }else if(cur > right){
                right--;
            }else{
                return true;
            }
        }
        return false;
    }
}
