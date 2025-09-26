import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static final int size = 500;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[size + 1];
        dp = new int[size+1];
        for (int i = 1; i <= size; i++) dp[i] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s] = e;
        }

        for (int now = 1; now <= size; now++) {
            for (int pre = 1; pre < now; pre++) {
                if (arr[pre] == 0) continue;
                if (arr[now] > arr[pre]) {
                    dp[now] = Math.max(dp[now], dp[pre] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= size; i++) max = Math.max(max, dp[i]);
        System.out.println(N - max);
    }
}
