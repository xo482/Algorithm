import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, Q;
    static int[] isParent;
    static ArrayList<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, cost));
        }
        list.sort((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = Kruskal(a, b);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int Kruskal(int a, int b) {
        isParent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) isParent[i] = i;
        isParent[a] = isParent[b] = 0;

        int cnt = 0, sum = 0;
        for (Edge edge : list) {
            int aP = findParent(edge.a);
            int bP = findParent(edge.b);

            if (aP==bP) continue;

            isParent[aP] = bP;
            sum += edge.cost;
            cnt++;

            if (cnt == N-2) break;
        }

        return sum;
    }

    static int findParent(int v) {
        if (v == isParent[v]) return v;
        return isParent[v] = findParent(isParent[v]);
    }

    static class Edge{
        int a, b, cost;

        public Edge(int v1, int v2, int cost) {
            this.a = v1;
            this.b = v2;
            this.cost = cost;
        }
    }
}