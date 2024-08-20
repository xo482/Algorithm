import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static int N;
    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new List[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        visited[1] = true;
        Q.addLast(1);

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();

            for (int nxt : arr[now]) {
                if (!visited[nxt]) {
                    Q.addLast(nxt);
                    visited[nxt] = true;
                }
            }
        }

        boolean flagT = false;
        boolean flagF = false;
        for (int i = 1; i < N+1; i++) {
            if (visited[i] && !flagT) {
                sb.append(i).append(" ");
                flagT = true;
            }
            if (!visited[i] && !flagF) {
                sb.append(i).append(" ");
                flagF = true;
            }
            if (flagT && flagF) break;
        }

        System.out.println(sb);
    }
}