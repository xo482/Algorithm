import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        System.out.println(prim(1));
    }

    private static int prim(int start) {
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Q.add(new Node(start, 0));
        int total = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            if (visited[curNode.v]) continue;

            visited[curNode.v] = true;
            total += curNode.cost;

            for (Node nxtNode : list[curNode.v])
                if (!visited[nxtNode.v])
                    Q.add(nxtNode);
        }

        return total;
    }

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
