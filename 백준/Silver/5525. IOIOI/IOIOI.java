import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] arr;
    static int[] dp;
    static int N, M, standard;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        standard = 2 * N + 1;
        arr = br.readLine().toCharArray();
        dp = new int[M];
        Arrays.fill(dp, 1);

        for (int i = 1; i < M; i++)
            if (arr[i] != arr[i-1])
                dp[i] = dp[i-1] + 1;

        int cnt = 0;
        for (int i = standard-1; i < M; i++)
            if (dp[i] >= standard && arr[i] == 'I')
                cnt++;


        System.out.println(cnt);
    }
}