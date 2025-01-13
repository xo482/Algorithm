import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dp;
    static int[] arr;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][3];
        for (int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(br.readLine());


        if (N < 3) {
            int sum = 0;
            for (int i = 1; i < N + 1; i++) sum += arr[i];
            System.out.println(sum);
            return;
        }

        dp[1][1] = arr[1];

        dp[2][1] = arr[2];
        dp[2][2] = arr[2] + dp[1][1];

        dp[3][1] = arr[3] + arr[1];
        dp[3][2] = arr[3] + dp[2][1];

        for (int i = 4; i < N + 1; i++) {
            dp[i][1] = Math.max(dp[i-3][2], Math.max(dp[i-2][1], dp[i-2][2])) + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 3; j++) {
//                System.out.print(dp[i][j] + " ");
                max = Math.max(max, dp[i][j]);
            }
//            System.out.println();
        }
        System.out.println(max);
    }
}