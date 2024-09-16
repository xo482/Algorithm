import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static boolean[] visited;
    static List<Node>[] list;
    static int max=0, sum=0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        list = new List[n+1];
        for (int i = 1; i < n + 1; i++) list[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        prim(1);
        System.out.println(sum-max);
    }

    static void prim(int start) {
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Q.add(new Node(start,0));

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            if (visited[cur.v]) continue;

            visited[cur.v] = true;
            sum += cur.cost;
            max = Math.max(max, cur.cost);

            for (Node next : list[cur.v])
                if (!visited[next.v])
                    Q.add(next);
        }
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