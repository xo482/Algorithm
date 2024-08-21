import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N,M;
    static List<Node>[] list;
    static int[] inDegree;
    static int[] need;
    static boolean[] mid;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();
        inDegree = new int[N + 1];
        need = new int[N + 1];
        mid = new boolean[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            list[X].add(new Node(Y, K));
            inDegree[Y]++;
            mid[X] = true;
        }

        need[N] = 1;
        Q.addLast(N);
        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            for (Node nxt : list[now]) {
                need[nxt.vertex] += need[now] * nxt.count;
                inDegree[nxt.vertex]--;

                if (inDegree[nxt.vertex] == 0) Q.addLast(nxt.vertex);
            }
        }

        for (int i = 1; i < N; i++) {
            if (!mid[i]) sb.append(i).append(" ").append(need[i]).append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int vertex;
        int count;

        public Node(int vertex, int count) {
            this.vertex = vertex;
            this.count = count;
        }
    }
}