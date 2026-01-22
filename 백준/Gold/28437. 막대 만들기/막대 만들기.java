import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, Q, max = 0;
    static int[] base, need, dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        base = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) base[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(base);

        Q = Integer.parseInt(br.readLine());
        need = new int[Q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, need[i]);
        }

        dp = new int[max + 1];
        for (int i = 0; i < N; i++) {
            if (base[i] > max) continue;
            dp[base[i]] = 1;
        }
        
        for (int i = 1; i <= max; i++) {
            if (dp[i] == 0) continue;
            for (int j = i * 2; j <= max; j += i) {
                dp[j] += dp[i];
            }
        }

        for (int i = 0; i < Q; i++) {
            sb.append(dp[need[i]]).append(" ");
        }
        System.out.println(sb);
    }
}