import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] dp;
    static List<Integer>[] tree;
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N+1][2];
        tree = new List[N+1];
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[p].add(c);
            tree[c].add(p);
        }
        
        dfs(-1, 1);
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
    
    static void dfs(int pre, int n) {
        dp[n][0] = 0;
        dp[n][1] = 1;
        
        for (int c : tree[n]) {
            if (c == pre) continue;
            dfs(n, c);
            dp[n][0] += dp[c][1];
            dp[n][1] += Math.min(dp[c][0], dp[c][1]);        
        }
    }
}