import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, P, K;
    static int[] arr;
    static List<Edge>[] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[P + 1];
        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, cost));
            list[b].add(new Edge(a, cost));
            arr[i] = cost;
        }

        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (dfs(arr[mid])) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(start < arr.length ? arr[start] : -1);
    }

    private static boolean dfs(int maxValue) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][K + 1];
        stack.addLast(new Node(1, K));


        while (!stack.isEmpty()) {
            Node now = stack.removeLast();
            if (now.v == N) return true;
            if (visited[now.v][now.chance]) continue;

            visited[now.v][now.chance] = true;
            for (Edge nxt : list[now.v]) {
                if (!visited[nxt.v][now.chance] && nxt.cost <= maxValue) {
                    stack.add(new Node(nxt.v, now.chance));
                    continue;
                }

                if (now.chance > 0 && !visited[nxt.v][now.chance - 1] && nxt.cost > maxValue)
                    stack.add(new Node(nxt.v, now.chance - 1));
            }
        }

        return false;
    }


    static class Edge {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static class Node {
        int v;
        int chance;

        public Node(int v, int chance) {
            this.v = v;
            this.chance = chance;
        }
    }
}
