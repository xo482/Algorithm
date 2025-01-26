import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] dp;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (N == 2) {
            System.out.println(1);
            return;
        }

        dp[1] = 0; dp[2] = 1;
        for (int i = 3; i < N + 1; i++)
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]) % MOD;

        System.out.println(dp[N]);
    }
}