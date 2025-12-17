import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static long[] remain;
    static long sum = 0, answer = 0;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        remain = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            remain[(int)(sum%M)]++;
        }
        for (int i = 0; i < M; i++) {
            if (remain[i] < 2) continue;
            answer += remain[i] * (remain[i] - 1) / 2;
        }
        System.out.println(answer + remain[0]);
    }
}