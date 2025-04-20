import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, cnt;
    static int[][] points;
    static long len1, len2, len3;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        points = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long v1 = getLength(i, j);

                for (int k = j+1; k < N; k++) {
                    long v2 = getLength(i, k);
                    long v3 = getLength(j, k);
                    long t = (v1 + v2 + v3) / 2;

                    if (t == v1 || t == v2 || t == v3) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static long getLength(int i, int j) {
        long x1 = points[i][0];
        long y1 = points[i][1];
        long x2 = points[j][0];
        long y2 = points[j][1];

        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}