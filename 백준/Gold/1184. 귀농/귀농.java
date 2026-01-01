import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans = 0;
    static int[][] sum;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        sum = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
        }

        // 대각선 접점 (mr, mc)
        for (int mr = 1; mr < N; mr++) {
            for (int mc = 1; mc < N; mc++) {

                // ---------- A ↔ D ----------
                map.clear();

                // A: (r1,c1) ~ (mr,mc)
                for (int r = 1; r <= mr; r++) {
                    for (int c = 1; c <= mc; c++) {
                        int sA = getSum(r, c, mr, mc);
                        map.put(sA, map.getOrDefault(sA, 0) + 1);
                    }
                }

                // D: (mr+1,mc+1) ~ (r2,c2)
                for (int r = mr + 1; r <= N; r++) {
                    for (int c = mc + 1; c <= N; c++) {
                        int sD = getSum(mr + 1, mc + 1, r, c);
                        ans += map.getOrDefault(sD, 0);
                    }
                }

                // ---------- B ↔ C ----------
                map.clear();

                // B: (r1,mc+1) ~ (mr,c2)
                for (int r = 1; r <= mr; r++) {
                    for (int c = mc + 1; c <= N; c++) {
                        int sB = getSum(r, mc + 1, mr, c);
                        map.put(sB, map.getOrDefault(sB, 0) + 1);
                    }
                }

                // C: (mr+1,c1) ~ (r2,mc)
                for (int r = mr + 1; r <= N; r++) {
                    for (int c = 1; c <= mc; c++) {
                        int sC = getSum(mr + 1, c, r, mc);
                        ans += map.getOrDefault(sC, 0);
                    }
                }
            }
        }

        System.out.print(ans);
    }

    private static int getSum(int i, int j, int k, int l) {
        return sum[k][l]
                + sum[i - 1][j - 1]
                - sum[k][j - 1]
                - sum[i - 1][l];
    }
}