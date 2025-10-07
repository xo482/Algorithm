import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int MAXCOUPON = 100;
    static int[][] dp;
    static boolean[] canNotDay;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int INF = 10000 * N;

        canNotDay = new boolean[N + 6];
        dp = new int[N + 6][MAXCOUPON+2];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], INF);
        dp[0][0] = 0;

        String s = br.readLine();
        if (!(s ==null || s.equals(""))) {
            st = new StringTokenizer(s);
            for (int i = 0; i < M; i++) canNotDay[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < MAXCOUPON; j++) {
                
                if (dp[i][j] == INF) continue;
                
                if (canNotDay[i+1]) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                    continue;
                }

                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 10000);
                dp[i+3][j+1] = Math.min(dp[i+3][j+1], dp[i][j] + 25000);
                dp[i+5][j+2] = Math.min(dp[i+5][j+2], dp[i][j] + 37000);

                if (j >= 3) dp[i+1][j-3] = Math.min(dp[i+1][j-3], dp[i][j]);
            }
        }

        int answer = INF;
        for (int i = 0; i < MAXCOUPON; i++) answer = Math.min(answer, dp[N][i]);
        System.out.println(answer);
    }

}