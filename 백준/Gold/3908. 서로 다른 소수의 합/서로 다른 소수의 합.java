import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {

        boolean[] isPrime = new boolean[1121];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(1121); i++) {
            if (isPrime[i]) continue;
            for (int j = i*i; j < 1121; j+=i) isPrime[j] = true;
        }

        int[][] dp = new int[1121][15];
        for (int i = 2; i <= 1120; i++) {
            if (isPrime[i]) continue;
            dp[i][1] = 1;

            for (int j = 1120; j >= 2; j--) {
                if (j+i > 1120) continue;
                for (int k = 1; k < 14; k++) {
                    if (dp[j][k] == 0) continue;
                    if (i==j && k==1) continue;
                    dp[j + i][k + 1] += dp[j][k];
                }
            }
        }


        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k]).append('\n');
        }
        System.out.print(sb);
    }
}