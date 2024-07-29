import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int iStart = Integer.parseInt(st.nextToken())-1;
            int jStart = Integer.parseInt(st.nextToken())-1;
            int iEnd = Integer.parseInt(st.nextToken())-1;
            int jEnd = Integer.parseInt(st.nextToken())-1;

            for (int i = iStart; i <= iEnd; i++) 
                for (int j = jStart; j <= jEnd; j++) 
                    sum += map[i][j];

            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}