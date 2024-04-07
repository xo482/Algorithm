import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 길이
        int[] arr = new int[N];
        int[] dp = new int[N];

        // init
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = N-2; i >= 0; i--) 
            for (int j = i+1; j <N; j++) 
                if (arr[i] < arr[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
              
        int max = 0;
        for (int i : dp) max = Math.max(max, i);     
        System.out.println(max);
    }

}
