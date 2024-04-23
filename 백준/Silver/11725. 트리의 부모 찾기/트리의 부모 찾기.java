import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Q.addLast(1);
        visited[1] = 1;

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            for (int next : adj[now]) {
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    Q.addLast(next);
                }
            }
        }

        for (int now = 2; now <= N; now++) {
            for (int next : adj[now]) {
                if (visited[next] < visited[now]) sb.append(next).append("\n");
            }
        }

        System.out.print(sb);
    }
}
