import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, ans = 37;
    static int[][] arr;
    static int[] NSign, MSign;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        NSign = new int[N];
        MSign = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int len = 1 << N;
        for (int candidate = 0; candidate < len; candidate++) {
            int cnt = 0;
            Arrays.fill(NSign, 1);
            Arrays.fill(MSign, 1);

            for (int j = 0; j < N; j++) {
                if ((candidate & (1 << j)) > 0) {
                    NSign[j] = -1;
                    cnt++;
                }
            }

            boolean flag = false;
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += (arr[i][j] * NSign[i]);
                }
                if (sum == 0) {
                    flag = true;
                    break;
                }

                if (sum < 0) {
                    MSign[j] = -1;
                    cnt++;
                }
            }

            if (flag) continue;

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += (arr[i][j] * NSign[i] * MSign[j]);
                }
                if (sum <= 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            ans = Math.min(ans, cnt);
        }
        
        if (ans == 37) System.out.println(-1);
        else System.out.println(ans);
    }
}