import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        arr = new int[N];
        dp = new int[10_001];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 0; i < N; i++) 
            for (int j = arr[i]; j <= K; j++) 
                dp[j] += dp[j - arr[i]];

        System.out.println(dp[K]);
    }
}