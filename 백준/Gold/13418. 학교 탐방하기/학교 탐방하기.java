import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M ,A, B, C;
    static int min, max;
    static List<Node>[] list;

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > -1) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (C == 1) C = 0;
            else C = 1;

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        min = prim(0);
        max = reversePrim(0);
        System.out.println((max+min)*(max-min));
    }

    private static int prim(int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Q.add(new Node(start, 0));
        int sum = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            if (visited[curNode.v]) continue;

            visited[curNode.v] = true;
            sum += curNode.cost;

            for (Node nxtNode : list[curNode.v]) {
                if (!visited[nxtNode.v])
                    Q.add(nxtNode);
            }
        }
        return sum;
    }
    private static int reversePrim(int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cost, o1.cost));
        Q.add(new Node(start, 0));
        int sum = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            if (visited[curNode.v]) continue;

            visited[curNode.v] = true;
            sum += curNode.cost;

            for (Node nxtNode : list[curNode.v]) {
                if (!visited[nxtNode.v])
                    Q.add(nxtNode);
            }
        }
        return sum;
    }
}