import java.io.*;
import java.util.*;

// 앞에 선다 -> 먼저 나온다
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] inDegree;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            inDegree[B]++;
            list[A].add(B);
        }

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) if (inDegree[i] == 0) Q.addLast(i);

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            sb.append(now).append(" ");

            for (int next : list[now]) {
                if (--inDegree[next] == 0) Q.addLast(next);
            }
        }
        System.out.println(sb);
    }
}
