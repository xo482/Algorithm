import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] p1 = new int[n];
            int[] p2 = new int[n];

            p1[0] = Integer.parseInt(st.nextToken());
            p2[0] = Integer.parseInt(st.nextToken());
            int p1Shoot = Integer.parseInt(st.nextToken());
            int p2Shoot = Integer.parseInt(st.nextToken());

            // 0: 패스   1: 드리블
            int[][] p1Arr = new int[n][2];
            int[][] p2Arr = new int[n][2];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) p1Arr[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) p1Arr[i][1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) p2Arr[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) p2Arr[i][1] = Integer.parseInt(st.nextToken());


            for (int i = 1; i < n; i++) {
                p1[i] = Math.min(p2Arr[i-1][0] + p2[i - 1], p1Arr[i-1][1] + p1[i - 1]);
                p2[i] = Math.min(p1Arr[i-1][0] + p1[i - 1], p2Arr[i-1][1] + p2[i - 1]);
            }

            sb.append(Math.min(p1[n - 1] + p1Shoot, p2[n - 1] + p2Shoot)).append("\n");
        }

        System.out.print(sb);
    }

}