import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                int coin = coins[i];
                for (int j = 0; j <= M; j++) {
                    if (j + coin > M) continue;
                    dp[j + coin] += dp[j];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.print(sb);
    }

}