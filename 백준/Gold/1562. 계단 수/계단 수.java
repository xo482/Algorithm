import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, MOD = 1000000000;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10][1024];
        for (int i = 1; i < 10; i++) dp[1][i][1 << i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {

                    if (j < 9) dp[i][j][k | (1 << j)] += dp[i-1][j+1][k];
                    if (j > 0) dp[i][j][k | (1 << j)] += dp[i-1][j-1][k];

                    dp[i][j][k | (1 << j)] %= MOD;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i][1023];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}