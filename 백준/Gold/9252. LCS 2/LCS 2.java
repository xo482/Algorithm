import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = s1.length();
        int M = s2.length();
        int[] answer = new int[5];

        int[][][] dp = new int[N + 1][M + 1][5];
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                    dp[i][j][1] = i;
                    dp[i][j][2] = j;
                    dp[i][j][3] = dp[i - 1][j - 1][1];
                    dp[i][j][4] = dp[i - 1][j - 1][2];
                }
                else if (dp[i][j - 1][0] >= dp[i - 1][j][0]) {
                    dp[i][j][0] = dp[i][j - 1][0];
                    dp[i][j][1] = dp[i][j - 1][1];
                    dp[i][j][2] = dp[i][j - 1][2];
                    dp[i][j][3] = dp[i][j - 1][3];
                    dp[i][j][4] = dp[i][j - 1][4];
                }
                else {
                    dp[i][j][0] = dp[i - 1][j][0];
                    dp[i][j][1] = dp[i - 1][j][1];
                    dp[i][j][2] = dp[i - 1][j][2];
                    dp[i][j][3] = dp[i - 1][j][3];
                    dp[i][j][4] = dp[i - 1][j][4];
                }

                if (answer[0] < dp[i][j][0]) {
                    answer[0] = dp[i][j][0];
                    answer[1] = i;
                    answer[2] = j;
                    answer[3] = dp[i][j][1];
                    answer[4] = dp[i][j][2];
                }
            }
        }

        System.out.println(answer[0]);
        if (answer[0] == 0) return;

        int i = answer[1];
        int j = answer[2];
        while (true) {
            sb.append(s1.charAt(i-1));
            int pre_i = dp[i][j][3];
            int pre_j = dp[i][j][4];
            i = pre_i;
            j = pre_j;

            if (i == 0 || j == 0) break;
        }

        System.out.println(sb.reverse().toString());
    }
}