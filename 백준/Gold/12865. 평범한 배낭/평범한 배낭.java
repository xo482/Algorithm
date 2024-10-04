import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, W, V;
    static int[] dp; // 인덱스는 무게, 요소는 해당 무게에서의 최대 가치값

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            for (int j = K; j >= W; j--) dp[j] = Math.max(dp[j], dp[j - W] + V);
        }
        System.out.println(dp[K]);
    }
}