import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        dp = new int[25];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 5;
        dp[3] = 11;

        for (int i = 4; i <= 24; i++) {
            dp[i] = (dp[i - 1] + 4 * dp[i - 2]);

            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += 3 * dp[j];
            }
            for (int j = i - 3; j >= 0; j -= 2) {
                dp[i] += 2 * dp[j];
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}