import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] inDegree;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            inDegree[B]++;
        }

        // logic
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++)
            if (inDegree[i] == 0) {
                Q.add(i);
                sb.append(i).append(" ");
            }

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            for (int nxt : list[now]) {
                if (--inDegree[nxt] == 0) {
                    Q.add(nxt);
                    sb.append(nxt).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}