import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
    static PriorityQueue<Edge> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static int N, total = 0;
    static int[] isParent;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        isParent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) isParent[i] = i;

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                Q.add(new Edge(i, j, cost));
            }
        }

        int cnt = 0; // 새로 추가된 도로의 개수
        while (!Q.isEmpty()) {
            Edge now = Q.poll();
            int aP = findParent(now.a);
            int bP = findParent(now.b);

            if (now.cost < 0) {
                isParent[aP] = isParent[bP];
                total -= now.cost;
                continue;
            }

            if (aP == bP) continue;

            isParent[aP] = bP;
            total += now.cost;
            cnt++;
            sb2.append(now.a).append(" ").append(now.b).append("\n");
        }

        sb.append(total).append(" ").append(cnt).append("\n").append(sb2.toString());
        System.out.println(sb);
    }

    static int findParent(int a) {
        if (a == isParent[a]) return a;
        return isParent[a] = findParent(isParent[a]);
    }

    static class Edge{
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}