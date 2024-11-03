import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max = 0;
    static List<Node>[] list;
    static List<Integer> leaf = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        for (int i = 1; i < N+1; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        for (int i = 1; i < N + 1; i++)
            if (list[i].size() == 1)
                leaf.add(i);

        for (int i : leaf) {
            dfs(i, 0, 0, i);
        }
        System.out.println(max);
    }

    static void dfs(int now,int pre,int sum, int start) {
//        System.out.print("now = " + now);
//        System.out.print(", pre = " + pre);
//        System.out.println(", sum = " + sum);
        if (list[now].size()==1 && now != start) { max = Math.max(max, sum); return; }

        for (Node next : list[now]) {
            if (next.v == pre) continue;
            dfs(next.v, now, sum+next.cost, start);
        }
    }

    static class Node{
        int v,cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}