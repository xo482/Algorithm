import java.io.*;
import java.util.*;

public class Main {
    static int d, p;
    static int[] len, capacity;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        len = new int[p];
        capacity = new int[p];
        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            len[i] = Integer.parseInt(st.nextToken());
            capacity[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[d + 1];
        Arrays.fill(dp, 0);
        for(int i=0; i<p; i++){
            int l = len[i];
            int c = capacity[i];
            for(int j=d; j>=l; j--){
                if(j == l) dp[j] = Math.max(dp[j], c);
                else if(dp[j - l] > 0) dp[j] = Math.max(dp[j], Math.min(dp[j - l], c));
            }
        }
        System.out.println(dp[d]);
    }
}