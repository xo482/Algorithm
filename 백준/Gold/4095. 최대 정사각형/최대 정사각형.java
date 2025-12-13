import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, max;
    static int[][] adj, dp;

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            dp = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) dp[i][j] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dp[i][j] == 0) continue;
                    
                    if (i != 0 && j != 0) dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
}