import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] inDegree; // -1은 방문처리
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) list[i] = new ArrayList<>();
        inDegree = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            inDegree[end]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == -1) continue;
            if (inDegree[i] == 0) {
                inDegree[i] = -1;
                sb.append(i).append(" ");

                if (!list[i].isEmpty()) {
                    for (int nxt : list[i]) inDegree[nxt]--;
                    i=0;
                }
            }
        }

        System.out.print(sb);
    }
}