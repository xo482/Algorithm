import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int INF = 1000000001;
    static int N, M;
    static int[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int treeSize = getTreeSize();
        tree = new int[treeSize];
        Arrays.fill(tree, INF);

        int start_idx = treeSize / 2;
        for (int i = 0; i < N; i++) tree[start_idx + i] = Integer.parseInt(br.readLine());
        init(start_idx);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a += start_idx -1;
            b += start_idx -1;

            if (i == M - 1) sb.append(query(a, b));
            else sb.append(query(a, b)).append("\n");
        }

        System.out.print(sb);

//        for (int i = 1; i < treeSize; i++) {
//            System.out.println(i + ": " + tree[i] + "  ");
//        }
    }

    private static int query(int s_idx, int e_idx) {
        int min = INF;
        while (s_idx <= e_idx) {
            if (s_idx % 2 == 1) min = Math.min(min, tree[s_idx]);
            if (e_idx % 2 == 0) min = Math.min(min, tree[e_idx]);

            s_idx = (s_idx + 1) / 2;
            e_idx = (e_idx - 1) / 2;
        }

        return min;
    }

    private static void init(int s_idx) {
        for (int i = 0; i < N; i++) {
            int idx = s_idx + i;
            while (idx > 1) {
                tree[idx / 2] = Math.min(tree[idx / 2], tree[idx]);
                idx /= 2;
            }
        }
    }

    private static int getTreeSize() {
        int depth = 0;
        while (Math.pow(2, depth++) < N) {}
        return (int) Math.pow(2, depth);
    }
}