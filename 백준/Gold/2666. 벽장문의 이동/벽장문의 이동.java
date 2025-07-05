import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, ans = Integer.MAX_VALUE;
    static int[] pos = new int[2];
    static int[] targets;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        pos[0] = Integer.parseInt(st.nextToken());
        pos[1] = Integer.parseInt(st.nextToken());
        Arrays.sort(pos);

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        for (int i = 0; i < M; i++) targets[i] = Integer.parseInt(br.readLine());

        tracking(0, pos[0], pos[1], 0);
        System.out.println(ans);
    }


    static void tracking(int targetIdx, int L, int R, int move) {
        if (targetIdx == M) {
            ans = Math.min(ans, move);
            return;
        }
        int target = targets[targetIdx];

        if (target == L || target == R) tracking(targetIdx + 1, L, R, move);
        if (target < L) tracking(targetIdx + 1, target, R, move + (L - target));
        if (target > R) tracking(targetIdx + 1, L, target, move + (target - R));
        if (L < target && target < R) {
            tracking(targetIdx + 1, target, R, move + (target - L));
            tracking(targetIdx + 1, L, target, move + (R - target));
        }
    }
}

