import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, t;
    static int total = 0;
    static boolean[] visited;
    static List<Node>[] list;
    static PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        Q.add(new Node(1, 0));
        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            if (visited[curNode.v]) continue;

            visited[curNode.v] = true;
            total += curNode.cost;

            for (Node nxtNode : list[curNode.v]) {
                if (!visited[nxtNode.v])
                    Q.add(nxtNode);
            }
        }

        System.out.println(((N - 2) * (N - 1) / 2 * t) + total);
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