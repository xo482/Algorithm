import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[] dp;
    static int INF = 10001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        while (n-- > 0) {
            int coin = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                if (i + coin > k) break;
                dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
            }
        }

        if (dp[k] == INF) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}