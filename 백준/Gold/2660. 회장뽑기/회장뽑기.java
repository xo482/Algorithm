import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N + 1][N + 1];
        int[] scores = new int[N + 1];

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            if (m1 == -1) break;
            list[m1][m2] = 1;
            list[m2][m1] = 1;
        }

        // 점수 구하기
        for (int i = 1; i < N + 1; i++) {
            int[] visited = new int[N + 1];
            ArrayDeque<Integer> Q = new ArrayDeque<>();
            Q.addLast(i);

            while (!Q.isEmpty()) {
                int now = Q.removeFirst();

                for (int nxt = 1; nxt < N + 1; nxt++) {
                    if (nxt == i) continue;
                    if (list[now][nxt] == 1 && visited[nxt] == 0) {
                        visited[nxt] = visited[now] + 1;
                        Q.addLast(nxt);
                    }
                }
            }

            int max = 0;
            for (int i1 : visited) {
                max = Math.max(max, i1);
            }
            scores[i] = max;
        }

        // 최소 값 구하기
        int min = 50;
        for (int i = 1; i < N + 1; i++){
            min = Math.min(min, scores[i]);
        }
        sb.append(min).append(" ");

        // 회장 후보 수
        int cnt = 0;
        for (int i = 1; i < N + 1; i++)
            if (scores[i] == min) cnt++;
        sb.append(cnt).append("\n");

        // 회장 후보 구하기
        for (int i = 1; i < N + 1; i++)
            if (scores[i] == min) sb.append(i).append(" ");

        System.out.print(sb);
    }
}