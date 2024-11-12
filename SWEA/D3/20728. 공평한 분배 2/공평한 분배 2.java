import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            int min  = 1_000_000_000;
            for (int i = 0; i <= N - K; i++)
                min = Math.min(min, arr[i + K - 1] - arr[i]);

            sb.append("#").append(t+1).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
}