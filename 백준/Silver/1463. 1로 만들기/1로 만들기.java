import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        int a, b, c, d;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i=4; i < 1_000_001; i++){
            if (i % 3 == 0){
                c = dp[i] = dp[i/3] + 1;
            } else {
                c = Integer.MAX_VALUE;
            }

            if (i % 2 == 0) {
                d = dp[i] = dp[i / 2] + 1;
            } else {
                d = Integer.MAX_VALUE;
            }

            a = dp[i-1] + 1;
            b = dp[i-2] + 2;
            dp[i] = Math.min(Math.min(a,b), Math.min(c,d));
        }

        System.out.print(dp[N]);
    }
}