import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A, B, N;
    static Target[] L, R;
    static int[] ans = new int[3];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        L = new Target[N];
        R = new Target[N];
        ans[2] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            L[i] = new Target(i+1, l);
            R[i] = new Target(i+1, r);
        }

        int standard = A - B + 1;
        if (standard <= 0) {
            System.out.print("-1 -1");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (standard <= L[i].cost && L[i].cost < ans[2]) {
                ans[0] = i + 1;
                ans[1] = -1;
                ans[2] = L[i].cost;
            }
        }

        for (int i = 0; i < N; i++) {
            if (standard <= R[i].cost && R[i].cost < ans[2]) {
                ans[0] = -1;
                ans[1] = i + 1;
                ans[2] = R[i].cost;
            }
        }


        Arrays.sort(R);
        for (int LIdx = 0; LIdx < N; LIdx++) {
            if (L[LIdx].cost > ans[2]) continue;
            int start = 0;
            int end = N-1;
            int RIdx;
            while (start <= end) {
                RIdx = (start + end) / 2;
                if (standard <= L[LIdx].cost + R[RIdx].cost) end = RIdx - 1;
                else start = RIdx + 1;
            }
            RIdx = start;

            if (RIdx == N) continue;
            if (L[LIdx].num == R[RIdx].num) RIdx++;
            if (RIdx == N) continue;

            if (ans[2] == Integer.MAX_VALUE || ans[2] > L[LIdx].cost + R[RIdx].cost) {
                ans[0] = L[LIdx].num;
                ans[1] = R[RIdx].num;
                ans[2] = L[LIdx].cost + R[RIdx].cost;
            }
        }

        if (ans[2] == Integer.MAX_VALUE) {
            System.out.print("No");
        } else {
            System.out.print(ans[0] + " " + ans[1]);
        }
    }

    static class Target implements Comparable<Target>{
        int num;
        int cost;

        public Target(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Target o) {
            return this.cost - o.cost;
        }
    }
}