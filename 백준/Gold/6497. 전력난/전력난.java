import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 집의 수
            int n = Integer.parseInt(st.nextToken()); // 길의 수
            if (m==0) break;

            visited = new boolean[m];
            list = new List[m];
            for (int i = 0; i < m; i++) list[i] = new ArrayList<>();

            int total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                total += z;

                list[x].add(new Node(y, z));
                list[y].add(new Node(x, z));
            }

            sb.append(total - prim(m-1)).append("\n");
        }

        System.out.print(sb);
    }

    private static int prim(int start) {
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Q.add(new Node(start, 0));
        int sum = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();

            if (visited[curNode.v]) continue;

            visited[curNode.v] = true;
            sum += curNode.cost;

            for (Node nxtNode : list[curNode.v])
                if (!visited[nxtNode.v])
                    Q.add(nxtNode);
        }
        return sum;
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