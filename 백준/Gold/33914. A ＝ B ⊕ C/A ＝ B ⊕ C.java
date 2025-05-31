import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int X, Y;
    static long[][] dp = new long[3001][3001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());


//        dp[2][1] = 3; // 1 0 1,,, 0 1 1,,, 1 1 0
//        dp[0][3] = 1; // 0 0 0

        dp[0][0] = 1;
        for (int i = 0; i < 3001; i++) {
            for (int j = 0; j < 3001; j++) {
                if ((i+j)%3 != 0) continue;

                if (i+2 < 3001 && j+1 < 3001) {
                    dp[i + 2][j + 1] += dp[i][j] * 3;
                    dp[i + 2][j + 1] %= 1000000007;
                }
                if (j+3 < 3001) {
                    dp[i][j + 3] += dp[i][j];
                    dp[i][j + 3] %= 1000000007;
                }
            }
        }

        System.out.println(dp[X][Y]);


        // 0 1 1, 0 1 1
        // 1 0 1, 1 0 1
        // 1 1 0, 1 1 0
        // 0 0 0, 0 0 0
    }
}