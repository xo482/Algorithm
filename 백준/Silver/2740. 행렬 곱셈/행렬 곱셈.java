import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) B[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] answer = mul(A, B);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) sb.append(answer[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] mul(int[][] a, int[][] b) {
        int[][] answer = new int[a.length][b[0].length];

        for (int i = 0; i < answer.length; i++)
            for (int j = 0; j < answer[0].length; j++)
                answer[i][j] = calculate(i, j);

        return answer;
    }

    private static int calculate(int r, int c) {
        int answer=0;
        for (int i = 0; i < M; i++) answer += A[r][i] * B[i][c];
        return answer;
    }
}