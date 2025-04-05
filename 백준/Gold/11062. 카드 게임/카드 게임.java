import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, T;
    static int[] card;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;

            N = Integer.parseInt(s);
            card = new int[N];
            dp = new int[N][N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());

            sb.append(tracking(0, 0, N-1)).append("\n");
        }
        System.out.println(sb);
    }

    // 지금 누구턴인데 start~end까지의 최댓값을 구해보겠다
    static int tracking(int turn, int start, int end) { // 짝수면 내턴임
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        if (turn == N - 1) {
            if (turn % 2 == 0) return card[start];
            return 0;
        }

        if (turn % 2 == 0) {
            dp[start][end] = Math.max(
                    card[start] + tracking(turn+1, start + 1, end),
                    card[end] + tracking(turn+1, start, end - 1)
            );
        }
        else {
            dp[start][end] = Math.min(
                    tracking(turn+1, start + 1, end),
                    tracking(turn+1, start, end - 1)
            );
        }
        return dp[start][end];
    }
}