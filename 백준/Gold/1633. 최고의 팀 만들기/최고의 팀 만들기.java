import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        final int MAX = 15;
        final int NEG = -1_000_000_000; // -INF
        int[][] dp = new int[MAX + 1][MAX + 1];
        for (int i = 0; i <= MAX; i++) Arrays.fill(dp[i], NEG);
        dp[0][0] = 0;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;
            int ws = Integer.parseInt(st.nextToken()); // white score
            int bs = Integer.parseInt(st.nextToken()); // black score

            for (int w = MAX; w >= 0; w--) {
                for (int b = MAX; b >= 0; b--) {
                    int cur = dp[w][b];
                    if (cur == NEG) continue;
                    if (w < MAX) dp[w + 1][b] = Math.max(dp[w + 1][b], cur + ws);
                    if (b < MAX) dp[w][b + 1] = Math.max(dp[w][b + 1], cur + bs);
                }
            }
        }

        System.out.println(dp[MAX][MAX]);
    }
}
