import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static long cnt = 0;
    static int[] dp;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());

        map.put(0, 1);
        for (int i = 1; i <= N; i++) {
            cnt += map.getOrDefault(dp[i] - K, 0);
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }

        System.out.println(cnt);
    }
}