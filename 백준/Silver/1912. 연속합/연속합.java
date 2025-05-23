import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max = -1001;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i] + Math.max(0, dp[i - 1]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}