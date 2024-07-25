import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int now = N - 1; now > 0; now--) for (int nxt = now - 1; nxt >= 0; nxt--) if (arr[nxt] > arr[now]) dp[nxt] = Math.max(dp[nxt], dp[now]+1);

        int max = 0;
        for (int i : dp)
            max = Math.max(max, i);

        System.out.println(max);
    }
}