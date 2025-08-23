import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp = new int[31];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 31; i++) dp[i] = dp[i-1] + dp[i-2] * 2;

        int symmetryCnt = dp[N / 2];
        if (N % 2 == 0) symmetryCnt += dp[(N - 1) / 2] * 2;

        System.out.println((dp[N] - symmetryCnt) / 2 + symmetryCnt);
    }
}