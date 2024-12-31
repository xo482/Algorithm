import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static int INF = Integer.MAX_VALUE;
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1][N+1];
            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());


            for (int k = 1; k < N; k++) {
                for (int i = 1; i < N+1-k; i++) {
                    int j = i + k;
                    dp[i][j] = INF;

                    for (int l = i; l < j; l++) dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j] + arr[j] - arr[i - 1]);
                }
            }

            sb.append(dp[1][N]).append("\n");
        }
        System.out.print(sb);
    }
}