import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static int zeroCnt = 0, plusCnt = 0, minusCnt = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,N);
        sb.append(minusCnt).append("\n").append(zeroCnt).append("\n").append(plusCnt);
        System.out.println(sb);
    }

    static void dfs(int r, int c, int length) {
        int standard = arr[r][c];
        boolean flag = false;

        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (standard != arr[i][j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        // 불합격
        if (flag) {
            for (int i = r; i < r + length; i += length/3) {
                for (int j = c; j < c+length; j += length/3) {
                    dfs(i,j, length/3);
                }
            }
        }
        // 합격
        else {
            if (standard == -1) minusCnt++;
            if (standard == 0) zeroCnt++;
            if (standard == 1) plusCnt++;
        }
    }

}