import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;
    static int[] inDegree, rank;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            rank = new int[N + 1];
            inDegree = new int[N + 1];
            list = new List[N + 1];
            for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

            // init
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) rank[Integer.parseInt(st.nextToken())] = i;

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (rank[i] < rank[j]) {
                        list[i].add(j);
                        inDegree[j]++;
                    }
                }
            }

            M = Integer.parseInt(br.readLine());
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (rank[a] < rank[b]) solution(a, b);
                else solution(b, a);
            }
            
            sb.append(sort()).append("\n");
        }

        System.out.println(sb);
    }

    private static String sort() {
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++)
            if (inDegree[i] == 0)
                Q.add(i);

        int cnt = 0;
        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            sb.append(now).append(" ");
            cnt++;

            for (int nxt : list[now])
                if (--inDegree[nxt] == 0)
                    Q.add(nxt);
        }
        if (cnt != N) return "IMPOSSIBLE";
        return sb.toString();
    }

    // a는 순위가 올라가는 놈
    private static void solution(int a, int b) {

        list[a].remove((Integer) b);
        list[b].add(a);

        inDegree[a]++;
        inDegree[b]--;
    }
}