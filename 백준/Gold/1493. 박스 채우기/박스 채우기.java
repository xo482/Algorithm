import java.io.*;
import java.util.*;

// 44% return boolean -> return void
// 52% Math.pow(2, i) -> (1 << i)
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, W, H;
    static long cnt;
    static int[] cubes = new int[20];
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            cubes[idx] = Integer.parseInt(st.nextToken());
        }

        tracking(L, W, H);
        if (flag) System.out.println(-1);
        else System.out.println(cnt);
    }

    private static void tracking(int l, int w, int h) {
        int x = Math.min(l, Math.min(w, h));
        if (x == 0) return;

        for (int i = 19; i >= 0; i--) {
            if (cubes[i] == 0) continue;
            if ((1 << i) > x) continue;

            cubes[i]--;
            cnt++;

            int len = 1 << i;
            tracking(l - len, len, len);
            tracking(len, w - len, len);
            tracking(len, len, h - len);
            tracking(l - len, w - len, len);
            tracking(l - len, len, h - len);
            tracking(len, w - len, h - len);
            tracking(l - len, w - len, h - len);
            return;
        }

        flag = true;
    }
}
