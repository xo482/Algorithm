import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N , L, R, X;
    static int[] arr;
    static int answer = 0;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        if (N == 1) {
            System.out.println(0);
            return;
        }

        tracking(0);
        System.out.println(answer);
    }

    static void tracking(int idx) {
        if (stack.size() >= 2) {

            int sum = 0;
            for (int i : stack) sum += i;
            int x = stack.getLast() - stack.getFirst();

            if (L <= sum && sum <= R && x >= X) {
                answer++;
            }

            if (sum > R) return;
        }

        if (idx == N) return;

        for (int i = idx; i < N; i++) {
            stack.addLast(arr[i]);
            tracking(i + 1);
            stack.removeLast();
        }
    }
}