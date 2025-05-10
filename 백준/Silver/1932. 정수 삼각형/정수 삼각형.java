import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int size = N * (N + 1) / 2;
        arr = new int[size];
        dp = new int[size];

        int idx = 0;
        while (idx < size) {
            if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        idx = 0;
        for (int floor = 1; floor < N; floor++) {
            for (int j = 0; j < floor; j++) {
                dp[idx + floor] = Math.max(dp[idx + floor], dp[idx] + arr[idx + floor]);
                dp[idx + floor+1] = Math.max(dp[idx + floor+1], dp[idx] + arr[idx + floor+1]);

                idx++;
            }
        }

        int max = 0;
        for (int i = size-N ; i < size; i++) max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}