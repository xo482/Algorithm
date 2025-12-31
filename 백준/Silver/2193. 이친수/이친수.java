import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            System.out.println(1);
            return;
        }

        dp = new long[N+1][2];
        dp[1][1] = 1;
        dp[2][0] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
        }

        System.out.println(dp[N][1] + dp[N][0]);
    }
}