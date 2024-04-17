import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] adj;
    static boolean[] visited;
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 탐색 시작 지점
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            adj[com1][com2] = 1;
            adj[com2][com1] = 1;
        }

        dfs(V);

        sb.append("\n");
        for (int i = 1; i < N+1; i++) {
            visited[i] = false;
        }

        // 시작 노드 설정
        queue.addLast(V);

        while (!queue.isEmpty()) {
            int now = queue.removeFirst();
            if (visited[now]) continue;
            visited[now] = true;
            sb.append(now).append(" ");
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && adj[now][i] == 1) {
                    queue.addLast(i);
                }

            }


        }

        System.out.println(sb);
    }

    private static void dfs(int now) {
        visited[now] = true;
        sb.append(now).append(" ");
        for (int i = 1; i < N+1; i++)
            if (!visited[i] && adj[now][i] == 1)
                dfs(i);
    }

}