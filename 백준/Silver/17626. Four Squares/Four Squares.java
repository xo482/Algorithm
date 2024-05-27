import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50_001];
        dp[1] = 1;

        int min = 0;
        for (int i = 2; i < 50_001; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1;
        }

        System.out.print(dp[n]);
    }
}

/**
 * 1 = 1^2
 * 2 = 1^2 + 1^2
 * 3 = 1^2 + 1^2 + 1^2
 *
 * 4 = 2^2
 * 5 = 2^2 + 1^2
 * 6 = 2^2 + 1^2 + 1^2
 * 7 = 2^2 + 1^2 + 1^2 + 1^2
 * 8 = 2^2 + 2^2
 *
 * 9 = 3^2
 * 10 = 3^2 + 1^2
 * 11 = 3^2 + 1^2 + 1^2
 * 12 = 3^2 + 1^2 + 1^2 + 1^2 ------> 2^2 + 2^2 + 2^2
 * 13 = 3^2 + 2^2
 * 14 = 3^2 + 2^2 + 1^2
 * 15 = 3^2 + 2^2 + 1^2 + 1^2
 *
 * 16 = 4^2
 */