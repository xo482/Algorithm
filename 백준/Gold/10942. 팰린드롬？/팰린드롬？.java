import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, Q;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) dp[i][i] = 1;
        for (int i = 1; i <= N-1; i++) if (arr[i] == arr[i+1]) dp[i][i+1] = 1;

        for (int i = 2; i <= N; i++)
            for (int j = 1; i+j <= N; j++)
                if (arr[j] == arr[i+j] && dp[j+1][i+j-1] == 1)
                    dp[j][i+j] = 1;

        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b]).append("\n");
        }
        System.out.print(sb);
    }
}