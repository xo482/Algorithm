import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, H;
    static int[][] dp;
    static List<Integer>[] list;
    static int MOD = 10007;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        dp = new int[N+1][H+1];
        for(int id = 0; id <= N; id++) dp[id][0] = 1;
        
        list = new List[N+1];
        for(int id = 1; id <= N; id++) {
            list[id] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                list[id].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        for(int id = 1; id <= N; id++) {
            for(int h = 1; h <= H; h++) {
                for(int cost : list[id]) {
                    if(cost > h) continue;
                    dp[id][h] += dp[id-1][h-cost];
                }
                dp[id][h] += dp[id-1][h];
                dp[id][h] %= MOD;
            }
        }
        
        System.out.print(dp[N][H]);
    }
}
