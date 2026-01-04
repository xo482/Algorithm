import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N ,M, x, y, a, b;
    static int[] board;
    static boolean[] visited;
    static boolean[] light;
    static List<Integer>[] list;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N * N];
        visited = new boolean[N * N];
        light = new boolean[N * N];
        list = new List[N * N];
        for (int i = 0; i < N * N; i++) list[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;

            int from = x * N + y;
            int to = a * N + b;
            list[from].add(to);
        }

        Q.add(0);
        visited[0] = true;
        light[0] = true;

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            int r = now / N;
            int c = now % N;

            for (int nxt : list[now]) {
                if (visited[nxt]) continue;
                if (light[nxt]) continue;
                
                light[nxt] = true;

                for (int i = 0; i < 4; i++) {
                    int nr = nxt / N + dr[i];
                    int nc = nxt % N + dc[i];

                    if (nr >= N || nr < 0 || nc >= N || nc < 0) continue;
                    if (!visited[nr * N + nc]) continue;

                    Q.add(nxt);
                    visited[nxt] = true;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= N || nr < 0 || nc >= N || nc < 0) continue;
                if (!light[nr * N + nc]) continue;
                if (visited[nr * N + nc]) continue;

                Q.add(nr * N + nc);
                visited[nr * N + nc] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N * N; i++) {
            if (light[i]) cnt++;
        }
        System.out.println(cnt);
    }
}