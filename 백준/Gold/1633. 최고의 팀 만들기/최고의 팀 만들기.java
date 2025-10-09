import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dp = new int[16][16];
    
    public static void main(String[] args) throws Exception {
        while(true) {
            String line = br.readLine();
            if (line == null || line.equals("")) break;
            
            st = new StringTokenizer(line);
            int w_v = Integer.parseInt(st.nextToken());
            int b_v = Integer.parseInt(st.nextToken());
            
            for (int w = 15; w >= 0; w--) {
                for (int b = 15; b >= 0; b--) {
                    if(w != 0) dp[w][b] = Math.max(dp[w][b], dp[w-1][b] + w_v);
                    if (b != 0) dp[w][b] = Math.max(dp[w][b], dp[w][b-1] + b_v);
                }
            }
        }
        System.out.print(dp[15][15]);
    }
}
