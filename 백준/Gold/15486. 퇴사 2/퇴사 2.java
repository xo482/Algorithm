import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max=0;
    static int[][] arr; // 1차원- 날짜,   2차원- 0: 기간, 1: 보수
    static int[] dp; // 돈 총합

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        dp = new int[N+2];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        for (int now = 1; now < N+1; now++) {
            int period = arr[now][0];
            int next = now + period;
            int pay = arr[now][1];
            max = Math.max(max, dp[now]);

            if (next > N+1) continue;
            dp[next] = Math.max(dp[next], max + pay);
        }

        max = Math.max(max, dp[N+1]);
        System.out.println(max);
    }
}