import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][][] dp;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][M + 1][2];
        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) distance[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N + 1; i++) {

            for (int j = 1; j < M + 1; j++) {
                dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][0] + distance[i]);
                if (j == 1) dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1] + distance[i]);
            }

            for (int j = 0; j < M; j++) {
                dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j + 1][1]);
                dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j + 1][0]);
                if (j == 0) dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][1]);
            }
        }

        System.out.println(dp[N][0][1]);
    }
}