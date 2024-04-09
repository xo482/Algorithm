import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] >= 10007) dp[i] %= 10007;
        }

        System.out.println(dp[N-1]);
    }
}