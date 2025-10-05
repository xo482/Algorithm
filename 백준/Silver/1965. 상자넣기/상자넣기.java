import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int answer = 1;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            int max = -1;
            int idx = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                        idx = j;
                    }
                }
            }
            if (idx == -1) continue;
            dp[i] = dp[idx] + 1;
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.print(answer);
    }
}
