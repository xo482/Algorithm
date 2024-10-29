import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        arr = br.readLine().toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] < '0' || arr[i] > '9') {
                System.out.println("0");
                return;
            }
        }

        if (arr[0] == '0') {
            System.out.println("0");
            return;
        }
        for (int i = 1; i < len; i++) {
            if (arr[i] == '0' && arr[i-1] != '1' && arr[i-1] != '2') {
                System.out.println("0");
                return;
            }
        }

        if (len == 1) {
            System.out.println("1");
            return;
        }

        dp = new int[len];
        dp[len-1] = 1;
        dp[len-2] = 1;
        if (arr[len-1] == '0') {
            dp[len-1] = 0;
            dp[len-2] = 0;
        }

        if ((arr[len-2] == '2' && arr[len-1] <= '6') || (arr[len-2] == '1' && arr[len-1] <= '9')) dp[len - 2]++;

        if (arr[len-2] == '0') dp[len-2] = 0;

        for (int i = len-3; i >= 0; i--) {
            dp[i] = dp[i+1];
            if ((arr[i] == '2' && arr[i+1] <= '6') || (arr[i] == '1' && arr[i+1] <= '9')) dp[i] += dp[i+2];
            if (arr[i] == '0') dp[i] = 0;
            dp[i] %= 1000000;

        }

        System.out.println(dp[0]);
    }
}