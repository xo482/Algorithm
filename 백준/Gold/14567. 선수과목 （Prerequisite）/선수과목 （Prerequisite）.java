import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] inDegree, answer;
    static List<Integer>[] list;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        answer = new int[N + 1];
        Arrays.fill(answer, 1);
        list = new List[N+1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            inDegree[b]++;
        }

        for (int i = 1; i < N + 1; i++)
            if (inDegree[i] == 0)
                Q.add(i);

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();

            for (int next : list[now]) {
                if (--inDegree[next] == 0) Q.add(next);

                answer[next] = Math.max(answer[next], answer[now] + 1);
            }
        }

        for (int i = 1; i < N + 1; i++) sb.append(answer[i]).append(" ");
        System.out.println(sb);
    }
}