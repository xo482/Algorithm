import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K, T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            List<Integer>[] list = new List[N + 1];
            int[] time = new int[N + 1];
            int[] answer = new int[N + 1];
            int[] inDegree = new int[N + 1];
            for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) answer[i] = time[i] = Integer.parseInt(st.nextToken());

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                inDegree[end]++;
            }

            ArrayDeque<Integer> Q = new ArrayDeque<>();

            for (int i = 1; i < N + 1; i++)
                if (inDegree[i] == 0)
                    Q.add(i);

            while (!Q.isEmpty()) {
                Integer now = Q.poll();

                for (int next : list[now]) {
                    answer[next] = Math.max(answer[next], answer[now] + time[next]);
                    if (--inDegree[next] == 0) Q.add(next);

                }
            }

            sb.append(answer[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }
}