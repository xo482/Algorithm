import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int totalCost = 0, cnt = 0;
    static int[] parent;
    static PriorityQueue<Node> Q = new PriorityQueue<>(((o1, o2) -> o1.cost-o2.cost));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int pa = find(a);
            int pb = find(b);
            parent[pb] = pa;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                if (i==1 || j==1) continue;
                
                Q.add(new Node(i, j, cost));
            }
        }

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            int pa = find(now.a);
            int pb = find(now.b);

            if (pa == pb) continue;

            parent[pb] = pa;
            totalCost += now.cost;
            cnt += 1;

            sb.append("\n").append(now.b).append(" ").append(now.a);
        }

        System.out.print(totalCost + " " + cnt);
        if (cnt != 0) System.out.print(sb);
    }

    private static int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    static class Node {
        int a, b, cost;
        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}