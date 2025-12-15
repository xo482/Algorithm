import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] parent;
    static boolean[] visited;
    static List<Integer> know = new ArrayList<>();
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[M];
        for (int i = 0; i < M; i++) list[i] = new ArrayList<>();

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        for (int i = 0; i < len; i++) know.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int group_len = Integer.parseInt(st.nextToken());
            int leader = Integer.parseInt(st.nextToken());
            list[i].add(leader);

            for (int j = 1; j < group_len; j++) {
                int member = Integer.parseInt(st.nextToken());
                union(leader, member);
                list[i].add(member);
            }
        }

        for (int now : know) visited[find(now)] = true;

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int now = list[i].get(0);
            if (!visited[find(now)]) cnt++;
        }
        System.out.println(cnt);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}