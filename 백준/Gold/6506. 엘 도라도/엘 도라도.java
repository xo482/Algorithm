import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            if (N == 0 && K == 0) break;

            arr = new int[N];
            dp = new long[N][K + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i][1] = 1;
            }

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int k = 2; k <= K; k++) {
                    for (int j = i+1; j < N; j++) {
                        if (arr[i] < arr[j])
                            dp[j][k] += dp[i][k - 1];
                    }
                }
                cnt +=dp[i][K];
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}