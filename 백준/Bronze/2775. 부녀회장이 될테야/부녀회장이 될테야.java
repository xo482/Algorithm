import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[15][15];
    static int T;

    public static void main(String[] args) throws IOException {

        for (int i = 1; i < 15; i++) dp[i][1] = 1;
        for (int j = 1; j < 15; j++) dp[0][j] = j;
        for (int i = 1; i < 15; i++)
            for (int j = 2; j < 15; j++)
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
        
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append("\n");
        }
        System.out.print(sb);
    }
}