import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K, x, y;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[M + 1][K + 1];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for (int m = M; m > 0; m--) {
                for (int k = K; k > 0; k--) {
                    if (m-x < 0) continue;
                    if (k-y < 0) continue;

                    dp[m][k] = Math.max(dp[m][k], dp[m - x][k - y] + 1);
                }
            }
        }
        System.out.println(dp[M][K]);
    }
}