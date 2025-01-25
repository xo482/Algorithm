import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E, P;
    static int[] dist;
    static List<int[]>[] list;
    static PriorityQueue<Node> Q = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.w - o2.w;
        }
    });
    static int INF = 50000001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        list = new List[V + 1];
        for (int i = 1; i < V + 1; i++) list[i] = new ArrayList<>();

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, w});
            list[b].add(new int[]{a, w});
        }

        boolean flag = false;
        Q.add(new Node(1, 0, new ArrayList<>(1)));
        while (!Q.isEmpty()) {
            Node now = Q.poll();

//            for (Integer i : now.way) {
//                System.out.println(i + " ");
//            }
//            System.out.println();

            if (dist[now.v] < now.w) continue;
            if (now.v == V && now.way.contains(P)) flag = true;

            dist[now.v] = now.w;
            for (int[] nxt : list[now.v]) {
                if (dist[nxt[0]] >= now.w + nxt[1]) {
                    dist[nxt[0]] = now.w + nxt[1];
                    List<Integer> nxtWay = new ArrayList<>(List.copyOf(now.way));
                    nxtWay.add(nxt[0]);
                    Q.add(new Node(nxt[0], dist[nxt[0]], nxtWay));
                }
            }
        }

        if (V == P || P == 1) flag = true;

        if (flag) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }

    static class Node {
        int v;
        int w;
        List<Integer> way;

        public Node(int v, int w, List<Integer> way) {
            this.v = v;
            this.w = w;
            this.way = way;
        }
    }
}