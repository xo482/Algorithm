import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] arr1, arr2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        dp = new int[len1][len2];
        for (int j = 0; j < len2; j++) {
            if (arr1[0] == arr2[j]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            if (arr1[i] == arr2[0]) dp[i][0] = 1;

            for (int j = 1; j < len2; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}