import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] building;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        building = new int[N];
        ans = new int[N][2]; // 0: 보이는 건물 수, 1: 가장 가까운 놈
        for (int i = 0; i < N; i++) ans[i][1] = 1000000;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) building[i] = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i < N; i++) {
            if (building[i] < building[i-1]) stack.add(i - 1);

            while (!stack.isEmpty()) {
                if (building[stack.getLast()] > building[i]) break;
                stack.removeLast();
            }

            ans[i][0] += stack.size();
            if (!stack.isEmpty() && Math.abs(ans[i][1]- i) > Math.abs(stack.getLast()- i))
                ans[i][1] = stack.getLast();
        }

        stack.clear();
        for (int i = N-2; i >= 0; i--) {
            if (building[i] < building[i+1]) stack.add(i+1);

            while (!stack.isEmpty()) {
                if (building[stack.getLast()] > building[i]) break;
                stack.removeLast();
            }

            ans[i][0] += stack.size();
            if (!stack.isEmpty() && Math.abs(ans[i][1]- i) > Math.abs(stack.getLast()- i))
                ans[i][1] = stack.getLast();
        }

        for (int i = 0; i < N; i++) {
            if (ans[i][0] == 0) { sb.append("0\n"); continue; }
            sb.append(ans[i][0]).append(" ").append(ans[i][1]+1).append("\n");
        }
        System.out.println(sb);
    }
}