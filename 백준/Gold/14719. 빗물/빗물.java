import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] arr;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            int high = Integer.parseInt(st.nextToken());
            for (int i = N-1; i >= N-high; i--) arr[i][j] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) continue;
                boolean flag = false;
                for (int k = j+1; k < M; k++) {
                    if (arr[i][k] == 0) continue;
                    if (flag) break;
                    cnt += k-j-1;
                    flag = true;
                }
            }
        }

        System.out.println(cnt);
    }
}