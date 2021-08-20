package LeetCode.dp;

import java.util.ArrayList;
import java.util.HashMap;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "11106";
        int result = d.numDecodings(s);
        System.out.println(result);

    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            int curOnesNum = s.charAt(i) - '0';
            int curTensNum = (s.charAt(i - 1) - '0') * 10 + curOnesNum;

            if (curOnesNum != 0) {
                dp[i] += dp[i - 1];
            }

            if (curTensNum >= 10 && curTensNum <= 26) {
                dp[i] += (i >= 2) ? dp[i - 2] : 1;
            }
        }

        return dp[s.length() - 1];
    }

}
