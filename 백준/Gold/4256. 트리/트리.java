import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N;
    static int[][] tree;
    static boolean[] visited;
    static List<Integer> preorder = new ArrayList<>();
    static List<Integer> inorder = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            tree = new int[N + 1][2];
            visited = new boolean[N+1];

            inorder.clear();
            preorder.clear();
            preorder.add(-1);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) preorder.add(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) inorder.add(Integer.parseInt(st.nextToken()));

            int root = preorder.get(1);
            visited[root] = true;

            for (int i = 2; i <= N; i++) {
                int now = preorder.get(i);
                visited[now] = true;
                int now_idx = inorder.indexOf(now);

                int candidate_left = -1;
                int candidate_right = -1;
                for (int j = now_idx - 1; j >= 0; j--) {
                    if (!visited[inorder.get(j)]) continue;
                    candidate_left = inorder.get(j);
                    break;
                }

                for (int j = now_idx + 1; j < N; j++) {
                    if (!visited[inorder.get(j)]) continue;
                    candidate_right = inorder.get(j);
                    break;
                }


                int idx_left = preorder.indexOf(candidate_left);
                int idx_right = preorder.indexOf(candidate_right);

                if (idx_left > idx_right) tree[candidate_left][1] = now;
                else tree[candidate_right][0] = now;
            }

            postorder(root);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void postorder(int p) {
        if (tree[p][0] != 0) postorder(tree[p][0]);
        if (tree[p][1] != 0) postorder(tree[p][1]);
        sb.append(p).append(' ');
    }

}
