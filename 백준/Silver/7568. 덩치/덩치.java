import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, x, y;
    static int[][] build; // 0: 몸무게, 1: 키

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        build = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            build[i][0] = x;
            build[i][1] = y;
        }


        for (int i = 0; i < N; i++) {

            int cnt = 1;
            for (int j = 0; j < N; j++)
                if (build[i][0] < build[j][0] && build[i][1] < build[j][1])
                    cnt++;

            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}