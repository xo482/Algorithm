import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long[] arr;
    static int[][] dp;
    static int[] visited;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        dp = new int[N][2];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (arr[i] != 0) {
                answer += arr[i];
                visited[i] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] != 0) {
                if (i == 0) continue;
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                continue;
            }

            dp[i][1] = dp[(i-1+N) % N][0] + 1;
            if (visited[(i-1+N) % N] == 1) dp[i][1] = Math.max(dp[(i-1+N) % N][0], dp[(i-1+N) % N][1]) + 1;
            dp[i][0] = Math.max(dp[(i-1+N) % N][0], dp[(i-1+N) % N][1]);
        }

        System.out.println(answer + Math.max(dp[N-1][0], dp[N-1][1]));
    }
}
