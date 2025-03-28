import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]>[] list = new List[10000];
    static int nodeCount = 0, max = 0;

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10000; i++) {
            list[i] = new ArrayList<>();
        }


        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) break;

            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, cost});
            list[b].add(new int[]{a, cost});
            nodeCount++;
        }

        for (int i = 0; i < nodeCount; i++) {
            dfs(i+1, 0, 0);
        }

        System.out.println(max);
    }

    private static void dfs(int now, int pre, int sum) {
        if (list[now].size() == 1 && list[now].get(0)[0] == pre) {
            max = Math.max(max, sum);
            return;
        }

        for (int[] nxt : list[now]) {
            if (nxt[0] == pre) continue;
            dfs(nxt[0], now,sum + nxt[1]);
        }
    }
}