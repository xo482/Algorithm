import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] adj;
    static boolean[] visited;
    static int cnt = 0;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adj = new int[V + 1][V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            adj[com1][com2] = 1;
            adj[com2][com1] = 1;
        }

        dfs(1);

        for (boolean b : visited) {
            if (b) cnt++;
        }
        System.out.println(cnt-1);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i < V+1; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}