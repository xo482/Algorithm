import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K, a, b, startIdx;
    static long c;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0; i < M+K; i++) {
            setABC();

            if (a == 1) update(b, c);
            if (a == 2) {
                long sum = query(b, (int)c);
                sb.append(sum).append('\n');
            }
        }
        System.out.print(sb);
    }

    static long query(int s, int e) {
        s = s + startIdx - 1;
        e = e + startIdx - 1;
        long sum = 0;

        while(s <= e) {
            if (s % 2 == 1) sum += tree[s];
            if (e % 2 == 0) sum += tree[e];

            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }
        return sum;
    }

    static void update(int idx, long value) {
        idx = idx + startIdx - 1;
        long diff = value - tree[idx];

        while (idx > 0) {
            tree[idx] += diff;
            idx = idx / 2;
        }
    }

    static void setABC() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int treeSize = getTreeSize();
        tree = new long[treeSize];
        startIdx = treeSize / 2;
        for(int i = 0; i < N; i++) {
            int idx = startIdx + i;
            long value = Long.parseLong(br.readLine());

            while (idx > 0) {
                tree[idx] += value;
                idx = idx / 2;
            }
        }
    }

    static int getTreeSize() {
        int i = 0;
        while (true) {
            int size = (int) Math.pow(2, i++);
            if (size >= N) break;
        }
        return (int) Math.pow(2, i);
    }
}