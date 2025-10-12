import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st1, st2;
    static int N, M, max_cost;
    static int[] dp, memory, cost;

    public static void main(String[] args) throws IOException {
        st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        memory = new int[N];
        cost = new int[N];

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st1.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
            max_cost += cost[i];
        }

        dp = new int[max_cost + 1];
        for (int i = 0; i < N; i++) {
            for (int j = max_cost; j >= 0; j--) {
                if (j - cost[i] < 0) continue;
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= max_cost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}