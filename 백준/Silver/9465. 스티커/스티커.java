import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int N;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[2][N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) dp[0][i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) dp[1][i] = Integer.parseInt(st.nextToken());

            if (N == 1){
                sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
                continue;
            }

            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];

            for (int i = 2; i < N; i++) {
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
            sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
        }
        System.out.print(sb);
    }
}
