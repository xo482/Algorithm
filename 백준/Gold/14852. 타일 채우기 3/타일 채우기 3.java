import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int MOD = 1000000007;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];
        if (N >= 1) dp[1] = 2;
        if (N >= 2) dp[2] = 7;
        long sum_dp = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2] + 2 * sum_dp) % MOD;
            sum_dp += dp[i - 2];
        }
        System.out.println(dp[N]);
    }
}