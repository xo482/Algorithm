import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[n * 2 + 1];
        dp[0] = 1;
        dp[1] = 2;
        if (tops[0] == 1) dp[1] += 1;

        for (int i = 2; i < n * 2 + 1; i++) {

            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            if (i % 2 == 0) continue;

            int idx = i / 2;
            if (tops[idx] == 1) {
                dp[i] = (dp[i] + dp[i - 1]) % 10007;
            }
        }


        return dp[n*2];
    }
}