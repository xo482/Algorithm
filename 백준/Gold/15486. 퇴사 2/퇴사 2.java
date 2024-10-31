import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max=0;
    static int[] dp, t, p;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        t = new int[N+1];
        p = new int[N+1];
        dp = new int[N+2];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }


        for (int now = 1; now < N+1; now++) {
            int period = t[now];
            int next = now + period;
            int pay = p[now];
            
            max = Math.max(max, dp[now]);

            if (next > N+1) continue;
            dp[next] = Math.max(dp[next], max + pay);
        }

        max = Math.max(max, dp[N+1]);
        System.out.println(max);
    }
}