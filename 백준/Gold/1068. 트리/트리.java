import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, delete, ans = 0;
    static List<Integer>[] list;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static int[] isParent;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new List[N];
        isParent = new int[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int child = 0; child < N; child++) {
            int parent = Integer.parseInt(st.nextToken());
            isParent[child] = parent;

            if (parent == -1) {
                Q.add(child);
                continue;
            }

            list[parent].add(child);
        }

        delete = Integer.parseInt(br.readLine());

        while (!Q.isEmpty()) {
            Integer now = Q.removeFirst();
            if (now == delete)  {
                if (isParent[now] != -1 && list[isParent[now]].size() == 1) ans++;
                continue;
            }

            if (list[now].isEmpty()) {
                ans++;
                continue;
            }

            for (int nxt : list[now])
                Q.add(nxt);
        }

        System.out.println(ans);
    }
}