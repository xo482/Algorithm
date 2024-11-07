import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dp;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        long sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += tracking(N,i);
        }
        System.out.println(sum%1000000000);
    }

    private static long tracking(int depth, int num) {
        if (depth==1)
            return 1L;

        if (dp[depth][num] == 0) {
            if (num == 0)
                dp[depth][num] = tracking(depth - 1, 1);
            if (num == 9)
                dp[depth][num] = tracking(depth - 1, 8);
            if (num != 0 && num != 9)
                dp[depth][num] = tracking(depth - 1, num - 1) + tracking(depth - 1, num + 1);
        }
        return dp[depth][num] % 1000000000;
    }
}