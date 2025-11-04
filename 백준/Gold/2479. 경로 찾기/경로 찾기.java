import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static List<Integer>[] list;
    static Map<Integer, String> map = new HashMap<>();
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(i, str);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                String s1 = map.get(i);
                String s2 = map.get(j);
                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    if (s1.charAt(k) != s2.charAt(k)) cnt++;
                }
                if (cnt == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        q.add(start);
        visited[start] = -1;
        while (!q.isEmpty()) {
            int now = q.removeFirst();

            for (int nxt : list[now]) {
                if (visited[nxt] != 0) continue;
                q.addLast(nxt);
                visited[nxt] = now;
            }
        }

        if (visited[end] == 0) {
            System.out.println(-1);
            return;
        }

        q.add(end);
        while (!q.isEmpty()) {
            int now = q.removeFirst();
            if (now == -1) break;
            stack.addLast(now);
            q.addLast(visited[now]);
        }

        while (!stack.isEmpty()) {
            int now = stack.removeLast();
            sb.append(now).append(' ');
        }
        System.out.println(sb);
    }
}
