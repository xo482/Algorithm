import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int V;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N + 1][N + 1];
        boolean[] visitedDfs = new boolean[N + 1];
        boolean[] visitedBfs = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start][end] = 1;
            adj[end][start] = 1;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(V);

        while (!stack.isEmpty()) {
            int now = stack.removeLast();
            if (visitedDfs[now]) continue;

            visitedDfs[now] = true;
            sb.append(now).append(" ");

            for (int i = N; i > 0; i--) {
                if (adj[now][i] == 1 && !visitedDfs[i]) {
                    stack.addLast(i);
                }
            }
        }
        sb.append("\n");


        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Q.addLast(V);
        visitedBfs[V] = true;

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            sb.append(now).append(" ");

            for (int i = 1; i < N + 1; i++) {
                if (adj[now][i] == 1 && !visitedBfs[i]) {
                    Q.addLast(i);
                    visitedBfs[i] = true;
                }
            }
        }


        System.out.println(sb);
    }
}