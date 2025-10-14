import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];

        for (int i = 1; i <= K; i++) dp[0][i] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(dp[N][K]);
    }
}