import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] inDegree;
    static List<Integer>[] list;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            String[] split = br.readLine().split(" ");
            for (int i = 1; i < split.length-1; i++) {
                int start = Integer.parseInt(split[i]);
                int end = Integer.parseInt(split[i+1]);
                list[start].add(end);
                inDegree[end]++;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0) {
                Q.addLast(i);
            }
        }
        int cnt = 0;
        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            sb.append(now).append(" ");

            for (int next : list[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) Q.addLast(next);
            }

            cnt++;
        }

        if (cnt == N) {
            System.out.print(sb);
        } else {
            System.out.println("0");
        }
    }
}
