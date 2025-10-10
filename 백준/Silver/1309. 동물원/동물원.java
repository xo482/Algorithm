import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, MOD = 9901;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][2][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][1][0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0][0] += dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][1][0];
            dp[i][0][1] += dp[i - 1][0][0] + dp[i - 1][1][0];
            dp[i][1][0] += dp[i - 1][0][0] + dp[i - 1][0][1];

            dp[i][0][0] %= MOD;
            dp[i][0][1] %= MOD;
            dp[i][1][0] %= MOD;
        }

        int answer = dp[N - 1][0][0] + dp[N - 1][0][1] + dp[N - 1][1][0];
        System.out.println(answer % MOD);
    }
}