import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N , M;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        M += Integer.parseInt(st.nextToken());

        int treeSize = getTreeSize();
        tree = new long[treeSize];

        int start_idx = treeSize / 2;
        for (int i = 0; i < N; i++) tree[start_idx + i] = Long.parseLong(br.readLine());

        init(start_idx);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + start_idx - 1;
            long c = Long.parseLong(st.nextToken());

            if (a == 1) update(b, c);
            if (a == 2) sb.append(query(b, (int)c + start_idx - 1)).append("\n");
        }
        System.out.print(sb);
    }

    private static void update(int idx, long value) {
        long diff = value - tree[idx];
        tree[idx] = value;
        while (idx > 1) {
            tree[idx / 2] += diff;
            idx /= 2;
        }
    }

    private static long query(int s_idx, int e_idx) {

        long sum = 0;
        while (s_idx <= e_idx) {
            if (s_idx % 2 == 1) sum += tree[s_idx];
            if (e_idx % 2 == 0) sum += tree[e_idx];

            s_idx = (s_idx + 1) / 2;
            e_idx = (e_idx - 1) / 2;
        }
        return sum;
    }

    private static void init(int start_idx) {
        for (int i = 0; i < N; i++) {
            int idx = start_idx + i;
            int idx2 = idx;

            while (idx2 > 1) {
                tree[idx2 / 2] += tree[idx];
                idx2 /= 2;
            }
        }
    }

    private static int getTreeSize() {
        int cnt = 0;
        while (Math.pow(2,cnt++) < N) {}
        return (int) Math.pow(2, cnt);
    }
}
