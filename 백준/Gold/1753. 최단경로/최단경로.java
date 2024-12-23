import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V, E;
    static int INF = 10_000_000;
    static List<int[]>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[V + 1];
        Arrays.fill(distance, INF);

        list = new List[V + 1];
        for (int i = 1; i < V + 1; i++) list[i] = new ArrayList<>();

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
        }

        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Q.add(new int[]{start, 0});
        while (!Q.isEmpty()) {
            int[] now = Q.poll();

            if (distance[now[0]] < now[1]) continue;

            distance[now[0]] = now[1];
            for (int[] nxt : list[now[0]]) {
                if (distance[nxt[0]] > distance[now[0]] + nxt[1]) {
                    distance[nxt[0]] = distance[now[0]] + nxt[1];
                    Q.add(new int[]{nxt[0], distance[nxt[0]]});
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }
}