import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }


        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = i + 1; k <= N; k++) {
                    for (int l = j + 1; l <= M; l++) {
                        int sum = dp[k][l] - dp[i][l] - dp[k][j] + dp[i][j];
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        System.out.println(max);
    }
}