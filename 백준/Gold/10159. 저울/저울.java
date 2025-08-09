import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] goLeftList, goRightList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        goLeftList = new List[N + 1];
        goRightList = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            goLeftList[i] = new ArrayList<>();
            goRightList[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            goLeftList[right].add(left);
            goRightList[left].add(right);
        }

        for (int now = 1; now < N + 1; now++) {
            visited = new boolean[N + 1];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.addLast(now);

            while (!stack.isEmpty()) {
                int num = stack.removeLast();
                for (int nxt : goLeftList[num]) {
                    if (visited[nxt]) continue;
                    stack.addLast(nxt);
                    visited[nxt] = true;
                }
            }

            stack.addLast(now);
            while (!stack.isEmpty()) {
                int num = stack.removeLast();
                for (int nxt : goRightList[num]) {
                    if (visited[nxt]) continue;
                    stack.addLast(nxt);
                    visited[nxt] = true;
                }
            }

            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) cnt++;
            }
            sb.append(cnt-1).append('\n');
        }

        System.out.println(sb);
    }
}