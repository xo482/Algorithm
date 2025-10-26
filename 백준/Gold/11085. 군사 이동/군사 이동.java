import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int P, W, s_n, e_n;
    static int[] distance;
    static List<Node>[] list;
    static ArrayDeque<Node> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        distance = new int[P];
        list = new List[P];
        for (int i = 0; i < P; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        s_n = Integer.parseInt(st.nextToken());
        e_n = Integer.parseInt(st.nextToken());

        while (W-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, cost));
            list[v].add(new Node(u, cost));
        }


        Q.add(new Node(s_n, 50000));
        distance[s_n] = 50000;

        while (!Q.isEmpty()) {
            Node now = Q.removeFirst();

            if (distance[now.v] > now.cost) continue;

            for (Node nxt : list[now.v]) {
                int size = Math.min(distance[now.v], nxt.cost);
                if (distance[nxt.v] < size) {
                    distance[nxt.v] = size;
                    Q.add(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }

        System.out.println(distance[e_n]);
    }

    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}