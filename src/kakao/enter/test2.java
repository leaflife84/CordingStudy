package kakao.enter;

public class test2 {
    public static void main(String[] args) {
        test2 t = new test2();
        System.out.println(t.solution(-4));
    }
    static long[] memo;
    public String solution(int n) {
        memo = new long[1000];
        if(n < 0){
            n = Math.abs(n);
            return String.valueOf(fiboM(0,n));
        }else{
            return String.valueOf(fibo(n));
        }

    }

    public static long fiboM(int n, int max) {
        if (n >= max)
            return n;
        else if (memo[n] != 0)
            return memo[n];
        else {
            return memo[n] = fiboM(n + 1, max) + fiboM(n + 2, max);
        }

    }

    public static long fibo(int n) {
        if (n <= 1)
            return n;
        else if (memo[n] != 0)
            return memo[n];
        else{
            return memo[n] = fibo(n - 1) + fibo(n - 2);
        }
    }
}
