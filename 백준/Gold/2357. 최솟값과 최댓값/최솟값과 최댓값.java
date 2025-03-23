import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, treeSize, startIdx;
    static int[][] tree;
    static int INF = 1000000001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        
        treeSize = getTreeSize();
        startIdx = treeSize / 2;
        tree = new int[treeSize][2]; // 0 최솟값, 1 최댓값
        
        
        for (int i = 1; i < treeSize; i++) tree[i][0] = INF;
        for (int i = startIdx; i < startIdx+N; i++) tree[i][0] = tree[i][1] = Integer.parseInt(br.readLine());
        init();
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + startIdx - 1;
            int b = Integer.parseInt(st.nextToken()) + startIdx - 1;

            int[] res = query(a,b);
            sb.append(res[0]).append(" ").append(res[1]).append("\n");
        }
        System.out.print(sb);
    }

    private static int[] query(int sIdx, int eIdx) {
        int min = INF, max = 0;
        while (sIdx <= eIdx) {
            if (sIdx % 2 == 1) {
                min = Math.min(min, tree[sIdx][0]);
                max = Math.max(max, tree[sIdx][1]);
            }
            if (eIdx % 2 == 0) {
                min = Math.min(min, tree[eIdx][0]);
                max = Math.max(max, tree[eIdx][1]);
            }

            sIdx = (sIdx + 1) / 2;
            eIdx = (eIdx - 1) / 2;
        }
        return new int[]{min, max};
    }

    private static void init() {
        for (int i = treeSize-1; i > 1; i--) {
            tree[i / 2][0] = Math.min(tree[i / 2][0], tree[i][0]);
            tree[i / 2][1] = Math.max(tree[i / 2][1], tree[i][1]);
        }
    }

    private static int getTreeSize() {
        int cnt = 0;
        while (Math.pow(2, cnt++) < N) {}
        return (int) Math.pow(2, cnt);
    }
}
