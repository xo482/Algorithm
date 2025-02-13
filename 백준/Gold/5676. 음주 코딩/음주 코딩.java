import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {

        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;

            st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];
            tree = new int[4*N];
            Arrays.fill(tree, 1);

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x > 0) arr[i] = 1;
                if (x < 0) arr[i] = -1;
            }

            init(1, 1, N);

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                char cal = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cal == 'C') {
                    if (b == 0) update(1, 1, N, a, 0);
                    if (b > 0) update(1, 1, N, a, 1);
                    if (b < 0) update(1, 1, N, a, -1);
                }
                if (cal == 'P') {
                    int result = mul(1, 1, N, a, b);

                    if (result > 0) sb.append('+');
                    else if (result < 0) sb.append('-');
                    else sb.append('0');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void update(int idx, int start, int end, int target, int value) {
        if (start == end) {
            tree[idx] = value;
            return;
        }

        int mid = (start + end) / 2;
        if (start <= target && target <= mid) update(2*idx, start, mid, target, value);
        if (mid+1 <= target && target <= end) update(2*idx+1, mid+1, end, target, value);

        tree[idx] = tree[2*idx] * tree[2*idx+1];
    }

    private static int mul(int idx, int start, int end, int left, int right) {
        if (start > right || end < left) return 1;
        if (left <= start && end <= right) return tree[idx];

        int mid = (start + end) / 2;
        int sumLeft = mul(2 * idx, start, mid, left, right);
        int sumRight = mul(2 * idx + 1, mid + 1, end, left, right);
        return sumLeft * sumRight;
    }

    private static void init(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(2 * idx, start, mid);
        init(2 * idx + 1, mid + 1, end);
        tree[idx] = tree[2 * idx] * tree[2 * idx + 1];
    }
}