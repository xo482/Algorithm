import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N;

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            if (N < 4) {
                sb.append(1).append("\n");
                continue;
            }
            if (N < 6) {
                sb.append(2).append("\n");
                continue;
            }

            long[] dp = new long[N+1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;

            for (int i = 6; i < N + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}